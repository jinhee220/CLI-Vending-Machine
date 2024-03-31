package com.techelevator.ProductsForSale;

import com.techelevator.Bank;
import java.util.Map;
import com.techelevator.PhysicalInventory;
public class Pony extends Product {

    private String ponySound= "Neigh, Neigh, Yay!";

    public String getPonySound() {
        return ponySound;
    }

    public Pony(String name, int price){
        super(name,price,"Pony");
    }

    // joanne - inventory map made! now we can update within function
    //classes imported: PhysicalInventory, Bank


    @Override
    public void dispenseProduct(Map stockMap){
        double getPrice= getPrice()/100.0;
        String formattedString = String.format("The price is: $%.2f",getPrice);
        System.out.println("Dispensing pony product:  " + getName());
        System.out.println(formattedString);
        System.out.println(ponySound);

    }

//    //Override: String.Format to show $0.00 format
//    @Override
//    public String toString(){
//        double price = getPrice()/100.0;
//        return String.format("$%.2f", price);
//    }



}

