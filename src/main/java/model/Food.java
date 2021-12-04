package model;
import java.util.ArrayList;
import java.util.Random;

/**
 * {@code Food} Az az objektum ami az ételt tartalmazza, amit a kígyó felvesz.
 */
public class Food {
    private Coordinate foodcoordinate;
    private int value;
    private boolean result;

    /**
     *
     * @param value Az érték, amit a kaja kap
     * @param availablecoordinates Az elérhető koordináták, ahová spwanolhat a kaja.
     * @param result Az eredmény kaja-e vagy sem.
     */
    public Food(int value, ArrayList<Coordinate> availablecoordinates, boolean result){
        Random randomgenerator = new Random();
        if(result == true) {
            this.value = value;
            foodcoordinate.setX(availablecoordinates.get(randomgenerator.nextInt(availablecoordinates.size())).getX());
            foodcoordinate.setY(availablecoordinates.get(randomgenerator.nextInt(availablecoordinates.size())).getY());
        }
        else{
            this.value = randomgenerator.nextInt(10);
            foodcoordinate.setX(availablecoordinates.get(randomgenerator.nextInt(availablecoordinates.size())).getX());
            foodcoordinate.setY(availablecoordinates.get(randomgenerator.nextInt(availablecoordinates.size())).getY());
        }
    }

    /**
     * {@code getFoodcoordinate,getValue} Getter metódusok.
     * @return Koordinátát, illetve értéket ad vissza.
     */
    public Coordinate getFoodcoordinate() {
        return foodcoordinate;
    }

    public int getValue() {
        return value;
    }
}
