import java.util.Comparator;

/** Abram Denzlinger
 * April 26, 2026
 * Assignment 6.2

 * *
 * Bubble_Sort.java
 * *
 * This program demonstrates a generic implementation of the Bubble Sort algorithm.
 * It uses Comparable and Comparator interfaces to sort an array.
 * *
 * 1. Comparable Approach: Uses the object's "natural ordering" to sort ascending.
 * 2. Comparator Approach: Uses custom rules (descending order) to re-sort the
 * same list, providing a built-in test of functionality.
 * 3. Printing starting state, when changes are made, and final states further
 * tests and demonstrates functionality.
 */

public class Bubble_Sort {

    public static void main(String[] args) {
        // test values from example solution in Blackboard
        Integer[] testValues = {5, 3, 4, 9, 0, 1, 2, 7, 6, 8};

        System.out.println("--- Phase 1: Comparable Sort (Ascending) ---");
        System.out.println("Starting state:");
        printArray(testValues);

        // Running the Comparable sort
        bubbleSort(testValues);

        System.out.println("Result (Ascending):");
        printArray(testValues);

        // Re-sorting the same array, but descending this time
        System.out.println("--- Phase 2: Comparator Sort (Descending) ---");

        System.out.println("Re-sorting the same array in descending order:...");

        // Running Comparator sort to reverse the order
        bubbleSort(testValues, (a, b) -> b.compareTo(a));

        System.out.println("Result (Descending):");
        printArray(testValues);
    }

    // Bubble Sort using Comparable
    public static <T extends Comparable<T>> void bubbleSort(T[] array) {
        System.out.println("--> Running Comparable method:");
        T temp;
        for (int i = 0; i < array.length - 1; ++i) {
            for (int j = 0; j < array.length - 1; ++j) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    System.out.println("Switch made");
                }
            }
        }
    }

    // Bubble Sort using Comparator
    public static <T> void bubbleSort(T[] array, Comparator<T> comparator) {
        System.out.println("--> Running Comparator method:");
        T temp;
        for (int i = 0; i < array.length - 1; ++i) {
            for (int j = 0; j < array.length - 1; ++j) {
                if (comparator.compare(array[j], array[j + 1]) > 0) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    System.out.println("Switch made");
                }
            }
        }
    }

    // Helper method to print the array
    public static <T> void printArray(T[] arrayParam) {
        System.out.print("array = {");
        for (T e : arrayParam) {
            System.out.print(" [" + e + "] ");
        }
        System.out.println("};\n");
    }
}