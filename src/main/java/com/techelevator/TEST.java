package com.techelevator;

import com.techelevator.controller.FileReader;
import com.techelevator.controller.MoneyController;
import com.techelevator.model.VendingMachineItem;

import java.util.Map;

public class TEST {

    public static void main(String[] args) {
        FileReader test = new FileReader();
        Map<String, VendingMachineItem> testMap = test.makeItemMap("alternate.csv");
//        System.out.println(testMap);
//        System.out.println("Item Name: "+testMap.get("A1").getName() + " , Item Price: "+testMap.get("A1").getPrice() );
//        System.out.println(testMap.get("B2").toString());

        MoneyController wallet = new MoneyController();
        wallet.addMoney();
//        System.out.println(wallet.getWallet());








    }


}
