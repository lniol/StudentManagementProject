/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.finalprojectt;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class DashboardController {
    
    @FXML
    Label reslbl;
      
    /**
     * Method to serialize and save the current student list into a binary file
     */
    
    @FXML
    private void SaveToFile() throws IOException {
        try {
            // Locate the data file
            File f = new File("data.bin");
            // Delete the old file version if it exists to overwrite fresh data
            f.delete();
            
            // Initialize streams to write object data to the binary file
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.bin"));
            
            // Write the entire Students ArrayList to the file
            oos.writeObject(App.Students);
            
            // Update UI status label and close the stream safely
            reslbl.setText("Successfully saved " + App.Students.size() + " students to file");
            oos.close();
        } catch (IOException e) {
            // Handle any file system or writing errors
            reslbl.setText("Error saving to file: " + e.getMessage());
       }
    }

    /**
     * Method to deserialize and load the student list back into the app from the binary file
     */
    @FXML
    private void ReadFromFile() throws IOException {
        // Automatically opens and manages the input stream using try-with-resources
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.bin"))) {
            // Clear existing runtime data before loading saved data
            App.Students.clear();
            
            // Read the object from file and cast it back to an ArrayList of Students
            App.Students = (ArrayList<Student>) ois.readObject();
            
            // Update UI status label with the count of loaded records
            reslbl.setText("Successfully loaded " + App.Students.size() + " students from file");
        } catch (IOException | ClassNotFoundException e) {
            // Handle cases where the file doesn't exist, is corrupted, or object class mismatches
            reslbl.setText("Error loading from file: " + e.getMessage());
        }
    }
    
    /**
     * Navigation: Switches scene to the AddStudent page
     */
    @FXML
    private void Addstudent() throws IOException {
         App.setRoot("AddStudent");
    }

    /**
     * Navigation: Switches scene to the AddGrades page
     */
    @FXML
    private void openAddGrades() throws IOException {
        App.setRoot("AddGrades"); 
    }

    /**
     * Navigation: Switches scene to the ViewStudents page
     */
    @FXML
    private void ShowStudent() throws IOException {
        App.setRoot("ViewStudents");
    }
    
    /**
     * Navigation: Switches scene to the ViewReports page
     */
    @FXML
    private void Report() throws IOException {
        App.setRoot("ViewReports");
    }
    
    @FXML
    private void logout() throws IOException {
        App.setRoot("LoginPage");
    }

}