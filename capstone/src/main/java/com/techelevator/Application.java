package com.techelevator;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import com.techelevator.ProductsForSale.*;

import static com.techelevator.PhysicalInventory.*;
/*
Restock on program Start
Process all UserInput
Closes System
*/

//joanne - this looked amazing! All I did was add in the parts we needed for purchase!
//to joanne- added boolean for isvalidbill and then put if else into the case for feed money, check out and let me know, also feel free to move any methods or anything
public class Application {

	private static boolean isValidBill(int amountInCents) {
		return amountInCents == 100 || amountInCents == 500 || amountInCents == 1000 || amountInCents == 2000;
	}

	public static void main(String[] args) throws FileNotFoundException {

		VendingLogger log = new VendingLogger();

		//make a scanner to process input
		Scanner scanner= new Scanner(System.in);

		//restock products - keep map parameter stockMap consistent
		Map<String, List> stockMap = new HashMap<>();
		restock(stockMap);

		// Get user input for main menu
		boolean isProgramOn = true;

		Bank b = new Bank(0);

		System.out.println("//--------------------------------//");
		System.out.println("//-----Welcome To TE-Vending!-----//");
		System.out.println("//--------------------------------//");
		System.out.println();



		while (isProgramOn) {
			// Main menu loop
			System.out.println("Please select an option.");
			Menu.showMainOptions();
			String userInput = scanner.nextLine();
			switch (userInput) {

				//-------- NEW CASE: MAIN --------//
				case "1": // Display Products
					System.out.println("<-------------------------->");

					showStock(stockMap);

					System.out.println("<-------------------------->");
					System.out.println();
					break;

				//-------- NEW CASE: MAIN --------//
				case "2": // Purchase
					boolean isTransactionOn = true;
					System.out.println();
					System.out.println("**-------------------------------**");
					System.out.println();

					while (isTransactionOn) {
						String stringBalance = String.format("$%.2f",b.getBalance()/100.00);
						System.out.println("Please select an option. \n Balance: " + stringBalance);
						Menu.showPurchaseOptions();
						userInput = scanner.nextLine();

						switch (userInput){
								//-------- NEW CASE: PURCHASE --------//
							case "1": //Feed Money
								System.out.println();
								System.out.println("How much would you like to insert? \n 1.00 | 5.00 | 10.00 | 20.00");
								userInput = scanner.nextLine();

								if (userInput.equalsIgnoreCase("exit")) {

									break;
								}

								try{
									int amountInCents= Integer.parseInt(userInput.replace(".",""));
									if(isValidBill(amountInCents)) {

										b.setOldBalance(b.getBalance());
										b.addBalance(userInput.replace(".", ""));
										//log
										log.logTransaction("FEED MONEY", b.getOldBalance(), b.getBalance());
										System.out.println();
										System.out.println("**-------------------------------**");
										break;
									}else{
										System.out.println("Please enter valid bill: 1.00, 5.00, 10.00, 20.00. Select 1 to try again");
										break;
									}
								}catch (Exception e){
									System.out.println("Please enter a $0.00 amount!");

									System.out.println();
									System.out.println("**-------------------------------**");
									break;
								}

								//-------- NEW CASE: PURCHASE --------//
							case "2": //Select Product
								showStock(stockMap);
								System.out.println("Please select a product using the slot ID.");
								userInput = scanner.nextLine();
								try {
									//the if statements get for product child type
									if (userInput.equals("A1") || userInput.equals("A2") || userInput.equals("A3") || userInput.equals("A4")) {
										b.setOldBalance(b.getBalance());
										b.subtractBalance(userInput, stockMap);
										if(b.getOldBalance() == b.getBalance()){
											System.out.println("Balance is not high enough! Please add more money!");
											System.out.println();
											System.out.println("**-------------------------------**");
											break;
										}
										System.out.println();
										System.out.println("**-------------------------------**");
										unBoxAndDispense(stockMap, userInput);
										updateStock(stockMap, userInput);
										//log
										log.logTransaction(unboxName(stockMap, userInput) + " bought", b.getOldBalance(), b.getBalance());
										System.out.println();
										System.out.println("**-------------------------------**");
									}

									if (userInput.equals("B1") || userInput.equals("B2") || userInput.equals("B3") || userInput.equals("B4")) {
										b.setOldBalance(b.getBalance());
										b.subtractBalance(userInput, stockMap);
										if(b.getOldBalance() == b.getBalance()){
											System.out.println("Balance is not high enough! Please add more money!");
											System.out.println();
											System.out.println("**-------------------------------**");
											break;
										}
										System.out.println();
										System.out.println("**-------------------------------**");
										unBoxAndDispense(stockMap, userInput);
										updateStock(stockMap, userInput);
										log.logTransaction(unboxName(stockMap, userInput), b.getOldBalance(), b.getBalance());
										//log
										System.out.println();
										System.out.println("**-------------------------------**");
									}

									if (userInput.equals("C1") || userInput.equals("C2") || userInput.equals("C3") || userInput.equals("C4")) {
										b.setOldBalance(b.getBalance());
										b.subtractBalance(userInput, stockMap);
										if(b.getOldBalance() == b.getBalance()){
											System.out.println("Balance is not high enough! Please add more money!");
											System.out.println();
											System.out.println("**-------------------------------**");
											break;
										}
										System.out.println();
										System.out.println("**-------------------------------**");
										unBoxAndDispense(stockMap, userInput);
										updateStock(stockMap, userInput);
										log.logTransaction(unboxName(stockMap, userInput), b.getOldBalance(), b.getBalance());
										//log
										System.out.println();
										System.out.println("**-------------------------------**");
									}

									if (userInput.equals("D1") || userInput.equals("D2") || userInput.equals("D3") || userInput.equals("D4")) {
										b.setOldBalance(b.getBalance());
										b.subtractBalance(userInput, stockMap);
										if(b.getOldBalance() == b.getBalance()){
											System.out.println("Balance is not high enough! Please add more money!");
											System.out.println();
											System.out.println("**-------------------------------**");
											break;
										}
										System.out.println();
										System.out.println("**-------------------------------**");
										unBoxAndDispense(stockMap, userInput);
										updateStock(stockMap, userInput);
										log.logTransaction(unboxName(stockMap, userInput), b.getOldBalance(), b.getBalance());
										//log
										System.out.println();
										System.out.println("**-------------------------------**");
									} else {
										throw new Exception();
									}
									break;
								}catch (Exception e) {
									System.out.println();
									System.out.println("**-------------------------------**");

									System.out.println("Please enter an existing slot ID!");

									System.out.println();
									System.out.println("**-------------------------------**");
									break;
								}

								//-------- NEW CASE: PURCHASE --------//
							case "3": //Finish Transaction
								b.setOldBalance(b.getBalance());
								b.dispenseBalance(b.getBalance());
								log.logTransaction("Change Dispensed", b.getOldBalance(), b.getBalance());
								//log
								isTransactionOn = false;

								System.out.println();
								System.out.println("**-------------------------------**");
								break;

							//-------- NEW CASE: PURCHASE --------//
							default:
								System.out.println("Invalid choice. Please try again and make sure you are selecting 1, 2, or 3.");

								System.out.println();
								System.out.println("**-------------------------------**");
								System.out.println();
						}
					}
					break;

				//-------- NEW CASE: MAIN --------//
				case "3": // Exit
					System.out.println("Exiting application. Have a great day!");
					isProgramOn = false;
					System.exit(0);
					break;

				//-------- NEW CASE: MAIN --------//
				default:
					System.out.println("Invalid choice. Please try again and make sure you are selecting 1, 2, or 3.");

					System.out.println();
					System.out.println("**-------------------------------**");
					System.out.println();
			}
		}

	}
//Notes: I think this logic works for always displaying the main menu when the machine is turned on, then taking the
	//userInput and then getting to the purchase menu option if they choose case 2, then if they hit anything but
	//1,2,3 they get an invalid choice/error message.

		//while (input != "3") - Notes- did this as a default at the bottom
		//switch (userInput)

			//case "1": Display Product -->  call Product.displayProducts()- Note: called the stockMap to display


			//case "2": Purchase --> call Menu.purchaseOptions() - called the purchase menu

				//while (input != finish)
				//switch (userInput)

					//case "1": Display Products --> back to purchaseMenu

					//case "2": Feed Money --> back to purchaseMenu

					//case "3": Select Products --> back to purchaseMenu

					//case "4": Finish Transaction --> back to mainMenu

		//Exit
	}



