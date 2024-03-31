package com.techelevator;
 //Kaela's notes for Joanne- didn't instantiate bank class yet, let me know if this looks okay/ feel free to change anything
//added for loops to print options

import java.util.ArrayList;
import java.util.List;

//if anyone gets to it
public class Menu {
    //Instance Variables
    //   name variable menu
    //Instantiate Bank Class --> so we can display balance with menu

    private  List<String> menu;

    // Getter & Setter List

    public List<String> getMenu() {
        return menu;
    }

    public void setMenu(List<String> menu) {
        this.menu = menu;
    }

    //Constructor List --> Parameter (menu)
    //joanne - updated to empty constructor for ease of calling method

    public Menu(){
        this.menu= menu;
    }

    //void method for mainOptions ()

//hard coded in number values, before it was set to index assignments
    public static void showMainOptions(){

            /*
        Create List "1. Display Products"
        add the options we need to list
        out list */
        List<String> mainOptions= new ArrayList<>();
        mainOptions.add( "1. Display Item"); //index 0
        mainOptions.add( "2. Purchase"); //index 1
        mainOptions.add( "3. Exit"); //index 2

        //for each loop/ for loop to print out each option

            for (String option : mainOptions) {
                System.out.println(option);
            }
        }



    //void method for purchaseOptions ()


    public static void showPurchaseOptions(){

         /*
        Create List
        add the options we need to list
        sout list
         */
        List<String> purchaseOptions= new ArrayList<>() ;
            purchaseOptions.add("1. Feed Money");
            purchaseOptions.add("2. Select Product");
            purchaseOptions.add("3. Finish Transaction");

            for (String option: purchaseOptions){
                System.out.println(option);
            }


    }



}



