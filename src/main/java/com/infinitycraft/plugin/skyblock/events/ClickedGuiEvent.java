package com.infinitycraft.plugin.skyblock.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Objects;

public class ClickedGuiEvent implements Listener {

    @EventHandler
    public void InvClick(InventoryClickEvent e) {
        if (e.getView().getTitle().equals("Test GUI")) {
            Player player = (Player) e.getWhoClicked();
            //Determine what they selected and what to do
            if (Objects.requireNonNull(e.getCurrentItem()).getItemMeta().getDisplayName().equals("test")) {
                player.closeInventory();
                player.sendMessage("testing");
            }
            e.setCancelled(true); //So they cant take the items
        }
    }
}


/**
 Player player = (Player) e.getWhoClicked();

 ItemStack item = e.getCurrentItem();

 if(e.getClickedInventory() == null){
 return;
 }
 if(e.getView().getTitle().equals("Test GUI")){
 e.setCancelled(true);
 if(item==null || !item.hasItemMeta()){
 return;
 }

 if(item.getItemMeta().getDisplayName().equals("test")){
 player.closeInventory();
 player.sendMessage("testing");
 }
 */