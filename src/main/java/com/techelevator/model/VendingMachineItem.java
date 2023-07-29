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

    public void reduceQuantity(){
       quantity-=1;
    }

    @Override
    public String toString() {
        return ": " + name + " | Price: " + price +" | Quantity: " + quantity;
    }

    @Override
    public String vendingSound() {
        return "no sound";
    }

}
