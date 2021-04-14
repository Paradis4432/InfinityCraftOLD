package com.infinitycraft.plugin.general.staffMode.events.items;

import com.infinitycraft.plugin.general.staffMode.GUIs.StaffMenu;
import com.infinitycraft.plugin.general.staffMode.items.StaffMenuItem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import static com.infinitycraft.plugin.general.staffMode.events.MainStaffEvent.staffModeList;

public class StaffMenuItemEvent implements Listener {
    @EventHandler
    public void playerUseItem(PlayerInteractEvent e) {
        if (staffModeList.contains(e.getPlayer().getUniqueId()) && e.getPlayer().getInventory().getItemInMainHand().hashCode() == StaffMenuItem.staffMenu.hashCode()) {
            StaffMenu.GenerateInventory(e.getPlayer(), 1, false, "");
            e.setCancelled(true);
        }
    }
}
