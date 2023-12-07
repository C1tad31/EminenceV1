package me.c1tad31.eminence.utils;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class SceneController {

    private double xOffset = 0;
    private double yOffset = 0;

    public void close(ActionEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    public void minimize(ActionEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    public void drag(MouseEvent event, AnchorPane pane) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        pane.setOnMousePressed(event1 -> {
            xOffset = stage.getX() - event1.getScreenX();
            yOffset = stage.getY() - event1.getScreenY();
        });
        pane.setOnMouseDragged(event12 -> {
            stage.setX(event12.getScreenX() + xOffset);
            stage.setY(event12.getScreenY() + yOffset);
        });
    }

    public void sceneDetails(ActionEvent event, String path, int width, int height) {
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/me/c1tad31/eminence/" + path));
            Scene scene = new Scene(root, width, height);
            scene.setFill(Color.TRANSPARENT);
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();        }
    }

    public void toolbarDockImage(Stage stage) {
        var appIcon = new Image("/imgs/img.png");
        stage.getIcons().add(appIcon);

        //Set icon on the taskbar/dock
        if (Taskbar.isTaskbarSupported()) {
            var taskbar = Taskbar.getTaskbar();

            if (taskbar.isSupported(Taskbar.Feature.ICON_IMAGE)) {
                final Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
                var dockIcon = defaultToolkit.getImage(getClass().getResource("/imgs/img.png"));
                taskbar.setIconImage(dockIcon);
            }

        }
    }
}
