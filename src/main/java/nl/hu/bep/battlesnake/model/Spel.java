package nl.hu.bep.battlesnake.model;

import java.io.Serializable;

public class Spel implements Serializable {
    private String samenvatng;

    public Spel(String samenvatng) {
        this.samenvatng = samenvatng;
    }

    public String getSamenvatng() {
        return samenvatng;
    }

    public Spel setSamenvatng(String samenvatng) {
        this.samenvatng = samenvatng;
        return null;
    }
}
