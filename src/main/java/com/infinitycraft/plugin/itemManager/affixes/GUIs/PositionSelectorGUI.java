package com.infinitycraft.plugin.itemManager.affixes.GUIs;

import com.infinitycraft.plugin.inventoryManager.CreateInventory;
import com.infinitycraft.plugin.itemManager.ItemCreator;
import com.infinitycraft.plugin.itemManager.templates.Fillers;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class PositionSelectorGUI {
    /**
     * A GUI to select the affixes to change
     * @param player The player who wants to change there affixes
     */
    public static void openGUI(Player player) {
        // Setup Variables
        Map<ItemStack, Integer> m = new HashMap<>();

        // Create Items
        m.put(ItemCreator.createItem(Material.NAME_TAG, 1, "Prefix", "&7Click here to edit your prefix!"), 12);
        m.put(ItemCreator.createItem(Material.NAME_TAG, 1, "Suffix", "&7Click here to edit your suffix!"), 14);

        // Create Inventory
        Inventory inv = CreateInventory.createCustomInventory(null, 3, "Choose a position!", Fillers.filler, m);

        // Open Inventory
        player.openInventory(inv);
    }
}
