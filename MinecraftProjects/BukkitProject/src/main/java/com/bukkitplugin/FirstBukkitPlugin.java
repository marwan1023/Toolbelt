package com.bukkitplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class FirstBukkitPlugin extends JavaPlugin {

    public FirstBukkitPlugin() {

    }

    @Override
    public void onEnable() {
        if (Bukkit.getOnlinePlayers().size() == 1) {
            Player player = (Player) Bukkit.getOnlinePlayers().toArray()[0];
            broadcastToServer("What's up " + player.getName());
        } else {
            broadcastToServer("What's up ninjas!!!");
        }

    }

    private void broadcastToServer(String msg) {
        Bukkit.broadcastMessage(ChatColor.GOLD + msg);
    }

}
