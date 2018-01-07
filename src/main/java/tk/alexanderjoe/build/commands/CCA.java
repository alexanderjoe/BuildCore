package tk.alexanderjoe.build.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import tk.alexanderjoe.build.build;

public class CCA implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player p = (Player)sender;
        if(sender instanceof Player){
            if(sender.isOp()){
                if(cmd.getName().equalsIgnoreCase("chatclearall")){
                    if(sender.isOp()){
                        for (int i = 0; i < 340; i++){
                            Bukkit.broadcastMessage("");
                        }
                        Bukkit.broadcastMessage(build.prefix + "§cChat has been cleared by " + p.getDisplayName() + "§c!");
                        for (Player p1 : Bukkit.getServer().getOnlinePlayers()){
                            Location loc = p1.getLocation();
                            p1.playSound(loc, Sound.ANVIL_LAND, 5, (float) 1);
                        }

                    }
                }
            } else{
                sender.sendMessage(build.prefix + "§cYou do not have permission for this!");
            }
        }
        return true;
    }
}
