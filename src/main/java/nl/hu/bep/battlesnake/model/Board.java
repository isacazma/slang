package nl.hu.bep.battlesnake.model;

import java.util.ArrayList;
import java.util.List;

public class Board {

        private int height;
        private int width;
        private List<Board> food = new ArrayList<>();

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

    public List<Board> getFood() {
        return food;
    }

    public void setFood(List<Board> food) {
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

    private List<Board>  hazards= new ArrayList<>();
    private List<Slang> snakes = new ArrayList<>();

}
