package me.zach.exyleserver.objects.player;

import me.zach.exyleserver.objects.Logger;
import me.zach.exyleserver.objects.LoggerLevel;
import me.zach.exyleserver.objects.User;
import me.zach.exyleserver.packet.Packet;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class GamePlayer extends User {

    private ArrayList<Packet> packetQueue;

    public GamePlayer(Socket socket, String username, String password, PrintWriter outputStream, BufferedReader inputStream) {
        super(socket, username, password, outputStream, inputStream);
        this.packetQueue = new ArrayList<>();
    }

    public GamePlayer(User user) {
        this(user.getSocket(), user.getUsername(), user.getPassword(), user.getOutputStream(), user.getInputStream());
    }

    public boolean addPacketToQueue(Packet packet) {
        if(packetQueue.size() < 40) {
            packetQueue.add(packet);
            return true;
        }
        Logger.log(this.getUsername() + " is overflowing the packet buffer therefore we are removing the last packet!", LoggerLevel.LOW);
        packetQueue.remove(0);
        return false;
    }

    public void processPackets() {
            if(packetQueue.size() > 0) {
                for (Packet packet : packetQueue) {
                    packet.process();
                    packetQueue.remove(packet);
                    if(packetQueue.size() <= 0) {
                        break;
                    }
                }
            }
    }
}
