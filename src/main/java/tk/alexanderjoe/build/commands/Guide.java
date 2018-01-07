package tk.alexanderjoe.build.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import tk.alexanderjoe.build.build;

public class Guide implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        Player p = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("guide")) {
            p.sendMessage(build.prefix + "§eStarter guide: \n§3» To create a world enter the command: \n§2» /mvc " + p.getName() + " normal -g CleanroomGenerator:. "
                    + "\n§c» Do not forget to add the colon and dot!");
        }
        return true;
    }

}

