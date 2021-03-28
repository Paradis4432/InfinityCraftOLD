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

public class AffixesGUI {
    /**
     * A simple GUI to select your affixes
     * @param player The player that is changing there affixes
     * @param position The position of the affixes
     */
    public static void openGUI(Player player, String position) {
        // Setup Variables
        Map<ItemStack, Integer> m = new HashMap<>();

        // Create Items
        m.put(ItemCreator.createItem(Material.NAME_TAG, 1, "Bob", "&7Click to set your " + position + " to Bob!"), 12);
        m.put(ItemCreator.createItem(Material.PAINTING, 1, "Custom", "&7Click here to set a custom " + position + "!"), 13);
        m.put(ItemCreator.createItem(Material.NAME_TAG, 1, "Jeff", "&7Click to set your " + position + " to Jeff!"), 14);

        // Create Inventory
        Inventory inv = CreateInventory.createCustomInventory(null, 3, "Edit your " + position + "!", Fillers.filler, m);

        // Open Inventory
        player.openInventory(inv);
    }
}
