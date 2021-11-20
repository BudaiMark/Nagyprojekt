package model;


import java.util.ArrayList;

public class Snake {
    private SnakeBody body;
    private Directions direction;

    private final int boardHeight;
    private final int boardWidth;

    public Snake(int boardWidth, int boardHeight){
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        int middleX = boardWidth / 2;
        int middleY = boardHeight / 2;
        body = new SnakeBody(new Coordinate(middleY, middleX));
        direction = Directions.RIGHT;
    }

    public void moveDirection(){
        switch (direction){
            case UP:
                incrimentBody(-1,0);
                break;
            case DOWN:
                incrimentBody(1, 0);
                break;
            case LEFT:
                incrimentBody(0, -1);
                break;
            case RIGHT:
                incrimentBody(0, 1);
                break;
            default: break;
        }

    }


    private void incrimentBody(int yIncriment, int xIncriment){
        ArrayList<Coordinate> nodes = body.getNodes();
        for (int i = body.size()-1; i > 0; i--) {
            nodes.set(i, nodes.get(i-1));
        }
        Coordinate head = body.getHead();
        head.setY(head.getY()+yIncriment);
        head.setX(head.getX()+xIncriment);
    }

    public Boolean checkIfSnakeCrashed(){
        return body.collision(boardWidth, boardHeight);
    }

    public SnakeBody getBodyAsNodes(){
        return body;
    }

    public void setDirection(Directions direction){this.direction = direction;}

    public ArrayList<Coordinate> getBodyAsCoordinates(){return body.getNodes();}

    public  Coordinate getHeadCoordinates() {return body.getHead(); }

    public ArrayList<Integer> getBodyYs(){return body.getYs();}

    public ArrayList<Integer> getBodyXs() { return body.getXs();}


}