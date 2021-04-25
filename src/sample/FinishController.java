package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class FinishController {



    @FXML
    private Label text;

    @FXML
    void initialize() {

        text.setText("В течении недели Вы можете приобрести их в аэропорту города " + DatabaseHandler.USER.getLocation());

    }


}

