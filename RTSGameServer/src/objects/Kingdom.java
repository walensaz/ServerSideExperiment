package objects;

import GoogleAPI.API;
import objects.worldobjects.Tile;
import objects.worldobjects.Tiles.*;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Kingdom implements Serializable {

    private static final long serialVersionUID = -942038562193532152L;

    private int kingdomnum;
    private Tile[][] map;

    public Kingdom(int kingdomnum) {
        this.kingdomnum = kingdomnum;
        this.map = new Tile[700][1000];
        createMap();
    }

    private void createMap() {
        this.map[350][500] = new Throne(350,500, false, false, null);
        Random random = new Random();
        for(int x = 0; x < 700; x++) {
            for(int y = 0; y < 1000; y++) {
                if((random.nextInt(1000) < 200)) {
                    int spawn = random.nextInt(100);
                    if(spawn < 34) {
                        map[x][y] = new FoodTile(x,y,false,getKingdomLevel(x,y));
                        continue;
                    } else if(spawn < 55) {
                        map[x][y] = new WoodTile(x, y, false, getKingdomLevel(x, y));
                        continue;
                    } else if(spawn < 75) {
                        map[x][y] = new StoneTile(x,y,false,getKingdomLevel(x,y));
                        continue;
                    } else if(spawn < 94) {
                        map[x][y] = new SilverTile(x,y,false,getKingdomLevel(x,y));
                        continue;
                    } else {
                        map[x][y] = new GoldTile(x,y,false,getKingdomLevel(x,y));
                        continue;
                    }
                } else if(!(x == 350 && y == 500)){
                    map[x][y] = new Tile(x,y,false);
                    continue;
                }
            }
        }
    }

    private boolean inForest(int x, int y) {
        return ((x > 325 && y > 475) && (x < 375 && y < 525));
    }

    private int getKingdomLevel(int x, int y) {
        if(inForest(x, y)) {
            return 6;
        } else if((x > 250 && y > 375) && (x < 400 && y < 625)) {
            return 5;
        } else if((x > 200 && y > 300) && (x < 550 && y < 700)) {
            return 4;
        } else if((x > 150 && y > 225) && (x < 600 && y < 750)) {
            return 3;
        } else if((x > 100 && y > 175) && (x < 700 && y < 850)) {
            return 2;
        } else {
            return 1;
        }


    }


    @Override
    public String toString() {
        System.out.println("Kingdom");
        String str = "KINGDOM " + kingdomnum + "\n";
        for(int x = 0; x < 700; x++) {
            System.out.println();
            for(int y = 0; y < 1000; y++) {
                System.out.print(map[x][y].toString());
            }
        }
        return str;
    }

    public void printToFile(File file) throws Exception {
        API api = new API("1SsI5qSU_U9E48ahXdA5AsIGlPbW_6b1Xv9N0YhRgBh8");
        List<List<Object>> list = new ArrayList<>();
        list.add(api.makeLine("Kingdom", kingdomnum));
        api.writeTo(list, "A1:B1");
        list = new ArrayList<>();
        List<Object> objects = new ArrayList<>();
        for(int x = 0; x < 700; x++) {
            list.add(objects);
            objects = new ArrayList<>();
            for(int y = 0; y < 1000; y++) {
                objects.add(map[x][y].toString());
            }
        }
        api.writeTo(list, "A2:ZZZ");
    }

}
