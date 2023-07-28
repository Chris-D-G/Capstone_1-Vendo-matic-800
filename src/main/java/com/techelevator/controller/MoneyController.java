package com.techelevator.controller;

import java.sql.SQLOutput;
import java.util.Scanner;

public class MoneyController {

    private double wallet;
    private final double QUARTER = 0.25;
    private final double DIME = 0.10;
    private final double NICKEL = 0.05;
    private final double DOLLAR = 1.00;

    public double getBalance() {
        return wallet;
    }

    public MoneyController() {
        wallet = 0.00;
    }

    public void addMoney() {
        //ToDO have the input be an external argument
        Scanner userInput = new Scanner( System.in);
        System.out.println(" Insert money (whole dollar amount) ");
        System.out.print(" $ ");

        double totalAmount = 0;

        try {
            String userAmount = userInput.nextLine().trim();
            int number = Integer.parseInt(userAmount);
            totalAmount = number * DOLLAR;
        }
        catch( Exception e){
            System.out.println("You did not enter whole dollar value");
            System.out.println("System will exit now.");
            System.exit(1);
        }


        wallet += totalAmount;

        System.out.print("Added $");
        System.out.printf("%.2f", totalAmount  );
        System.out.println(" to the balance");
        System.out.println();


    }



    public void makeChange(){

        double remainingWallet = getBalance();
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
        wallet = 0;

    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    //ToDO a method that reduces the current wallet total





}
