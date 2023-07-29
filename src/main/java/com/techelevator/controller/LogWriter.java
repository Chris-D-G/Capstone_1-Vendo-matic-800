package com.techelevator.controller;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LogWriter {

    //ToDo Method that logs date time, Action, transaction amount and wallet balance
    public void writeToLog(String action, double transactionAmount, double walletBalance ){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
        LocalDateTime now = LocalDateTime.now();
        // create a print writer inside of a try - catch
        try (FileWriter writer = new FileWriter("Log.txt", true);
        PrintWriter printer = new PrintWriter (writer) ) {
            //inside the try have it print out the same information to the log
            printer.println(dtf.format(now) + " " + action + " $" + transactionAmount + " $" + walletBalance);

        } catch ( IOException e) {
            System.out.println( "Error");
        }



    }



}
