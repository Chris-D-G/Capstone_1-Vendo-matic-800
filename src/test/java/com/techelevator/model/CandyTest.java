package com.techelevator.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class CandyTest {

    @Test
    public void testVendingSound() {
        // Arrange
        String expectedVendingSound = "Yummy Yummy, So Sweet!";
        Candy candy = new Candy("Test Candy", 1.0);

        // Act
        String actualVendingSound = candy.vendingSound();

        // Assert
        assertEquals("Vending sound should be 'Yummy Yummy, So Sweet!'",expectedVendingSound, actualVendingSound);
    }
}

