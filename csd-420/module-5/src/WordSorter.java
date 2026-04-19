import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.TreeSet;
import java.util.List;

/*
 * Abram Denzlinger
 * April 19, 2026
 * Assignment 5.2
 *
 * Class: WordSorter
 * * Functionality:
 * This program reads words from an external text file titled 'collection_of_words.txt'
 * and performs the following steps:
 * 1. Reads the file content
 * 2. Converts all words to lowercase and removes non-alphanumeric punctuation.
 * 3. Uses a TreeSet to automatically filter out duplicate entries and store
 * the remaining words in ascending order.
 * 4. Outputs the unique list of words to the console in both ascending and
 * descending sequences.
 *
 * Requirements:
 * The file 'collection_of_words.txt' must be located in the project's root directory.
 */

public class WordSorter {

    public static void main(String[] args) {
        // Test Code: Ensure the file exists
        String fileName = "collection_of_words.txt";

        System.out.println("--- Starting Word Sorter ---");
        try {
            processWords(fileName);
            System.out.println("--- Processing Completed ---");
        } catch (IOException e) {
            System.err.println("Error: Could not find '" + fileName + "'. Please make sure it is in the project root folder.");
        }
    }

    public static void processWords(String fileName) throws IOException {
        // Read all lines from the file
        List<String> lines = Files.readAllLines(Paths.get(fileName));

        // TreeSet automatically handles uniqueness and sorting
        TreeSet<String> uniqueWords = new TreeSet<>();

        for (String line : lines) {
            // Split words using whitespace
            String[] words = line.split("\\s+");

            for (String word : words) {
                if (!word.isEmpty()) {
                    // Removing non-alphanumeric characters and converting to lowercase
                    // Using Regex to replace anything that isn't a letter or number with an empty string
                    String cleanWord = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

                    // Only add if not empty (prevents adding empty strings created above
                    if (!cleanWord.isEmpty()) {
                        uniqueWords.add(cleanWord);
                    }
                }
            }
        }

        // Display Ascending
        System.out.println("\nWords in Ascending Order:");
        System.out.println(uniqueWords);

        // Display Descending
        System.out.println("\nWords in Descending Order:");
        System.out.println(uniqueWords.descendingSet());
    }
}