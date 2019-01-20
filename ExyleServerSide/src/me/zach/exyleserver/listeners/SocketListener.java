package me.zach.exyleserver.listeners;

import me.zach.exyleserver.Launch;
import me.zach.exyleserver.handlers.LoginHandler;
import me.zach.exyleserver.objects.Logger;
import me.zach.exyleserver.objects.LoggerLevel;
import me.zach.main.MultiThreadedServer;
import me.zach.main.Server;

import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class SocketListener implements Runnable {

    private LoginHandler loginHandler;
    private MultiThreadedServer server;

    public SocketListener(Server server) {
        Logger.log("Listening for incoming sockets...", LoggerLevel.INFO);
        this.loginHandler = new LoginHandler();
        this.server = new MultiThreadedServer(server);
        Launch.gameThreads.schedule(this.server, 1, TimeUnit.MILLISECONDS);
    }

    @Override
    public void run() {
        Socket newSocket = null;
        newSocket = server.listen();
        if (newSocket != null) {
            Logger.log("Accepted a socket...");
            handleConnection(newSocket);
        }
    }

    private void handleConnection(Socket socket) {
        loginHandler.run(socket);
    }


}