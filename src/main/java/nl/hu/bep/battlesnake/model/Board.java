package nl.hu.bep.battlesnake.model;

import com.fasterxml.jackson.databind.JsonNode;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Board {

    private int height;
    private int width;
    private List<Point> food = new ArrayList<>();
    private List<Board>  hazards= new ArrayList<>();
    private List<Snake> snakes = new ArrayList<>();

    public Board(JsonNode js) {
        this.height = js.get("height").intValue();
        this.width = js.get("width").intValue();
        for (JsonNode node : js.get("food")) {
            int x = node.get("x").intValue();
            int y = node.get("y").intValue();
            food.add(new Point(x,y));

        }

        this.hazards =null;

    }

    public Board(int height, int width, List<Point> food, List<Board> hazards, List<Snake> snakes) {
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

    public List<Snake> getSnakes() {
        return snakes;
    }

    public void setSnakes(List<Snake> snakes) {
        this.snakes = snakes;
    }

    public void addSnake(Snake snake){
        this.snakes.add(snake);
    }


}
