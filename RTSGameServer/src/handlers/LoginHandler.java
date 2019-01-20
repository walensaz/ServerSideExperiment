package handlers;

import objects.Player;

import java.io.*;

public class LoginHandler {

    public static Player getPlayer(String email, String password, String username) {
        boolean isMember = email != null;
        File playerFile = isMember ? getMember(email) : getGuest(username);

        //Check if player exists. If it does it, read and return existing player
        if (playerFile.exists()) {
            try (ObjectInputStream playerInputStream = new ObjectInputStream(new FileInputStream(playerFile))) {
                return (Player) playerInputStream.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            playerFile.getParentFile().mkdirs();
            playerFile.createNewFile();
        } catch(IOException e) {
            e.printStackTrace();
        }
        //Player does not exist and needs to be created
        Player player = isMember ? new Player(email, password, username) : new Player(username);
        try (ObjectOutputStream playerOutputStream = new ObjectOutputStream(new FileOutputStream(playerFile))) {
            playerOutputStream.writeObject(player);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return player;
    }

    private static File getGuest(String username) {
        return new File(System.getProperty("user.dir") + "\\players\\guestPlayers\\" + username + ".ser");
    }

    private static File getMember(String email) {
        return new File(System.getProperty("user.dir") + "\\players\\memberPlayers\\" + email + ".ser");
    }
}
