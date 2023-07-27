package com.techelevator;

import java.util.Scanner;

public class Menu {
    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";

    public void mainMenu() {
        System.out.println("(1) Display Vending Machine Items");
        System.out.println("(2) Purchase");
        System.out.println("(3) Exit");
        System.out.println();
        System.out.print("Please make a selection: ");

    }
    public void purchaseMenu () {
        System.out.println("Current money provided: $ ");
       System.out.println();
        System.out.println("(1) Feed Money");
        System.out.println("(2) Select Product");
        System.out.println("(3) Finish Transaction");
        System.out.println();
        System.out.print("Please make a selection: ");
    }
    public String getUserInputMainMenu () {
        Scanner userInput = new Scanner(System.in);
        String choice = userInput.nextLine().trim();

        if (choice.equals("1") ) {
            return MAIN_MENU_OPTION_DISPLAY_ITEMS;
        } else if (choice.equals("2")) {
            return MAIN_MENU_OPTION_PURCHASE;

        } else {
            return "Exit";
        }

    }
}