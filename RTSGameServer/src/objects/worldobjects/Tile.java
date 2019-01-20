package objects.worldobjects;

public class Tile {

    public static int FOOD = 175300, STONE = 137500, WOOD = 137500, SILVER = 104650, GOLD = 65;
    private int x;
    private int y;
    private boolean isOccupied;

    public Tile(int x, int y, boolean isOccupied) {
        this.x = x;
        this.y = y;
        this.isOccupied = isOccupied;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isOccupied() {
        return isOccupied;
    }


    @Override
    public String toString() {
        return "T";
    }
}
