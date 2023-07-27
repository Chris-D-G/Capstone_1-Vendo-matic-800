package com.techelevator;

public class Candy extends VendingMachineItem {
    public Candy(String name, double price) {
        super(name, price);
    }

    @Override
    public String vendingSound() {
        return "Yummy Yummy, So Sweet!";
    }
}
