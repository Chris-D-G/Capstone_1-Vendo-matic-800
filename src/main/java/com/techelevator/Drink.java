package com.techelevator;

public class Drink extends VendingMachineItem {

    public Drink(String name, double price) {
        super(name, price);
    }

    @Override
    public String vendingSound() {
        return "Glug Glug, Yum!";
    }
}
