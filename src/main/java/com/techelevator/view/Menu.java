package com.techelevator.view;

import com.techelevator.controller.MoneyController;
import com.techelevator.model.VendingMachineItem;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Menu {
    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };
    private final Scanner userInput = new Scanner(System.in);



    //ToDO simplify the code to use the string array
    public void mainMenu() {
        System.out.println();
        System.out.println("(1) Display Vending Machine Items");
        System.out.println("(2) Purchase");
        System.out.println("(3) Exit");
        System.out.println();
        System.out.print("Please make a selection: ");

    }
    public void purchaseMenu () {

        System.out.println("(1) Feed Money");
        System.out.println("(2) Select Product");
        System.out.println("(3) Finish Transaction");
        System.out.println();
        System.out.print("Please make a selection: ");
    }
    public String getUserInputMainMenu () {
        String choice = userInput.nextLine().trim();

        if (choice.equals("1") ) {
            return MAIN_MENU_OPTION_DISPLAY_ITEMS;
        } else if (choice.equals("2")) {
            return MAIN_MENU_OPTION_PURCHASE;

        } else {
            return "Exit";
        }
    }

    public String getUserInputPurchaseMenu(){
        String purchaseChoice = userInput.nextLine().trim();

        if(purchaseChoice.equals("1")){
            return "1";
        }else if(purchaseChoice.equals("2")){
            return "2";
        }else{
            return "3";
        }

    }

    public void displayVendingItems(Map<String, VendingMachineItem> vendingMachineMap){

        // create a set to hold the keys of the map
        Set<String> vendingMapKeys = vendingMachineMap.keySet();

        //use a for each loop to output the vending items
        for(String key: vendingMapKeys){
            System.out.println(key+ " " +vendingMachineMap.get(key).toString());

        }




    }


}