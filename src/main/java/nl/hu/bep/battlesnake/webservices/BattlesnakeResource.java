package nl.hu.bep.battlesnake.webservices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import nl.hu.bep.battlesnake.model.Board;
import nl.hu.bep.battlesnake.model.GameInformation;
import nl.hu.bep.battlesnake.model.Snake;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

class MoveResponse{
    public String move;
    public  String shout;

    public  MoveResponse(String move , String shout){
        this.move = move;
        this.shout = shout;
    }
        }



@Path("/snake")
public class BattlesnakeResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGameInfo() {
        GameInformation info = new GameInformation();
        info.setAuthor("dit");

        return Response.ok(info).build();
    }


    @POST
    @Path("/start")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response startGame(){
        return Response.ok().build();
    }

    @POST
    @Path("/move")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response moveSnake(String r){
        System.out.println(r);
        ObjectMapper om = new ObjectMapper();
        try {
            JsonNode request = om.readTree(r);
            Board board = new Board(request.get("board"));
            for (JsonNode node : request.get("board").get("snakes")) {
                board.addSnake(new Snake(node));
            }
            System.out.println(board.getSnakes().get(0).getName());
            MoveResponse move = new MoveResponse("up","going Up");
            return  Response.ok(move).build();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return  Response.serverError().build();
    }


    @POST
    @Path("/end")
    @Consumes(MediaType.APPLICATION_JSON)
   public Response endGame(){
        return Response.ok().build();
    }
}