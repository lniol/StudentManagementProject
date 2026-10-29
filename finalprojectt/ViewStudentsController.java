package com.mycompany.finalprojectt;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

// Initializable is an interface - by implementing it we are required
// to override the initialize method which runs automatically when the screen loads
public class ViewStudentsController implements Initializable {

    // dropdown list that shows all student IDs
    @FXML
    ComboBox StdIds;

    // label that displays the student information on screen
    @FXML
    Label reslbl;

    // this method is from the Initializable interface
    // it runs automatically when the page loads - before the user does anything
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // clear the dropdown first to avoid duplicates
        StdIds.getItems().clear();

        // if the list is empty, tell the user to add students first
        if (App.Students.isEmpty()) {
            reslbl.setText("No students added yet. Please go back and add a student.");
            return;
        }

        // loop through all students and add their IDs to the dropdown
        for (Student student : App.Students) {
            StdIds.getItems().add(student.getID());
        }

        // automatically highlight the first option in the dropdown
        StdIds.getSelectionModel().selectFirst();
    }

    // runs when the user clicks the "Show Details" button
    @FXML
    private void showStudent() throws IOException {

        // make sure there are students to search through
        if (App.Students.isEmpty()) return;

        // get the ID the user selected from the dropdown
        int selectedID = (int) StdIds.getSelectionModel().getSelectedItem();

        // search for the student that matches the selected ID
        for (Student student : App.Students) {
            if (student.getID() == selectedID) {
                // once found, display all their details in the label
                reslbl.setText(
                    "Name   : " + student.getName() +
                    "\nID     : " + student.getID() +
                    "\nMajor  : " + student.getMajor() +
                    "\nGrade  : " + student.getGrade()
                );
            }
        }
    }

    // goes back to the main dashboard when Back is clicked
    @FXML
    private void Back() throws IOException {
        App.setRoot("Dashboard");
    }
}