package com.techelevator.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class MunchyTest {
    @Test
    public void testVendingSound() {
        // Arrange
        String expectedVendingSound = "Crunch Crunch, Yum!";
       Munchy munchy = new Munchy("Test Munchy", 1.0);

        // Act
        String actualVendingSound = munchy.vendingSound();

        // Assert
        assertEquals("Vending sound should be 'Crunch Crunch, Yum!'", expectedVendingSound, actualVendingSound);

    }
}


