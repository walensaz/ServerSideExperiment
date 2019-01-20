package threads;

import handlers.Comparer;
import handlers.LoginHandler;
import objects.Logger;
import objects.Player;
import Run.Main;
import objects.preconnection.Login;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public class LoginThread extends Thread implements Runnable {

    private Login client;
    private Player player;
    private boolean isConnected;
    private Socket connection;
    private PrintWriter output;
    private BufferedReader input;
    String inputLine, outputLine;

    public LoginThread(Socket connection) throws IOException {
        this.connection = connection;
        input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        output = new PrintWriter(connection.getOutputStream());
        isConnected = false;
        client = new Login("ghdfgkdg");
    }

    private boolean canConnect() throws Exception {
        if (Comparer.compare(client, (inputLine = input.readLine()))) {
            if((player = LoginHandler.getPlayer(client.getEmail(), client.getPassword(), client.getUsername())) != null) {
                String[] split = inputLine.split("#")[1].split(":");
                client = (split.length == 1) ? new Login(split[0]) : new Login(split[0], split[1]);
                player.setSocket(connection);
                player.setInputStream(input);
                player.setOutputStream(output);
            }
        }
        return false;
    }

    public void run() {
        try {
            if (canConnect()) {
                Logger.log("Connected: " + player.toString());
                Main.connected.add(player);
                isConnected = true;
            }
        } catch (SocketException ex) {
            Logger.log("Connection exception " + client.toString());
            try {
                connection.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (isConnected) {
            //TODO: Add game thread.
        }
        this.interrupt();
    }
}
