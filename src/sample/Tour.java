package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Tour {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button bookNow;

    @FXML
    private RadioButton radio1;

    @FXML
    private RadioButton radio3;

    @FXML
    private RadioButton radio2;

    @FXML
    private ToggleGroup group;
    @FXML
    private RadioButton radio4;

    @FXML
    void initialize() {
        radio1.setText("Майами - " + DatabaseHandler.USER.getLocation());
        radio2.setText("Франция - " + DatabaseHandler.USER.getLocation());
        radio3.setText("США - " + DatabaseHandler.USER.getLocation());
        radio4.setText("Бали - " + DatabaseHandler.USER.getLocation());
        RadioButton selection = (RadioButton) group.getSelectedToggle();
        bookNow.setOnAction(event -> {


            bookNow.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            if (selection == null) {

                loader.setLocation(getClass().getResource("finishTwo.fxml"));


            } else {

                loader.setLocation(getClass().getResource("finish.fxml"));


            }
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

}



