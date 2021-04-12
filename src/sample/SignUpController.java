package sample;



import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.*;



public class SignUpController {
    static  boolean  result = false;
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
    private ToggleGroup group;

    @FXML
    void initialize() {


        signUpLoginButton.setOnAction(event -> {
        signUpNewUser();

        });
    }


    private void signUpNewUser() {

        DatabaseHandler dbHandler = new DatabaseHandler();
        String firstName = nameField.getText();
        String lastName = surnameField.getText();
        String login = loginField2.getText();
        String password = passField2.getText();
        String location = locationField.getText();
        String gender = "";
        if (group.getSelectedToggle().equals(radioMale)) {
            gender = "Мужской";
        } else {
            gender = "Женский";
        }


        User user = new User(firstName, lastName, login, password, location, gender);
        try {
            dbHandler.signUpUser(user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
