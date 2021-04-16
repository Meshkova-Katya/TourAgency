package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

public class HomeController {

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
    private RadioButton radio4;

    @FXML
    void initialize() {
        radio1.setOnAction(event -> radio1.setText("Майами - " + SignUpController.loc));
        radio2.setOnAction(event -> radio1.setText("Франция - " + SignUpController.loc));
        radio1.setOnAction(event -> radio1.setText("США - " + SignUpController.loc));
        radio2.setOnAction(event -> radio1.setText("Бали - " + SignUpController.loc));
    }
}
