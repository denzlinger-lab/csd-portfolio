import java.util.Random;
import java.io.FileOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class RandomArrays {
    public static void main(String[] args) {
        Random rand = new Random();

        int[] intArray = new int[5];
        double[] doubleArray = new double[5];

        for (int i = 0; i < 5; i++) {
            intArray[i] = rand.nextInt(100);
            doubleArray[i] = rand.nextDouble();
        }

        // 'true' flag enables append mode.
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("abramdatafile.dat", true))) {

            for (int val : intArray) {
                dos.writeInt(val);
            }

            for (double val : doubleArray) {
                dos.writeDouble(val);
            }

            System.out.println("Data successfully appended to abramdatafile.dat");

        } catch (IOException e) {
            System.err.println("IT Ops Alert: Write failed! " + e.getMessage());
        }
    }
}