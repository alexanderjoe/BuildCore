package tk.alexanderjoe.build.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class PlayerJoin implements Listener{
    @EventHandler
    public void on(PlayerJoinEvent e){
        for (Player p : Bukkit.getServer().getOnlinePlayers()){
            Location loc = p.getLocation();
            p.playSound(loc, Sound.CAT_MEOW, 5, (float) 1);
        }
    }
}
