package com.techelevator.model;

import org.junit.Test;

import static org.junit.Assert.*;
public class DrinkTest {
    @Test
    public void testVendingSound() {
        // Arrange
        String expectedVendingSound = "Glug Glug, Yum!";
        Drink drink = new Drink("Test Drink", 1.0);

        // Act
        String actualVendingSound = drink.vendingSound();

        // Assert
        assertEquals("Vending sound should be 'Glug Glug, Yum!'", expectedVendingSound, actualVendingSound);

    }
}
