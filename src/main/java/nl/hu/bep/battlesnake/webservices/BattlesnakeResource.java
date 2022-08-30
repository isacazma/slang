package nl.hu.bep.battlesnake.webservices;

import com.fasterxml.jackson.core.JsonProcessingException;
import nl.hu.bep.battlesnake.model.*;
import nl.hu.bep.battlesnake.movement.DataParser;
import nl.hu.bep.battlesnake.movement.Move;
import nl.hu.bep.battlesnake.movement.MoveController;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


//class MoveResponse{
//    public String move;
//    public  String shoukt;
//
//    public  MoveResponse(String move , String shout){
//        this.move = move;
//        this.shout = shout;
//    }
//        }



@Path("/snake")
public class BattlesnakeResource {
    private GameInformation dao = GameInformation.getInstance();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getSnake(){
        return dao.listAll();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public javax.ws.rs.core.Response update(@FormParam("color") String color, @FormParam("head") String head, @FormParam("tail") String tail){
        GameInformation updateSnake = new GameInformation("Alucard", color, head, tail);
        if (dao.update(updateSnake)){
            System.out.println("kk slet");
            return javax.ws.rs.core.Response.ok("Je hebt de snake geupdate.").build();
        }
System.out.println("kk hoer");
        return javax.ws.rs.core.Response.ok().build();
    }

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getGameInfo() {
//        GameInformation info = new GameInformation();
//        info.setAuthor("dit");
//
//        return Response.ok(info).build();
//    }


    @POST
    @Path("/start")
    @Consumes(MediaType.APPLICATION_JSON)
    public javax.ws.rs.core.Response start() throws SQLException {
        return javax.ws.rs.core.Response.ok("Start").build();
    }



    @POST
    @Path("/move")
    @Consumes(MediaType.APPLICATION_JSON)
//    throws JsonProcessingException
    public Response moveSnake(String r)  throws JsonProcessingException {
        DataParser dataparser = new DataParser();
        System.out.println(r);

        try{
            dataparser.DataParse(r);
            Board board = dataparser.getBoard();
            Snake you = dataparser.getYou();

            MoveController moveController = new MoveController(board, you);


            Move move =  moveController.getBestMove();
            MoveResponse moveResponse = new MoveResponse(move,"cola zero");


            String moveResponseJson = moveController.getJson(moveResponse);
            System.out.println("jsonMoveResponse: ");
            System.out.println(moveResponseJson);


            return  Response.ok(moveResponseJson).build();

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return  Response.serverError().build();
    }

    @GET
    @Path("/games")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Integer> games(){
        Game game = new Game();
        return game.getDbData();
    }

    @GET
    @Path("/games/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> games(@PathParam("id") int gameID){
        Game game = new Game();
        return game.getDbSingleData(gameID);
    }

    @DELETE
    @Path("/deleteGame")
    @Produces(MediaType.APPLICATION_JSON)
    public javax.ws.rs.core.Response deleteGame(int x) throws SQLException {
        Game game = new Game();
        game.deleteDBData(x);
        return javax.ws.rs.core.Response.ok("Game is deleted.").build();
    }

    @POST
    @Path("/end")
    @Consumes(MediaType.APPLICATION_JSON)
   public Response endGame(){
        return Response.ok().build();
    }
}