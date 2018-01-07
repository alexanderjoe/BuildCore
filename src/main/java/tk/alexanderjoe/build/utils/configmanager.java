package tk.alexanderjoe.build.utils;

import org.bukkit.configuration.file.FileConfiguration;
import tk.alexanderjoe.build.build;

public class configmanager {

    private static FileConfiguration config;

    public static FileConfiguration getConfig() {
        if(config == null) {
            config = build.plugin.getConfig();
        }
        return config;
    }

    public static void SaveConfig() {
        build.plugin.saveConfig();
    }
}
