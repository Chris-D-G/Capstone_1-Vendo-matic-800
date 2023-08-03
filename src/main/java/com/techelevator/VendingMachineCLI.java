package com.techelevator;

// Menu is provided to you as a suggested class to handle user input
// Build out a menu class to start

import com.techelevator.controller.FileReader;
import com.techelevator.controller.LogWriter;
import com.techelevator.controller.MoneyController;
import com.techelevator.model.VendingMachineItem;
import com.techelevator.view.Menu;

import java.util.Map;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";

	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};

	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";

	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY,PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION };


	private Map<String, VendingMachineItem> vendingMachineMap;


	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;

	}

	public static void main(String[] args) {
		// You will need to create a Menu class to handle display.
		Menu menu = new Menu();
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}



	//ToDO add J-UNIT tests to test all of the code
	public void run() {
		//initializes the map with the items
		FileReader fileReader = new FileReader();
		vendingMachineMap = fileReader.makeItemMap("main.csv");
		MoneyController wallet = new MoneyController();
		LogWriter logWriter = new LogWriter();
		logWriter.logStartup();


		while (true) {

			menu.displayMenu(MAIN_MENU_OPTIONS);


			// Use a method from your Menu class to initialize this value
			String choice = menu.getUserInputMainMenu();

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				menu.displayVendingItems(vendingMachineMap);

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {

				// this will determine if a discount is applied
				int purchaseQTYTracker = 0;
				//this loop will repeat until the user chooses to exit the purchase menu
				while(true){
					System.out.print("Current balance: $ ");
					System.out.printf("%.2f", wallet.getBalance());
					System.out.println();
					menu.displayMenu(PURCHASE_MENU_OPTIONS);
					// gets user input for the purchase menu
					String secondChoice = menu.getUserInputPurchaseMenu();
					// if user selects 1 it should ask to add money
					//-----------------------------ADD MONEY---------------------
					if(secondChoice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)){
						//Prompt the user to add money
						System.out.println(" Insert money (whole dollar amount) ");
						System.out.print(" $ ");
						// This gets the users input
						String userAmount = menu.getUserInput();
						double amountDouble = 0;
						int amount = 0;
						try {
							amount = Integer.parseInt(userAmount);
							amountDouble = amount;
						}
						catch( Exception e){
							System.out.println("You did not enter whole dollar value");
							System.out.println("Returning to menu");
							continue;
						}
						//adds money to the wallet
						wallet.addMoney(amountDouble);
						//log the transaction to the Log
						logWriter.writeToLog("FEED MONEY: " ,amountDouble , wallet.getBalance());
						//---------------------------------------PURCHASE ITEM----------------
						// if user selects 2 its going to ask for an item selection after displaying the item list
					}else if (secondChoice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT )){
						//displays the items
						menu.displayVendingItems(vendingMachineMap);
						if(purchaseQTYTracker % 2 !=0){
							System.out.println("Your purchase will be discounted by $1");
						}
						//prompt the user for the vending code
						System.out.print("Type in item code: ");
						// get user input for the code
						String userPurchase =  menu.getUserInput().toUpperCase();
						//use a try - catch to prevent errors from incorrect user input
						try{
							System.out.println();
							//checks the quantity of the items before producing the sound
							if (vendingMachineMap.get(userPurchase).getQuantity()>0 && wallet.getBalance()>0){

								// to apply the discount, this checks to see if the previous purchase tracker is odd
								if(purchaseQTYTracker % 2 !=0){

									//this checks to see if the balance is higher the purchase cost and completes the sound output and the purchase string if the balance is higher than the purchase price
									if(wallet.getBalance()>=vendingMachineMap.get(userPurchase).getPrice()-1){
										//this will subtract the money from the wallet with a discount or return "Insufficient funds" if there isn't enough money
										wallet.subtractMoney(vendingMachineMap.get(userPurchase).getPrice()-1);
										//reduces the quantity by 1 for each purchase
										vendingMachineMap.get(userPurchase).reduceQuantity();
										//Log the transaction
										logWriter.writePurchase(vendingMachineMap.get(userPurchase).getName(),userPurchase,vendingMachineMap.get(userPurchase).getPrice() , wallet.getBalance());
										// this will output the vending sound of the specific item
										System.out.println(vendingMachineMap.get(userPurchase).vendingSound());
										//prints out a message displaying what was purchases, for how much, and the balance left.
										System.out.println("You have purchased "+ vendingMachineMap.get(userPurchase).getName()
												//todo add 2f formatting
												+ " for $" + (vendingMachineMap.get(userPurchase).getPrice()-1)
												+" and your remaining balance is $"  + wallet.getBalance());
										purchaseQTYTracker++;
									}else{
										//if the purchase cannot be completed the following message is displayed
										System.out.println("Insufficient Funds!");
									}
								}else{
									if(wallet.getBalance()>=vendingMachineMap.get(userPurchase).getPrice()){
										//subtract money from wallet at full price
										wallet.subtractMoney(vendingMachineMap.get(userPurchase).getPrice());
										//reduces the quantity by 1 for each purchase
										vendingMachineMap.get(userPurchase).reduceQuantity();
										//Log the transaction
										logWriter.writePurchase(vendingMachineMap.get(userPurchase).getName(),userPurchase,vendingMachineMap.get(userPurchase).getPrice() , wallet.getBalance());
										// this will output the vending sound of the specific item
										System.out.println(vendingMachineMap.get(userPurchase).vendingSound());
										//prints out a message displaying what was purchases, for how much, and the balance left.
										System.out.println("You have purchased "+ vendingMachineMap.get(userPurchase).getName()
												//todo add 2f formatting
												+ " for $" + (vendingMachineMap.get(userPurchase).getPrice())
												+" and your remaining balance is $"  + wallet.getBalance());
										purchaseQTYTracker++;
									}else{
										//if the purchase cannot be completed the following message is displayed
										System.out.println("Insufficient Funds!");
									}
								}
							}else{
								System.out.println("ITEM OUT OF STOCK! CANNOT PURCHASE!");
							}
						}catch(Exception e){
							System.out.println("Error. Invalid code");
						}
					//-----------------------MAKE CHANGE-------------------------------------------
					}else{
						//  option 3 "Finish Transaction"
						//	returns the change
						logWriter.writeToLog("GIVE CHANGE: ", wallet.getBalance(), 0.00);
						System.out.println(wallet.makeChange());
						System.out.println();
						// Send user back to the main menu
						break;
					}
				}
			}else if(choice.equals(MAIN_MENU_OPTION_EXIT)){
				logWriter.logShutdown();
				break;
			}

			else if(choice.equals("4")){
				System.out.println("HIDDEN REPORT");
				break;
			}else{
				logWriter.logShutdown();
				break;
			}
		}
	}
}
