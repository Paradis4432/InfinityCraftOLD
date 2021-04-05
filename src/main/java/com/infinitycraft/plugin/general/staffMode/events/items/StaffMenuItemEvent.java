package com.infinitycraft.plugin.general.staffMode.events.items;

import com.infinitycraft.plugin.general.staffMode.GUIs.StaffMenu;
import com.infinitycraft.plugin.general.staffMode.items.StaffMenuItem;
import com.infinitycraft.plugin.general.storageManager.GetObject;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class StaffMenuItemEvent implements Listener {
    @EventHandler
    public void playerUseItem(PlayerInteractEvent e) {
        if ((boolean) GetObject.getPlayer(e.getPlayer().getUniqueId(), "staffMode") && e.getPlayer().getInventory().getItemInMainHand().hashCode() == StaffMenuItem.staffMenu.hashCode()) {
            StaffMenu.GenerateInventory(e.getPlayer(), 1, false, "");
            e.setCancelled(true);
        }
    }
}
