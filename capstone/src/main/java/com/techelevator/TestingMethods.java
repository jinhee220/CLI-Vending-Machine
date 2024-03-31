package com.techelevator;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map;
import java.util.HashMap;
import com.techelevator.Bank;
import com.techelevator.Menu;
import com.techelevator.*;
import com.techelevator.ProductsForSale.*;
import com.techelevator.VendingLogger.*;

import static com.techelevator.PhysicalInventory.*;

/*
i just made this because i needed a way to test my terribly long
functions :)
 */

public class TestingMethods {

    public static Map<String, List> stockMap = new HashMap<>();
    public static final int MAX_QUANTITY = 5;
    public static int currentQuantity;
    public static final String INV_FILE = "vendingmachine.csv";
    private final String VENDING_FILE = "VendingLog.txt";


    public static void main(String[] args) {

        String VENDING_FILE = "VendingLog.txt";

        VendingLogger logger = new VendingLogger();


        Menu m = new Menu();
        m.showMainOptions();
        m.showPurchaseOptions();
        System.out.println();


//        Map<String, List> stockMap = new HashMap<>();
//        PhysicalInventory inv = new PhysicalInventory();
//
//        inv.setStockMap(stockMap);
//
//        inv.restock(stockMap);
        /*
        restock(stockMap);
        showStock(stockMap);
        String userInput = "D1";

        System.out.println();

        //get from user input to object
        unBoxAndDispense(stockMap, userInput);

        System.out.println();

        updateStock(stockMap, userInput);
        showStock(stockMap);

        //because Bank class is not static, we need to insantiate
        Bank b = new Bank(0);
        //b.addBalance("1000");
        b.setOldBalance(b.getBalance()); //grab and hold old balance value for log
        System.out.println("Balance: " + b.getOldBalance()); //we need old balance for logging

        b.addBalance("1837"); //return Balance: $10.00
        System.out.println("Balance: " + b); //due to constructor and println, toString is autoapplied
        */
        //description is transaction

        File log = new File(VENDING_FILE);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
        String timeStamp = dateFormat.format(new Date());
        String logEntry = String.format("%s %s: $%.2f $%.2f%n", timeStamp, "Feed Money", 0.00, 1.50);

        //File reader to access the file
        try (PrintWriter printWriter = new PrintWriter(new FileOutputStream(log.getAbsolutePath()))) {
            printWriter.println(logEntry);
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        b.subtractBalance("A1", stockMap);//this works atm
//        System.out.println("Balance: " + b);

        //b.dispenseBalance(b.getBalance());
        //create a stockmap in main so we can provide input
//
    }

    public void logTransaction(String description, int oldBalance, int balance) {
        File log = new File(VENDING_FILE);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
        String timeStamp = dateFormat.format(new Date());
        String logEntry = String.format("%s %s: $%.2f $%.2f", timeStamp, description, oldBalance, balance);

        //File reader to access the file
        try (FileWriter fileWriter = new FileWriter(new FileOutputStream(log.getAbsolutePath() ).toString())) {
            fileWriter.write(logEntry);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
