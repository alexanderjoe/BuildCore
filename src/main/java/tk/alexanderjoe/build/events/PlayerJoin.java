package tk.alexanderjoe.build.events;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import tk.alexanderjoe.build.build;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayer(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        //Cancel join message
        e.setJoinMessage(null);

        //Tidy up the player
        p.setGameMode(GameMode.CREATIVE);
        p.setHealth(20);
        p.setFoodLevel(20);
        build.gameUP(p);

        //Play a sound
        for (Player p2 : Bukkit.getServer().getOnlinePlayers()) {
            Location loc = p2.getLocation();
            p2.playSound(loc, Sound.CAT_MEOW, 5, (float) 1);
        }
    }
}
