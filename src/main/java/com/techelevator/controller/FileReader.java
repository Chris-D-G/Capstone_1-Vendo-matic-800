package com.techelevator.controller;

import com.techelevator.model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileReader {
    private String filepath;
    private File inputFile;
    Map<String, VendingMachineItem> vendingMachineMap;

    public Map<String,VendingMachineItem> makeItemMap(){
        //create an empty map
        vendingMachineMap = new HashMap<>();
        filepath ="main.csv";
        // create a file based on the file path
        inputFile = new File(filepath);
        //open a scanner to read the text in the input file
        try(Scanner inputText = new Scanner(inputFile)){
            // while the file has a next line
            while(inputText.hasNextLine()){
                //make currentLine the next line in the file
                String currentLine = inputText.nextLine();
                // split currentLine based on commas
                String[] items = currentLine.split(",");
                //this if loop checks the type based on position 3 in the items array

                // if the item is a gum this will create a gum
                 if(items[3].equals("Gum")){

                     // set the gum name equal to the item in position 1 of the array
                     String gumName = items[1];

                     //set the gum price equal to the item in position 2 of the array
                     double gumPrice = Double.parseDouble(items[2]);

                     // create a new gum based on the name and price created earlier
                     Gum gummyGumGum  = new Gum(gumName,gumPrice);

                     // add the new gum to the map setting the string in position 0 of the array as the key
                     vendingMachineMap.put(items[0],gummyGumGum );

                 // if the item is a drink this will create a drink
                 }else if(items[3].equals("Drink")){
                     // set the drink name equal to the item in position 1 of the array
                     String drinkName = items[1];

                     //set the drink price equal to the item in position 2 of the array
                     double drinkPrice = Double.parseDouble(items[2]);

                     // create a new drink based on the name and price created earlier
                     Drink drink = new Drink(drinkName,drinkPrice);

                     // add the new drink to the map setting the string in position 0 of the array as the key
                     vendingMachineMap.put(items[0],drink);

                 // if the item is a candy, this will create a candy
                 }else if(items[3].equals("Candy")){

                     // set the candy name equal to the item in position 1 of the array
                     String candyName = items[1];

                     //set the candy price equal to the item in position 2 of the array
                     double candyPrice = Double.parseDouble(items[2]);

                     // create a new candy based on the name and price created earlier
                     Candy cavities = new Candy(candyName,candyPrice);

                     // add the new candy to the map setting the string in position 0 of the array as the key
                     vendingMachineMap.put(items[0],cavities);

                 // if neither of the conditions above are met, the item must be "Munchy"
                 }else{
                     // set the munchy name equal to the item in position 1 of the array
                     String munchyName = items[1];

                     //set the munchy price equal to the item in position 2 of the array
                     Double munchyPrice = Double.parseDouble(items[2]);

                     // create a new munchy based on the name and price created earlier
                     Munchy crunch = new Munchy(munchyName,munchyPrice);

                     // add the new candy to the map setting the string in position 0 of the array as the key
                     vendingMachineMap.put(items[0],crunch);
                 }

            }




        }catch(FileNotFoundException e){
            System.out.println("Something went wrong. See error message below");
            System.out.println(e.getMessage());
        }


        return vendingMachineMap;
    }



}
