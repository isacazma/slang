package nl.hu.bep.battlesnake.parsers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import nl.hu.bep.battlesnake.model.Board;
import nl.hu.bep.battlesnake.model.Snake;

import javax.ws.rs.core.Response;

public class MoveParser {

    public Board MoveParse(String r) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        try {
        JsonNode request = om.readTree(r);
        Board board = new Board(request.get("board"));


        for (JsonNode node : request.get("board").get("snakes")) {
            board.addSnake(new Snake(node));
        }

        return board;
    }catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }}
