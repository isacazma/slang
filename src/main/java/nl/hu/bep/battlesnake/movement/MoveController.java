package nl.hu.bep.battlesnake.movement;

import com.fasterxml.jackson.databind.ObjectMapper;
import nl.hu.bep.battlesnake.model.Board;
import nl.hu.bep.battlesnake.model.MoveResponse;
import nl.hu.bep.battlesnake.model.Snake;

import java.awt.*;
import java.util.ArrayList;

// Move controller will determine move based on Board object
public class MoveController {
    private Board board;
    private Snake you;

    private ArrayList<Move> possibleMoves;

    public MoveController(Board board, Snake you) {
        this.board = board;
        this.you = you;

        this.possibleMoves = new ArrayList<>();
        this.possibleMoves.add(Move.up);
        this.possibleMoves.add(Move.down);
        this.possibleMoves.add(Move.left);
        this.possibleMoves.add(Move.right);
    }

    public Move getBestMove() {

        // Collision check
        collisionCheck();
        // Snake collision check
        snakeCollisionCheck();
        // fastest way to food
        Move bestMove = moveToFood();


        System.out.println(bestMove.name().toLowerCase());

        return  bestMove;

    }

    private void collisionCheck(){
        if(you.getHead().x == 0)
            possibleMoves.remove(Move.left);
        if(you.getHead().x == board.getWidth()-1)
            possibleMoves.remove(Move.right);
        if(you.getHead().y == board.getHeight()-1)
            possibleMoves.remove(Move.up);
        if(you.getHead().y == 0)
            possibleMoves.remove(Move.down);
    }

    private void snakeCollisionCheck(){
        if(this.possibleMoves.isEmpty())
            return;

        // Loop through all snakes in the game
        for(Snake snake : board.getSnakes()){
            // Loop per snake through all body points
            for(Point point : snake.getBody()){

                if(point.x == you.getHead().x - 1 && point.y == you.getHead().y){
                    // No possible move to left
                    this.possibleMoves.remove(Move.left);
                }
                if(point.x == you.getHead().x + 1 && point.y == you.getHead().y){
                    // No possible move to right
                    this.possibleMoves.remove(Move.right);
                }
                if(point.y == you.getHead().y + 1 && point.x == you.getHead().x){
                    // No possible move to up
                    this.possibleMoves.remove(Move.up);
                }
                if(point.y == you.getHead().y - 1 && point.x == you.getHead().x){
                    // No possible move to down
                    this.possibleMoves.remove(Move.down);
                }
            }
        }
    }

    private Move moveToFood(){

        Point nearestFoodPoint = nearestFoodPoint();

        if(nearestFoodPoint == null && possibleMoves != null)
          return null;

        //hier maak je weg naar eten
        // Walk Y hoogte
        if(nearestFoodPoint.y > you.getHead().y && possibleMoves.contains((Move.up)))
            return Move.up;

        if(nearestFoodPoint.y < you.getHead().y && possibleMoves.contains((Move.down)))
            return Move.down;


        // hoogte is rechts
        if(nearestFoodPoint.x > you.getHead().x && possibleMoves.contains((Move.right)))
            return Move.right;

        if(nearestFoodPoint.x < you.getHead().x && possibleMoves.contains((Move.left)))
            return Move.left;

        //zelfmoord
        return Move.down;
    }

    private Point nearestFoodPoint(){
        double bestScore = 0;
        Point pointOfInterest = null;
        for(Point food : this.board.getFood()) {
            // √[(x₂ - x₁)² + (y₂ - y₁)²]
            double score = Math.sqrt(Math.pow(food.x - you.getHead().x, 2) + Math.pow(food.y - you.getHead().y, 2));
            // If the new score of the food is closer than the best score -> make it the best score
            if(score > bestScore){
                bestScore = score;
                pointOfInterest = food;
            }
        }
        System.out.println("ooowddd");
        System.out.println(bestScore);

        System.out.println(pointOfInterest);
        return pointOfInterest;
    }

    public String getJson(MoveResponse moveResponse){
        ObjectMapper mapper = new ObjectMapper();

        try {

            //Convert object to JSON string
            String jsonInString = mapper.writeValueAsString(moveResponse);
            System.out.println(jsonInString);
            return jsonInString;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
