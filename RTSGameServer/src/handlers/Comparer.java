package handlers;

public class Comparer {

    public static boolean compare(Object client, String type) {
        return type.contains(client.toString().split("#")[0]);
    }
}
