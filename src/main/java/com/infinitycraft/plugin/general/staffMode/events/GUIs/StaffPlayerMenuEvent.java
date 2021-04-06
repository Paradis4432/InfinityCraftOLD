package com.infinitycraft.plugin.general.staffMode.events.GUIs;

import com.infinitycraft.plugin.general.staffMode.GUIs.PlayerMenu;
import com.infinitycraft.plugin.general.staffMode.GUIs.StaffPlayerMenu;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

public class StaffPlayerMenuEvent implements Listener {
    @EventHandler
    public static void InventoryClickEvent(InventoryClickEvent e) {
        if (e.getInventory().getType() != InventoryType.CREATIVE) {
            if (e.getView().getTitle().contains("Viewing Staff: ")) {
                // Exit
                if (e.getInventory().getItem(e.getSlot()).hashCode() == StaffPlayerMenu.exit.hashCode()) {
                    e.getWhoClicked().closeInventory();
                    e.setCancelled(true);
                }
                else if (e.getInventory().getItem(e.getSlot()).hashCode() == StaffPlayerMenu.teleport.hashCode()) {
                    e.getWhoClicked().closeInventory();
                    e.setCancelled(true);
                    String name = e.getView().getTitle().substring(e.getView().getTitle().indexOf("Viewing Staff: ") + 15);
                    Player target = Bukkit.getPlayer(name);
                    e.getWhoClicked().sendMessage(ChatColor.GOLD + "Teleported to: " + name + "!");
                    e.getWhoClicked().teleport(target);
                }
            }
        }
    }
}
