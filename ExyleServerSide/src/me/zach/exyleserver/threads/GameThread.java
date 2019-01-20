package me.zach.exyleserver.threads;

import me.zach.exyleserver.Utils;
import me.zach.exyleserver.objects.player.GamePlayer;
import me.zach.exyleserver.objects.Logger;
import me.zach.exyleserver.packet.Packet;

import java.io.IOException;
import java.net.SocketException;
import java.util.concurrent.*;

public class GameThread implements Runnable {

    private GamePlayer gamePlayer;
    private Future<?> gameThread;

    public GameThread(GamePlayer gamePlayer) {
        MainGameThread.onLogin(gamePlayer);
        this.gamePlayer = gamePlayer;
        gameThread = Utils.playerThreads.scheduleAtFixedRate(this, 10, 10, TimeUnit.MILLISECONDS);
    }

    @Override
    public void run() {
            String incomingPacket = "";
            try {
                if ((incomingPacket = gamePlayer.getInputStream().readLine()) != null) {
                    Packet packet = Packet.packetDecoder(incomingPacket);
                    if (packet != null) {
                        gamePlayer.addPacketToQueue(packet);
                    }
                }
            } catch(SocketException e) {
                Logger.log(gamePlayer.getUsername() + " has disconnected from the server!");
                gameThread.cancel(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
            gamePlayer.processPackets();
    }
}
