package com.techelevator;

import java.util.Map;

public class TEST {

    public static void main(String[] args) {
        FileReader test = new FileReader();
        Map<String,VendingMachineItem> testMap = test.makeItemMap();
//        System.out.println(testMap);
        System.out.println("Item Name: "+testMap.get("A1").getName() + " , Item Price: "+testMap.get("A1").getPrice() );







    }


}
