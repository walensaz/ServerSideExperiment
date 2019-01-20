package me.zach.exyleserver.objects.Tasks;

import me.zach.exyleserver.objects.player.GamePlayer;
import me.zach.exyleserver.packet.packets.SendMessagePacket;
import me.zach.exyleserver.threads.MainGameThread;

public class SendMessageTask implements GlobalTask {

    private String sender;
    private String message;
    private String receiver;

    public SendMessageTask(String sender, String message) {
        this.sender = sender;
        this.message = message;
        this.receiver = null;
    }

    public SendMessageTask(String sender, String message, String receiver) {
        this.sender = sender;
        this.message = message;
        this.receiver = receiver;
    }

    @Override
    public void run() {
        if(receiver == null) {
            for (GamePlayer user : MainGameThread.getOnlineUsers()) {
                user.send(new SendMessagePacket(sender, message));
            }
        }
    }
}
