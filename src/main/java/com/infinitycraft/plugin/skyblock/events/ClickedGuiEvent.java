package com.infinitycraft.plugin.skyblock.events;

import com.infinitycraft.plugin.skyblock.craftsGUIs.RawRabbitTieresMenu;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Objects;

public class ClickedGuiEvent implements Listener {

    @EventHandler
    public void InvClick(InventoryClickEvent e) {
        if (e.getView().getTitle().equals(ChatColor.GOLD + "List Of All Custom Crafts!")) {
            Player player = (Player) e.getWhoClicked();
            //Determine what they selected and what to do
            switch (Objects.requireNonNull(e.getCurrentItem()).getType()) {

                //items
                case RABBIT:
                    //player.sendMessage("testing");
                    break;
                case MUTTON:
                    player.sendMessage("testing1");
                    break;
                case PORKCHOP:
                    player.sendMessage("testing2");
                    break;
                case  BEEF:


                //close menu and default
                case BARRIER:
                    player.closeInventory();
                    break;
                default:
                    //player.sendMessage("test");
                    break;
            }
            e.setCancelled(true);

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