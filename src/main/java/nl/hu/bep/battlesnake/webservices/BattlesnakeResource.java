package nl.hu.bep.battlesnake.webservices;

import nl.hu.bep.battlesnake.model.GameInformation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.Console;

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
        MoveResponse move = new MoveResponse("up","going Up");
        return  Response.ok(move).build();
    }


    @POST
    @Path("/end")
    @Consumes(MediaType.APPLICATION_JSON)
   public Response endGame(){
        return Response.ok().build();
    }
}