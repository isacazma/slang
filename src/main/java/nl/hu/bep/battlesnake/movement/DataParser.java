package nl.hu.bep.battlesnake.movement;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import nl.hu.bep.battlesnake.model.Board;
import nl.hu.bep.battlesnake.model.Snake;

// Move parser will receive json input and will parse all fields to a board object
public class DataParser {
    private Board board;
    private Snake you;

    public void DataParse(String r) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        try {
            JsonNode request = om.readTree(r);
            this.board = new Board(request.get("board"));
            this.you = new Snake(request.get("you"));

            for (JsonNode node : request.get("board").get("snakes")) {
                board.addSnake(new Snake(node));
            }
        }catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Snake getYou() {
        return you;
    }

    public void setYou(Snake you) {
        this.you = you;
    }
}
