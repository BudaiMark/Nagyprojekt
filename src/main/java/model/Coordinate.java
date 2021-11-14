package model;

public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isEqual(Coordinate other){
        return this.x == other.x && this.y == other.y;
    }

    public Coordinate copy(Coordinate coordinate){
        return new Coordinate(coordinate.getX(), coordinate.getY());
    }
}
