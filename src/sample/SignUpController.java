package sample;


import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;

import javafx.scene.control.*;


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
    private ToggleGroup group;

    @FXML
    private Label error;

    private void signUpNewUser() {

        DatabaseHandler dbHandler = new DatabaseHandler();
        String firstName = nameField.getText().trim();
        String lastName = surnameField.getText().trim();
        String login = loginField2.getText().trim();
        String password = passField2.getText().trim();
        String location = locationField.getText().trim();
        if (!login.equals("") && !password.equals("") && !firstName.equals("") && !lastName.equals("") && !location.equals("")) {

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
        } else {
            String str = "Заполните все поля!";
            errorInLoginOrPass(str);
        }

    }

    @FXML
    void initialize() {
        signUpLoginButton.setOnAction(event -> {

            signUpNewUser();
            StageHolder.getSignUpController().close();
        });
    }
    private void errorInLoginOrPass(String string) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");
        alert.setHeaderText(string);
        alert.showAndWait();
    }

}
