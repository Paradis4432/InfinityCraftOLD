package com.infinitycraft.plugin.events;

import com.infinitycraft.plugin.guis.chatcolorGui;
import com.infinitycraft.plugin.guis.tagsGui;
import com.infinitycraft.plugin.main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class inventoryClickListener implements Listener {

    private main plugin;

    public inventoryClickListener(main plugin){
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this,plugin);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e){
        String title = e.getView().getTitle();

        if(title.equals(tagsGui.tagsInvName)){
            e.setCancelled(true);
            if(e.getCurrentItem() == null){
                return;
            }
            if(title.equals(tagsGui.tagsInvName)){
                tagsGui.click((Player) e.getWhoClicked(), e.getSlot() , e.getCurrentItem() , e.getInventory());
            }
        }
    }

    @EventHandler
    public void onChatColorClick(InventoryClickEvent e){
        String title = e.getView().getTitle();

        if(title.equals(chatcolorGui.chatcolorInvName)){
            e.setCancelled(true);
            if(e.getCurrentItem() == null){
                return;
            }
            if(title.equals(chatcolorGui.chatcolorInvName)){
                chatcolorGui.click((Player) e.getWhoClicked(), e.getSlot() , e.getCurrentItem() , e.getInventory());
            }
        }
    }
}
