package me.zach.exyleserver.packet;

import me.zach.exyleserver.packet.packets.LoadPlayerPacket;
import me.zach.exyleserver.packet.packets.LoginPacket;
import me.zach.exyleserver.packet.packets.PrivateMessagePacket;
import me.zach.exyleserver.packet.packets.SendMessagePacket;

public enum Packets {

    
    LOGIN_PACKET(1, LoginPacket.class),
    SEND_MESSAGE_PACKET(2, SendMessagePacket.class),
    PRIVATE_MESSAGE_PACKET(3, PrivateMessagePacket.class),
    LOAD_PLAYER_PACKET(4, LoadPlayerPacket.class);


    private int packetId;
    private Class packetClass;


    Packets(int packetId,  Class packetClass) {
        this.packetId = packetId;
        this.packetClass = packetClass;
    }

    public int getPacketId() {
        return packetId;
    }

    public Class getPacketClass() {
        return packetClass;
    }
}
