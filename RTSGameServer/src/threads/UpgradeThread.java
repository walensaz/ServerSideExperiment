package threads;

import Run.Main;
import objects.playerobjects.Building;

public class UpgradeThread extends Thread implements Runnable {

    public UpgradeThread(){}


    @Override
    public void run() {
        while (true) {
            if (Main.upgrading.size() > 0) {
                Building building = Main.upgrading.get(0);
                if(building.canUpgrade()) {
                    building.upgrade();
                    Main.upgrading.remove(0);
                }
            }
        }
    }
}
