package me.c1tad31.eminence.login;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import me.c1tad31.eminence.announcements.AnnouncementsController;
import me.c1tad31.eminence.utils.SceneController;
import org.bson.Document;

import java.net.URL;
import java.util.ResourceBundle;

@Getter
@Setter
@Data
public class LoginController implements Initializable {

    private final SceneController sceneController = new SceneController();
    private final AnnouncementsController announcementController = new AnnouncementsController();

    @FXML
    public Button loginCloseBtn;
    @FXML
    public Label announcementsText;
    @FXML
    public ImageView discord;
    @FXML
    public ImageView insta;
    @FXML
    public ImageView yt;

    @FXML
    private AnchorPane background;
    @FXML
    private ImageView logoTopLeft;

    @FXML
    private ImageView logoLeftTop;

    @FXML
    private ImageView logoRightTop;

    @FXML
    private ImageView logoBottomLeft;

    @FXML
    private ImageView logoTopRight;

    @FXML
    private ImageView logoBottomRight;

    @FXML
    public TextField usernameText;

    @FXML
    private PasswordField passwordText;

    @FXML
    private Label nameLabel;

    @FXML
    private CheckBox showPassCheck;

    @FXML
    private CheckBox rembMeCheck;

    @FXML
    private Button loginLoginBtn;

    @FXML
    private Button loginRegisterBtn;

    @FXML
    private AnchorPane announcementsPane;

    @FXML
    private Label announcementLabel;

    @FXML
    private void handleClose(ActionEvent event) {
        sceneController.close(event);
    }

    @FXML
    private void handleDrag(MouseEvent event) {
        sceneController.drag(event, background);
    }

    @FXML
    private void handleLogin(ActionEvent event) {
        String userName = usernameText.getText();
        String passWord = passwordText.getText();

        if (usernameText != null && passwordText != null && !userName.isEmpty() && !passWord.isEmpty()) {
            System.out.println(userName + " " + passWord);

            String uri = "mongodb+srv://citadel:Haloreach1!@eminence.wdxfv2a.mongodb.net/?retryWrites=true&w=majority";
            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(new com.mongodb.ConnectionString(uri))
                    .build();

            try (MongoClient mongoClient = MongoClients.create(settings)) {
                MongoDatabase database = mongoClient.getDatabase("users");
                MongoCollection<Document> collection = database.getCollection("user");

                FindIterable<Document> found = collection.find(Filters.eq("username", userName));

                if (found.first() != null) {
                    // Username exists, check password
                    Document userDocument = found.first();
                    String storedPassword = userDocument.getString("password");

                    if (verifyPassword(storedPassword, passWord)) {
                        // Passwords match, login successful
                        sceneController.sceneDetails(event, "dashboard/dashboard.fxml", 817, 500);
                    } else {
                        // Passwords do not match
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Eminence V1");
                        alert.setHeaderText("Password Error");
                        alert.setContentText("Invalid password.");
                        alert.show();
                    }
                } else {
                    // Username isn't found
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Eminence V1");
                    alert.setHeaderText("Username Error");
                    alert.setContentText("Invalid username.");
                    alert.show();
                }
            } catch (Exception e) {
                e.printStackTrace();
                // Handle exception appropriately (e.g., show an error message)
            }
        } else {
            System.out.println("Username or password text fields are null or empty.");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Eminence V1");
            alert.setContentText("Username or password text fields are null or empty.");
            alert.setHeaderText("Username / Password Error");
            alert.show();
        }
    }


    @FXML
    private void handleRegister(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Discord Registration At This Time");
        alert.setContentText("Please Join Our Discord: https://discord.gg/VYyMsN43Dn to register for this product");
        alert.setTitle("Eminence V1");
        alert.show();
//        sceneController.sceneDetails(event, "register/register.fxml", 671, 398); need to implement a way to login on the panel and still use the same db
    }

    private static boolean verifyPassword(String hashedPassword, String inputPassword) {
        Argon2 argon2 = Argon2Factory.create();
        try {
            return argon2.verify(hashedPassword, inputPassword);
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialization code, if needed
    }
}
