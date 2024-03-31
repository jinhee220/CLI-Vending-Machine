package com.techelevator.ProductsForSale;

import com.techelevator.Bank;
import java.util.Map;
import com.techelevator.PhysicalInventory;

public class Penguin extends Product {

    private String penguinSound= "Squawk, Squawk, Whee!";

    public String getPenguinSound() {
        return penguinSound;
    }

    public void setPenguinSound(String penguinSound) {
        this.penguinSound = penguinSound;
    }

    public Penguin(String name, int price){
        super(name,price,"Cat");
    }

    // joanne - inventory map made! now we can update within function
    //classes imported: PhysicalInventory, Bank
    @Override
    public void dispenseProduct(Map stockMap){
        double getPrice= getPrice()/100.0;
        String formattedString = String.format("The price is: $%.2f",getPrice);
        System.out.println("Dispensing penguin product:  " + getName());
        System.out.println(formattedString);
        System.out.println(penguinSound);
        //updates in pony

    }




}
