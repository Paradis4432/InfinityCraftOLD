package com.infinitycraft.plugin.general.chat.affixes.GUIs;

import com.infinitycraft.plugin.general.tools.inventories.CreateInventory;
import com.infinitycraft.plugin.general.tools.items.ItemCreator;
import com.infinitycraft.plugin.general.tools.items.templates.Fillers;
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
        prefix = ItemCreator.createItem(Material.NAME_TAG, 1, "Prefix", "&7Click here to edit your prefix!");
        suffix = ItemCreator.createItem(Material.NAME_TAG, 1, "Suffix", "&7Click here to edit your suffix!");
        m.put(prefix, 12);
        m.put(suffix, 14);

        // Create Inventory
        inv = CreateInventory.createCustomInventory(null, 3, "Choose a position!", Fillers.filler, m);

        // Open Inventory
        player.openInventory(inv);
    }

    // All Items
    public static ItemStack prefix;
    public static ItemStack suffix;
    // Inventory
    public static Inventory inv;
}
