package me.zach.exyleserver.objects.objects.worldobjects.Tiles;

public class WoodTile extends ResourceTile {

    public WoodTile(int x, int y, boolean isOccupied, int level) {
        super(x, y, isOccupied, ResourceTile.createResources(4, level), level);
    }

    @Override
    public String toString() {
        return "W";
    }

}