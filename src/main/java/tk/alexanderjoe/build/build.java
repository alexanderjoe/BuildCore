package tk.alexanderjoe.build;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import tk.alexanderjoe.build.commands.*;
import tk.alexanderjoe.build.utils.PlayerJoin;

import java.io.File;

public class build extends JavaPlugin implements Listener {

    public static build plugin;
    public static String prefix = "§bBuildCore" + "§7> §f";
    public FileConfiguration config = this.getConfig();

    public void onEnable(){
        plugin = this;

        Bukkit.getConsoleSender().sendMessage("§2BuildCore has been activated!");

        PluginManager pm = getServer().getPluginManager();

        pm.registerEvents(new PlayerJoin(), this);

        getCommand("chatclearall").setExecutor(new CCA());
        getCommand("chatclear").setExecutor(new CC());
        getCommand("kick").setExecutor(new Kick());
        getCommand("guide").setExecutor(new Guide());
        getCommand("download").setExecutor(new Download());
        getCommand("nnw").setExecutor(new NNW());

        if(config.getBoolean("WCV")) { } else {
            getCommand("mvc").setExecutor(new mvc());
            getCommand("mvcreate").setExecutor(new mvc());
            getCommand("mv").setExecutor(new mvc());
        }

        config.addDefault("WCV", true);
        config.options().copyDefaults(true);
        saveConfig();
    }

//    private void createConfig() {
//        try {
//            if (!getDataFolder().exists()) {
//                getDataFolder().mkdirs();
//            }
//            File file = new File(getDataFolder(), "config.yml");
//            if (!file.exists()) {
//                getLogger().info("Config.yml not found, creating!");
//                saveDefaultConfig();
//            } else {
//                getLogger().info("Config.yml found, loading!");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "Bad Vibes muh dude.");
//        }
//    }
//    public static String wcv = plugin.getConfig().getString("WCV");

    public void sync(Runnable runnable) {
        getServer().getScheduler().runTask(this, runnable);
    }

    public void async(Runnable runnable) {
        getServer().getScheduler().runTaskAsynchronously(this, runnable);
    }

    public void onDisable(){
        plugin = null;

        Bukkit.getConsoleSender().sendMessage("§4BuildCore has been deactivated!");
    }
}
