package com.techelevator;

import com.techelevator.ProductsForSale.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import com.techelevator.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.techelevator.PhysicalInventory.restock;
import static junit.framework.TestCase.assertEquals;


/*
some of these methods may not be testable, if they're
if theyre not then I can remove them from the testing after.

I think with our program build, there isnt too much we can test
but if you could, please also take a look to see if any methods
throughout are testable!

//for joanne- i think the add balance should work and worked on the dispense balance. Wasn't sure on the subtract balance since it was prompting me to change the parameters
//and i didn't want to mess anything up so let me know what you think, started on some of the others and just labeled them a_, b_, c_, d_ etc
*/
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UnitTest1 {

//Test B Add Balance
        private Bank bank;

        @Before
        public void setUpB() {
            bank = new Bank(0);
        }

        @Test
        public void b_testAddBalance() {
            //Arrange
            int initialBalance = bank.getBalance();

            //Act
            bank.addBalance("5.00");

            //Assert
            int expectedBalance = initialBalance + 500;
            assertEquals(expectedBalance, bank.getBalance(), 0.001);
        }

//Test C Subtract Balance

    private Map<String, List<Product>> stockMap;

    @Before
    public void setUpC() {
        bank = new Bank(1000);
        stockMap = new HashMap<>();
    }

    //Test E Update Stock

    @Test
    public void e_test_updateStock(Map stockMap, String slotID) {
        //Arrange

        //Act

        //Assert

    }
//Test F Dispense Balance
    @Before
    public void setUpF() {
        bank = new Bank(1000);
    }


    @Test
    public void f_test_dispenseBalance(int balance) {


        //Arrange
        int initialBalance = bank.getBalance();

        //Act
        bank.dispenseBalance(initialBalance);

        //Assert
        assertEquals(0, bank.getBalance(), 0.001);
    }


