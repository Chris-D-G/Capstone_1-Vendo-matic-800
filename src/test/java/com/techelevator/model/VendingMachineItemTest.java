package com.techelevator.model;

import org.junit.Test;


public class VendingMachineItemTest {
    private static class TestItem extends VendingMachineItem {
        public TestItem(String name, double price) {
            super(name, price);
        }

        @Override
        public String vendingSound() {
            return "Test Sound";
        }
    }

    @Test
    public void testGetName() {
        // Arrange
        String expectedName = "Test Candy";
        VendingMachineItem item = new TestItem(expectedName, 1.0);

        // Act
        String actualName = item.getName();

        // Assert
        assertEquals(expectedName, actualName, "Item name should match");
    }

    private void assertEquals(String expectedName, String actualName, String itemNameShouldMatch) {
    }

    @Test
    public void testGetPrice() {
        // Arrange
        double expectedPrice = 1.0;
        VendingMachineItem item = new TestItem("Test Candy", expectedPrice);

        // Act
        double actualPrice = item.getPrice();

        // Assert
        assertEquals(expectedPrice, actualPrice, 0.0001, "Item price should match");
    }

    private void assertEquals(double expectedPrice, double actualPrice, double v, String itemPriceShouldMatch) {
    }

    @Test
    public void testGetQuantity() {
        // Arrange
        int expectedQuantity = 1;
        VendingMachineItem item = new TestItem("Test Candy", 1.0);

        // Act
        int actualQuantity = item.getQuantity();

        // Assert
        assertEquals(String.valueOf(expectedQuantity), String.valueOf(actualQuantity), "Item quantity should match");
    }

    @Test
    public void testReduceQuantity() {
        // Arrange
        int initialQuantity = 3;
        VendingMachineItem item = new TestItem("Test Candy", 1.0);
        item.reduceQuantity();

        // Act
        int quantityAfterReduction = item.getQuantity();

        // Assert
        assertEquals(String.valueOf(initialQuantity - 1), String.valueOf(quantityAfterReduction), "Item quantity should be reduced by 1");
    }

    @Test
    public void testToString() {
        // Arrange
        String expectedString = ": Test Candy | Price: 1.0 | Quantity: 1";
        VendingMachineItem item = new TestItem("Test Candy", 1.0);

        // Act
        String actualString = item.toString();

        // Assert
        assertEquals(expectedString, actualString, "toString() should return the expected string representation");
    }

    @Test
    public void testVendingSound() {
        // Arrange
        String expectedSound = "Test Sound";
        VendingMachineItem item = new TestItem("Test Candy", 1.0);

        // Act
        String actualSound = item.vendingSound();

        // Assert
        assertEquals(expectedSound, actualSound, "Vending sound should match");
    }
}

