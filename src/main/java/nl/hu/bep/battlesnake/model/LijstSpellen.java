package nl.hu.bep.battlesnake.model;

import java.util.ArrayList;

public class LijstSpellen {

    public static ArrayList<Spel> getAlleSpellen() {
        return alleSpellen;
    }

    public static void setAlleSpellen(ArrayList<Spel> alleSpellen) {
        LijstSpellen.alleSpellen = alleSpellen;
    }

    public static ArrayList<Spel> alleSpellen = new ArrayList<Spel>();

    public static void addGame(Spel spel){
        alleSpellen.add(spel.setSamenvatng(" dit was spel "+alleSpellen.size()));
}}
