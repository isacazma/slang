package nl.hu.bep.battlesnake.webservices;

import com.fasterxml.jackson.core.JsonProcessingException;
import nl.hu.bep.battlesnake.model.Board;
import nl.hu.bep.battlesnake.model.GameInformation;
import nl.hu.bep.battlesnake.model.Snake;
import nl.hu.bep.battlesnake.movement.DataParser;
import nl.hu.bep.battlesnake.model.MoveResponse;
import nl.hu.bep.battlesnake.movement.MoveController;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//class MoveResponse{
//    public String move;
//    public  String shout;
//
//    public  MoveResponse(String move , String shout){
//        this.move = move;
//        this.shout = shout;
//    }
//        }



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
    public Response moveSnake(String r) throws JsonProcessingException {
        DataParser dataparser = new DataParser();
        System.out.println(r);

        try{
            dataparser.DataParse(r);
            Board board = dataparser.getBoard();
            Snake you = dataparser.getYou();

            MoveController moveController = new MoveController(board, you);


           String moved =  moveController.getBestMove();
            MoveResponse move = new MoveResponse(moved,"k");
//                    new MoveResponse("UP", "hallo JUMBO");
//           move = move.TomTom();

System.out.println("is het hier");
System.out.println(moved);
System.out.println(move);
            return  Response.ok(move).build();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return  Response.serverError().build();
    }
//            System.out.println(board.getSnakes().get(0).getHead().x);
//            System.out.println(board.getSnakes().get(0).getHead().y);
    @POST
    @Path("/end")
    @Consumes(MediaType.APPLICATION_JSON)
   public Response endGame(){
        return Response.ok().build();
    }
}