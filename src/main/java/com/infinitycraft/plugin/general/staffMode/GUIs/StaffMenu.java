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
import org.bukkit.inventory.meta.SkullMeta;

import java.sql.ResultSet;
import java.util.*;

public class StaffMenu {
    public static void GenerateInventory(Player player, Integer page, boolean staffMode, String query) {
        // Make Items
        search = ItemCreator.createItem(Material.OAK_SIGN, 1, "Search Players", "Searches for all players in the server.");
        nextPage = ItemCreator.createItem(Material.ARROW, 1, "Next Page", "Show the next page of players.");
        previousPage = ItemCreator.createItem(Material.ARROW, 1, "Previous Page", "Show's the previous page of players.");
        showStaff = ItemCreator.createItem(Material.COMMAND_BLOCK, 1, "Show Staff", "Shows all active staff.");
        showPlayers = ItemCreator.createItem(Material.PLAYER_HEAD, 1, "Show Players", "Shows all active players.");
        exit = ItemCreator.createItem(Material.BARRIER, 1, ChatColor.DARK_RED + "Exit", "Exit's this menu.");
        nickName = ItemCreator.createItem(Material.NAME_TAG, 1, "Nickname", "Change's your name.");
        fly0 = ItemCreator.createItem(Material.FEATHER, 1, "Flight Off", "Toggles flight on.");
        fly1 = ItemCreator.createItem(Material.FEATHER, 1, "Flight On", "Toggles flight off.");
        // Fetch Players & Skulls
        List<Player> players = new ArrayList<>();
        List<ItemStack> skulls = new ArrayList<>();
        try {
            ResultSet rs;
            if (staffMode){
                if (query.equals("")) {
                    rs = SQLDatabase.statement.executeQuery("SELECT name FROM players WHERE online = true AND staffMode = 1 ORDER BY name LIMIT 28 OFFSET " + (page - 1) * 28 );
                }
                else {
                    rs = SQLDatabase.statement.executeQuery("SELECT name FROM players WHERE online = true AND staffMode = 1  AND name LIKE '%" + query + "%' ORDER BY name LIMIT 28 OFFSET " + (page - 1) * 28 );
                }
            }
            else {
                if (query.equals("")){
                    rs = SQLDatabase.statement.executeQuery("SELECT name FROM players WHERE online = true ORDER BY name LIMIT 28 OFFSET " + (page - 1) * 28 );
                }
                else {
                    rs = SQLDatabase.statement.executeQuery("SELECT name FROM players WHERE online = true AND name LIKE '%" + query + "%' ORDER BY name LIMIT 28 OFFSET " + (page - 1) * 28 );
                }
            }
            while (rs.next()) {
                players.add(Bukkit.getPlayer(rs.getString("name")));
            }
            for (Player i : players) {
                ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
                SkullMeta meta = (SkullMeta) skull.getItemMeta();
                meta.setOwningPlayer(i);
                meta.setDisplayName(i.getName());
                skull.setItemMeta(meta);
                skulls.add(skull);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Add Items
        Map<ItemStack, Integer> itemMap = new HashMap<>();
        itemMap.put(nextPage, 52);
        itemMap.put(search, 50);
        itemMap.put(exit, 49);
        itemMap.put(nickName, 47);
        itemMap.put(previousPage, 46);
        if (player.getAllowFlight()) {
            itemMap.put(fly1, 48);
        }
        else {
            itemMap.put(fly0, 48);
        }
        if (staffMode) {itemMap.put(showPlayers, 51);}
        else {itemMap.put(showStaff, 51);}
        // Add Skulls
        int position = 10;
        for (ItemStack i : skulls) {
            itemMap.put(i, position);
            if (position == 16 || position == 25 || position == 34) {
                position += 3;
            }
            else {
                position++;
            }
        }
        // Create Inventory
        if (staffMode) {
            if (query.equals("")){
                inv = CreateInventory.createCustomInventory(null, 6, "Staff Menu (Page " + page + ") " + "Showing Staff", Fillers.filler, itemMap);
            }
            else {
                inv = CreateInventory.createCustomInventory(null, 6, "Staff Menu (Page " + page + ") " + "Showing Staff, Searching For " + query, Fillers.filler, itemMap);
            }
        }
        else {
            if (query.equals("")) {
                inv = CreateInventory.createCustomInventory(null, 6, "Staff Menu (Page " + page + ")" , Fillers.filler, itemMap);
            }
            else {
                inv = CreateInventory.createCustomInventory(null, 6, "Staff Menu (Page " + page + ") Searching For " + query, Fillers.filler, itemMap);
            }
        }
        player.openInventory(inv);
    }
    public static ItemStack search;
    public static ItemStack nextPage;
    public static ItemStack previousPage;
    public static ItemStack showStaff;
    public static ItemStack showPlayers;
    public static ItemStack exit;
    public static ItemStack nickName;
    public static ItemStack fly0;
    public static ItemStack fly1;
    public static Inventory inv;
}
