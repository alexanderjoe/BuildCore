package tk.alexanderjoe.build.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import tk.alexanderjoe.build.build;

public class Kick implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(cmd.getName().equalsIgnoreCase("kick")){
            if(sender.hasPermission("build.kick")){
                if (args.length < 2){
                    sender.sendMessage(build.prefix + "§cCorrect usage: /kick <player> <reason>");
                    return true;
                }
                String reason = "";
                int x = 0;
                for (String a : args) {
                    if (x == 0) {
                        x++;
                        continue;
                    }
                    reason = reason + " " + a;
                }
                Player target = Bukkit.getServer().getPlayer(args[0]);
                if (target == null) {
                    sender.sendMessage(build.prefix + "§cCould not find player " + args[0] + "!");
                    return true;
                }
                if (target.isOp() || target.hasPermission("build.exempt")) {
                    sender.sendMessage(build.prefix + "§cYou are not permitted to kick " + args[0] + "!");
                    return true;
                }
                target.kickPlayer("§c§nKicked§f \n\n§7Staff: §4" + sender.getName() + "\n§7Reason:§4" + reason);
                Bukkit.getServer().broadcastMessage(build.prefix + target.getName() + " has been kicked by " + sender.getName() + " for '" + reason + "'!");
            }else{
                sender.sendMessage(build.prefix + "§cYou are not permitted to kick players!");
            }
        }
        return true;
    }
}

