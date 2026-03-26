package com.sms.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // We are using MySQL. Change 'registration_db' to your actual DB name in phpMyAdmin
    private static final String URL = "jdbc:mysql://localhost:3306/registration_db";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // Default XAMPP password is empty

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                // 1. Load the Driver (The translator)
                Class.forName("com.mysql.cj.jdbc.Driver");
                // 2. Establish the connection
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Success: Connected to the database!");
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Error: Connection failed! " + e.getMessage());
            }
        }
        return connection;
    }
}