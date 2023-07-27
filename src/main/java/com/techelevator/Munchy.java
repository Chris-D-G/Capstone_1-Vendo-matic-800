package com.techelevator;

public class Munchy extends VendingMachineItem {
    public Munchy(String name, double price) {
        super(name, price);
    }
    @Override
    public String vendingSound () {
        return "Crunch Crunch, Yum!";
    }
}
