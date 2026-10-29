package com.mycompany.finalprojectt;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * FXML Controller class
 *
 */
public class AddStudentController {

    @FXML
    TextField idtxt;
    
    @FXML
    Label relbl;
    
    @FXML
    TextField nametxt;
    
    @FXML
    TextField majortxt;

    /**
     * Method to add a new student after validation
     */
    
    @FXML
    private void AddStudent() throws IOException {
        
    // Check if any of the text fields are left empty
    if (idtxt.getText().isEmpty() || nametxt.getText().isEmpty() || majortxt.getText().isEmpty()) {
        relbl.setText("All Data Required");
    } else {
        try {
            // Extract data and safely parse the ID string into an integer
            int ID = Integer.parseInt(idtxt.getText());
            String name = nametxt.getText();
            String major = majortxt.getText();
            
            // Create a new Student object with the provided data
            Student s = new Student(name, ID, major);
            
            // Add the newly created student object to the global list
            App.Students.add(s);
            
            // Display success message and clear all text fields for next input
            relbl.setText("Student Added Successfully");
            nametxt.clear();
            majortxt.clear();
            idtxt.clear();
            
        } catch (NumberFormatException e) {
            // Catch error if the user enters non-numeric characters in the ID field
            relbl.setText("Error: ID must be numbers only!");
        }
    }
    }

    /**
     * Method to navigate back to the Dashboard
     */
    @FXML
    private void Back() throws IOException {
        App.setRoot("Dashboard");
    }  
    
}