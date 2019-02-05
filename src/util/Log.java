package util;

public class Log {
    public static void msg(String msg) {
        System.out.println("[INFO] " + msg);
    }

    public static void error(String msg) {
        System.err.println("[ERROR] " + msg);
    }

    public static void warn(String msg) {
        System.err.println("[WARNING] " + msg);
    }

    public static void debug(Object msg) {
        System.out.println("[DEBUG] " + msg.toString());
    }
}
