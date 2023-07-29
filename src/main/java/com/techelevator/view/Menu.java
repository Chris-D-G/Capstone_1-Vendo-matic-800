package com.techelevator.view;

import com.techelevator.controller.MoneyController;
import com.techelevator.model.VendingMachineItem;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Menu {
    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";
    private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
    private final Scanner userInput = new Scanner(System.in);




    public void displayMenu(String[] array) {
        System.out.println();
        for (int i = 0; i < array.length ; i++) {
            System.out.println("(" +(i+1)+") " + array[i] );
        }
        System.out.println();
        System.out.print("Please make a menu selection: ");
    }

    public String getUserInputMainMenu () {
        String choice = getUserInput();

        if (choice.equals("1") ) {
            return MAIN_MENU_OPTION_DISPLAY_ITEMS;
        } else if (choice.equals("2")) {
            return MAIN_MENU_OPTION_PURCHASE;

        } else if(choice.equals("3")) {
            return MAIN_MENU_OPTION_EXIT;
        }else if (choice.equals("4")){
            return "4";
        }else{
            return MAIN_MENU_OPTION_EXIT;
        }
    }

    public String getUserInputPurchaseMenu(){
        String purchaseChoice = getUserInput();
        if(purchaseChoice.equals("1")){
            return PURCHASE_MENU_OPTION_FEED_MONEY;
        }else if(purchaseChoice.equals("2")){
            return PURCHASE_MENU_OPTION_SELECT_PRODUCT;
        }else{
            return PURCHASE_MENU_OPTION_FINISH_TRANSACTION;
        }
    }

    public void displayVendingItems(Map<String, VendingMachineItem> vendingMachineMap){
        // create a set to hold the keys of the map
        Set<String> vendingMapKeys = vendingMachineMap.keySet();
        //use a for each loop to output the vending items
        for(String key: vendingMapKeys){
            System.out.println(key + vendingMachineMap.get(key).toString());
        }
    }

    public String getUserInput(){
        String userText = userInput.nextLine().trim();
        return userText;
    }


}