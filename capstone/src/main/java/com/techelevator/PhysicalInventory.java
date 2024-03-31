package com.techelevator;

//import products package

//Joanne start

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import com.techelevator.ProductsForSale.*;

public class PhysicalInventory {
    //Instance Variables: Map key = SlotID: value = List products
    //     A1: [yellow duck, yellow duck, yellow ducks, yellow duck, yellow duck]
    //Constant for max Quantity = 5;
    // int variable for current quantity
    private static Map<String, List> stockMap = new HashMap<>();
    private static final int MAX_QUANTITY = 5;
    private static int currentQuantity;
    public static final String INV_FILE = "vendingmachine.csv";

    //getter / setter for maxQuantity/ currentQuantity, Map
    public static Map<String, List> getStockMap() {
        return stockMap;
    }

    public static void updateStock(String name, int i) {
    }

    public int getCurrentQuantity() {
        return currentQuantity;
    }
    public int getMAX_QUANTITY() {
        return MAX_QUANTITY;
    }

    public void setStockMap(Map<String, List> stockMap) {
        this.stockMap = stockMap;
    }
    public void setCurrentQuantity(int currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    // joanne - empty parameters to make call easier
    public PhysicalInventory (){
        this.stockMap = getStockMap();
        this.currentQuantity = getCurrentQuantity();
    }

    /*
    Add a update inventory method (maybe)
     */
    public static void updateStock(Map stockMap, String userInput){
        String key = userInput;
        List productList = (List) stockMap.get(key);
        //use key to access map
        try{
            if (productList.size() > 0 ){
                productList.remove(0);
            }else {
                throw new Exception();
            }
        }catch (Exception e){
            System.out.println("ITEM OUT OF STOCK");
        }
    }

    //created a method to unbox from list in map value and dispense
    public static void unBoxAndDispense (Map stockMap, String userInput){
        List productList = (List) stockMap.get(userInput);
        Object product = productList.get(0);
        if (product instanceof Product) {
            ((Product) product).dispenseProduct(stockMap);
        }
    }

    public static String unboxName (Map stockMap, String userInput){
        String result = "";
        List productList = (List) stockMap.get(userInput);
        Object product = productList.get(0);
        if (product instanceof Product) {
            result = ((Product) product).getName();
        }
        return result;
    }


    //Created a new method for producing a new List with hashmap + product data
    /* joanne
    1. without moving to a new hashmap, the array just prints out object references
    2. once you unwrap the value List --> Object --> subclass, you can access the product.getName() getter
    3. this lets us show the object name as the value, without leaking reference information
    4. but if you output hashmap as is, key slots are not sorted (maps are difficult to sort)
    5. so you convert the map to a list of strings (key + value.getName())
    6. then sort the List and output results
     */
    public static void showStock( Map<String,List> stockMap){
        //create a container map to allow data type flexibility
        Map<String, String> showMap = new HashMap<>();

        //work through the keyset of original to add entries
        for (String key : stockMap.keySet()) {
            List productList = stockMap.get(key);
            //unwrap element object from List container
            Object product = productList.get(0);
            //unwrap from super Object to Product subclass
            if (product instanceof  Product) {
                double itemPrice = ((Product)product).getPrice()/100.00;
                String.format("$%.2f", itemPrice);
                showMap.put(key, itemPrice + " " + ((Product)product).getName());
            }
        }

        //convert map to list for sorting
        //joanne - added quantity remaining
        List<String> showList = new ArrayList<>();
        for (String key : showMap.keySet()) {
            showList.add(key + ": " + showMap.get(key) + ", "
                    + stockMap.get(key).size() + " remaining");
        }

        Collections.sort(showList);
        for (int i=0; i < showList.size(); i++) {
            System.out.println(showList.get(i));
        }

    }


    //void method: restockInventory (map) --> map parameter, we will access in main
    /* joanne
    1. grab text line --> delineate to array --> assign variables to access easy
    2. since we're dealing with integer, price had trouble parsing due to decimal (nullPointExcept)
       therefore I replaced the decimal with an empty string, then parsed to integer
    3. this allowed the program to pass to the switch cases (I hardcoded for the sake of time..
       finding a way to automate would have taken a while)
    4. within each case, we create a list and add 5 different instances of the same item
    5. finally put the element into Map as <Slot : List>
     */
    public static void restock (Map<String,List> stockMap){
        //delineate file and assign variables
        File inventoryPath = new File(INV_FILE);
        try (Scanner readInventory = new Scanner(inventoryPath)) {
            while (readInventory.hasNextLine()) {
                //delineate by ","
                String infoLine = readInventory.nextLine();
                String[] productInfo = infoLine.split(",");

                String slot = productInfo[0];
                String name = productInfo[1];
                int price = Integer.parseInt(productInfo[2].replace(".", ""));

                    //Switch case using slot
                 switch (slot) {
                     //Ducks
                     case "A1":
                         currentQuantity = 0;
                         //create and add object to new list
                         List<Duck> yellowDuckList = new ArrayList<>();
                         while (currentQuantity < MAX_QUANTITY) {
                             yellowDuckList.add(new Duck(name, price));
                             currentQuantity += 1;
                         }
                         stockMap.put(slot, yellowDuckList);


                     case "A2":
                         currentQuantity = 0;
                         //create and add object to new list
                         List<Duck> cubeDuckList = new ArrayList<>();
                         while (currentQuantity < MAX_QUANTITY) {
                             cubeDuckList.add(new Duck(name, price));
                             currentQuantity += 1;
                         }
                         stockMap.put(slot, cubeDuckList);

                     case "A3":
                         currentQuantity = 0;
                         //create and add object to new list
                         List<Duck> beachDuckList = new ArrayList<>();
                         while (currentQuantity < MAX_QUANTITY) {
                             beachDuckList.add(new Duck(name, price));
                             currentQuantity += 1;
                         }
                         stockMap.put(slot, beachDuckList);

                     case "A4":
                         currentQuantity = 0;
                         //create and add object to new list
                         List<Duck> batDuckList = new ArrayList<>();
                         while (currentQuantity < MAX_QUANTITY) {
                             batDuckList.add(new Duck(name, price));
                             currentQuantity += 1;
                         }
                         stockMap.put(slot, batDuckList);
                         break;

                     //Penguins
                     case "B1":
                         currentQuantity = 0;
                         //create and add object to new list
                         List<Penguin> emporerPenguinList = new ArrayList<>();
                         while (currentQuantity < MAX_QUANTITY) {
                             emporerPenguinList.add(new Penguin(name, price));
                             currentQuantity += 1;
                         }
                         stockMap.put(slot, emporerPenguinList);

                     case "B2":
                         currentQuantity = 0;
                         //create and add object to new list
                         List<Penguin> macaroniPenguinList = new ArrayList<>();
                         while (currentQuantity < MAX_QUANTITY) {
                             macaroniPenguinList.add(new Penguin(name, price));
                             currentQuantity += 1;
                         }
                         stockMap.put(slot, macaroniPenguinList);

                     case "B3":
                         currentQuantity = 0;
                         //create and add object to new list
                         List<Penguin> rockhopperPenguinList = new ArrayList<>();
                         while (currentQuantity < MAX_QUANTITY) {
                             rockhopperPenguinList.add(new Penguin(name, price));
                             currentQuantity += 1;
                         }
                         stockMap.put(slot, rockhopperPenguinList);

                     case "B4":
                         currentQuantity = 0;
                         //create and add object to new list
                         List<Penguin> galapagosPenguinList = new ArrayList<>();
                         while (currentQuantity < MAX_QUANTITY) {
                             galapagosPenguinList.add(new Penguin(name, price));
                             currentQuantity += 1;
                         }
                         stockMap.put(slot, galapagosPenguinList);
                         break;

                     //Cats
                     case "C1":
                         currentQuantity = 0;
                         //create and add object to new list
                         List<Cat> blackCatList = new ArrayList<>();
                         while (currentQuantity < MAX_QUANTITY) {
                             blackCatList.add(new Cat(name, price));
                             currentQuantity += 1;
                         }
                         stockMap.put(slot, blackCatList);

                     case "C2":
                         currentQuantity = 0;
                         //create and add object to new list
                         List<Cat> whiteCatList = new ArrayList<>();
                         while (currentQuantity < MAX_QUANTITY) {
                             whiteCatList.add(new Cat(name, price));
                             currentQuantity += 1;
                         }
                         stockMap.put(slot, whiteCatList);

                     case "C3":
                         currentQuantity = 0;
                         //create and add object to new list
                         List<Cat> tabbyCatList = new ArrayList<>();
                         while (currentQuantity < MAX_QUANTITY) {
                             tabbyCatList.add(new Cat(name, price));
                             currentQuantity += 1;
                         }
                         stockMap.put(slot, tabbyCatList);

                     case "C4":
                         currentQuantity = 0;
                         //create and add object to new list
                         List<Cat> calicoCatList = new ArrayList<>();
                         while (currentQuantity < MAX_QUANTITY) {
                             calicoCatList.add(new Cat(name, price));
                             currentQuantity += 1;
                         }
                         stockMap.put(slot, calicoCatList);
                         break;

                     //Pony
                     case "D1":
                         currentQuantity = 0;
                         //create and add object to new list
                         List<Pony> unicornPonyList = new ArrayList<>();
                         while (currentQuantity < MAX_QUANTITY) {
                             unicornPonyList.add(new Pony(name, price));
                             currentQuantity += 1;
                         }
                         stockMap.put(slot, unicornPonyList);

                     case "D2":
                         currentQuantity = 0;
                         //create and add object to new list
                         List<Pony> pegasusPonyList = new ArrayList<>();
                         while (currentQuantity < MAX_QUANTITY) {
                             pegasusPonyList.add(new Pony(name, price));
                             currentQuantity += 1;
                         }
                         stockMap.put(slot, pegasusPonyList);

                     case "D3":
                         currentQuantity = 0;
                         //create and add object to new list
                         List<Pony> horseList = new ArrayList<>();
                         while (currentQuantity < MAX_QUANTITY) {
                             horseList.add(new Pony(name, price));
                             currentQuantity += 1;
                         }
                         stockMap.put(slot, horseList);

                     case "D4":
                         currentQuantity = 0;
                         //create and add object to new list
                         List<Pony> rainbowHorseList = new ArrayList<>();
                         while (currentQuantity < MAX_QUANTITY) {
                             rainbowHorseList.add(new Pony(name, price));
                             currentQuantity += 1;
                         }
                         stockMap.put(slot, rainbowHorseList);
                         break;
                 }
            }
        }catch (FileNotFoundException fnf) {
            System.out.println(fnf.getMessage());
        }
    }
}

