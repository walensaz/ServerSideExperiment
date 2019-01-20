package me.zach.exyleserver.objects.player.objects;

import java.util.HashMap;

public class Troops {

    private HashMap<TroopType, Integer> troops;

    public Troops(HashMap<TroopType, Integer> troops) {
        this.troops = troops;
    }
}
