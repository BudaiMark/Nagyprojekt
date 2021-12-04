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

@Data
public class SnakeController {
    private String username;
    private OperandSymbols operandSymbol;
    private static final String STANDARD= "-fx-border-color: black;";

    @FXML
    private Button continueButton;


    public void loadGameEndController(ActionEvent actionEvent) throws IOException {
        Database.addUsertoDB(new User("Márk", 100, OperandSymbols.MULTIPLY.name()));
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/gameend.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
        Logger.info("Betöltődik a konvertáló felület.");


    }

    public void initialize(){

        continueButton.setStyle(STANDARD);
        Logger.info("Betöltődik az LaunchController initialize() függvényben szereplő Button");


    }
}
