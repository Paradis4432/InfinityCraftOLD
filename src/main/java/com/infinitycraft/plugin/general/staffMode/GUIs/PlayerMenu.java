package com.infinitycraft.plugin.general.staffMode.GUIs;

import com.infinitycraft.plugin.general.tools.inventories.CreateInventory;
import com.infinitycraft.plugin.general.tools.items.ItemCreator;
import com.infinitycraft.plugin.general.tools.items.templates.Fillers;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerMenu {
    public static void generate(Player player, ItemStack skull) {
        // Create Items
        exit = ItemCreator.createItem(Material.BARRIER, 1, ChatColor.DARK_RED + "Exit", "Exit's this menu.");
        viewInventory = ItemCreator.createItem(Material.CHEST, 1, "View Inventory", "View this player's inventory.");
        viewEnderChest = ItemCreator.createItem(Material.ENDER_CHEST, 1, "View Ender Chest", "View this player's ender chest");
        viewArmor = ItemCreator.createItem(Material.ARMOR_STAND, 1, "View Armor", "View this player's armor and shield slot.");
        viewReports = ItemCreator.createItem(Material.REDSTONE, 1, "View Reports", "View this player's reports.");
        viewStats = ItemCreator.createItem(Material.OAK_SIGN, 1, "View More Info", "See extra information about this player.");
        takeAction = ItemCreator.createItem(Material.BEDROCK, 1, "Take Action", "Ban, Kick, or punish this player.");
        // Edit Skull
        SkullMeta meta = (SkullMeta) skull.getItemMeta();
        List<String> lore = new ArrayList<String>();
        Player skullOwner = (Player) meta.getOwningPlayer();
        lore.add("Position: " + skullOwner.getLocation().getBlockX() + ", " + skullOwner.getLocation().getBlockY()+ ", " + skullOwner.getLocation().getBlockZ());
        lore.add("World: " + skullOwner.getWorld().getName());
        lore.add("Health: " + skullOwner.getHealth());
        lore.add("Hunger: " + skullOwner.getFoodLevel());
        lore.add("Saturation: " + skullOwner.getSaturation());
        meta.setLore(lore);
        skull.setItemMeta(meta);
        // Add Items
        Map<ItemStack, Integer> items = new HashMap<ItemStack, Integer>();
        items.put(exit, 49);
        items.put(viewInventory, 29);
        items.put(viewEnderChest, 20);
        items.put(viewArmor, 13);
        items.put(viewReports, 24);
        items.put(viewStats, 33);
        items.put(takeAction, 40);
        items.put(skull, 4);
        // Create Inventory
        inv = CreateInventory.createCustomInventory(null, 6, "Viewing Player: " + skullOwner.getName(), Fillers.filler, items);
        player.openInventory(inv);
    }
    public static ItemStack exit;
    public static ItemStack viewInventory;
    public static ItemStack viewEnderChest;
    public static ItemStack viewArmor;
    public static ItemStack viewReports;
    public static ItemStack viewStats;
    public static ItemStack takeAction;
    public static Inventory inv;
}
