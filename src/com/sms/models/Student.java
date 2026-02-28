package com.sms.models;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.sms.db.DatabaseConnection;
// Student inherits from Person and must implement DatabaseOperations
public class Student extends Person implements DatabaseOperations {
    private int id;
    private String course;
    private int marks;

    public Student(int id, String name, String email, String course, int marks) {
        super(name, email); // Calls the constructor of the Abstract Person class
        this.id = id;
        this.course = course;
        this.marks = marks;
    }

    // Implementing the Abstract method from Person
    @Override
    public void displayInfo() {
        System.out.println("ID: " + id + " | Name: " + name + " | Course: " + course+" | marks :"+marks);
    }

    // Implementing Interface Methods (DatabaseOperations)
    @Override
    public void add() {
        // 1. Get the connection we tested earlier
        java.sql.Connection conn = com.sms.db.DatabaseConnection.getConnection();
        
        // 2. Prepare the SQL command
        String sql = "INSERT INTO students (id, name, email, course, marks) VALUES (?, ?, ?, ?, ?)";
        
        try {
            // 3. Create a PreparedStatement to prevent SQL injection
            java.sql.PreparedStatement pstmt = conn.prepareStatement(sql);
            
            // 4. Fill in the '?' placeholders with this object's data
            pstmt.setInt(1, this.id);
            pstmt.setString(2, this.name);   // Inherited from Person
            pstmt.setString(3, this.email);  // Inherited from Person
            pstmt.setString(4, this.course);
            pstmt.setInt(5, this.marks);
            
            // 5. Run the command
            pstmt.executeUpdate();
            System.out.println("✅ Success: Student " + this.name + " has been saved to MySQL!");
            
        } catch (java.sql.SQLException e) {
            System.out.println("❌ Database Error: " + e.getMessage());
        }
    }

    @Override
    public void delete() {
        java.sql.Connection con=com.sms.db.DatabaseConnection.getConnection();
        String sql = "DELETE FROM students WHERE id = ?";
        
        try{
            java.sql.PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1, this.id);
            int rowsdeleted=pst.executeUpdate();
            if(rowsdeleted>0){
                System.out.print("well deleted");
            }
            else{
                System.out.print("not deleted");
            }
        }catch(Exception e){
            
        }
        System.out.println("Deleting student...");
        
    }

    @Override
    public void update() {
        java.sql.Connection con = com.sms.db.DatabaseConnection.getConnection();
        String sql = "UPDATE students SET name = ?, course = ? WHERE id = ?";

        try {
            java.sql.PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, "mugisha");
            pst.setString(2, "computer and software engineering");
            pst.setInt(3, 1);
                

            // ⭐ THIS IS THE MISSING LINE:
            int rowsAffected = pst.executeUpdate(); 

            if (rowsAffected > 0) {
            System.out.println("✅ Success: Student updated!");
            } else {
                System.out.println("⚠️ Warning: No student found with ID 1.");
            }
            } catch (Exception e) {
            System.out.println("❌ Database Error: " + e.getMessage());
            }
    }

    @Override
    public void search(String keyword) {
        System.out.println("Searching for: " + keyword);
    }
}