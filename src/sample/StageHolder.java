package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class StageHolder {

    private static Stage loginStage;
    private static Stage signUpController;


    public static void load() {
        try {
            loginStage = new Stage();
            Parent root = FXMLLoader.load(StageHolder.class.getResource("controller.fxml"));
            loginStage.setTitle("Тур агенство");
            loginStage.setScene(new Scene(root, 600, 600));

            signUpController = new Stage();
            Parent root2 = FXMLLoader.load(StageHolder.class.getResource("signUp.fxml"));
            signUpController.initOwner(loginStage);
            signUpController.initModality(Modality.APPLICATION_MODAL);
            signUpController.setScene(new Scene(root2));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Stage getLoginStage() {
        return loginStage;
    }

    public static Stage getSignUpController() {
        return signUpController;
    }

}
