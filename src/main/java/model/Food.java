package model;
import java.util.ArrayList;
import java.util.Random;


public class Food {
    private Coordinate foodcoordinate;
    private int value;
    private boolean result;


    public Food(int value, ArrayList<Coordinate> availablecoordinates, boolean result){
        Random randomgenerator = new Random();
        if(result == true) {
            this.value = value;
            foodcoordinate.setX(availablecoordinates.get(randomgenerator.nextInt(availablecoordinates.size())).getX());
            foodcoordinate.setY(availablecoordinates.get(randomgenerator.nextInt(availablecoordinates.size())).getY());
        }
        else{
            do{
            this.value = randomgenerator.nextInt(10);
            }while(this.value == value);
            foodcoordinate.setX(availablecoordinates.get(randomgenerator.nextInt(availablecoordinates.size())).getX());
            foodcoordinate.setY(availablecoordinates.get(randomgenerator.nextInt(availablecoordinates.size())).getY());
        }
    }

    public Coordinate getFoodcoordinate() {
        return foodcoordinate;
    }

    public int getValue() {
        return value;
    }
}
