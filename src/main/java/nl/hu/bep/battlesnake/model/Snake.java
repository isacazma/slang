package nl.hu.bep.battlesnake.model;

import com.fasterxml.jackson.databind.JsonNode;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Snake {
    private String id;
    private String name;
    private int health;
    private List<Point> body = new ArrayList<>();
    private Point head;
    private int length;
    private String shout;
    private String squad;
    private String customizations_color;
    private String customizations_head;
    private String customizations_tail;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Snake(JsonNode js) {
        this.id = js.get("id").textValue();
        this.name = js.get("name").textValue();

        for (JsonNode node : js.get("body")) {
            int x = node.get("x").intValue();
            int y = node.get("y").intValue();
            body.add(new Point(x,y));
        }
//        this.health = health;
//        this.head = head;
//        this.length = length;
//        this.shout = shout;
//        this.squad = squad;
//        this.customizations_color = customizations_color;
//        this.customizations_head = customizations_head;
//        this.customizations_tail = customizations_tail;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public List<Point> getBody() {
        return body;
    }

    public void setBody(List<Point> body) {
        this.body = body;
    }

    public Point getHead() {
        return head;
    }

    public void setHead(Point head) {
        this.head = head;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getShout() {
        return shout;
    }

    public void setShout(String shout) {
        this.shout = shout;
    }

    public String getSquad() {
        return squad;
    }

    public void setSquad(String squad) {
        this.squad = squad;
    }

    public String getCustomizations_color() {
        return customizations_color;
    }

    public void setCustomizations_color(String customizations_color) {
        this.customizations_color = customizations_color;
    }

    public String getCustomizations_head() {
        return customizations_head;
    }

    public void setCustomizations_head(String customizations_head) {
        this.customizations_head = customizations_head;
    }

    public String getCustomizations_tail() {
        return customizations_tail;
    }

    public void setCustomizations_tail(String customizations_tail) {
        this.customizations_tail = customizations_tail;
    }
}
