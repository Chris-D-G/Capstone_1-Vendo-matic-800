package com.techelevator.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class GumTest {
    @Test
    public void testVendingSound() {
        // Arrange
        String expectedVendingSound = "Chew Chew, Yum!";
        Gum gum = new Gum("Test Gum", 1.0);

        // Act
        String actualVendingSound = gum.vendingSound();

        // Assert
        assertEquals("Vending sound should be 'Chew Chew, Yum!'", expectedVendingSound, actualVendingSound);

    }

}