package model;
import java.util.ArrayList;
import java.util.Random;


public class Food {
    private Coordinate foodcoordinate;
    private int value;


    public Food(int value, ArrayList<Coordinate> availablecoordinates){
        Random randomgenerator = new Random();
        this.value = value;
        foodcoordinate.setX(availablecoordinates.get(randomgenerator.nextInt(availablecoordinates.size())).getX());
        foodcoordinate.setY(availablecoordinates.get(randomgenerator.nextInt(availablecoordinates.size())).getY());
    }

    public Food(ArrayList<Coordinate> availablecoordinates){
        Random randomgenerator = new Random();
        value = randomgenerator.nextInt(10);
        foodcoordinate.setX(availablecoordinates.get(randomgenerator.nextInt(availablecoordinates.size())).getX());
        foodcoordinate.setY(availablecoordinates.get(randomgenerator.nextInt(availablecoordinates.size())).getY());
    }

    public Coordinate getFoodcoordinate() {
        return foodcoordinate;
    }

    public int getValue() {
        return value;
    }
}
