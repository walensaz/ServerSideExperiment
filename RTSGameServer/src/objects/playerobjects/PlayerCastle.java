package objects.playerobjects;

import Run.Main;
import objects.Player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class PlayerCastle implements Serializable {

    private static final long serialVersionUID = -942038562193532152L;
    private HashMap<Integer, Building> buildings;

    public PlayerCastle() {
        buildings = new HashMap<>();
        buildings.put(Building.CASTLE.getId(), Building.CASTLE);
        buildings.put(Building.FARM.getId(), Building.FARM);
        buildings.put(Building.SAWMILL.getId(), Building.SAWMILL);
        buildings.put(Building.QUARRY.getId(), Building.QUARRY);
        buildings.put(Building.BARRACKS.getId(), Building.BARRACKS);
        buildings.put(Building.HOSPITAL.getId(), Building.HOSPITAL);
        buildings.put(Building.JAIL.getId(), Building.JAIL);
        buildings.put(Building.ALTAR.getId(), Building.ALTAR);
        buildings.put(Building.LIBRARY.getId(), Building.LIBRARY);
        buildings.put(Building.ARMORY.getId(), Building.ARMORY);
        buildings.put(Building.MARKETPLACE.getId(), Building.MARKETPLACE);
        buildings.put(Building.WAR_HALL.getId(), Building.WAR_HALL);
        buildings.put(Building.EMBASSY.getId(), Building.EMBASSY);
        buildings.put(Building.WATCHTOWER.getId(), Building.WATCHTOWER);
        buildings.put(Building.FACTORY.getId(), Building.FACTORY);
        buildings.put(Building.DEPOT.getId(), Building.DEPOT);
        buildings.put(Building.HOUSE.getId(), Building.HOUSE);
    }

    public Building getBuilding(int id) {
        for(Building building : buildings.values()) {
            if(building.getId() == id) {
                return building;
            }
        }
        return null;
    }

    public boolean contains(int id) {
        for(Building building : buildings.values()) {
            if(building.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public boolean upgrade(int id) {
        if(!(buildings.values().contains(true))) {
            Building building = getBuilding(id);
            Main.upgrading.add(findInsertionPoint(building, Main.upgrading), building);
        }
        return false;
    }


    private int findInsertionPoint(Building building, ArrayList<Building> buildings) {
        int low = 0, high = buildings.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            long compareValue = buildings.get(mid).getTimeleft();
            if (compareValue < building.getTimeleft()) low = mid + 1;
            else if (compareValue > building.getTimeleft()) high = mid - 1;
            else return mid;
        }
        return low;
    }


    @Override
    public String toString() {
        return "PlayerCastle#" +
                "" + buildings +
                ":";
    }
}
