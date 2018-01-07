package tk.alexanderjoe.build.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tk.alexanderjoe.build.build;
import tk.alexanderjoe.build.utils.ColorTranslator;
import tk.alexanderjoe.build.utils.configmanager;

public class NNW implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        Player p = (Player)sender;
        if(cmd.getName().equalsIgnoreCase("nnw")) {
            if(!(sender instanceof Player)) {
                sender.sendMessage(ColorTranslator.translate(build.prefix + "&cOnly console can use this command!"));
            } else {
                if(p.hasPermission("buildcore.superadmin")) {
                    if(configmanager.WCV()) {
                        sender.sendMessage(ColorTranslator.translate(build.prefix + "&cNo new worlds can be created now."));
                        configmanager.SetWCV(false);
                    } else {
                        sender.sendMessage(ColorTranslator.translate(build.prefix + "&aWorlds can be created now."));
                        configmanager.SetWCV(true);
                        Bukkit.reload();
                    }
                }
            }
        }
        return true;
    }
}
