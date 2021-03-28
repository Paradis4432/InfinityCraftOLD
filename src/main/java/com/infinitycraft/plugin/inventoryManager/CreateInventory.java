package com.infinitycraft.plugin.inventoryManager;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;
import java.util.Map;

public class CreateInventory {
    /**
     * A tool to make a new custom Inventory
     * @param owner The owner of the inventory
     * @param rows How many rows (of 9) the inventory should have
     * @param name The name of the inventory
     * @param filler The filler of the inventory
     * @param Items The items to place (item, position)
     * @return The final inventory
     */
    public static Inventory createCustomInventory(@Nullable Player owner, Integer rows, String name, ItemStack filler, Map<ItemStack, Integer> Items) {
        // Create Inventory
        Inventory inv = Bukkit.createInventory(owner, rows * 9 , Component.text(name));
        // Add Filler
        int slots = (rows * 9) - 1;
        int currentSlot = 0;
        while (currentSlot <= slots) {
            inv.setItem(currentSlot, filler);
            currentSlot++;
        }
        // Add Items
        for (Map.Entry<ItemStack,Integer> entry : Items.entrySet()) {
            inv.setItem(entry.getValue(), entry.getKey());
        }
        // Return Inventory
        return inv;
    }
}
