package com.mycompany.finalprojectt;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

/**
 * FXML Controller class
 */
public class LoginPageController implements Initializable {

    @FXML
    PasswordField passwordtxt;

    @FXML
    TextField UserNametxt;

    @FXML
    Label resultlbl;

    // Counter for login attempts
    private int attempts = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Set focus on username field when page opens
        UserNametxt.requestFocus();
    }

    @FXML
    private void switchToSecondary() throws IOException {

        // Check if fields are empty
        if (UserNametxt.getText().isEmpty() || passwordtxt.getText().isEmpty()) {
            resultlbl.setText("Please fill all fields");
            return;
        }

        // Validate username and password
        if (passwordtxt.getText().trim().equals(App.password)
                && UserNametxt.getText().trim().equals(App.username)) {

            resultlbl.setText("Login successful");
            App.setRoot("Dashboard");

        } else {

            attempts++;
            resultlbl.setText("Wrong username or password. Attempt: " + attempts);

            // Clear input fields after failed login
            UserNametxt.clear();
            passwordtxt.clear();
        }
    }
}