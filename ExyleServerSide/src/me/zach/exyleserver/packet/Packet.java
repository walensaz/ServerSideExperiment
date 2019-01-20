package me.zach.exyleserver.packet;

import me.zach.exyleserver.objects.Logger;

public interface Packet {

    String encode();

    Packet decode(String[] contents) throws ArrayIndexOutOfBoundsException;

    boolean process();

    int getID();

    static Packet packetDecoder(String contents) {
        int id = Integer.valueOf(contents.split(":")[0]);
        for(Packets packet : Packets.values()) {
            if(packet.getPacketId() == id) {
                try {
                    if(packet.getPacketId() == 1) {
                        return (Packet) packet.getPacketClass().newInstance();
                    }
                    return ((Packet) packet.getPacketClass().newInstance()).decode(contents.split(":"));
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}
