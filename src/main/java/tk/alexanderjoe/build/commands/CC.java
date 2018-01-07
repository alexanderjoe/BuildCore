package tk.alexanderjoe.build.commands;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import tk.alexanderjoe.build.build;

public class CC implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            Location loc = p.getLocation();
            if(cmd.getName().equalsIgnoreCase("chatclear")){
                if(p.hasPermission("build.clearchatself")){
                    for (int i = 0; i < 340; i++){
                        p.sendMessage("");
                    }
                    p.sendMessage(build.prefix + "§cYour chat has been cleared!");
                    p.playSound(loc, Sound.BURP, 5, (float) 0.8);
                }
            }
        }
        return true;
    }

}
