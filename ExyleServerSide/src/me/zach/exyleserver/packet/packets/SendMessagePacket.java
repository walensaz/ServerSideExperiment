package me.zach.exyleserver.packet.packets;

import me.zach.exyleserver.objects.Tasks.SendMessageTask;
import me.zach.exyleserver.packet.Packet;
import me.zach.exyleserver.packet.Packets;
import me.zach.exyleserver.threads.MainGameThread;

public class SendMessagePacket implements Packet {


    public SendMessagePacket() { }

    private String sender;
    private String message;

    public SendMessagePacket(String sender, String message) {
        this.sender = sender;
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean process() {
        MainGameThread.addTaskToQueue(new SendMessageTask(this.sender, this.message));
        return true;
    }

    @Override
    public String encode() {
        return Packets.SEND_MESSAGE_PACKET.getPacketId() + ":" + sender + ":" + message;
    }

    @Override
    public Packet decode(String[] contents) {
        if(contents.length > 3) {
            String message = contents[2];
            for(int i = 2; i < contents.length; i++) {
                message += ":" + contents[i];
            }
            return new SendMessagePacket(contents[1], message);
        }
        return new SendMessagePacket(contents[1], contents[2]);
    }

    @Override
    public int getID() {
        return 0;
    }
}
