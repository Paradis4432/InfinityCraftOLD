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
     *
     * @param player The player who wants to change there chat color.
     */
    public static void openGUI(Player player) {
        // Setup Variables
        Map<ItemStack, Integer> m = new HashMap<>();

        // Create Items
        darkRed = ItemCreator.createItem(Material.RED_WOOL, 1, "&4Dark Red", "&7Click to use dark red!");
        red = ItemCreator.createItem(Material.RED_DYE, 1, "&cRed", "&7Click to use red!");
        gold = ItemCreator.createItem(Material.GOLD_BLOCK, 1, "&6Gold", "&7Click to use gold!");
        yellow = ItemCreator.createItem(Material.YELLOW_WOOL, 1, "&eYellow", "&7Click to use yellow!");
        darkGreen = ItemCreator.createItem(Material.GREEN_WOOL, 1, "&2Dark Green", "&7Click to use dark green!");
        green = ItemCreator.createItem(Material.LIME_WOOL, 1, "&aGreen", "&7Click to use green!");
        aqua = ItemCreator.createItem(Material.PRISMARINE_SHARD, 1, "&bAqua", "&7Click to use aqua!");
        darkAqua = ItemCreator.createItem(Material.PRISMARINE, 1, "&3Dark Aqua", "&7Click to use dark aqua!");
        darkBlue = ItemCreator.createItem(Material.BLUE_WOOL, 1, "&1Dark Blue", "&7Click to use dark blue!");
        blue = ItemCreator.createItem(Material.LIGHT_BLUE_WOOL, 1, "&9Blue", "&7Click to use blue!");
        lightPurple = ItemCreator.createItem(Material.MAGENTA_WOOL, 1, "&dLight Purple", "&7Click to use light purple!");
        darkPurple = ItemCreator.createItem(Material.PURPLE_WOOL, 1, "&5Dark Purple", "&7Click to use dark purple!");
        white = ItemCreator.createItem(Material.WHITE_WOOL, 1, "&fWhite", "&7Click to use white");
        gray = ItemCreator.createItem(Material.LIGHT_GRAY_WOOL, 1, "&7Gray", "&7Click to use gray!");
        darkGray = ItemCreator.createItem(Material.GRAY_WOOL, 1, "&8Dark Gray", "&7Click to use dark gray!");
        black = ItemCreator.createItem(Material.BLACK_WOOL, 1, "&0Black", "&7Click to use black!");
        m.put(darkRed, 12);
        m.put(red, 13);
        m.put(gold, 14);
        m.put(yellow, 20);
        m.put(darkGreen, 21);
        m.put(green, 22);
        m.put(aqua, 23);
        m.put(darkAqua, 24);
        m.put(darkBlue, 29);
        m.put(blue, 30);
        m.put(lightPurple, 31);
        m.put(darkPurple, 32);
        m.put(white, 33);
        m.put(gray, 39);
        m.put(darkGray, 40);
        m.put(black, 41);
        // Create Inventory
        inv = CreateInventory.createCustomInventory(null, 6, "Pick a chat color!", Fillers.filler, m);

        // Open Inventory
        player.openInventory(inv);
    }

    // All Items
    public static ItemStack darkRed;
    public static ItemStack red;
    public static ItemStack gold;
    public static ItemStack yellow;
    public static ItemStack darkGreen;
    public static ItemStack green;
    public static ItemStack aqua;
    public static ItemStack darkAqua;
    public static ItemStack darkBlue;
    public static ItemStack blue;
    public static ItemStack lightPurple;
    public static ItemStack darkPurple;
    public static ItemStack white;
    public static ItemStack gray;
    public static ItemStack darkGray;
    public static ItemStack black;
    // Inventory
    public static Inventory inv;

}
