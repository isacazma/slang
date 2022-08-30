package nl.hu.bep.battlesnake.model;



import com.fasterxml.jackson.databind.JsonNode;
import nl.hu.bep.battlesnake.database.testDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Game {

    private String id;
    private Object ruleset;
    private String map;
    private Integer timeout;
    private String source;

    private List<String> gameList = new ArrayList<>();

    public Game(JsonNode js) {
        this.id = js.get("id").textValue();

        this.map = js.get("map").textValue();
        this.timeout = js.get("map").intValue();
        this.source = js.get("source").textValue();
    }

   public Game setIdea (String id){
       this.id = id;

       return null;
   }

    public Game() { }

    public Game getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getRuleset() {
        return ruleset;
    }

    public void setRuleset(Object ruleset) {
        this.ruleset = ruleset;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDBData(String gameID, String turns, String snakeSize) throws SQLException {
        testDatabase test = new testDatabase();
        test.setId(gameID, turns, snakeSize);
    }

    public List<Integer> getDbData() {
        testDatabase test = new testDatabase();

        return test.getId();
    }

    public void deleteDBData(int id) throws SQLException {
        testDatabase test = new testDatabase();
        test.deleteID(id);
    }

    public Map<String, Object> getDbSingleData(int id) {
        testDatabase test = new testDatabase();
        return test.getSingleData(id);
    }
}
