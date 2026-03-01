/*
Abram Denzlinger
March 1, 2026
CSD-402 - Assignment 9.2

This program demonstrates collection management and basic error
trapping in Java. It initializes an ArrayList with 10 strings and
displays them using an enhanced for-each loop. The program then
prompts the user for a specific index to view again. It utilizes
autoboxing and unboxing to convert the user's string input into
an integer for list access. Finally, it uses a try/catch block to
handle any invalid inputs or out-of-range requests, displaying a
specific "Out of Bounds" message if an exception occurs.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class SimpleArrayList {
    public static void main(String[] args) {
        // Create an ArrayList and fill it with 10 Strings
        ArrayList<String> books = new ArrayList<>();
        books.add("Timeline");
        books.add("Tubes");
        books.add("World Atlas");
        books.add("Lamb");
        books.add("American Gods");
        books.add("Snow Crash");
        books.add("Mythology");
        books.add("The Winner");
        books.add("Ready Player One");
        books.add("Superfreakonomics");

        // Use a for-each loop to print the collection
        System.out.println("Available elements:");
        for (String fruit : books) {
            System.out.println(fruit);
        }

        // Setup Scanner for user input
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter the index (0-9) of the element you'd like to see again: ");
        String userInput = input.nextLine();

        // Try/Catch format to handle the requested Exception
        try {
            // Autoboxing/Unboxing: Converting String input to Integer object then to int primitive
            Integer indexObject = Integer.parseInt(userInput);
            int index = indexObject; // Auto-unboxing

            System.out.println("The element is: " + books.get(index));
        } catch (Exception e) {
            // Displayed if the index is out of range or not a number
            System.out.println("An Exception has been thrown: Out of Bounds");
        }

        input.close();
    }
}