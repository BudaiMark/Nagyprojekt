package model;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class Game {

    private Snake snake;
    private ArrayList<Food> foods;
    private Random randomGenerator;

    private final int boardHeight;
    private final int boardWidth;

    public Game(int boardWidth, int boardHeight){
        snake = new Snake(boardWidth, boardHeight);
        randomGenerator = new Random(0);
        this.boardHeight = boardHeight;
        this.boardWidth = boardWidth;
        generateFood();

    }

    private void generateFood(){
        //Operation operation = new Operation();
        ArrayList<Coordinate> availablecoordinates = new ArrayList<>();
        for (int y = 0; y <  boardHeight- 1; y++) {
            for (int x = 0; x < boardWidth- 1 ; x++) {
                if(!snake.getBodyXs().contains(x) && !snake.getBodyYs().contains(y)){
                    availablecoordinates.add(new Coordinate(x,y));
                }
            }
        }
        Food result = new Food(operation.getResult(),availablecoordinates,true);
        foods.add(result);
        availablecoordinates.remove(result.getFoodcoordinate());
        for(int i =0; i< 2; i++){
            Food food = new Food(operation.getResult(), availablecoordinates, false);
            boolean differentvalue = isDifferentValue(food);
            if(differentValue == false){
                food = new Food(operation.getResult(), availablecoordinates, false);
            }
            else{
                foods.add(food);
            }
            availablecoordinates.remove(food.getFoodcoordinate());
        }
    }



    public void move(){

        if(snake.getHeadCoordinates().isEqual(food)) {
            Coordinate lastBody = snake.getBodyAsNodes().getTail().clone();
            snake.moveDirection();
            snake.getBodyAsNodes().snakeGrow(lastBody);
            generateFood();
        }
        else {
            snake.moveDirection();
        }
    }
    public void changeDirecton(KeyEvent keyEvent){
        KeyCode keyCode = keyEvent.getCode();
        switch (keyCode){
            case UP:
                snake.setDirection(Directions.UP);
                break;

            case RIGHT:
                snake.setDirection(Directions.RIGHT);
                break;

            case DOWN:
                snake.setDirection(Directions.DOWN);
                break;

            case LEFT:
                snake.setDirection(Directions.LEFT);
                break;

            default:
                break;
        }
    }
    public boolean isDifferentValue(Food food){
        boolean differentvalue = true;
        for(int i = 0; i< foods.size(); i++ ){
            if(foods.get(i).getValue() == food.getValue()){
                differentvalue = false;
                break;
            }
            
        }
        if(differentvalue == false){
            return false;
        }
        else{
            return true;
        }
    }


    public ArrayList<Coordinate> getSnakeCoords(){
        return snake.getBodyAsCoordinates();
    }


    public Boolean isOver() {
        return snake.checkIfSnakeCrashed();
    }

    public int getScore(){
        return snake.getBodyAsCoordinates().size();
    }
}
