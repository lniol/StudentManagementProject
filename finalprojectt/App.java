package com.mycompany.finalprojectt;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Main JavaFX Application Class
 */
public class App extends Application {

    // The global scene variable that holds the current view
    private static Scene scene;
    
    // Default hardcoded login credentials
    final static String username = "Lama";
    final static String password = "1234";
    
    // Global ArrayList to store Student objects dynamically during runtime
    public static ArrayList<Student> Students = new ArrayList<>();

    // The main entry point for the JavaFX application lifecycle
    @Override
    public void start(Stage stage) throws IOException {
        // Load the LoginPage.fxml as the initial view with dimensions 640x480
        scene = new Scene(loadFXML("LoginPage"), 640, 480);
        stage.setScene(scene);
        stage.setTitle("Student Management System"); // Sets the window title
        stage.show(); // Displays the window to the user
    }

    // Public method to switch between different FXML pages/screens
    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    // Helper method to locate and load the FXML file from the resources folder
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    // Standard main method to launch the JavaFX application
    public static void main(String[] args) {
        launch(); // Calls the internal JavaFX framework to start the app
    }
}