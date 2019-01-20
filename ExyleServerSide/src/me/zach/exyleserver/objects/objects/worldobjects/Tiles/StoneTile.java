package me.zach.exyleserver.objects.objects.worldobjects.Tiles;

public class StoneTile extends ResourceTile {

    public StoneTile(int x, int y, boolean isOccupied, int level) {
        super(x, y, isOccupied, ResourceTile.createResources(3, level), level);
    }

    @Override
    public String toString() {
        return "ST";
    }

}
