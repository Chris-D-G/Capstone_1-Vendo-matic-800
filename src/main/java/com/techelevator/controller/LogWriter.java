package com.techelevator.controller;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogWriter {
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
    private final LocalDateTime now = LocalDateTime.now();



    //Method that logs date time, Action, transaction amount and wallet balance
    public void writeToLog(String action, double transactionAmount, double walletBalance ){

        try (FileWriter writer = new FileWriter("Log.txt", true);
        PrintWriter printer = new PrintWriter (writer) ) {
            printer.printf(dtf.format(now) + " " + action + " $%.2f" +" $%.2f", transactionAmount ,  walletBalance);
            printer.println();
        } catch ( IOException e) {
            System.out.println( "Error");
        }
    }
    public void writePurchase(String action, String vendingCode, double transactionAmount, double walletBalance ){
        // create a print writer inside of a try - catch
        try (FileWriter writer = new FileWriter("Log.txt", true);
             PrintWriter printer = new PrintWriter (writer) ) {

            printer.printf(dtf.format(now) + " " + action +  " " + vendingCode + " $%.2f" + " $%.2f" , transactionAmount, walletBalance);
            printer.println();

        } catch ( IOException e) {
            System.out.println( "Error");
        }
    }





    public void logStartup(){

        try (FileWriter writer = new FileWriter("Log.txt", true);
             PrintWriter printer = new PrintWriter (writer) ) {
            printer.println("*******(SYSTEM STARTUP)*******");

        } catch ( IOException e) {
            System.out.println( "Error");
        }
    }

    public void logShutdown(){

        try (FileWriter writer = new FileWriter("Log.txt", true);
             PrintWriter printer = new PrintWriter (writer) ) {
            printer.println("*******(SYSTEM SHUTDOWN)*******");
        } catch ( IOException e) {
            System.out.println( "Error");
        }
    }

    //ToDO method that writes the the hidden log
    public void writeToHiddenLog(){

    }



}
