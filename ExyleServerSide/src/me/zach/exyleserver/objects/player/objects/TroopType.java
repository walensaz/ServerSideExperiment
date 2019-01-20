package me.zach.exyleserver.objects.player.objects;

public enum TroopType {
    FOOT_SOLDIER(1, 15, 20, 200),
    HUNTER(1, 22, 12, 160);


    private int tier;
    private int attack;
    private int defense;
    private int health;

    TroopType(int tier, int attack, int defense, int health) {
        this.tier = tier;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
    }

    public int getTier() {
        return tier;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getHealth() {
        return health;
    }
}
