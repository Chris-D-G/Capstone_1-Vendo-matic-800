package com.techelevator.model;

public abstract class VendingMachineItem implements Sound {
    private String name;
    private double price;
    private int quantity;


    public VendingMachineItem(String name, double price) {
        this.name = name;
        this.price = price;
        quantity = 1;
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
        if(quantity>0){
        quantity-=1;
        } else {
            System.out.println("ITEM OUT OF STOCK!");
        }
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
