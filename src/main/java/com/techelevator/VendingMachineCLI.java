package com.techelevator;

// Menu is provided to you as a suggested class to handle user input
// Build out a menu class to start

import com.techelevator.controller.FileReader;
import com.techelevator.controller.MoneyController;
import com.techelevator.model.VendingMachineItem;
import com.techelevator.view.Menu;

import java.util.Map;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
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

	public void run() {
		//initializes the map with the items
		FileReader fileReader = new FileReader();
		vendingMachineMap = fileReader.makeItemMap("main.csv");
		MoneyController wallet = new MoneyController();



		while (true) {

			menu.mainMenu();


			// Use a method from your Menu class to initialize this value
			String choice = menu.getUserInputMainMenu();

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
//				System.out.println( "Testing option one");
				menu.displayVendingItems(vendingMachineMap);

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				while(true){
					System.out.println("Current money provided: $ " + wallet.getBalance());
					System.out.println();
					menu.purchaseMenu();
					String secondChoice = menu.getUserInputPurchaseMenu();
					// if user selects 1 it should ask to add money
					if(secondChoice.equals("1")){
						wallet.addMoney();
						// if user selects 2 its going to ask for an item selection after displaying the item list
					}else if (secondChoice.equals("2")){
						menu.displayVendingItems(vendingMachineMap);
						//ToDO add the ability to buy item here

					}else{
						wallet.makeChange();
						break;
					}
				}
			}
			else{
				break;
			}
		}
	}
}
