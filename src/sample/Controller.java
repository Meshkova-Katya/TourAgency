package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passField;

    @FXML
    private Button signUpButton;

    @FXML
    private Button loginButton;

    @FXML
    void initialize() {

        loginButton.setOnAction(event -> {
            String login = loginField.getText().trim();
            String password = passField.getText().trim();
            if (!login.equals("") && !password.equals("")) {
                loginUser(login, password);
            } else {
                System.out.println("Login and password is empty");
            }
        });

        signUpButton.setOnAction(event -> {
            signUpButton.getScene().getWindow().hide(); // закрытие текущего окна

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/signUp.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait(); // чтобы подождал
        });

    }

    private void loginUser(String login, String password) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        boolean result = dbHandler.login(login, password);
        if (result) {
            System.out.println("Вы успешно вошли в систему!");

            loginButton.getScene().getWindow().hide(); // закрытие текущего окна
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/app.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait(); // чтобы подождал

        } else {
            System.out.println("Такого пользователя не существует!");
        }

    }
}
