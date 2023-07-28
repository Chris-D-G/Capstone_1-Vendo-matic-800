package com.techelevator.model;

public abstract class VendingMachineItem implements Sound {
    private String name;
    private double price;
    private int quantity;


    public VendingMachineItem(String name, double price) {
        this.name = name;
        this.price = price;
        quantity = 5;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Item: " + name + " | Current Price: " + price +" | Current quantity: " + quantity;
    }



    @Override
    public String vendingSound() {
        return "no sound";
    }

}
