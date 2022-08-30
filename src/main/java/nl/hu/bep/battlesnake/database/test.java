package nl.hu.bep.battlesnake.database;

public class test {
    private int key;
    private String id;
    private String turns;

    public test(int key, String id, String turns) {
        this.key = key;
        this.id = id; this.turns = turns;
    }

    public test(int key) {
        this.key = key;
    }

    public test() {
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getTurns() {
        return turns;
    }

    public void setTurns(String turns) {
        this.turns = turns;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
