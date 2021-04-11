package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField nameField;

    @FXML
    private PasswordField passField2;

    @FXML
    private Button signUpLoginButton;

    @FXML
    private TextField loginField2;

    @FXML
    private TextField surnameField;

    @FXML
    private TextField locationField;

    @FXML
    private RadioButton radioMale;

    @FXML
    private RadioButton radioFemale;

    @FXML
    void initialize() {

        DatabaseHandler dbHandler = new DatabaseHandler();

        signUpLoginButton.setOnAction(event -> {
            dbHandler.signUpUser(nameField.getText(), surnameField.getText(), loginField2.getText(), passField2.getText(),
                    locationField.getText(), "Male");
        });
    }
}
