package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
                String str = "Поле с логином или паролем пустое";
              errorInLoginOrPass(str);
            }
        });

        signUpButton.setOnAction(event -> StageHolder.getSignUpController().showAndWait());

    }

    private void loginUser(String login, String password) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = dbHandler.login(login, password);

        if (user == null) {
         String str = "Такого пользователя не существует!";
         errorInLoginOrPass(str);
        } else {
           dialogInfo();

            loginButton.getScene().getWindow().hide(); // закрытие текущего окна

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/tour.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait(); // чтобы подождал

        }

    }
    private void  errorInLoginOrPass(String string) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");
        alert.setHeaderText(string);
        alert.showAndWait();
    }
    private void dialogInfo() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Информационный диалог");
        alert.setHeaderText("Вы успешно вошли в систему!");
        alert.showAndWait();
    }

}
