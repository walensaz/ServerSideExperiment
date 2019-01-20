package me.zach.exyleserver.objects.objects.worldobjects.Tiles;

public class SilverTile extends ResourceTile {

    public SilverTile(int x, int y, boolean isOccupied, int level) {
        super(x, y, isOccupied, ResourceTile.createResources(2, level), level);
    }


    @Override
    public String toString() {
        return "S";
    }
}
