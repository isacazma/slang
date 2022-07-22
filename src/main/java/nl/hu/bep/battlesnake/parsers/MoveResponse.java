//package nl.hu.bep.battlesnake.parsers;
//
//public class MoveResponse{
//    public String move;
//    public  String shout;
//
//    public  MoveResponse(String move , String shout){
//        this.move = move;
//        this.shout = shout;
//    }
//}

//import javax.ws.rs.Consumes;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.core.MediaType;
//
//@POST
//@Path("/move")
//@Consumes(MediaType.APPLICATION_JSON)
//public Response moveSnake(String r){
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

