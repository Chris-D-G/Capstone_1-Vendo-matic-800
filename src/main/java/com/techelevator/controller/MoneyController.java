package com.techelevator.controller;

import java.util.Scanner;

public class MoneyController {

    private double wallet = 0.00;
    private final double QUARTER = 0.25;
    private final double DIME = 0.10;
    private final double NICKEL = 0.05;
    private final double DOLLAR = 1.00;

    public double getWallet() {
        return wallet;
    }


    //ToDO method to add money
    public double addMoney() {
        Scanner userInput = new Scanner( System.in);
        System.out.println(" Insert money");

        double userAmount = userInput.nextDouble();

        double totalAmount = userAmount * DOLLAR;
        wallet += totalAmount;

        System.out.println("Added money " + totalAmount + " to the wallet.");
    }

    public static void main(String[] args) {
        MoneyController moneyController = new MoneyController();
        System.out.println("Current wallet balance: $" + moneyController.getWallet());
        moneyController.addMoney();
        System.out.println("Updated wallet balance: $" + moneyController.getWallet());
    }



// record user input using the scanner, make sure user only uses numbers
        // convert user value into int
        // multiply dollar by converter value
        // set wallet = new amount


    //ToDO method to make change
    public void makeChange(){

        double remainingWallet = getWallet();
        int quarterCounter = 0;
        int dimeCounter = 0;
        int nickelCounter = 0;
        // attempt making change using quarters first
        //
        quarterCounter = (int) Math.floor(remainingWallet/QUARTER);
        remainingWallet = remainingWallet-(QUARTER * quarterCounter);
        //if greater than zero keep going and attempt dimes
        if(remainingWallet>0){
            dimeCounter = (int) Math.floor(remainingWallet/DIME);
            remainingWallet = remainingWallet-(DIME * dimeCounter);
        }
        //if greater than zero keep going and attempt dimes
        if(remainingWallet>0) {
            nickelCounter = (int) Math.floor(remainingWallet / NICKEL);
            remainingWallet = remainingWallet - (NICKEL * nickelCounter);
        }
        //Display the change to the user
        System.out.println("Your change is: "+
                "\n " + quarterCounter + " quarters "+
                "\n " + dimeCounter + " dimes "+
                "\n " + nickelCounter + " nickels " +
                "\n " + " totaling $" +( (QUARTER*quarterCounter)+ (DIME * dimeCounter) + (NICKEL * nickelCounter) ) );




    }
}
