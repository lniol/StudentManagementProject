/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalprojectt;
import java.io.Serializable;

/**
 * Student Model Class
 * Implements Serializable to allow student objects to be saved into binary files.
 * 
 */
public class Student implements Serializable {
    
   // Private attributes to ensure Encapsulation (Data Hiding)
   private String name;
   private int ID;
   private String major;
   private Double Grade;

    /**
     * Constructor to initialize a new Student object with essential details
     */
    public Student(String name, int ID, String major) {
        this.name = name;
        this.ID = ID;
        this.major = major;
    }

    // --- Getters and Setters Methods ---

    /**
     * @return the name of the student
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set for the student
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the ID of the student
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set for the student
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the major of the student
     */
    public String getMajor() {
        return major;
    }

    /**
     * @param major the major to set for the student
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * @return the grade of the student
     */
    public Double getGrade() {
        return Grade;
    }

    /**
     * @param Grade the grade to set for the student
     */
    public void setGrade(Double Grade) {
        this.Grade = Grade;
    }
    
}