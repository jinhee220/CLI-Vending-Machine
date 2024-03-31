package com.techelevator;

//import product package

/*
Transaction format:
date time action $in/out $newbalance
 */

import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//figure out assignment friday
public class VendingLogger {
    //variables needed: action, LocalDate, Time(object/method should exist), balanceInOut, balance
    private final String VENDING_FILE = "VendingLog.txt";

    public VendingLogger() {
    }

    public void logTransaction(String description, double oldBalance, double balance) throws FileNotFoundException {
        File log = new File(VENDING_FILE);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
        String timeStamp = dateFormat.format(new Date());




        String logEntry = String.format("%s - %s: $%,.2f -> $%,.2f", timeStamp, description, oldBalance/100, balance/100);


        //File reader to access the file
        try (PrintWriter printWriter = new PrintWriter(new FileOutputStream(log, true), true)) {

            log.createNewFile();

            printWriter.println(logEntry);
        }catch (Exception e){
            System.out.println();
        }
    }
}


//instantiate money/balance
//printwriter needed for logging
//import and access VendingLog file

//can hard reference File Input Lecture code

//needs 1 method to log it
