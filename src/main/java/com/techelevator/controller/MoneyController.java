package com.techelevator.controller;

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
        String output = "Your change is: "+
                "\n " + quarterCounter + " quarter(s) "+
                "\n " + dimeCounter + " dime(s) "+
                "\n " + nickelCounter + " nickel(s) " +
                "\n " + "Totaling $";


        System.out.printf(output + "%.2f", ( (QUARTER*quarterCounter)+ (DIME * dimeCounter) + (NICKEL * nickelCounter) ) );


    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }
}
