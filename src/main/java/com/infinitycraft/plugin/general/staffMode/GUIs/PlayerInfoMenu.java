package com.infinitycraft.plugin.general.staffMode.GUIs;

import com.infinitycraft.plugin.general.storageManager.SQLDatabase;
import com.infinitycraft.plugin.general.tools.inventories.CreateInventory;
import com.infinitycraft.plugin.general.tools.items.ItemCreator;
import com.infinitycraft.plugin.general.tools.items.templates.Fillers;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerInfoMenu {
    public static void generate(Player player, ItemStack skull) {
        // Edit Skull
        SkullMeta meta = (SkullMeta) skull.getItemMeta();
        Player skullOwner = (Player) meta.getOwningPlayer();
        // Create Items
        exit = ItemCreator.createItem(Material.BARRIER, 1, ChatColor.DARK_RED + "Exit", "Exit's this menu.");
        viewInventory = ItemCreator.createItem(Material.CHEST, 1, "View Inventory", "View this player's inventory.");
        viewEnderChest = ItemCreator.createItem(Material.ENDER_CHEST, 1, "View Ender Chest", "View this player's ender chest");
        viewArmor = ItemCreator.createItem(Material.ARMOR_STAND, 1, "View Armor", "View this player's armor and shield slot.");
        hunger = ItemCreator.createItem(Material.COOKED_PORKCHOP, 1, "Hunger and Saturation","");
        health = ItemCreator.createItem(Material.APPLE, 1, "Health", "Health: " + skullOwner.getHealth());
        teleport = ItemCreator.createItem(Material.ENDER_PEARL, 1, "Teleport", "Teleport to this player!");
        viewUpvotes = ItemCreator.createItem(Material.EMERALD, 1, "Upvotes", "");
        database = ItemCreator.createItem(Material.OAK_SIGN, 1, "Database", "View MySQL Database for more info.");
        viewReports = ItemCreator.createItem(Material.REDSTONE, 1, "View Reports", "View this player's reports.");
        viewStats = ItemCreator.createItem(Material.OAK_SIGN, 1, "View More Info", "See extra information about this player.");
        takeAction = ItemCreator.createItem(Material.BEDROCK, 1, "Take Action", "Ban, Kick, or punish this player.");
        // Edit View Reports
        ItemMeta reportMeta = viewReports.getItemMeta();
        try (PreparedStatement getReportAmount = SQLDatabase.connection.prepareStatement("SELECT COUNT(*) FROM reports WHERE target = UNHEX(?)")) {
            String UUID = String.valueOf(skullOwner.getUniqueId()).replaceAll("-", "");
            getReportAmount.setString(1, UUID);
            ResultSet rs = getReportAmount.executeQuery();
            while (rs.next()) {
                reportMeta.setDisplayName("Total Reports: " + rs.getString(1));
            }
        }
        catch (Exception throwables) {
            throwables.printStackTrace();
        }
        viewReports.setItemMeta(reportMeta);
        // Edit View Upvotes
        ItemMeta upvoteMeta = viewUpvotes.getItemMeta();
        try (PreparedStatement getUpvoteAmount = SQLDatabase.connection.prepareStatement("SELECT COUNT(*) FROM upvotes WHERE target = UNHEX(?)")) {
            String UUID = String.valueOf(skullOwner.getUniqueId()).replaceAll("-", "");
            getUpvoteAmount.setString(1, UUID);
            ResultSet rs = getUpvoteAmount.executeQuery();
            while (rs.next()) {
                upvoteMeta.setDisplayName("Total Upvotes: " + rs.getString(1));
                List<String> loreLore = new ArrayList<>();
                loreLore.add("Total Upvotes: " +rs.getString(1));
                upvoteMeta.setLore(loreLore);
            }
        }
        catch (Exception throwables) {
            throwables.printStackTrace();
        }
        viewUpvotes.setItemMeta(upvoteMeta);
        // Add Saturation to Hunger
        ItemMeta hungerMeta = hunger.getItemMeta();
        List<String> lore = new ArrayList<>();
        lore.add("Hunger: " + skullOwner.getFoodLevel());
        lore.add("Saturation: " + skullOwner.getSaturation());
        hungerMeta.setLore(lore);
        hunger.setItemMeta(hungerMeta);
        // Add Items
        Map<ItemStack, Integer> items = new HashMap<ItemStack, Integer>();
        items.put(exit, 49);
        items.put(takeAction, 40);
        items.put(viewEnderChest, 11);
        items.put(viewInventory, 20);
        items.put(hunger, 29);
        items.put(health, 38);
        items.put(database, 15);
        items.put(viewUpvotes, 24);
        items.put(viewReports, 33);
        items.put(teleport, 42);
        items.put(skull, 4);
        items.put(viewArmor, 13);
        // Create Inventory
        inv = CreateInventory.createCustomInventory(null, 6, "Info For: " + skullOwner.getName(), Fillers.filler, items);
        player.openInventory(inv);
    }
    public static ItemStack exit;
    public static ItemStack viewInventory;
    public static ItemStack viewEnderChest;
    public static ItemStack viewArmor;
    public static ItemStack viewReports;
    public static ItemStack viewStats;
    public static ItemStack takeAction;
    public static ItemStack hunger;
    public static ItemStack health;
    public static ItemStack database;
    public static ItemStack viewUpvotes;
    public static ItemStack teleport;
    public static Inventory inv;
}
