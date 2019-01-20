package me.zach.exyleserver.handlers;

import me.zach.exyleserver.objects.player.GamePlayer;
import me.zach.exyleserver.objects.Logger;
import me.zach.exyleserver.packet.Packet;

import java.io.IOException;

public class PacketHandler implements Runnable {

    private GamePlayer user;
    private String incomingPacket;

    public PacketHandler(GamePlayer user) {
        this.incomingPacket = "";
        Logger.log("Enabling Packer Handler");
        this.user = user;
    }

    @Override
    public void run() {
        while(user.getSocket().isConnected()) {
            try {
                if ((incomingPacket = user.getInputStream().readLine()) != null) {
                    Packet packet = Packet.packetDecoder(incomingPacket);
                    if(packet != null) {
                        user.addPacketToQueue(packet);
                    }
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}