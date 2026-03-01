
/*
Abram Denzlinger
March 1, 2026
CSD-402 - Assignment 9.2

This program handles persistent data storage by interacting
with the local file system. It checks for the existence of a file
named data.file and either creates it or prepares to append to it.
The program generates 10 random integers, writing them to the file
separated by spaces. After closing the file to ensure data integrity,
it reopens the file using a Scanner to read the stored values back
into the program and display them to the console.
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

public class FileHandler {
    public static void main(String[] args) {
        // Define the file name as specified
        File dataFile = new File("data.file");
        Random rand = new Random();

        try {
            // Create file if it doesn't exist, or append if it does
            // 'true' indicates append mode
            FileWriter writer = new FileWriter(dataFile, true);

            for (int i = 0; i < 10; i++) {
                // Generate random numbers (0-99) and add a space
                int randomNumber = rand.nextInt(100);
                writer.write(randomNumber + " ");
            }
            writer.close();

            // Reopen the file to read and display the data
            Scanner reader = new Scanner(dataFile);
            System.out.println("Reading data from data.file:");

            while (reader.hasNext()) {
                System.out.print(reader.next() + " ");
            }
            System.out.println(); // Final newline for formatting

            reader.close();

        } catch (IOException e) {
            System.out.println("An error occurred during file operations.");
        }
    }
}