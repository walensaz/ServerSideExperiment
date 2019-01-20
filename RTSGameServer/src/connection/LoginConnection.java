package connection;

import threads.LoginThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginConnection extends Thread implements Runnable {

    ServerSocket serversocket;

    public LoginConnection() throws Exception {
        serversocket = new ServerSocket(4554);
        System.out.println("Listening on address " + serversocket.getInetAddress());
    }


    public void run() {
        Socket client;
        while (true) {
            try {
                client = serversocket.accept();
                new Thread(new LoginThread(client)).start();
            } catch (IOException e) {
                System.out.println("Caught exception in connection.LoginConnection class");
                try {
                    serversocket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                return;
            }
        }
    }
}
