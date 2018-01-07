package tk.alexanderjoe.build.commands;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.json.JSONObject;
import tk.alexanderjoe.build.build;
import tk.alexanderjoe.build.utils.Zip;

import java.io.File;
import java.util.UUID;

public class Download implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        String current = "---";
        if (sender instanceof Player) {
            current = ((Player) sender).getWorld().getName();
        }
        try {
            build.plugin.async(new Runnable() {
                @Override
                public void run() {
                    String currentWorld = "---";
                    currentWorld = ((Player) sender).getWorld().getName();
                    sender.sendMessage(ChatColor.YELLOW + "Compressing world... " + currentWorld);
                    currentWorld = "/" + currentWorld;
                    String randy = UUID.randomUUID().toString().substring(0, 3);
                    File zip = new File( currentWorld + "-" + randy + ".zip");

                    try {
                        Zip.create(((Player) sender).getWorld().getWorldFolder(), zip);
                    } catch (Exception e) {
                        e.printStackTrace();
                        sender.sendMessage(ChatColor.RED + "Failed to compress.");
                        return;
                    }

                    sender.sendMessage(ChatColor.YELLOW + "Uploading world...");
                    try {
                        HttpResponse<JsonNode> json = Unirest.post("http://file.io").field("file", zip).asJson();
                        JSONObject object = json.getBody().getObject();
                        zip.delete();
                        sender.sendMessage(ChatColor.GOLD + "Upload complete: " + object.getString("link"));
                    } catch (Exception e) {
                        e.printStackTrace();
                        sender.sendMessage(ChatColor.RED + "Failed to upload, see the server logs.");
                    }

                }
            });
        } catch(Exception e) {
            e.printStackTrace();
            sender.sendMessage(ChatColor.YELLOW + "There was an error compressing and uploading the world.");
        }
        return true;
    }

}
