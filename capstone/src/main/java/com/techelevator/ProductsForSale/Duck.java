package com.techelevator.ProductsForSale;

import com.techelevator.Bank;
import com.techelevator.PhysicalInventory;
import com.techelevator.VendingLogger;

import java.util.Map;

//extend product
public class Duck extends Product {


    //share product variables
    private String duckSound = "Quack, Quack, Splash!";

    //share product getter and setter


    public String getDuckSound() {
        return duckSound;
    }

    public void setDuckSound(String duckSound) {
        this.duckSound = duckSound;
    }

    //removed sound constructor, don't think we'll need it functionallu
    //it makes producing a inventory more difficult
    public Duck(String name, int price) {
        super(name, price, "Duck");
    }




    // joanne - inventory map made! now we can update within function
    //classes imported: PhysicalInventory, Bank
    @Override
    public void dispenseProduct(Map stockMap) {
        double getPrice= getPrice()/100.0;
        String formattedString = String.format("The price is: $%.2f",getPrice);
        System.out.println("Dispensing duck product:  " + getName());
        System.out.println(formattedString);
        System.out.println(duckSound);
    }

}








