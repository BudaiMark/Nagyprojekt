package controller;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.tinylog.Logger;

import java.io.IOException;
public class GameModeController {
    /**
     * {@code STANDARDRD}Alapvető érték definiálása a gombok számára
     */
    private static final String STANDARD= "-fx-border-color: black;";

    /**
     * {@code startButton} A képernyőn látható vizuális eszköz példányosítása, az fxml-ből érjük el id alapján
     */
    private String username;

    public void setUserName(String username){
        this.username= username;
    }


    @FXML
    private Button sumButton;

    @FXML
    private Button subsecButton;

    @FXML
    private Button multiplyButton;

    @FXML
    private Button allButton;


    /**
     * {@code startAction()}Egy gomb megnyomásának hatására lefut a metódus amiben betöltjük az új fxml-t.
     * @param actionEvent A gombhoz tartozó esemény.
     * @throws IOException A lefutása közben adódó Input-Output kivétel.
     */

    public void snakeAction(ActionEvent actionEvent) throws IOException {

        /*FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/user.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
        Logger.info("Betöltődik a konvertáló felület.");*/


    }

    /**
     * {@code initialize()}Ez a metódus fut le először, a konstruktorhoz nagyon hasonló, azonban innen elérjük az fxml fájl tagjait.
     */
    @FXML
    public void initialize(){

        sumButton.setStyle(STANDARD);
        subsecButton.setStyle(STANDARD);
        multiplyButton.setStyle(STANDARD);
        allButton.setStyle(STANDARD);
        Logger.info("Betöltődik az LaunchController initialize() függvényben szereplő Button és Textfield vizuális beállítása.");


    }
}
