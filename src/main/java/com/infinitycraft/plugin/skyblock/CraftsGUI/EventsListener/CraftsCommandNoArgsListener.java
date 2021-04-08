package com.infinitycraft.plugin.skyblock.CraftsGUI.EventsListener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Objects;

public class CraftsCommandNoArgsListener implements Listener {

    @EventHandler
    public void InvClick(InventoryClickEvent e) {
        if (e.getView().getTitle().equals(ChatColor.GOLD + "List Of All Custom Crafts!")) {
            Player player = (Player) e.getWhoClicked();
            //Determine what they selected and what to do
            if(e.getCurrentItem() != null){

                switch (Objects.requireNonNull(e.getCurrentItem()).getType()) {

                    //items
                    case RABBIT:
                        player.closeInventory();
                        player.performCommand("crafts rabbit");
                        break;
                    case MUTTON:
                        player.closeInventory();
                        player.performCommand("crafts mutton");
                        break;
                    case PORKCHOP:
                        player.sendMessage("testing2");
                        break;

                    //close menu and default
                    case BARRIER:
                        player.closeInventory();
                        break;
                    default:
                        //player.sendMessage("test");
                        break;
                }
            }
            e.setCancelled(true);

        }
    }
}