package controller;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NewFXMain extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws Exception {
        this.primaryStage = stage;
        showRegistrationScreen();
    }

    public void showRegistrationScreen() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/patient_registration_screen.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showReviewDetailsScreen() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/patient_review_screen.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
  
}
