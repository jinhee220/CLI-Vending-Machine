## Module 1 Capstone - Vending Machine Software

You're developing an application for the newest vending machine distributor,
CuteCo, Inc. They've just released a new vending machine, the Vendo-Matic 800.

### Application requirements

1. The vending machine dispenses four kinds of cute stuffed animals: ducks, penguins, cats, and ponies.
   - Each vending machine item has a Name and a Price.
2. A main menu must display when the software runs, presenting the following options:
    > ```
    > (1) Display Vending Machine Items
    > (2) Purchase
    > (3) Exit
    > ```
3. The vending machine reads its inventory from an input file when the vending machine
starts.
4. The vending machine is automatically restocked each time the application runs.
5. When the customer selects "(1) Display Vending Machine Items", they're presented
with a list of all items in the vending machine with its quantity remaining:
    - Each vending machine product has a slot identifier and a purchase price.
    - Each slot in the vending machine has enough room for 5 of that product.
    - Every product is initially stocked to the maximum amount.
    - A product that has run out must indicate that it's SOLD OUT.
6. When the customer selects "(2) Purchase", they're guided through the purchasing
process menu:
    ```
    Current Money Provided: $2.00
    
    (1) Feed Money
    (2) Select Product
    (3) Finish Transaction
    
    ```
7. The purchase process flow is as follows:
    1. Selecting "(1) Feed Money" allows the customer to repeatedly feed money into the
    machine in whole dollar amounts.
        - The "Current Money Provided" indicates how much money the customer
        has fed into the machine.
    2. Selecting "(2) Select Product" allows the customer to select a product to
    purchase.
        - Show the list of products available and allow the customer to enter
        a code to select an item.
        - If the product code doesn't exist, the vending machine informs the customer and returns them
        to the Purchase menu.
        - If a product is currently sold out, the vending machine informs the customer and returns them to the
        Purchase menu.
        - If a customer selects a valid product, it's dispensed to the customer.
        - Dispensing an item prints the item name, cost, and the money
        remaining. Dispensing also returns a message:
          - All duck items print "Quack, Quack, Splash!"
          - All penguin items print "Squawk, Squawk, Whee!"
          - All cat items print "Meow, Meow, Meow!"
          - All pony items print "Neigh, Neigh, Yay!"
        - After the machine dispenses the product, the machine must update its balance
        accordingly and return the customer to the Purchase menu.
    3. Selecting "(3) Finish Transaction" allows the customer to complete the
    transaction and receive any remaining change.
        - The machine returns the customer's money using nickels, dimes, and quarters
        (using the smallest amount of coins possible).
        - The machine's current balance updates to $0 remaining.
    4. After completing their purchase, the user returns to the "Main" menu to
    continue using the vending machine.
8. The vending machine logs all transactions to prevent theft from the vending machine.
   - Each purchase must generate a line in a file called `Vending.log`.
   - The lines must follow the format shown in the following example.
       - The first dollar amount is the amount deposited, spent, or given as change.
       - The second dollar amount is the new balance.
        ```
        02/01/2024 12:00:00 PM FEED MONEY: $5.00 $5.00 
        02/01/2024 12:00:15 PM FEED MONEY: $5.00 $10.00 
        02/01/2024 12:00:20 PM Emperor Penguin B4 $1.75 $8.25 
        02/01/2024 12:01:25 PM Unicorn Pony D2 $1.50 $6.75 
        02/01/2024 12:01:35 PM GIVE CHANGE: $6.75 $0.00
        ```
9. Create as many of your classes as possible to be "testable" classes. Limit console
input and output to as few classes as possible.
10. Optional - Sales Report
    - Provide a "Hidden" menu option on the main menu ("4") that writes to a sales
    report that shows the total sales since the machine started. The name of the
    file must include the date and time so each sales report is uniquely named.
    - An example of the output format appears at the end of this file.
11. Provide unit tests demonstrating that your code works correctly.
___
### Vending machine data file
The input file that stocks the vending machine products is a comma `,` delimited file. Each line is a separate product in the file and follows this format:

| Column Name   | Description |
----------------|-------------|
| Slot Location | The slot location in the vending machine containing the product.   |
| Product Name  | The display name of the vending machine product.                   |
| Price         | The purchase price for the product.                                |
| Type          | The product type for this row.                                     |

For example:

```
A1,Yellow Duck,3.05,Duck
B1,Emperor Penguin,1.80,Penguin
B2,Macaroni Penguin,1.50,Penguin
C1,Black Cat,1.25,Cat
```

**An input file is in your repository: `vendingmachine.csv`.**

 ---
### Sales report
The output sales report file is also comma-delimited for consistency. Each line is a separate product with the number of sales for the applicable product. At the end of the report is a blank line followed by the **TOTAL SALES** dollar amount indicating the gross sales from the vending machine.

For example:

>```
>Emperor Penguin,0
>Macaroni Penguin,1
>Yellow Duck,3
>Cube Duck,2
>Black Cat,1
>White Cat,0
>Tabby Cat,0
>Unicorn Pony,2

>
>**TOTAL SALES** $11.05
>```
