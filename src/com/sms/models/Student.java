package com.sms.models;

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
        System.out.println("ID: " + id + " | Name: " + name + " | Course: " + course);
    }

    // Implementing Interface Methods (DatabaseOperations)
    @Override
    public void add() {
        // We will add JDBC logic here in Day 3
        System.out.println("Adding student to database...");
    }

    @Override
    public void delete() {
        System.out.println("Deleting student...");
    }

    @Override
    public void update() {
        System.out.println("Updating student...");
    }

    @Override
    public void search(String keyword) {
        System.out.println("Searching for: " + keyword);
    }
}