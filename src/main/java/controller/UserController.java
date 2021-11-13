package controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.tinylog.Logger;

import java.io.IOException;

public class UserController {

    private static final String STANDARD= "-fx-border-color: black;";

    @FXML
    private Button continueButton;

    @FXML
    private TextField userName;

    @FXML
    private Label errorLabel;


    public void continueAction(ActionEvent actionEvent) throws IOException {
        if (!userName.getText().isEmpty()){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/gamemode.fxml"));
            Parent root = fxmlLoader.load();
            GameModeController controller = fxmlLoader.getController();
            controller.setUserName(userName.getText());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
            Logger.info("Az első kérdés betöltődik.");

        }else{

            errorLabel.setText("Játékos neve üres");
            Logger.warn("Játékos neve üres");

        }
    }
    public void initialize(){

        continueButton.setStyle(STANDARD);
        Logger.info("Betöltődik az LaunchController initialize() függvényben szereplő Button és Textfield vizuális beállítása.");


    }

}
