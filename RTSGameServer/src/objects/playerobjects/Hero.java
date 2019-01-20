package objects.playerobjects;

import objects.playerobjects.hero.HeroItem;
import objects.playerobjects.hero.HeroSlots;

import java.io.Serializable;
import java.util.HashMap;

public class Hero implements Serializable {

    private static final long serialVersionUID = -942038562193532152L;

    private int level;
    private long xp;

    private HashMap<Integer, HeroItem> heroitems;

    public Hero() {
        level = 1;
        xp = 1;
        heroitems = new HashMap<>();
        heroitems.put(HeroSlots.HEAD, HeroItem.NOTHING);
        heroitems.put(HeroSlots.CHEST, HeroItem.NOTHING);
        heroitems.put(HeroSlots.LEG, HeroItem.NOTHING);
        heroitems.put(HeroSlots.FEET, HeroItem.NOTHING);
        heroitems.put(HeroSlots.ACCESSORY_1, HeroItem.NOTHING);
        heroitems.put(HeroSlots.ACCESSORY_2, HeroItem.NOTHING);
    }

    public Hero(int level, long xp, HashMap<Integer, HeroItem> heroitems) {
        this.level = level;
        this.xp = xp;
        this.heroitems = heroitems;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public long getXp() {
        return xp;
    }

    public void setXp(long xp) {
        this.xp = xp;
    }

    public HashMap<Integer, HeroItem> getHeroitems() {
        return heroitems;
    }

    public void setHeroitems(HashMap<Integer, HeroItem> heroitems) {
        this.heroitems = heroitems;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "level=" + level +
                ", xp=" + xp +
                ", heroitems=" + heroitems +
                '}';
    }
}
