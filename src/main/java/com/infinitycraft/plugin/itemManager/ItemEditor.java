package com.infinitycraft.plugin.itemManager;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class ItemEditor {
    /**
     * Edit an existing item!
     * @param item The original item!
     * @param amount The new amount
     * @param material The new material (optional)
     * @param displayName The new display name (optional)
     * @param lore The new lore (optional)
     * @return The new item
     */
    public static ItemStack editItem(ItemStack item, int amount, @Nullable Material material, @Nullable String displayName, @Nullable String... lore) {
        // Setup MetaData
        ItemMeta meta = item.getItemMeta();
        List<String> loreList = new ArrayList<>();
        // Make changes if not null
        if (material != null) { item.setType(material); }
        if (displayName != null) { meta.setDisplayName(displayName); }
        if (lore != null) {
            for (String loreString : lore) {
                loreList.add(ChatColor.translateAlternateColorCodes('&', loreString));
            }
        }
        // Combine Data
        meta.setLore(loreList);
        item.setItemMeta(meta);
        // Return finalized item
        return item;
    }
}
