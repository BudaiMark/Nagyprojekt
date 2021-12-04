package controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.OperandSymbols;

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
    private String userName;

    public void setUserName(String userName){
        this.userName= userName;
    }


    @FXML
    private Button sumButton;

    @FXML
    private Button subsecButton;

    @FXML
    private Button multiplyButton;

    @FXML
    private Button allButton;


    public OperandSymbols switchOperation(Button button){
        String buttonText;
        buttonText = button.getText();
        OperandSymbols operandSymbols;
        switch (buttonText){
            case "Összeadás":
                operandSymbols = OperandSymbols.SUM;
                break;
            case "Kivonás":
                operandSymbols = OperandSymbols.SUBTRACTION;
                break;
            case "Szorzás":
                operandSymbols = OperandSymbols.MULTIPLY;
                break;
            case "Összes":
                operandSymbols = OperandSymbols.ALLOPERATION;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + buttonText);
        }
        return operandSymbols;
    }
    /**
     * {@code snakeAction()}Egy gomb megnyomásának hatására lefut a metódus amiben betöltjük az új fxml-t.
     * @param actionEvent A gombhoz tartozó esemény.
     * @throws IOException A lefutása közben adódó Input-Output kivétel.
     */
    public void snakeAction(ActionEvent actionEvent) throws IOException {
        Button transButton = (Button)actionEvent.getSource();
        OperandSymbols transOperandSymbol =switchOperation(transButton);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/snake.fxml"));
        Parent root = fxmlLoader.load();
        SnakeController controller = fxmlLoader.getController();
        controller.setUsername(userName);
        controller.setOperandSymbol(transOperandSymbol);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
        Logger.info("Betöltődik a konvertáló felület.");


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
