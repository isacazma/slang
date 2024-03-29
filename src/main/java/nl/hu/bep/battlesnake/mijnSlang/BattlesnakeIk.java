package nl.hu.bep.battlesnake.mijnSlang;



import nl.hu.bep.battlesnake.model.GameInformation;

import java.util.HashMap;
import java.util.Map;

public class BattlesnakeIk {
    private static BattlesnakeIk instance;
    private static Map<String, Object> res = new HashMap<>();
    private static GameInformation snake = new GameInformation("1", "Alucard", "#26CF04",
            "smile", "bolt");

    static {
        res.put("apiversion", snake.getApiversion());
        res.put("author", snake.getAuthor());
        res.put("color", snake.getColor());
        res.put("head", snake.getHead());
        res.put("tail", snake.getTail());
    }

    private BattlesnakeIk(){}

    public static BattlesnakeIk getInstance(){
        if (instance == null) {
            instance = new BattlesnakeIk();
        }
        return instance;
    }

    public Map<String,Object> listAll(){
        return res;
    }

    public boolean update(GameInformation gameInformation){

        if (res.get("author") == gameInformation.getAuthor()) {

            res.put("color", gameInformation.getColor());
            res.put("head", gameInformation.getHead());
            res.put("tail", gameInformation.getTail());

            return true;
        }

        return false;
    }
}
