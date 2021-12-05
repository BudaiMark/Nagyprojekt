package controller;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.Pair;
import lombok.Data;
import model.*;


import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Modality;

import javafx.scene.paint.Color;

import org.tinylog.Logger;


import java.io.IOException;
import java.util.ArrayList;

@Data
public class SnakeController{
    private String username;
    private OperandSymbols operandSymbol;
    private static final String STANDARD= "-fx-border-color: black;";

    private static final int BOARDWIDTH = 15;
    private static final int BOARDHEIGHT = 8;
    private static final int RECTSIZE = 37;
    private Game game;
    private Rectangle[][] rectBoard;
    private SnakeBody snakeBody;

    private Stage primaryStage;
    private Scene scene;
    private Timeline clock;

    @FXML
    private Button continueButton;

    @FXML
    private GridPane gameGrid;

    private void play(Scene scene) {
        clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            refreshBoard(scene);
        }), new KeyFrame(Duration.seconds(0.2)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    public void refreshBoard(Scene scene){
        game.move(operandSymbol);

        if (game.isOver()) {
            gameOver();
            return;
        }

        GridPane grid = (GridPane) scene.getRoot();
        ObservableList<Node> children = grid.getChildren();
        children.stream().forEach(rect -> {
            rect.getStyleClass().removeAll();
            rect.getStyleClass().add("-fx-fill: #E9E9E9;" + "-fx-stroke: black;" + "-fx-stroke-width: 1;");
        });

        game.getSnakeCoords().stream().forEach(pair -> {
            rectBoard[pair.getY()][pair.getX()].getStyleClass().removeAll();
            rectBoard[pair.getY()][pair.getX()].getStyleClass().add("-fx-fill: #5FBC87;" + "-fx-stroke: black;" + "-fx-stroke-width: 1;");
        });


        ArrayList<Food> foods = game.getFoods();
        foods.forEach(food -> {
            Integer value = food.getValue();
            rectBoard[food.getFoodcoordinate().getY()][food.getFoodcoordinate().getX()].getStyleClass().removeAll();
            rectBoard[food.getFoodcoordinate().getY()][food.getFoodcoordinate().getX()].getStyleClass().add("-fx-fill: #FF5768;" + "-fx-stroke: black;" + "-fx-stroke-width: 1;");
            rectBoard[food.getFoodcoordinate().getY()][food.getFoodcoordinate().getX()].setAccessibleText(value.toString());
        });

    }

    /*private Node getNodeFromGridPane(GridPane gridPane, ArrayList<Integer> xs, ArrayList<Integer> ys) {
        for (Node node : gridPane.getChildren()) {
            if (xs.contains(GridPane.getColumnIndex(node)) && ys.contains(GridPane.getRowIndex(node))) {
                return node;
            }
        }
        return null;
    }*/

    private void gameOver(){
        clock.stop();

        final Stage dialog = new Stage();
        dialog.setTitle("Game Over!");
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(primaryStage);

        GridPane grid = new GridPane();
        grid.add(new Text("Well Played!"), 1, 0, 3,1);
        grid.add(new Text("Score: " + game.getScore()), 0 , 1,1,1);

        String maxScorersName = null;
        int maxScore = 0;

        if(game.getScore() >= maxScore || maxScorersName == null){
            grid.add(new Text("Your Current High Score: " + game.getScore()), 0 , 2,3,1);
        } else {
            grid.add(new Text("Current High Score: " + maxScore + " By " + maxScorersName), 0 , 2,3,1);
        }
        grid.add(new Text("Name: "), 0, 3, 1,1);
        TextField nameField = new TextField();
        grid.add(nameField, 2, 3, 2,1);
        Scene dialogScene = new Scene(grid, 300, 200);
        dialog.setScene(dialogScene);
        dialog.show();

    }

    public void loadGameEndController(ActionEvent actionEvent) throws IOException {
        Database.addUsertoDB(new User(username, 100, OperandSymbols.MULTIPLY.name()));
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/gameend.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
        Logger.info("Betöltődik a konvertáló felület.");


    }

    public void setUsername(String username) {
        System.out.println("MEGHÍVÓDTAM");
        this.username = username;
    }

    public void initialize(){
        rectBoard = new Rectangle[BOARDHEIGHT][BOARDWIDTH];
        System.out.print("OPERÁCIÓSSZIMBÓLUM "+ username);
        for (int y = 0; y < BOARDHEIGHT; y++) {
            for (int x = 0; x < BOARDWIDTH; x++) {
                Rectangle rect = new Rectangle(37, 37);
                rect.setFill(Color.rgb(233,233,233));
                gameGrid.add(rect, x, y, 1, 1);
                rectBoard[y][x] = rect;
            }
        }

        game = new Game(BOARDWIDTH, BOARDHEIGHT, OperandSymbols.ALLOPERATION);
        play(scene);

        System.out.println("TÚLJÖTTEM---------------");

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> { game.changeDirecton(key);});
        
        continueButton.setStyle(STANDARD);
        Logger.info("Betöltődik az SnakeController initialize() függvényben szereplő Button");

    }
}
