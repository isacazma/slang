package nl.hu.bep.battlesnake.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Board {

    private int height;
    private int width;
    private List<Point> food = new ArrayList<>();
    private List<Board>  hazards= new ArrayList<>();
    private List<Slang> snakes = new ArrayList<>();

    public Board() {
        this.height = height;
        this.width = width;
        this.food = food;
        this.hazards = hazards;
        this.snakes = snakes;
    }

    public Board(int height, int width, List<Point> food, List<Board> hazards, List<Slang> snakes) {
        this.height = height;
        this.width = width;
        this.food = food;
        this.hazards = hazards;
        this.snakes = snakes;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public List<Point> getFood() {
        return food;
    }

    public void setFood(List<Point> food) {
        this.food = food;
    }

    public List<Board> getHazards() {
        return hazards;
    }

    public void setHazards(List<Board> hazards) {
        this.hazards = hazards;
    }

    public List<Slang> getSnakes() {
        return snakes;
    }

    public void setSnakes(List<Slang> snakes) {
        this.snakes = snakes;
    }


}
