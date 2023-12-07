//package me.c1tad31.eminence.register;
//
//import com.mongodb.MongoClient;
//import com.mongodb.MongoClientURI;
//import com.mongodb.client.FindIterable;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoDatabase;
//import com.mongodb.client.model.Filters;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import javafx.scene.control.*;
//import javafx.scene.image.ImageView;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.AnchorPane;
//import me.c1tad31.eminence.utils.SceneController;
//import org.bson.Document;
//
//import java.awt.*;
//import java.io.IOException;
//import java.net.URI;
//import java.net.URL;
//import java.util.ResourceBundle;
//
//public class RegisterController implements Initializable {
//
//    private final SceneController sceneController = new SceneController();
//
//    @FXML
//    public AnchorPane background;
//    @FXML
//    public TextField usernameText;
//    @FXML
//    public PasswordField passwordText;
//    @FXML
//    public TextField emailText;
//    @FXML
//    public PasswordField confirmPasswordText;
//    @FXML
//    public Button loginLoginBtn;
//    @FXML
//    public Button loginRegisterBtn;
//    @FXML
//    public Label nameLabel;
//    @FXML
//    public Label announcementsText;
//    @FXML
//    public ImageView logoTopLeft;
//    @FXML
//    public ImageView insta;
//    @FXML
//    public ImageView yt;
//    @FXML
//    public ImageView discord;
//    @FXML
//    public ImageView settings;
//    @FXML
//    public ImageView x;
//
//
//    @FXML
//    private void handleClose(ActionEvent event) {
//        sceneController.close(event);
//    }
//
//    @FXML
//    private void handleDrag(MouseEvent event) {
//        sceneController.drag(event, background);
//    }
//
//    @FXML
//    private void handleRegister(ActionEvent event) {
//        String username = usernameText.getText();
//        String password = passwordText.getText();
//        String email = emailText.getText();
//        String confirmPass = confirmPasswordText.getText();
//
//        // Check if any of the fields is null or empty
//        if (username == null || username.isEmpty() ||
//                password == null || password.isEmpty() ||
//                email == null || email.isEmpty() ||
//                confirmPass == null || confirmPass.isEmpty()) {
//
//            // Display an alert or show an error message
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setContentText("Please fill in all fields.");
//            alert.show();
//            return; // Exit the method, as we don't want to proceed with registration
//        }
//
//        // Rest of your registration logic
//        String uri = "mongodb+srv://citadel:Haloreach1!@eminence.wdxfv2a.mongodb.net/?retryWrites=true&w=majority";
//
//        try (MongoClient client = new MongoClient(new MongoClientURI(uri))) {
//            MongoDatabase database = client.getDatabase("users");
//            MongoCollection<Document> collection = database.getCollection("user");
//
//            FindIterable<Document> found = collection.find(Filters.eq("username", username));
//
//            // Rest of your registration logic
//
//            // Display success message
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setContentText("User Successfully Created!");
//            alert.show();
//        } catch (Exception e) {
//            e.printStackTrace();
//            // Handle exception appropriately (e.g., show error message)
//        }
//    }
//
//
//    @FXML
//    private void handleLogin(ActionEvent event) throws IOException {
//        sceneController.sceneDetails(event, "login/login.fxml", 671, 398);
//    }
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        insta.setOnMouseClicked(event -> {
//            Desktop desktop = Desktop.getDesktop();
//            try {
//                desktop.browse(URI.create("https://instagram.com/"));
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        });
//        discord.setOnMouseClicked(event -> {
//            Desktop desktop = Desktop.getDesktop();
//            try {
//                desktop.browse(URI.create("https://discord.gg/VYyMsN43Dn"));
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        });
//        yt.setOnMouseClicked(event -> {
//            Desktop desktop = Desktop.getDesktop();
//            try {
//                desktop.browse(URI.create("https://youtube.com/"));
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        });
//        x.setOnMouseClicked(event -> {
//            Desktop desktop = Desktop.getDesktop();
//            try {
//                desktop.browse(URI.create("https://twitter.com/"));
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        });
//        settings.setOnMouseClicked(event -> {
//            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//            alert.setContentText("Option Coming Soon....");
//            alert.show();
//        });
//    }
//}
