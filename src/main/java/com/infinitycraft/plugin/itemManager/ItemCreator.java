package com.infinitycraft.plugin.itemManager;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemCreator {
    /**
     * Creates a custom item!
     * @param material The material of the item
     * @param amount The amount of items that should be made
     * @param displayName The display name of the item
     * @param lore The lore of the item
     * @return The item you just made
     */
    public static ItemStack createItem(Material material, int amount, String displayName, String... lore) {
        // Create ItemStack
        ItemStack item = new ItemStack(material, amount);
        // Setup MetaData
        ItemMeta meta = item.getItemMeta();
        List<String> loreList = new ArrayList<>();
        // Add Lore
        for (String loreString : lore) {
            loreList.add(ChatColor.translateAlternateColorCodes('&', loreString));
        }
        // Set Display Name
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', displayName));
        // Combine Data
        meta.setLore(loreList);
        item.setItemMeta(meta);
        // Return finalized item
        return item;
    }
}
