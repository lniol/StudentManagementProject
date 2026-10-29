package com.mycompany.finalprojectt;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

// Initializable is an interface - by implementing it we are required
// to override the initialize method which runs automatically when the screen loads
public class ViewReportsController implements Initializable {

    // label that displays the full report on screen
    @FXML
    Label reslbl;

    // this method is from the Initializable interface
    // it runs automatically when the report page opens - before the user does anything
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // if no students exist, show a message and stop
        if (App.Students.isEmpty()) {
            reslbl.setText("No students found. Please add students first.");
            return;
        }

        // variables to hold our calculated values
        double total = 0;
        int passing = 0, failing = 0, aboveAvg = 0, belowAvg = 0;
        int countWithGrade = 0;

        // step 1: add up all the grades to get the total
        // we check for null first because some students may not have a grade yet
        for (Student student : App.Students) {
            if (student.getGrade() != null) {
                total += student.getGrade();
                countWithGrade++;
            }
        }

        // if no grades have been added yet, tell the user
        if (countWithGrade == 0) {
            reslbl.setText("No grades have been added yet. Please add grades first.");
            return;
        }

        // step 2: divide total by number of students with grades to get average
        double avg = total / countWithGrade;

        // step 3: go through each student and count categories
        for (Student student : App.Students) {

            // skip students with no grade
            if (student.getGrade() == null) continue;

            // check if student passed (grade above 60)
            if (student.getGrade() > 60) {
                passing++;
            } else {
                failing++;
            }

            // check if student is above or below the class average
            if (student.getGrade() > avg) {
                aboveAvg++;
            } else {
                belowAvg++;
            }
        }

        // step 4: display everything in the label
        reslbl.setText(
            "Total Students      : " + App.Students.size() +
            "\nStudents with Grade : " + countWithGrade +
            "\nClass Average       : " + String.format("%.2f", avg) +
            "\nPassing Students    : " + passing +
            "\nFailing Students    : " + failing +
            "\nAbove Average       : " + aboveAvg +
            "\nBelow Average       : " + belowAvg
        );
    }

    // goes back to the main dashboard when Back is clicked
    @FXML
    private void Back() throws IOException {
        App.setRoot("Dashboard");
    }
}