package com.infinitycraft.plugin.skyblock.CraftsGUI.CraftsCommandItemArg;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class RawRabbitTierGUI {

    //open a gui with all 12 tiers of the rabbit
    //add a listener that checks what tier the player presses
    //open RabbitTier[num] using player.performCommand("");

    public void ShowTiers(Player player){

        Inventory inv = Bukkit.createInventory(null,36, ChatColor.GOLD + "All Rabbits Tiers!");

        //create items
        ItemStack tier1 = new ItemStack(Material.RABBIT);
        ItemMeta tier1meta = tier1.getItemMeta();
        tier1meta.setDisplayName(ChatColor.GOLD + "Tier 1");
        tier1.setItemMeta(tier1meta);

        ItemStack tier2 = new ItemStack(Material.RABBIT);
        ItemMeta tier2meta = tier2.getItemMeta();
        tier2meta.setDisplayName(ChatColor.GOLD + "Tier 2");
        tier2.setItemMeta(tier2meta);

        ItemStack tier3 = new ItemStack(Material.RABBIT);
        ItemMeta tier3meta = tier3.getItemMeta();
        tier3meta.setDisplayName(ChatColor.GOLD + "Tier 3");
        tier3.setItemMeta(tier3meta);

        ItemStack tier4 = new ItemStack(Material.RABBIT);
        ItemMeta tier4meta = tier4.getItemMeta();
        tier4meta.setDisplayName(ChatColor.GOLD + "Tier 4");
        tier4.setItemMeta(tier4meta);

        ItemStack tier5 = new ItemStack(Material.RABBIT);
        ItemMeta tier5meta = tier5.getItemMeta();
        tier5meta.setDisplayName(ChatColor.GOLD + "Tier 5");
        tier5.setItemMeta(tier5meta);

        ItemStack tier6 = new ItemStack(Material.RABBIT);
        ItemMeta tier6meta = tier6.getItemMeta();
        tier6meta.setDisplayName(ChatColor.GOLD + "Tier 6");
        tier6.setItemMeta(tier6meta);

        ItemStack tier7 = new ItemStack(Material.RABBIT);
        ItemMeta tier7meta = tier7.getItemMeta();
        tier7meta.setDisplayName(ChatColor.GOLD + "Tier 7");
        tier7.setItemMeta(tier7meta);

        ItemStack tier8 = new ItemStack(Material.RABBIT);
        ItemMeta tier8meta = tier8.getItemMeta();
        tier8meta.setDisplayName(ChatColor.GOLD + "Tier 8");
        tier8.setItemMeta(tier8meta);

        ItemStack tier9 = new ItemStack(Material.RABBIT);
        ItemMeta tier9meta = tier9.getItemMeta();
        tier9meta.setDisplayName(ChatColor.GOLD + "Tier 9");
        tier9.setItemMeta(tier9meta);

        ItemStack tier10 = new ItemStack(Material.RABBIT);
        ItemMeta tier10meta = tier10.getItemMeta();
        tier10meta.setDisplayName(ChatColor.GOLD + "Tier 10");
        tier10.setItemMeta(tier10meta);

        ItemStack tier11 = new ItemStack(Material.RABBIT);
        ItemMeta tier11meta = tier11.getItemMeta();
        tier11meta.setDisplayName(ChatColor.GOLD + "Tier 11");
        tier11.setItemMeta(tier11meta);

        ItemStack tier12 = new ItemStack(Material.RABBIT);
        ItemMeta tier12meta = tier12.getItemMeta();
        tier12meta.setDisplayName(ChatColor.GOLD + "Tier 12");
        tier12.setItemMeta(tier12meta);

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
