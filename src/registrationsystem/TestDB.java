package registrationsystem;

import com.sms.db.DatabaseConnection;
import java.sql.Connection;

public class TestDB {
    public static void main(String[] args) {
        System.out.println("--- Starting Database Connection Test ---");
        
        // Try to get the connection from our DatabaseConnection class
        Connection conn = DatabaseConnection.getConnection();
        
        if (conn != null) {
            System.out.println("✅ CONNECTION SUCCESSFUL!");
            System.out.println("Your Java app is now talking to MySQL.");
        } else {
            System.out.println("❌ CONNECTION FAILED.");
            System.out.println("Check if XAMPP is running and the DB name is correct.");
        }
    }
}