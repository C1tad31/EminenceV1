package me.c1tad31.eminence.dashboard;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import me.c1tad31.eminence.utils.SceneController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class DashboardController implements Initializable {

    private final SceneController sceneController = new SceneController();
    @FXML private Label welcomeUser;

    @FXML
    private Button close;

    @FXML
    private Button minimize;

    @FXML
    private ImageView dashboardImage;

    @FXML
    private AnchorPane background;

    @FXML
    public void handleClose(ActionEvent event) {
        sceneController.close(event);
    }

    @FXML
    public void handleMinimize(ActionEvent event) {
        sceneController.minimize(event);
    }

    @FXML
    public void dragStage(MouseEvent event) {
        sceneController.drag(event, background);
    }

    @FXML
    public void handleDashboard(ActionEvent event) throws IOException {
        sceneController.sceneDetails(event, "dashboard/dashboard.fxml", 817, 500);
    }

    @FXML
    public void handleStressHub(ActionEvent event) throws IOException {
        sceneController.sceneDetails(event, "stresshub/stresshub.fxml", 817, 500);
    }

    @FXML
    public void handleTools(ActionEvent event) throws IOException {
        sceneController.sceneDetails(event, "tools/tools.fxml", 817, 500);
    }

    @FXML
    public void handleAdmin(ActionEvent event) throws IOException {
        sceneController.sceneDetails(event, "admin/admin.fxml", 817, 500);
    }

    @FXML
    public void handleSettings(ActionEvent event) throws IOException {
        sceneController.sceneDetails(event, "settings/settings.fxml", 817, 500);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
