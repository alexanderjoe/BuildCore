package tk.alexanderjoe.build.commands;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.json.JSONObject;
import tk.alexanderjoe.build.build;
import tk.alexanderjoe.build.utils.ColorTranslator;
import tk.alexanderjoe.build.utils.Zip;

import java.io.File;
import java.util.UUID;

public class DownloadWorld implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if(cmd.getName().equalsIgnoreCase("downloadworld")) {
            if(sender instanceof Player) {
                Player p = (Player) sender;
                String world = p.getWorld().getName().toString();
                File path = p.getWorld().getWorldFolder();
                if(!path.exists()) {
                    p.sendMessage(ColorTranslator.translate(build.prefix + "&cError! World doesn't exist."));
                    return true;
                } else {
                    p.sendMessage(ColorTranslator.translate(build.prefix + "&eCompressing world..."));
                    String randy = UUID.randomUUID().toString().substring(0, 3);
                    File zip = new File(world + "-" + randy + ".zip");

                    try {
                        Zip.create(path, zip);
                    } catch(Exception e) {
                        e.printStackTrace();
                        p.sendMessage(ColorTranslator.translate(build.prefix + "&cFailed to compress " + world + "."));
                        return true;
                    }

                    p.sendMessage(ColorTranslator.translate(build.prefix + "&eUploading world..."));
                    try {
                        HttpResponse<JsonNode> json = Unirest.post("http://file.io").field("file", zip).asJson();
                        JSONObject object = json.getBody().getObject();
                        zip.delete();
                        sender.sendMessage(ColorTranslator.translate(build.prefix + "&eUpload complete: " + object.getString("link")));
                    } catch(Exception e) {
                        e.printStackTrace();
                        p.sendMessage(ColorTranslator.translate(build.prefix + "&cFailed to upload world..."));
                    }
                }
            } else {
                sender.sendMessage(ColorTranslator.translate(build.prefix + "&cYou must be a player to use this command!"));
                return true;
            }
        }
        return true;
    }
}
