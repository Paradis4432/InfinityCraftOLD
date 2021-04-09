package com.infinitycraft.plugin.skyblock.CraftsGUI.CraftsCommandItemArg;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static com.infinitycraft.plugin.general.tools.items.ItemCreator.createItem;

public class BoneTierGUI {

    public void ShowTiers(Player player){

        Inventory inv = Bukkit.createInventory(null,36, ChatColor.GOLD + "All Bone Tiers!");

        //create items
        Material mat = Material.BONE;

        ItemStack tier1 = createItem(mat, 1, "Tier 1"," ");
        ItemStack tier2 = createItem(mat, 1, "Tier 2"," ");
        ItemStack tier3 = createItem(mat, 1, "Tier 3"," ");
        ItemStack tier4 = createItem(mat, 1, "Tier 4"," ");
        ItemStack tier5 = createItem(mat, 1, "Tier 5"," ");
        ItemStack tier6 = createItem(mat, 1, "Tier 6"," ");
        ItemStack tier7 = createItem(mat, 1, "Tier 7"," ");
        ItemStack tier8 = createItem(mat, 1, "Tier 8"," ");
        ItemStack tier9 = createItem(mat, 1, "Tier 9"," ");
        ItemStack tier10 = createItem(mat, 1, "Tier 10"," ");
        ItemStack tier11 = createItem(mat, 1, "Tier 11"," ");
        ItemStack tier12 = createItem(mat, 1, "Tier 12"," ");

        ItemStack close = createItem(Material.BARRIER, 1, "Close", " ");
        inv.setItem(31,close);

        inv.setItem(10,tier1);
        inv.setItem(11,tier2);
        inv.setItem(12,tier3);
        inv.setItem(13,tier4);
        inv.setItem(14,tier5);
        inv.setItem(15,tier6);
        inv.setItem(16,tier7);
        inv.setItem(20,tier8);
        inv.setItem(21,tier9);
        inv.setItem(22,tier10);
        inv.setItem(23,tier11);
        inv.setItem(24,tier12);

        player.openInventory(inv);

    }
}
