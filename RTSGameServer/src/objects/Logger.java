package objects;

import java.util.logging.Level;

public class Logger extends java.util.logging.Logger {

    public Logger(String name, String resourceBundleName) {
        super(name, resourceBundleName);
    }

    public static void log(String message) {
        System.out.println("LOGGED: " + message);
    }

    public static void error(String message) {
        throw new Error(message);
    }

}
