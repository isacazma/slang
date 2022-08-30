package nl.hu.bep.battlesnake.model;

import java.util.HashMap;
import java.util.Map;

public class GameInformation {
    private String apiversion;
    private String author;
    private String color;
    private String head;
    private String tail;


    private static GameInformation instance;
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


    public Map<String,Object> listAll(){
        return res;
    }


    public static GameInformation getInstance(){
        if (instance == null) {
            instance = new GameInformation();
        }
        return instance;
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


    private GameInformation(){}

    public GameInformation(String apiversion, String author, String color, String head, String tail) {
        this.apiversion = apiversion;
        this.author = author;
        this.color = color;
        this.head = head;
        this.tail = tail;
    }

    public GameInformation(String author, String color, String head, String tail) {
        this.author = author;
        this.color = color;
        this.head = head;
        this.tail = tail;
    }






    public void setApiversion(String apiversion) {
        this.apiversion = apiversion;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public void setTail(String tail) {
        this.tail = tail;
    }

//    public void setVersion(String version) {
//        this.version = version;
//    }

    public String getApiversion() {
        return apiversion;
    }

    public String getAuthor() {
        return author;
    }

    public String getColor() {
        return color;
    }

    public String getHead() {
        return head;
    }

    public String getTail() {
        return tail;
    }

//    public String getVersion() {
//        return version;
//    }
}

//    private String apiversion = "1";
//    private String author = "Alucard";
//    private String color = "#888888";
//    private String head = "default";
//    private String tail = "default";
//    private String version = "0.0.1-beta";