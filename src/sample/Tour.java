package sample;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import javafx.stage.Stage;


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
                finishWindow(StageHolder.getFinishStage());
            }

        });
    }

    private void finishWindow(Stage stage) {
        bookNow.getScene().getWindow().hide(); // закрытие текущего окна
        stage.showAndWait(); // чтобы подождал

    }


}





