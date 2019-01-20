package objects.worldobjects.Tiles;

import objects.Alliance;
import objects.worldobjects.Tile;

import java.io.Serializable;

public class Throne extends Tile implements Serializable {

    private boolean isOwned;
    private Alliance occupied;


    public Throne(int x, int y, boolean isOccupied, boolean isOwned, Alliance occupied) {
        super(x, y, isOccupied);
        this.isOwned = isOwned;
        this.occupied = occupied;
    }

    public boolean isOwned() {
        return isOwned;
    }

    public void setOwned(boolean owned) {
        isOwned = owned;
    }

    public Alliance getOccupied() {
        return occupied;
    }

    public void setOccupied(Alliance occupied) {
        this.occupied = occupied;
    }
}
