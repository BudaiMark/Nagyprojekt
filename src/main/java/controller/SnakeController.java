package controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import lombok.Data;
import model.Database;
import model.OperandSymbols;

import model.User;
import org.tinylog.Logger;

import java.io.IOException;

/**
 *{@code SnakeController} Az osztály ami megvalósítja magának a játéknak a vizuális illetve a háttérbeli logikájának az összekötését.
 */

@Data
public class SnakeController {
    /**
     * {@code username, operandSymbol} Az átadni kívánt változók
     */
    private String username;
    private OperandSymbols operandSymbol;
    /**
     * {@code STANDARDRD}Alapvető érték definiálása a gombok számára
     */
    private static final String STANDARD= "-fx-border-color: black;";
    /**
     * {@code continueButton} Az fxml gomb példányositása.
     */
    @FXML
    private Button continueButton;

    /**
     *
     * @param actionEvent A gomb megnyomására bekövetkező esemény aminek hatására,betöltjük új fxml-t illetve
     *                    Feltöltjük az adatbázisba a usert.
     * @throws IOException Input-Output kivételt dobhat a függvény
     */

    public void loadGameEndController(ActionEvent actionEvent) throws IOException {
        Database.addUsertoDB(new User("Márk", 100, OperandSymbols.MULTIPLY.name()));
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/gameend.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
        Logger.info("Betöltődik az GameEndController.");


    }

    public void initialize(){

        continueButton.setStyle(STANDARD);
        Logger.info("Betöltődik az SnakeController initialize() függvényben szereplő Button");


    }
}
