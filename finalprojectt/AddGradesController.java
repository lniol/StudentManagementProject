/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.finalprojectt;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class AddGradesController implements Initializable {

    @FXML
    private ComboBox<Integer> StdIds;
    
    @FXML
    private TextField gradetxt;
    
    @FXML
    private Label reslbl;
    
    @FXML
    private Button AddGrade;

    /**
     * Initializes the controller class. Automatically runs when the page opens.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Clear any existing items in the ComboBox to prevent duplicates
        StdIds.getItems().clear();
        
        // Check if the global list in App is empty
        if (App.Students.isEmpty()) {
            reslbl.setText("No Students, please add Students first");
        }
        
        // Loop through the list of students and add their IDs to the ComboBox
        for (Student s : App.Students) {
            StdIds.getItems().add(s.getID());
        }
        
        // If the ComboBox contains data, select the first student ID by default
        if (!StdIds.getItems().isEmpty()) {
            StdIds.getSelectionModel().select(0);
        }
    }

    /**
     * Method to assign a grade to the selected student ID
     */
    @FXML
    private void AddGrade() throws IOException {
        // Make sure there are students available in the system
        if (!App.Students.isEmpty()) {
            // Check if the grade text field is empty
            if (gradetxt.getText().isEmpty()) {
                reslbl.setText("All Data Required");
            } else {
                // Get the currently selected student ID from the ComboBox
                int id = StdIds.getSelectionModel().getSelectedItem();

                // Look for the student with the matching ID in the system list
                for (Student s : App.Students) {
                    if (s.getID() == id) {
                        // Update the student's grade and display a success message
                        s.setGrade(Double.parseDouble(gradetxt.getText()));
                        reslbl.setText("Grade Added Successfully!");
                    }
                }
            }
        }
    }

    /**
     * Method to navigate back to the Dashboard screen
     */
    @FXML
    private void Back() throws IOException {
        App.setRoot("Dashboard");
    }
}