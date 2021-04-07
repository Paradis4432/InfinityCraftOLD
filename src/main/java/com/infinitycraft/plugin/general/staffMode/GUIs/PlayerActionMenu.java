package com.infinitycraft.plugin.general.staffMode.GUIs;

import com.infinitycraft.plugin.general.tools.inventories.CreateInventory;
import com.infinitycraft.plugin.general.tools.items.ItemCreator;
import com.infinitycraft.plugin.general.tools.items.templates.Fillers;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerActionMenu {
    public static void generate(Player player, ItemStack skull) {
        // Edit Skull
        SkullMeta meta = (SkullMeta) skull.getItemMeta();
        Player skullOwner = (Player) meta.getOwningPlayer();
        // Create Items
        exit = ItemCreator.createItem(Material.BARRIER, 1, ChatColor.DARK_RED + "Exit", "Exit's this menu.");
        fakeKick = ItemCreator.createItem(Material.OAK_DOOR, 1, "Fake Kick", "Pretends to disconnect a player");
        customKick = ItemCreator.createItem(Material.OAK_SIGN, 1, "Custom Kick", "Customize the kick message.");
        weekBan = ItemCreator.createItem(Material.IRON_DOOR, 1, "Week Ban", "Ban this player for a week.");
        customBan = ItemCreator.createItem(Material.OAK_SIGN, 1, "Custom Ban", "Customize the ban message and duration.");
        permBan = ItemCreator.createItem(Material.BEDROCK, 1, "Permanent Ban", "Permanently ban this player.");
        // Add Items
        Map<ItemStack, Integer> items = new HashMap<ItemStack, Integer>();
        items.put(exit, 49);
        items.put(permBan, 40);
        items.put(fakeKick, 20);
        items.put(customKick, 29);
        items.put(weekBan, 24);
        items.put(customBan, 33);
        items.put(skull, 4);
        // Create Inventory
        inv = CreateInventory.createCustomInventory(null, 6, "Taking Action On: " + skullOwner.getName(), Fillers.filler, items);
        player.openInventory(inv);
    }
    public static ItemStack exit;
    public static ItemStack fakeKick;
    public static ItemStack customKick;
    public static ItemStack weekBan;
    public static ItemStack customBan;
    public static ItemStack permBan;
    public static Inventory inv;
}
