package nl.hu.bep.battlesnake.model;

import java.util.ArrayList;

public class LijstSpellen {

    public static ArrayList<Game> getAlleSpellen() {
        return alleSpellen;
    }

    public static void setAlleSpellen(ArrayList<Game> alleSpellen) {
        LijstSpellen.alleSpellen = alleSpellen;
    }

    public static ArrayList<Game> alleSpellen = new ArrayList<Game>();

    public static void addGame(Game spel){
        alleSpellen.add(spel.setIdea(" dit was spel "+alleSpellen.size()));
}}
