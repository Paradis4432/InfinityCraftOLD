package com.infinitycraft.plugin.general.staffMode.events.items;

import com.infinitycraft.plugin.general.staffMode.items.LauncherItem;
import com.infinitycraft.plugin.general.staffMode.items.VanishItem;
import com.infinitycraft.plugin.general.storageManager.GetObject;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class LauncherEvent implements Listener {
    @EventHandler
    public void playerUseItem(PlayerInteractEvent e) {
        if ((boolean) GetObject.getPlayer(e.getPlayer().getUniqueId(), "staffMode") && e.getPlayer().getInventory().getItemInMainHand().hashCode() == LauncherItem.launcher.hashCode()) {
            Player p = e.getPlayer();
            p.setVelocity(p.getLocation().getDirection().multiply(10));

        }
    }
}
