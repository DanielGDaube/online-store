package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


public class Store {

    public static void main(String[] args) throws FileNotFoundException {

        // Create lists for inventory and the shopping cart
        ArrayList<Product> inventory = new ArrayList<>();
        ArrayList<Product> cart = new ArrayList<>();


        // Load inventory from the data file (pipe-delimited: SKU|Product Name|Price|Department)
        loadInventory("products.csv", inventory);




        // Main menu loop
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 3) {
            System.out.println("\nWelcome to the Online Store!");
            System.out.println("1. Show Products");
            System.out.println("2. Show Cart");
            System.out.println("3. Exit");
            System.out.print("Your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter 1, 2, or 3.");
                scanner.nextLine();                 // discard bad input
                continue;
            }
            choice = scanner.nextInt();
            scanner.nextLine();                     // clear newline

            switch (choice) {
                case 1 -> displayProducts(inventory, cart, scanner);
                case 2 -> displayCart(cart, scanner);
                case 3 -> System.out.println("Thank you for shopping with us!");
                default -> System.out.println("Invalid choice!");
            }
        }
        scanner.close();
    }

    public static void loadInventory(String fileName, ArrayList<Product> inventory) {
        try {
            BufferedReader storeReader = new BufferedReader(new FileReader(fileName));

            storeReader.readLine();

            String line;

            while ((line = storeReader.readLine()) != null) {
                String[] tokens = line.split("\\|");
                String sku = tokens[0];
                String name = tokens[1];
                double price = Double.parseDouble(tokens[2]);
                String department = tokens[3];
                inventory.add(new Product(sku, name, price, department));
            }

        }
        catch (Exception e){


        }
    }

    /**
     * Displays all products and lets the user add one to the cart.
     * Typing X returns to the main menu.
     */
    public static void displayProducts(ArrayList<Product> inventory,
                                       ArrayList<Product> cart,
                                       Scanner scanner) {

        //       prompt for an id, find that product, add to cart
        for (Product product : inventory){
            System.out.println(product);
        }
        String choice = "";

        Product searchProduct;

        while (!choice.equalsIgnoreCase("x")) {
            String choiceYesNo = "";

            System.out.println("Enter item ID to search for item, or press X to return to the main menu");
            choice = scanner.nextLine();
            searchProduct = findProductById(choice, inventory);

            if (searchProduct == null && !choice.equalsIgnoreCase("x")){
                System.err.println("Invalid ID! Try again");
            }
            else {

                // Prompt the user for yes or no, yes adds item to cart, no returns to previous prompt
                while (!choiceYesNo.equalsIgnoreCase("no") && !choiceYesNo.equalsIgnoreCase("yes") && !choice.equalsIgnoreCase("x")) {
                    System.out.println("\nWould you like to add this item to your cart?\n");
                    System.out.println("Yes - Add item to cart\nNo - Search for different item");
                    choiceYesNo = scanner.nextLine();
                    if (choiceYesNo.equalsIgnoreCase("yes")) {
                        cart.add(searchProduct);
                        System.out.println("Item has been added to your cart");
                    }
                }
            }
        }

    }

    /**
     * Shows the contents of the cart, calculates the total,
     * and offers the option to check out.
     */
    public static void displayCart(ArrayList<Product> cart, Scanner scanner) {
        String choice = "";
        double totalAmount = 0.0;
        for (Product product : cart){
            System.out.println(product);
            totalAmount += product.getPrice();
        }
        System.out.println("Cart Total: $" + totalAmount);

        while (!choice.equalsIgnoreCase("x")) {
            System.out.println("Press C to check out\nPress X to return the main menu");
            choice = scanner.nextLine();
            switch (choice.toLowerCase()) {
                case "c" -> checkOut(cart, totalAmount, scanner);
                case "x" -> {}
                default -> System.err.println("Invalid input!");

            }
        }

    }

    /**
     * Handles the checkout process:
     * 1. Confirm that the user wants to buy.
     * 2. Accept payment and calculate change.
     * 3. Display a simple receipt.
     * 4. Clear the cart.
     */
    public static void checkOut(ArrayList<Product> cart,
                                double totalAmount,
                                Scanner scanner) {
        // TODO: implement steps listed above
    }

    /**
     * Searches a list for a product by its id.
     *
     * @return the matching Product, or null if not found
     */
    public static Product findProductById(String id, ArrayList<Product> inventory) {
        Product searchProduct = null;

        for (Product product : inventory){
            if (product.getSku().equals(id)){
                System.out.println(product);
                searchProduct = product;

            }
        }
        return searchProduct;
    }
}
