package me.zach.exyleserver.handlers;

import me.zach.exyleserver.objects.player.GamePlayer;
import me.zach.exyleserver.objects.Logger;
import me.zach.exyleserver.objects.LoggerLevel;
import me.zach.exyleserver.objects.User;
import me.zach.exyleserver.packet.packets.LoginPacket;
import me.zach.exyleserver.packet.Packet;
import me.zach.exyleserver.threads.GameThread;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.Timer;
import java.util.TimerTask;

public class LoginHandler extends Thread {

    private String incomingPacket;
    private int ran;

    public void run(Socket socket) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    try {
                        ran++;
                        if (ran >= 150) {
                            Logger.log("Login request timed out!");
                            timer.cancel();
                            socket.close();
                        }
                        User user = null;
                        incomingPacket = reader.readLine();
                        Packet packet = Packet.packetDecoder(incomingPacket);
                        if (packet instanceof LoginPacket) {
                            //So the login handler can access the internet address.
                            incomingPacket += ":" + socket.getInetAddress().toString();
                            LoginPacket loginPacket = (LoginPacket) packet.decode(incomingPacket.split(":"));
                            if (loginPacket.process()) {
                                user = new User(socket, loginPacket.getUsername(), loginPacket.getPassword(), writer, reader);
                                user.send(loginPacket);
                                new GameThread(new GamePlayer(user));
                                timer.cancel();
                            } else {
                                user = new User(socket, loginPacket.getUsername(), loginPacket.getPassword(), writer, reader);
                                user.send(loginPacket);
                                //Add logging system
                                Logger.log("Login failed: [User: " + loginPacket.getUsername() + "] [Pass: " + loginPacket.getPassword() + "] [IP: " + socket.getInetAddress() + "]", LoggerLevel.INFO);
                                timer.cancel();
                            }
                        }
                    } catch(SocketException e) {
                        timer.cancel();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            timer.scheduleAtFixedRate(task, 100, 100);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }


}
