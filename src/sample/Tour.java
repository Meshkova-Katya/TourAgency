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

        bookNow.setOnAction(event -> {


            if (group.getSelectedToggle() == null) {
                finishWindow(StageHolder.getFinishTwo());
            } else {
                finish(StageHolder.getFinishStage());
            }

        });
    }

    private void finishWindow(Stage stage) {
        bookNow.getScene().getWindow().hide(); // закрытие текущего окна
        stage.show(); // чтобы подождал

    }

    private void finish(Stage stage) {
        bookNow.getScene().getWindow().hide(); // закрытие текущего окна
        Parent root3 = null;
        try {
            root3 = FXMLLoader.load(StageHolder.class.getResource("finish.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        stage.setScene(new Scene(root3, 600, 600));
        stage.show(); // чтобы подождал

    }

}



