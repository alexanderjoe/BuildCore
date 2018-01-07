package tk.alexanderjoe.build.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tk.alexanderjoe.build.build;
import tk.alexanderjoe.build.utils.ColorTranslator;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ping implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if(cmd.getName().equalsIgnoreCase("ping")) {
            if(args.length == 0 && sender instanceof Player) {
                Player p = (Player) sender;
                int ping = getPing(p);
                String strPing = "" + ping;
                if(ping <= 100){
                    strPing = "&a" + ping;
                }
                else if (ping >= 101 && ping <= 200){
                    strPing = "&e" + ping;
                }
                else if(ping >= 201 && ping <= 400){
                    strPing = "&c" + ping;
                }
                else if(ping >= 401 && ping <= 1000){
                    strPing = "&4" + ping;
                }
                else{
                    strPing = "&8" + ping;
                }
                p.sendMessage(ColorTranslator.translate(build.prefix + "Your ping is &f" + strPing));
            } else {
                Player p = (Player) sender;
                Player target = Bukkit.getPlayer(args[0]);
                int ping = getPing(target);
                String strPing = "" + ping;
                if(ping <= 100){
                    strPing = "&a" + ping;
                }
                else if (ping >= 101 && ping <= 200){
                    strPing = "&e" + ping;
                }
                else if(ping >= 201 && ping <= 400){
                    strPing = "&c" + ping;
                }
                else if(ping >= 401 && ping <= 1000){
                    strPing = "&4" + ping;
                }
                else{
                    strPing = "&8" + ping;
                }
                p.sendMessage(ColorTranslator.translate(build.prefix + target.getName() +"'s ping is &f" + strPing));
            }
        }
        return true;
    }

    public static int getPing(Player p)
    {
        String bpName = Bukkit.getServer().getClass().getPackage().getName();
        String version = bpName.substring(bpName.lastIndexOf(".") + 1, bpName.length());
        try
        {
            Class<?> CPClass = Class.forName("org.bukkit.craftbukkit." + version + ".entity.CraftPlayer");
            Object CraftPlayer = CPClass.cast(p);

            Method getHandle = CraftPlayer.getClass().getMethod("getHandle", new Class[0]);
            Object EntityPlayer = getHandle.invoke(CraftPlayer, new Object[0]);

            Field ping = EntityPlayer.getClass().getDeclaredField("ping");

            return ping.getInt(EntityPlayer);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return 0;
    }
}
