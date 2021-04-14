package com.infinitycraft.plugin.general.staffMode.events.items;

import com.infinitycraft.plugin.general.staffMode.items.LauncherItem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import static com.infinitycraft.plugin.general.staffMode.events.MainStaffEvent.staffModeList;

public class LauncherEvent implements Listener {
    @EventHandler
    public void playerUseItem(PlayerInteractEvent e) {
        if (staffModeList.contains(e.getPlayer().getUniqueId()) && e.getPlayer().getInventory().getItemInMainHand().hashCode() == LauncherItem.launcher.hashCode()) {
            Player p = e.getPlayer();
            p.setVelocity(p.getLocation().getDirection().multiply(10));
            e.setCancelled(true);
        }
    }
}
