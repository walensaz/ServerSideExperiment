package me.zach.exyleserver.threads;

import me.zach.exyleserver.objects.player.GamePlayer;
import me.zach.exyleserver.objects.Tasks.GlobalTask;

import java.util.ArrayList;

public class MainGameThread implements Runnable {

    private static final ArrayList<GlobalTask> tasks = new ArrayList<>();
    private static final ArrayList<GamePlayer> onlineUsers = new ArrayList<>();

    public static ArrayList<GamePlayer> getOnlineUsers() {
        return onlineUsers;
    }

    public static void onLogin(GamePlayer user) {
        onlineUsers.add(user);
    }

    public static void addTaskToQueue(GlobalTask task) {
        tasks.add(task);
    }

    public static GamePlayer getUser(String username) {
        for(GamePlayer user : onlineUsers) {
            if(user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void run() {
        if (tasks.size() > 0 && tasks.get(0) != null) {
            tasks.get(0).run();
            tasks.remove(0);
        }
        for(GamePlayer user : onlineUsers) {
            if(!user.getSocket().isConnected()) {
                onlineUsers.remove(user);
            }
        }
    }
}
