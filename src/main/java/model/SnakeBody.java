package model;

import java.util.ArrayList;

public class SnakeBody {

    private boolean isDead;
    private ArrayList<Coordinate> nodes;


    public SnakeBody(Coordinate head){
        nodes = new ArrayList<>(1);
        nodes.add(head);
    }

    public void snakeGrow(Coordinate newTail){
        nodes.add(newTail);
    }

    public Integer size(){
        return nodes.size();
    }

    public Coordinate getHead(){
        return nodes.get(0);
    }

    public Coordinate getTail(){
        return nodes.get(size()-1);
    }

    public boolean collision(int maxX, int maxY){
        isDead |= isSelfCollision() || collidesWithWall(maxX, maxY);
        return isDead;
    }

    private Boolean isSelfCollision() {
        Coordinate head = nodes.get(0);
        boolean collides = false;
        for (int i = 1; i < size(); i++) {
            collides |= head.isEqual(nodes.get(i));
        }
        return collides;
    }

    private Boolean collidesWithWall(int maxX , int maxY){
        Coordinate head = nodes.get(0);
        return (head.getX() < 0 || head.getX() >= maxX || head.getY() < 0 || head.getY() >= maxY);
    }

    public ArrayList<Coordinate> getNodes(){
        return nodes;
    }

    public ArrayList<Integer> getXs(){
        ArrayList<Integer> xOrds = new ArrayList<>(nodes.size());
        for (Coordinate node: getNodes()) {
            xOrds.add(node.getX());
        }
        return xOrds;
    }

    public ArrayList<Integer> getYs(){
        ArrayList<Integer> yOrds = new ArrayList<>(nodes.size());
        for (Coordinate node: getNodes()) {
            yOrds.add(node.getY());
        }
        return yOrds;
    }
}
