import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.EOFException;
import java.io.IOException;

public class DataReader {
    public static void main(String[] args) {
        // Wrapped FileInputStream in BufferedInputStream for better performance,
        // then into DataInputStream to read primitive types.
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream("abramdatafile.dat")))) {

            System.out.println("--- Reading Data from abramdatafile.dat ---");

            // Loop until the end of the records
            int recordCount = 1;
            while (true) {
                try {
                    System.out.println("Record Set #" + recordCount);

                    // Read the 5 integers
                    System.out.print("Integers: ");
                    for (int i = 0; i < 5; i++) {
                        System.out.print(dis.readInt() + " ");
                    }

                    // Read the 5 doubles
                    System.out.print("\nDoubles:  ");
                    for (int i = 0; i < 5; i++) {
                        // Formatting to 2 decimal places
                        System.out.printf("%.2f ", dis.readDouble());
                    }

                    System.out.println("\n-----------------------");
                    recordCount++;

                } catch (EOFException e) {
                    // End Of File indicator
                    break;
                }
            }

        } catch (IOException e) {
            System.err.println("Ops Error: Could not access the data file. " + e.getMessage());
        }

        System.out.println("Read operation complete.");
    }
}