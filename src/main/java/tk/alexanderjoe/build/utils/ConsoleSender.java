package tk.alexanderjoe.build.utils;

import org.bukkit.Bukkit;

public class ConsoleSender {
    public static void send(String msg) {
        Bukkit.getConsoleSender().sendMessage(ColorTranslator.translate(msg));
    }
}
