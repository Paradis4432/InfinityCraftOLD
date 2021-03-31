package com.infinitycraft.plugin.chatManager.affixes.GUIs;

import com.infinitycraft.plugin.inventoryManager.CreateInventory;
import com.infinitycraft.plugin.itemManager.ItemCreator;
import com.infinitycraft.plugin.itemManager.templates.Fillers;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class AffixesGUI {
    /**
     * A simple GUI to select your affixes
     * @param player The player that is changing there affixes
     */
    public static void openGUI(Player player) {
        // Setup Variables
        Map<ItemStack, Integer> m = new HashMap<>();

        // Create Items
        option1 = ItemCreator.createItem(Material.NAME_TAG, 1, "EPIC", "&7Click to set your affixes to EPIC!");
        custom = ItemCreator.createItem(Material.PAINTING, 1, "Custom", "&7Click here to set a custom affixes!");
        option2 = ItemCreator.createItem(Material.BARRIER, 1, "Reset", "&7Click here to reset this affixes!");
        m.put(option1, 12);
        m.put(custom, 13);
        m.put(option2, 14);

        // Create Inventory
        inv = CreateInventory.createCustomInventory(null, 3, "Edit your affixes!", Fillers.filler, m);

        // Open Inventory
        player.openInventory(inv);
    }

    // All Items
    public static ItemStack option1;
    public static ItemStack option2;
    public static ItemStack custom;
    // Inventory
    public static Inventory inv;
}
