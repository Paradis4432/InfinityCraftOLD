package com.infinitycraft.plugin.skyblock.craftingSystem.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CreateCraftEvents implements Listener {

    @EventHandler
    public void InvClick(InventoryCloseEvent e) {
        Bukkit.getLogger().info("test");
        if (e.getView().getTitle().equals("Create the custom craft")) {
                ItemStack item = e.getInventory().getItem(0);
                sendMessage(item);
            }

            //e.setCancelled(true);

        }
    public void sendMessage(ItemStack item){
        Bukkit.getLogger().info(String.valueOf(item));
    }

}

/**
 * String meta = e.getCurrentItem().getItemMeta().getDisplayName();
 *                 List<String> lore = e.getCurrentItem().getItemMeta().getLore();
 *
 *                 player.sendMessage(meta);
 *                 player.sendMessage(String.valueOf(lore));
 */
