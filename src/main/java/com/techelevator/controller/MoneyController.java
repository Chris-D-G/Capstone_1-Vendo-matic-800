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
    public double addMoney(String userInput) {
        Scanner userInput = new Scanner( System.in);
        double 


        double dollarAmount = userInput.













        return 0.00;
    }
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
