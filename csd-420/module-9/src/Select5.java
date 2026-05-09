import java.sql.*;

public class Select5 {

    public static void main(String args[]) {

        try {
            Connection con;

            Class.forName("com.mysql.cj.jdbc.Driver");

            // Updated URL with 127.0.0.1 and security flags for Mac/MySQL 8.4
            String url = "jdbc:mysql://127.0.0.1:3306/databasedb?allowPublicKeyRetrieval=true&useSSL=false";

            // Using the standard credential method
            con = DriverManager.getConnection(url, "student1", "pass");

            System.out.println("Connection established - now executing a select");

            Statement stmt = con.createStatement();
            
            // This pulls everything from the table you just populated
            ResultSet rs = stmt.executeQuery("SELECT * FROM address33");

            System.out.println("Received Results:");

            // This counts how many columns are in your table (should be 7)
            int i = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                for (int x = 1; x <= i; ++x) {
                    // This prints each piece of data (ID, Names, Address, etc.)
                    System.out.println(rs.getString(x));
                }
                // Adds a space between each person for readability
                System.out.println("");
            }

            stmt.close();
            con.close();
        } catch (java.lang.Exception ex) {
            // High-visibility error reporting
            ex.printStackTrace();
        }
    }
}