package me.zach.exyleserver.objects;

import me.zach.exyleserver.packet.Packet;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

public class User {

    private Socket socket;
    private String username;
    private String password;
    private PrintWriter outputStream;
    private BufferedReader inputStream;

    public User(Socket socket, String username, String password, PrintWriter outputStream, BufferedReader inputStream) {
        this.socket = socket;
        this.username = username;
        this.password = password;
        this.outputStream = outputStream;
        this.inputStream = inputStream;
    }

    public Socket getSocket() {
        return socket;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PrintWriter getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(PrintWriter outputStream) {
        this.outputStream = outputStream;
    }

    public BufferedReader getInputStream() {
        return inputStream;
    }

    public void setInputStream(BufferedReader inputStream) {
        this.inputStream = inputStream;
    }

    public boolean send(Packet packet) {
        getOutputStream().println(packet.encode());
        getOutputStream().flush();
        return true;
    }
}
