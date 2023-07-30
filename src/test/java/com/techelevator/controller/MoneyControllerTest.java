package com.techelevator.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MoneyControllerTest {
    private  MoneyController wallet;
    @Before
    public void setUp() {
        wallet = new MoneyController();

    }

    @Test
    public void test_getBalance() {
        double expected = 0.00;
        double actual = wallet.getBalance();
        assertEquals("Wallet should be initialized to $0.00!",expected,actual,.00001);

    }

    @Test
    public void test_addMoney() {
        double expected = 15.00;
        wallet.addMoney(15.00);
        double actual = wallet.getBalance();
        assertEquals(expected,actual, .00001);


    }

    @Test
    public void test_makeChange() {
        wallet.addMoney(15.65);
        String expected =  "Your change is: "+
                "\n " + 62 + " quarter(s) "+
                "\n " + 1 + " dime(s) "+
                "\n " + 1 + " nickel(s) " +
                "\n " + "Totaling $15.65";
        String actual =  wallet.makeChange();
        System.out.println(actual);
        assertEquals(expected,actual);

    }


    @Test
    public void test_subtractMoney() {
        double actual = 13.50;
        wallet.addMoney(15);
        wallet.subtractMoney(1.50);
        double expected = wallet.getBalance();
        assertEquals(expected,actual,.00001);

    }
}