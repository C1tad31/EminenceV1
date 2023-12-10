package me.c1tad31.eminence;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import me.c1tad31.eminence.utils.SceneController;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    SceneController sceneController = new SceneController();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login/mfxlogin.fxml"));

        // Create a transparent scene
        Scene scene = new Scene(root, 832, 477);
        scene.setFill(Color.TRANSPARENT);

        // Set stage properties
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setTitle("Eminence Login"); // Set a title for your application
        primaryStage.setResizable(false); // Prevent resizing for login screen

        sceneController.toolbarDockImage(primaryStage);

        // Show the stage
        primaryStage.show();
    }

}