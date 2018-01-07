package tk.alexanderjoe.build;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import tk.alexanderjoe.build.commands.*;
import tk.alexanderjoe.build.utils.ColorTranslator;
import tk.alexanderjoe.build.utils.ConsoleSender;
import tk.alexanderjoe.build.utils.PlayerJoin;
import tk.alexanderjoe.build.utils.configmanager;

import java.io.File;

public class build extends JavaPlugin implements Listener {

    public static build plugin;
    public static String prefix = "§bBuildCore" + "§7> §f";
    public FileConfiguration config = this.getConfig();

    public void onEnable(){
        plugin = this;

        ConsoleSender.send(prefix + "&2Activated!");

        PluginManager pm = getServer().getPluginManager();

        pm.registerEvents(new PlayerJoin(), this);

        getCommand("chatclearall").setExecutor(new CCA());
        getCommand("chatclear").setExecutor(new CC());
        getCommand("kick").setExecutor(new Kick());
        getCommand("guide").setExecutor(new Guide());
        getCommand("ping").setExecutor(new ping());
//        getCommand("nnw").setExecutor(new NNW());

//        if(!configmanager.WCV()) {
//            getCommand("mvc").setExecutor(new mvc());
//            getCommand("mvcreate").setExecutor(new mvc());
//            getCommand("mv").setExecutor(new mvc());
//            ConsoleSender.send(prefix + "&cWorld creation has been disabled.");
//        }

        //Config
        File f = new File(this.getDataFolder(), "config.yml");
        if(!f.exists()) {
            this.getConfig().options().copyDefaults(true);
            saveConfig();
        }
        saveConfig();
    }

    public void onDisable(){
        plugin = null;

        ConsoleSender.send(prefix + "&4Deactivated!");
    }
}
