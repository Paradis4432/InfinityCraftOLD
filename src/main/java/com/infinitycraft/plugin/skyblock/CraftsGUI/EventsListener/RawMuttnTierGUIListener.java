package com.infinitycraft.plugin.skyblock.CraftsGUI.EventsListener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class RawMuttnTierGUIListener implements Listener {

    @EventHandler
    public void InvClick(InventoryClickEvent e) {
        if (e.getView().getTitle().equals(ChatColor.GOLD + "All Mutton Tiers!")) {
            Player player = (Player) e.getWhoClicked();
            //Determine what they selected and what to do
            if (e.getCurrentItem() != null) {

                //check for name and do based on event
            }
            e.setCancelled(true);

        }
    }
}
