package nl.hu.bep.battlesnake.model;

import java.util.ArrayList;
import java.util.List;

public class LijstSpellen {




    public static List<Game> getAlleSpellen() {
        return alleSpellen;
    }

    public static List<Game> alleSpellen = new ArrayList<Game>();

    public static void addGame(Game spel){
        alleSpellen.add(spel.setIdea(" dit was spel "+alleSpellen.size()));
}}
