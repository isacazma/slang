package nl.hu.bep.battlesnake.model;

import nl.hu.bep.battlesnake.movement.Move;

public class MoveResponse{
    private Move move;
    private String shout;

    public MoveResponse(Move move , String shout){
        this.move = move;
        this.shout = shout;
    }

    public MoveResponse(){}

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }



    public String getShout() {
        return shout;
    }
    public void setShout(String shout) {
        this.shout = shout;
    }




//    public String keuze(int x,int y){
//        String move = "l";
//        if(y >= 10 && x < 5){
//            move = "right";
//        }
//        if(y >= )
//    }
}


//            gameMove hier
//            gebruikt instantie van bord omdat het makelijker is om te llezen
//             dus fuctie maken makelijker
//            for (Snake snake : board.getSnakes()
//                 ) {
//
//            }


//import javax.ws.rs.Consumes;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.core.MediaType;
//
//@POST
//@Path("/move")
//@Consumes(MediaType.APPLICATION_JSON)
//public Response moveSnake(String r){
//        System.out.println(r);
//        ObjectMapper om = new ObjectMapper();
//        try {
//        JsonNode request = om.readTree(r);
//        Board board = new Board(request.get("board"));
//        for (JsonNode node : request.get("board").get("snakes")) {
//        board.addSnake(new Snake(node));
//        }
//        System.out.println(board.getSnakes().get(0).getName());
//        MoveResponse move = new MoveResponse("up","going Up");
//
//        return  Response.ok(move).build();
//        } catch (JsonProcessingException e) {
//        e.printStackTrace();
//        }
//        return  Response.serverError().build();
//        }

