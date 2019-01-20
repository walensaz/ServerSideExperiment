package me.zach.exyleserver.objects.objects.playerobjects;

import java.io.Serializable;

public class PlayerAlliance implements Serializable {

    private static final long serialVersionUID = -942038562193532152L;

    private String abrv;
    private String name;

    public PlayerAlliance() {
        abrv = null;
        name = null;
    }

    public PlayerAlliance(String abrv, String name) {
        this.abrv = abrv;
        this.name = name;
    }

    public String getAbrv() {
        return abrv;
    }

    public void setAbrv(String abrv) {
        this.abrv = abrv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PlayerAlliance{" +
                "abrv='" + abrv + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
