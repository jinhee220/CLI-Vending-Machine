package com.techelevator.ProductsForSale;


//Kaela's Notes for Joanne-
//Need to add a way to display the balance to the customer after displaying the product name, cost and sound

import com.techelevator.Bank;

import java.util.List;
import java.util.Map;

public abstract class Product {
    //Instance Variables: name, price, type
    private String name;
    private int price;
    private String type;
    //getter setter for all


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    //constructor (default)
    public Product() {

    }

    public Product(String name, int price, String type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }


    //method dispenseProduct (String productName)
        /*
        print type & cost
        make sound
        update inventory * Need to connect to Purchase Inventory
        update balance *Need to connect to money class
         */


    //removed make sound, in your overrides the sound is already produced
    //public abstract void makeSound();

    //joanne - removed the logic inside, it was printing things
    public abstract void dispenseProduct(Map map);

    //Override: String.Format to show $0.00 format
    @Override
    public String toString(){
        double doublePrice = price/100.0;
        return String.format("$%.2f", doublePrice);
    }
}



//switch case

