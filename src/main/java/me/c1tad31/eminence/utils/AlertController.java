package me.c1tad31.eminence.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AlertController {

    private Alert alert;

    public void showAlert(String choice, String title, String header, String content) {
        switch (choice) {
            case "confirm":
                handleAlert(AlertType.CONFIRMATION, title, header, content);
                break;
            case "info":
                handleAlert(AlertType.INFORMATION, title, header, content);
                break;
            case "warn":
                handleAlert(AlertType.WARNING, title, header, content);
                break;
            case "error":
                handleAlert(AlertType.ERROR, title, header, content);
                break;
        }
    }

    public void handleAlert(AlertType type, String title, String header, String content) {
        alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.show();
    }

    public void showInformationAlert(String title, String header, String content) {
        showAlert("info", title, header, content);
    }

    public void showWarningAlert(String title, String header, String content) {
        showAlert("warn", title, header, content);
    }

    public void showErrorAlert(String title, String header, String content) {
        showAlert("error", title, header, content);
    }

    public void showConfirmationAlert(String title, String header, String content) {
        showAlert("confirm", title, header, content);
    }
}
