package me.zach.exyleserver.objects.Tasks;

import me.zach.exyleserver.objects.player.GamePlayer;
import me.zach.exyleserver.packet.packets.PrivateMessagePacket;
import me.zach.exyleserver.threads.MainGameThread;

public class SendPrivateMessageTask implements GlobalTask {

    private String sender;
    private String message;
    private String receiver;

    public SendPrivateMessageTask(String sender, String message, String receiver) {
        this.sender = sender;
        this.message = message;
        this.receiver = receiver;
    }

    @Override
    public void run() {
        if(receiver == null) {
            for (GamePlayer user : MainGameThread.getOnlineUsers()) {
                if(user.getUsername().equalsIgnoreCase(receiver)) {
                    user.send(new PrivateMessagePacket(sender, message, receiver));
                    break;
                }
            }
        }
    }
}
