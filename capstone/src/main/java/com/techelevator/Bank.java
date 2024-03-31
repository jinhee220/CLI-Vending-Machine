package com.techelevator;

//import ProductsForSale package
import com.techelevator.ProductsForSale.*;
import org.w3c.dom.ls.LSOutput;

import java.awt.*;
import java.util.List;
import java.util.Map;

/*Joanne Start
note for kaela: i got the add and subtract methods working
but having a bit of trouble with dispense
string formatting also works but will need a bit of intention on use

Notes for Joanne- do we need to switch the division instead of QUARTER/balance
and do balance/QUARTER, for example if balance is 130 divided by quarter is 130/25
would give us amountQuarter 5
 */

public class Bank {
    //Instance Variables: int balance
    //Final variables: NICKEL, DIME, QUARTER
    //   String userInput
    private  int balance;
    private double oldBalance;
    private  final int NICKEL = 5;
    private  final int DIME = 10;
    private  final int QUARTER = 25;

    //Getter & Setter balance
    public  int getBalance() {
        return balance;
    }
    public  int getNICKEL() {
        return NICKEL;
    }
    public  int getDIME() {
        return DIME;
    }
    public  int getQUARTER() {
        return QUARTER;
    }

    //make the stringformat happen elsewhere
    public double getOldBalance() {
        return oldBalance;
    }

    public void setOldBalance(double oldBalance) {
        this.oldBalance = oldBalance;
    }
    public  void setBalance(int balance) {
        this.balance = balance;
    }

    //Constructor: property --> balance (stringFormatting can be set in here)
        //balance will always start at 0.00
        //String.Format in here
    public Bank (int balance){
        this.balance = balance;
    }

    //Override: String.Format to show $0.00 format
    @Override
    public String toString(){
        double doubleBalance = balance/100.0;
        return String.format("$%.2f", doubleBalance);
    }

    //Int Method addBalance (String userInput) --> feed money
        //userInput to integer
        //reset balance to old balance
    public  int addBalance (String userInput){
        balance = balance + Integer.parseInt(userInput);
        return balance;
    }

    //Int Method subtractBalance (maybe need productPrice)
        //balance - product price
        //reset balance to old balance
    public  int subtractBalance (String userInput, Map<String, List> stockMap){
        //userInput = key in stockMap + variable to hold the value of the key
        List<Object> productList = stockMap.get(userInput);
        Object product = productList.get(0);
        int price = 0;
        //that value would be an List + grab the element of the array to access price
        if (product instanceof Product){
            price = ((Product)product).getPrice();
        }
        //oldBalance = balance - price
        if ( balance - price > 0) {
            balance = balance - price;
        }else {
            return balance;
        }
        return balance;
    }

    //Int Method dispenseChange
        //goal is to set the 0.00
    public void dispenseBalance (int balance){
        //take balance and break down into coins

        int amtQuarter = 0;
        int amtDime = 0;
        int amtNickel = 0;
        int amtPenny = 0;

        String result;



        while (balance > 0){
            if(balance != 0){
                amtQuarter = balance/QUARTER;
                balance = balance%QUARTER;
            }
            if (balance != 0){
                amtDime = balance/DIME;
                balance = balance%DIME;
            }
            if (balance != 0){
                amtNickel = balance/NICKEL;
                balance = balance%NICKEL;
            }
            if (balance != 0){
                amtPenny = balance;
                balance = 0;
            }
        }

        result = "Your change is... " +
                "\nQuarters: " + amtQuarter +
                "\nDimes: " + amtDime +
                "\nNickels: " + amtNickel +
                "\nPennies: " + amtPenny;

        System.out.println(result);
    }
}
