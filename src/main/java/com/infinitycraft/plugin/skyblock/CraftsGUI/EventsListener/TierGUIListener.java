package com.infinitycraft.plugin.skyblock.CraftsGUI.EventsListener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Objects;

public class TierGUIListener implements Listener {

    @EventHandler
    public void InvClick(InventoryClickEvent e) {
        String title = e.getView().getTitle();
        String[] type = title.split(" ");

        Player player = (Player) e.getWhoClicked();
        player.sendMessage(type[1]);

        if (e.getView().getTitle().equals(ChatColor.GOLD + "All " + type[1] + " Tiers!")) {

            //Determine what they selected and what to do
            if(e.getCurrentItem() != null){
                for(int i = 1; i <= 12; i++){
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Tier " + i)) {
                        player.performCommand("crafts " + type[1] + " tier " + i);
                        player.sendMessage("crafts " + type[1] + " tier " + i);
                        e.setCancelled(true);
                        return;
                    }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Close")){
                        player.closeInventory();
                        return;
                    }
                }

            }

        }
    }
}
