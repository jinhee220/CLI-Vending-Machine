package com.techelevator.ProductsForSale;

import java.util.List;
import java.util.Map;


import com.techelevator.Bank;
import com.techelevator.PhysicalInventory;

public class Cat extends Product {

    private String catSound = "Meow, Meow, Meow!";

    public String getCatSound() {
        return catSound;
    }

    public void setCatSound(String catSound) {
        this.catSound = catSound;
    }

    public Cat(String name, int price) {
        super(name, price, "Cat");
    }

    // joanne - inventory map made! now we can update within function
    //classes imported: PhysicalInventory, Bank


    @Override
    public void dispenseProduct(Map stockMap) {
        double getPrice= getPrice()/100.0;
        String formattedString = String.format("The price is: $%.2f",getPrice);
        System.out.println("Dispensing cat product:  " + getName());
        System.out.println(formattedString);
        System.out.println(catSound);
    }
}


