package com.infinitycraft.plugin.chatManager.chatColor.GUIs;

import com.infinitycraft.plugin.inventoryManager.CreateInventory;
import com.infinitycraft.plugin.itemManager.ItemCreator;
import com.infinitycraft.plugin.itemManager.templates.Fillers;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class ChatColorChanger {
    /**
     * A simple GUI to change a players chat color!
     * @param player The player who wants to change there chat color.
     */
    public static void openGUI(Player player) {
        // Setup Variables
        Map<ItemStack, Integer> m = new HashMap<>();

        // Create Items
        m.put(ItemCreator.createItem(Material.BLACK_WOOL, 1, "&0Black", "&7Click to use black!"), 12);
        m.put(ItemCreator.createItem(Material.BLUE_WOOL, 1, "&1Dark Blue", "&7Click to use dark blue!"), 13);
        m.put(ItemCreator.createItem(Material.GREEN_WOOL, 1, "&2Dark Green", "&7Click to use dark green!"), 14);
        m.put(ItemCreator.createItem(Material.CYAN_WOOL, 1, "&3Cyan", "&7Click to use cyan!"), 21);
        m.put(ItemCreator.createItem(Material.RED_WOOL, 1, "&4Red", "&7Click to use red!"), 22);
        m.put(ItemCreator.createItem(Material.PURPLE_WOOL, 1,"&5Purple", "&7Click to use purple!"), 23);
        m.put(ItemCreator.createItem(Material.GRAY_WOOL, 1, "&8Gray", "&7Click to use gray!"), 30);
        m.put(ItemCreator.createItem(Material.LIGHT_GRAY_WOOL, 1, "&7Light Gray", "&7Click to use light gray!"), 31);
        m.put(ItemCreator.createItem(Material.LIGHT_BLUE_WOOL, 1, "&9Blue", "&7Click to use blue!"), 32);
        m.put(ItemCreator.createItem(Material.LIME_WOOL, 1, "&aLight Green", "&7Click to use light green!"), 39);
        m.put(ItemCreator.createItem(Material.MAGENTA_WOOL, 1, "&dLight Purple", "&7Click to use light purple!"), 40);
        m.put(ItemCreator.createItem(Material.YELLOW_WOOL, 1, "&eYellow", "&7Click to use yellow!"), 41);

        // Create Inventory
        Inventory inv = CreateInventory.createCustomInventory(null, 6, "Pick a chat color!", Fillers.filler, m);

        // Open Inventory
        player.openInventory(inv);
    }
}
