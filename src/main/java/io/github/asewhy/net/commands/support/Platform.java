package io.github.asewhy.net.commands.support;

public enum Platform {
    darwin,
    linux,
    win;

    private static final String OS = System.getProperty("os.name").toLowerCase();

    public static boolean isWindows() {
        return OS.contains("win");
    }

    public static boolean isDarwin() {
        return OS.contains("mac");
    }

    public static boolean isLinux() {
        return OS.contains("nix") ||
            OS.contains("nux") ||
        OS.contains("aix");
    }

    public static Platform current() {
        if(isDarwin()) {
            return Platform.darwin;
        } else if(isWindows()) {
            return Platform.win;
        } else {
            return Platform.linux;
        }
    }
}
