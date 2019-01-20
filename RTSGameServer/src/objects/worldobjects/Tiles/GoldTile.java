package objects.worldobjects.Tiles;

public class GoldTile extends ResourceTile {

    public GoldTile(int x, int y, boolean isOccupied, int level) {
        super(x, y, isOccupied, ResourceTile.createResources(1, level), level);
    }

    @Override
    public String toString() {
        return "G";
    }
}
