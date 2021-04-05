package com.infinitycraft.plugin.general.storageManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.ServerLoadEvent;

import java.sql.SQLException;

public class StorageAutomation implements Listener {
    /** Completes actions when a player joins
     *
     */
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        if (!(e.getPlayer().hasPlayedBefore())) {
            NewObject.newPlayer(e.getPlayer());
        }
        String name = (String) GetObject.getPlayer(e.getPlayer().getUniqueId(), "name");
        if (!name.equals(e.getPlayer().getName())) {
            EditObject.editPlayer(e.getPlayer().getUniqueId(), "name", e.getPlayer().getName());
        }
        Player player = e.getPlayer();
        EditObject.editPlayer(player.getUniqueId(), "online", true);
        if ((boolean) GetObject.getPlayer(e.getPlayer().getUniqueId(), "staffMode")) {
            e.getPlayer().performCommand("staff");
        }
    }

    /**
     * Mark a player as offline when they leave
     */
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        EditObject.editPlayer(player.getUniqueId(), "online", false);
    }

    @EventHandler
    public void serverStart(ServerLoadEvent e){
        try {
            SQLDatabase.statement.execute("UPDATE players SET online = false");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
