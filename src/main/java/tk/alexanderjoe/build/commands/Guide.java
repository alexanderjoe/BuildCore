package tk.alexanderjoe.build.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import tk.alexanderjoe.build.build;
import tk.alexanderjoe.build.utils.ColorTranslator;

public class Guide implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        Player p = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("guide")) {
            p.sendMessage(ColorTranslator.translate(
                    build.prefix +
                            "&eGuide: " +
                            "\n&7» &eTo create a world enter the command: " +
                            "\n&7» &e/mvc " + p.getName() + " normal -g CleanroomGenerator&c:. " +
                            "\n&7» &eDo not forget to add the colon and dot!" +
                            "\n&7» &eTo download a world use this command:" +
                            "\n&7» &e/downloadworld"
            ));
        }
        return true;
    }

}

