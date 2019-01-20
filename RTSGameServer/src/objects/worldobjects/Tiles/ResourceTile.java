package objects.worldobjects.Tiles;

import objects.worldobjects.Tile;

public class ResourceTile extends Tile {


    public transient static int GOLD = 24, SILVER = 32000, STONE = 56000, WOOD = 64000, FOOD = 72000;
    private int resources;
    private int level;

    public ResourceTile(int x, int y, boolean isOccupied, int resources, int level) {
        super(x, y, isOccupied);
        this.resources = resources;
        this.level = level;
    }

    public static int createResources(int type, int level) {
        switch(type) {
            case 1:
                switch (level) {
                    case 1:
                        return GOLD;
                    case 2:
                        return (int) (GOLD * 2.5);
                    case 3:
                        return (int) ((GOLD * 2.5) * 2.5);
                    default:
                        return GOLD;
                }
            case 2:
                switch (level) {
                    case 1:
                        return SILVER;
                    case 2:
                        return (int) (SILVER * 1.8);
                    case 3:
                        return (int) ((SILVER * 1.8) * 1.8);
                    case 4:
                        return (int) (((SILVER * 1.8) * 1.8) * 1.8);
                    case 5:
                        return (int) ((((SILVER * 1.8) * 1.8) * 1.8) * 1.8);
                    case 6:
                        return (int) (((((SILVER * 1.8) * 1.8) * 1.8) * 1.8) * 1.8);
                    default:
                        return SILVER;
                }
            case 3:
                switch (level) {
                    case 1:
                        return STONE;
                    case 2:
                        return (int) (STONE * 1.8);
                    case 3:
                        return (int) ((STONE * 1.8) * 1.8);
                    case 4:
                        return (int) (((STONE * 1.8) * 1.8) * 1.8);
                    case 5:
                        return (int) ((((STONE * 1.8) * 1.8) * 1.8) * 1.8);
                    case 6:
                        return (int) (((((STONE * 1.8) * 1.8) * 1.8) * 1.8) * 1.8);
                    default:
                        return STONE;
                }
            case 4:
                switch (level) {
                    case 1:
                        return WOOD;
                    case 2:
                        return (int) (WOOD * 1.8);
                    case 3:
                        return (int) ((WOOD * 1.8) * 1.8);
                    case 4:
                        return (int) (((WOOD * 1.8) * 1.8) * 1.8);
                    case 5:
                        return (int) ((((WOOD * 1.8) * 1.8) * 1.8) * 1.8);
                    case 6:
                        return (int) (((((WOOD * 1.8) * 1.8) * 1.8) * 1.8) * 1.8);
                    default:
                        return WOOD;
                }
            case 5:
                switch (level) {
                    case 1:
                        return FOOD;
                    case 2:
                        return (int) (FOOD * 1.8);
                    case 3:
                        return (int) ((FOOD * 1.8) * 1.8);
                    case 4:
                        return (int) (((FOOD * 1.8) * 1.8) * 1.8);
                    case 5:
                        return (int) ((((FOOD * 1.8) * 1.8) * 1.8) * 1.8);
                    case 6:
                        return (int) (((((FOOD * 1.8) * 1.8) * 1.8) * 1.8) * 1.8);
                    default:
                        return FOOD;
                }
        }
        return type;
    }

    public int getResources() {
        return resources;
    }

    public void setResources(int resources) {
        this.resources = resources;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }


    @Override
    public String toString() {
        return "{" + getX() + ", " + getY() + "}";
    }
}
