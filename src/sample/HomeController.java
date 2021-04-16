package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import static sample.SignUpController.*;

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
       radio1.setText("Майами - " + DatabaseHandler.loc);
        radio2.setText("Франция - " + DatabaseHandler.loc);
        radio3.setText("США - " + DatabaseHandler.loc);
        radio4.setText("Бали - " + DatabaseHandler.loc);
    }
}
