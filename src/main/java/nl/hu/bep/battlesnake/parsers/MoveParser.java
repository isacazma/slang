package nl.hu.bep.battlesnake.parsers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import nl.hu.bep.battlesnake.model.Board;
import nl.hu.bep.battlesnake.model.Snake;

public class MoveParser {

    public Board MoveParse(String r) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        JsonNode request = null;
        Board board = new Board(request.get("board"));

        try {
            request = om.readTree(String.valueOf(r));

            for (JsonNode node : request.get("board").get("snakes")) {
                board.addSnake(new Snake(node));
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return board;
    }
}
