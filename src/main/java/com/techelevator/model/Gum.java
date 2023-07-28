package com.techelevator.model;

public class Gum extends VendingMachineItem{
    public Gum(String name, double price) {
        super(name, price);
    }

    @Override
    public String vendingSound() {
        return "Chew Chew, Yum!";
    }
}
