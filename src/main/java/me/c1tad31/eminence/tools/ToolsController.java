package me.c1tad31.eminence.tools;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import me.c1tad31.eminence.utils.SceneController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ToolsController implements Initializable {

    private final SceneController sceneController = new SceneController();

    @FXML private Button close;
    @FXML private Button minimize;
    @FXML private TextField hostText;
    @FXML private Button pingBtn;
    @FXML private Label pingResults;
    @FXML private AnchorPane background;

    @FXML
    private void handleClose(ActionEvent event) {
        sceneController.close(event);
    }

    @FXML
    private void handleMinimize(ActionEvent event) {
        sceneController.minimize(event);
    }

    @FXML
    private void dragStage(MouseEvent event) {
        sceneController.drag(event, background);
    }


    @FXML
    private void handleDashboard(ActionEvent event) throws IOException {
        sceneController.sceneDetails(event, "dashboard/dashboard.fxml", 817, 500);
    }

    @FXML
    private void handleStressHub(ActionEvent event) throws IOException {
        sceneController.sceneDetails(event, "stresshub/stresshub.fxml", 817, 500);
    }

    @FXML
    private void handleTools(ActionEvent event) throws IOException {
        sceneController.sceneDetails(event, "tools/tools.fxml", 817, 500);
    }

    @FXML
    private void handleAdmin(ActionEvent event) throws IOException {
        sceneController.sceneDetails(event, "admin/admin.fxml", 817, 500);
    }

    @FXML
    private void handleSettings(ActionEvent event) throws IOException {
        sceneController.sceneDetails(event, "settings/settings.fxml", 817, 500);
    }

    @FXML
    private void handlePing() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("This feature will be added after beta");
        alert.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialization code, if needed
    }
}
