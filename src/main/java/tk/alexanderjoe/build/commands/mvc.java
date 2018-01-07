package tk.alexanderjoe.build.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import tk.alexanderjoe.build.build;
import tk.alexanderjoe.build.utils.ColorTranslator;
import tk.alexanderjoe.build.utils.configmanager;

public class mvc implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!configmanager.WCV()) {
            if (cmd.getName().equalsIgnoreCase("mvc") || cmd.getName().equalsIgnoreCase("mv") ||cmd.getName().equalsIgnoreCase("mvcreate")) {
                sender.sendMessage(ColorTranslator.translate(build.prefix + "&cNew worlds cannot be created at this time."));
            }
        }
        return true;
    }
}


