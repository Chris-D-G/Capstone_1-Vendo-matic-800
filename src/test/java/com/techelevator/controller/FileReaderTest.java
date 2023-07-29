package com.techelevator.controller;

import com.techelevator.model.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.*;

public class FileReaderTest {

    private FileReader fileReader;
    private Map<String, VendingMachineItem> testMap;

    @Before
    public void setUp() {
        fileReader = new FileReader();
        testMap = new TreeMap<>();
        testMap.put("A1", new Gum("U-Chews",1.65));
        testMap.put("B1",new Drink("Ginger Ayle",1.85));
        testMap.put("C1",new Candy("Snykkers",4.25));
        testMap.put("D1",new Munchy("Chippos",3.85));
        testMap.put("A2",new Munchy("Stackers",2.65));
        testMap.put("B2",new Drink("Papsi",3.45));
        testMap.put("C2",new Drink("Mountain Melter",3.55));
        testMap.put("D2",new Candy("Wonka Bar",2.35));
        testMap.put("A3",new Candy("Caramel Bar",2.25));
        testMap.put("B3",new Drink("7Down",3.25));
        testMap.put("C3",new Candy("Moonpie",2.95));
        testMap.put("D3",new Munchy("Popcorn",1.75));
        testMap.put("A4",new Gum("Teaberry",1.65));
        testMap.put("B4",new Munchy("Preengles",2.35));
        testMap.put("C4",new Gum("Singlemint Gum",2.35));
        testMap.put("D4",new Gum("Chiclets",1.35));
    }

    @Test
    public void test_Make_Item_Map(){

        Map<String, VendingMachineItem> expected = testMap;
        Map<String, VendingMachineItem> actual =fileReader.makeItemMap("alternate.csv");
        Assert.assertEquals("The maps do not match!",expected,actual);
        Assert.assertSame(expected,actual);





    }




}

