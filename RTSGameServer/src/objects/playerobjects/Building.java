package objects.playerobjects;

import java.io.Serializable;

public enum Building implements Serializable {

    CASTLE(0, 1, false, 21),
    FARM(1,1,false,21),
    SAWMILL(2,1,false,21),
    QUARRY(3,1,false,21),
    BARRACKS(4,1,false,21),
    HOSPITAL(5,1,false,21),
    JAIL(6,1,false,21),
    ALTAR(7,1,false,21),
    LIBRARY(8,1,false,21),
    ARMORY(9,1,false,21),
    MARKETPLACE(10,1,false,21),
    WAR_HALL(11,1,false,21),
    EMBASSY(12,1,false,21),
    WATCHTOWER(13,1,false,21),
    FACTORY(14,1,false,21),
    DEPOT(15,1,false,21),
    HOUSE(16,1,false,21);


    private static final long serialVersionUID = -942038562193532152L;

    private int level;
    private int id;
    private boolean isUpgrading;
    private int maxLevel;
    private long end;

    private final long BTIME = 100;
    private final double MULTIPLIER = 1.8;

    Building(int id, int level, boolean isUpgrading, int maxLevel) {
        this.level = level;
        this.id = id;
        this.isUpgrading = isUpgrading;
        this.maxLevel = maxLevel;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public boolean isUpgrading() {
        return isUpgrading;
    }

    public int getMaxLevel() { return maxLevel; }

    public long getTime() { return (long) ((BTIME * level) * MULTIPLIER); }

    public long getTimeleft() {
        return this.end;
    }

    public void startUpgrade() {
        isUpgrading = true;
        end = System.currentTimeMillis() + getTime();
    }

    public boolean canUpgrade() {
        if(System.currentTimeMillis() > end)
            return true;
        return false;
    }

    public void upgrade() {
        end = -1;
        isUpgrading = false;
        setLevel(getLevel() + 1);
    }


    @Override
    public String toString() {
        return "Building#" +
                "" + level +
                ":" + id +
                ":" + isUpgrading +
                ":" + maxLevel +
                ":";
    }
}
