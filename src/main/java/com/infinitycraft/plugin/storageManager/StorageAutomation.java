package com.infinitycraft.plugin.storageManager;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class StorageAutomation implements Listener {
    /**
     *     Automatically create player in database when a player joins for the first time.
     */
    @EventHandler
    public void onNewPlayerJoin(PlayerJoinEvent e) {
        if (!(e.getPlayer().hasPlayedBefore())) {
            NewObject.newPlayer(e.getPlayer().getUniqueId(), null, null, null, null, null);
        }
        String name = (String) GetObject.getPlayer(e.getPlayer().getUniqueId(), "name");
        if (!name.equals(e.getPlayer().getName())) {
            EditObject.editPlayer(e.getPlayer().getUniqueId(), "name", e.getPlayer().getName());
        }
    }
}
