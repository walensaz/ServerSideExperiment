package objects;

import Run.Main;
import objects.playerobjects.*;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

public class Player implements Serializable {

    private static final long serialVersionUID = -942038562193532152L;

    //Nullable
    private String email;
    private String password;
    private PlayerAlliance alliance;

    //NotNull
    private Rank rank;
    private String username;
    private PlayerCastle castle;
    private Hero hero;
    private VIP vip;
    private int kingdom;

    //Resources
    private ConcurrentHashMap<Integer, Resource> resources;
    private Resource gold;

    private Inventory items;
    private long power;
    private boolean hasSecondBuildingQueue;

    private transient Socket socket;
    private transient PrintWriter outputStream;
    private transient  BufferedReader inputStream;

    public Player(String username) {
        resources = new ConcurrentHashMap<>();
        resources.put(Resource.FOOD, new Resource(10000));
        resources.put(Resource.WOOD, new Resource(10000));
        resources.put(Resource.STONE, new Resource(20000));
        resources.put(Resource.SILVER, new Resource(20000));
        resources.put(Resource.GOLD, new Resource(100));
        this.username = username;
        this.castle = new PlayerCastle();
        this.hero = new Hero();
        this.alliance = new PlayerAlliance();
        this.vip = new VIP();
        this.kingdom = Main.newestkingdom;
        this.items = new Inventory();
        this.power = 1;
        this.hasSecondBuildingQueue = false;
    }

    public Player(String email, String password, String username) {
        this(username);
        this.email = email;
        this.password = password;
    }

    public ConcurrentHashMap<Integer, Resource> getResources() {
        return resources;
    }

    public void setResources(ConcurrentHashMap<Integer, Resource> resources) {
        this.resources = resources;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public PlayerCastle getCastle() {
        return castle;
    }

    public void setCastle(PlayerCastle castle) {
        this.castle = castle;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public PlayerAlliance getAlliance() {
        return alliance;
    }

    public void setAlliance(PlayerAlliance alliance) {
        this.alliance = alliance;
    }

    public VIP getVip() {
        return vip;
    }

    public void setVip(VIP vip) {
        this.vip = vip;
    }

    public int getKingdom() {
        return kingdom;
    }

    public void setKingdom(int kingdom) {
        this.kingdom = kingdom;
    }

    public Resource getGold() {
        return gold;
    }

    public void setGold(Resource gold) {
        this.gold = gold;
    }

    public Inventory getItems() {
        return items;
    }

    public void setItems(Inventory items) {
        this.items = items;
    }

    public long getPower() {
        return power;
    }

    public void setPower(long power) {
        this.power = power;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
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

    public void setHasSecondBuildingQueue(boolean has) { this.hasSecondBuildingQueue = has; }

    public boolean hasSecondBuildingQueue() {
        return this.hasSecondBuildingQueue;
    }

    public String getData() {
        try {
            return inputStream.readLine();
        } catch(IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void sendData(String inputStream) {
         outputStream.write(inputStream);
    }

    @Override
    public String toString() {
        return (this.email == null || this.email == "") ? "Player{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", alliance=" + alliance +
                ", username='" + username + '\'' +
                ", castle=" + castle +
                ", hero=" + hero +
                ", vip=" + vip +
                ", kingdom=" + kingdom +
                ", resources=" + resources +
                ", gold=" + gold +
                ", items=" + items +
                ", power=" + power +
                '}' : "Player{alliance=" + alliance +
                ", username='" + username + '\'' +
                ", castle=" + castle +
                ", hero=" + hero +
                ", vip=" + vip +
                ", kingdom=" + kingdom +
                ", resources=" + resources +
                ", gold=" + gold +
                ", items=" + items +
                ", power=" + power +
                '}';
    }
}
