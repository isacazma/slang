package nl.hu.bep.battlesnake.movement;

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
        this.possibleMoves.add(Move.UP);
        this.possibleMoves.add(Move.DOWN);
        this.possibleMoves.add(Move.LEFT);
        this.possibleMoves.add(Move.RIGHT);
    }

    public MoveResponse getBestMove() {

        // Collision check
        collisionCheck();
        // Snake collision check
        snakeCollisionCheck();
        // fastest way to food
        Move bestMove = moveToFood();
        System.out.println("ooow");
System.out.println(bestMove);
        return new MoveResponse(bestMove.name(), "HALLO JUMBO");
    }

    private void collisionCheck(){
        if(you.getHead().x == 0)
            possibleMoves.remove(Move.LEFT);
        if(you.getHead().x == board.getWidth()-1)
            possibleMoves.remove(Move.RIGHT);
        if(you.getHead().y == board.getHeight()-1)
            possibleMoves.remove(Move.UP);
        if(you.getHead().y == 0)
            possibleMoves.remove(Move.DOWN);
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
                    this.possibleMoves.remove(Move.LEFT);
                }
                if(point.x == you.getHead().x + 1 && point.y == you.getHead().y){
                    // No possible move to right
                    this.possibleMoves.remove(Move.RIGHT);
                }
                if(point.y == you.getHead().y + 1 && point.x == you.getHead().x){
                    // No possible move to up
                    this.possibleMoves.remove(Move.UP);
                }
                if(point.y == you.getHead().y - 1 && point.x == you.getHead().x){
                    // No possible move to down
                    this.possibleMoves.remove(Move.DOWN);
                }
            }
        }
    }

    private Move moveToFood(){

        Point nearestFoodPoint = nearestFoodPoint();

        if(nearestFoodPoint == null && possibleMoves != null)
           possibleMoves.get(0);

//hier maak je weg naar eten
        // Walk Y hoogte
        if(nearestFoodPoint.y > you.getHead().y && possibleMoves.contains((Move.UP)))
        return Move.UP;

        if(nearestFoodPoint.y < you.getHead().y && possibleMoves.contains((Move.DOWN)))
            return Move.DOWN;


// hoogte is rechts
        if(nearestFoodPoint.x > you.getHead().x && possibleMoves.contains((Move.RIGHT)))
            return Move.RIGHT;

        if(nearestFoodPoint.x < you.getHead().x && possibleMoves.contains((Move.LEFT)))
            return Move.LEFT;

        if(possibleMoves == null)
        {this.possibleMoves.add(Move.DOWN);}


       return possibleMoves.get(0);
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


}
