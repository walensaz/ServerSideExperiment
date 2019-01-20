package me.zach.exyleserver.objects.objects.worldobjects.Tiles;

public class FoodTile extends ResourceTile {

    public FoodTile(int x, int y, boolean isOccupied, int level) {
        super(x, y, isOccupied, ResourceTile.createResources(5, level), level);
    }

    @Override
    public String toString() {
        return "F";
    }
}
