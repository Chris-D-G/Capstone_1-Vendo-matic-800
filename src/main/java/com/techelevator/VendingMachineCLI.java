package com.techelevator;

// Menu is provided to you as a suggested class to handle user input
// Build out a menu class to start

import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };

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
		while (true) {
			menu.mainMenu();


			// Use a method from your Menu class to initialize this value
			String choice = menu.getUserInputMainMenu();

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				System.out.println( " Testing option one");
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				System.out.println(" Testing option two" );
				// do purchase
			}
			else{
				break;
			}
		}
	}
}
