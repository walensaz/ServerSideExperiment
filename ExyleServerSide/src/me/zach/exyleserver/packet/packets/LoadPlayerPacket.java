package me.zach.exyleserver.packet.packets;

import me.zach.exyleserver.packet.Packet;
import me.zach.exyleserver.packet.Packets;

public class LoadPlayerPacket implements Packet {

    public LoadPlayerPacket(String PID) {

    }

    @Override
    public String encode() {
        return null;
    }

    @Override
    public Packet decode(String[] contents) throws ArrayIndexOutOfBoundsException {
        return null;
    }

    @Override
    public boolean process() {
        return false;
    }

    @Override
    public int getID() {
        return Packets.LOAD_PLAYER_PACKET.getPacketId();
    }
}
