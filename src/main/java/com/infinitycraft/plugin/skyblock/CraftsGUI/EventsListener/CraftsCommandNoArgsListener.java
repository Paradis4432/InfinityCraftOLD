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
                        player.closeInventory();
                        player.performCommand("crafts porkchop");
                        break;
                    case BEEF:
                        player.closeInventory();
                        player.performCommand("crafts beef");
                        break;
                    case SPIDER_EYE:
                        player.closeInventory();
                        player.performCommand("crafts spider");
                        break;
                    case STRING:
                        player.closeInventory();
                        player.performCommand("crafts string");
                        break;
                    case COAL:
                        player.closeInventory();
                        player.performCommand("crafts coal");
                        break;
                    case STICK:
                        player.closeInventory();
                        player.performCommand("crafts stick");
                        break;
                    case BONE:
                        player.closeInventory();
                        player.performCommand("crafts bone");
                        break;
                    case SLIME_BALL:
                        player.closeInventory();
                        player.performCommand("crafts slimeball");
                        break;
                    case GOLD_INGOT:
                        player.closeInventory();
                        player.performCommand("crafts gold");
                        break;
                    case REDSTONE:
                        player.closeInventory();
                        player.performCommand("crafts redstone");
                        break;
                    case GUNPOWDER:
                        player.closeInventory();
                        player.performCommand("crafts gunpowder");
                        break;
                    case BLAZE_ROD:
                        player.closeInventory();
                        player.performCommand("crafts blaze");
                        break;
                    case EMERALD:
                        player.closeInventory();
                        player.performCommand("crafts emerald");
                        break;
                    case IRON_INGOT:
                        player.closeInventory();
                        player.performCommand("crafts iron");
                        break;
                    case ENDER_PEARL:
                        player.closeInventory();
                        player.performCommand("crafts ender");
                        break;
                    case DIAMOND:
                        player.closeInventory();
                        player.performCommand("crafts diamond");
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