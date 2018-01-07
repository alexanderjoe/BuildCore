package tk.alexanderjoe.build.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tk.alexanderjoe.build.build;
import tk.alexanderjoe.build.utils.ColorTranslator;

public class NNW implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if(cmd.getName().equalsIgnoreCase("nnw")) {
            if(!(sender instanceof Player)) {
                sender.sendMessage(ColorTranslator.translate(build.prefix + "&cOnly console can use this command!"));
            } else {
                if(build.plugin.config.getBoolean("WCV")) {
                    sender.sendMessage(ColorTranslator.translate(build.prefix + "&aNo new worlds can be created now."));
                    build.plugin.config.set("WCV", false);
                    build.plugin.saveConfig();
                } else {
                    sender.sendMessage(ColorTranslator.translate(build.prefix + "&aWorlds can be created now."));
                    build.plugin.config.set("WCV", true);
                    build.plugin.saveConfig();
                }
            }
        }
        return true;
    }
}
