package com.infinitycraft.plugin.skyblock.CraftingSystem.CustomGUIs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CraftGUI {

    // show crafts gui

    public void ShowGUI(Player player){
        //Inventory inv = Bukkit.createInventory(null,45, ChatColor.GOLD + "List Of All Custom Crafts!");
        Inventory inv = Bukkit.createInventory(null,45, ChatColor.GOLD + "List Of All Custom Crafts!");
        //player.sendMessage("Opening Crafts GUI");

        //create items
        //ItemStack nothing = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        //ItemMeta nothingMeta = nothing.getItemMeta();
        //nothingMeta.setDisplayName(ChatColor.GOLD + "Infinity Craft");
        //nothing.setItemMeta(nothingMeta);

        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.RED + "Close");
        close.setItemMeta(closeMeta);

        ItemStack item0 = new ItemStack(Material.RABBIT);
        //ItemMeta item0meta = item0.getItemMeta();
        //item0meta.setDisplayName(ChatColor.RED + "");
        //item0.setItemMeta(item0meta);

        ItemStack item1 = new ItemStack(Material.MUTTON);
        //ItemMeta item0meta = item0.getItemMeta();
        //item0meta.setDisplayName(ChatColor.RED + "");
        //item0.setItemMeta(item0meta);

        ItemStack item2 = new ItemStack(Material.PORKCHOP);
        //ItemMeta item0meta = item0.getItemMeta();
        //item0meta.setDisplayName(ChatColor.RED + "");
        //item0.setItemMeta(item0meta);

        ItemStack item3 = new ItemStack(Material.BEEF);
        //ItemMeta item0meta = item0.getItemMeta();
        //item0meta.setDisplayName(ChatColor.RED + "");
        //item0.setItemMeta(item0meta);

        ItemStack item4 = new ItemStack(Material.SPIDER_EYE);
        //ItemMeta item0meta = item0.getItemMeta();
        //item0meta.setDisplayName(ChatColor.RED + "");
        //item0.setItemMeta(item0meta);

        ItemStack item5 = new ItemStack(Material.STRING);
        //ItemMeta item0meta = item0.getItemMeta();
        //item0meta.setDisplayName(ChatColor.RED + "");
        //item0.setItemMeta(item0meta);

        ItemStack item6 = new ItemStack(Material.COAL);
        //ItemMeta item0meta = item0.getItemMeta();
        //item0meta.setDisplayName(ChatColor.RED + "");
        //item0.setItemMeta(item0meta);

        ItemStack item7 = new ItemStack(Material.STICK);
        //ItemMeta item0meta = item0.getItemMeta();
        //item0meta.setDisplayName(ChatColor.RED + "");
        //item0.setItemMeta(item0meta);

        ItemStack item8 = new ItemStack(Material.BONE);
        //ItemMeta item0meta = item0.getItemMeta();
        //item0meta.setDisplayName(ChatColor.RED + "");
        //item0.setItemMeta(item0meta);

        ItemStack item9 = new ItemStack(Material.SLIME_BALL);
        //ItemMeta item0meta = item0.getItemMeta();
        //item0meta.setDisplayName(ChatColor.RED + "");
        //item0.setItemMeta(item0meta);

        ItemStack item10 = new ItemStack(Material.GOLD_INGOT);
        //ItemMeta item0meta = item0.getItemMeta();
        //item0meta.setDisplayName(ChatColor.RED + "");
        //item0.setItemMeta(item0meta);

        ItemStack item11 = new ItemStack(Material.REDSTONE);
        //ItemMeta item0meta = item0.getItemMeta();
        //item0meta.setDisplayName(ChatColor.RED + "");
        //item0.setItemMeta(item0meta);

        ItemStack item12 = new ItemStack(Material.GUNPOWDER);
        //ItemMeta item0meta = item0.getItemMeta();
        //item0meta.setDisplayName(ChatColor.RED + "");
        //item0.setItemMeta(item0meta);

        ItemStack item13 = new ItemStack(Material.BLAZE_ROD);
        //ItemMeta item0meta = item0.getItemMeta();
        //item0meta.setDisplayName(ChatColor.RED + "");
        //item0.setItemMeta(item0meta);

        ItemStack item14 = new ItemStack(Material.EMERALD);
        //ItemMeta item0meta = item0.getItemMeta();
        //item0meta.setDisplayName(ChatColor.RED + "");
        //item0.setItemMeta(item0meta);

        ItemStack item15 = new ItemStack(Material.IRON_INGOT);
        //ItemMeta item0meta = item0.getItemMeta();
        //item0meta.setDisplayName(ChatColor.RED + "");
        //item0.setItemMeta(item0meta);

        ItemStack item16 = new ItemStack(Material.ENDER_PEARL);
        //ItemMeta item0meta = item0.getItemMeta();
        //item0meta.setDisplayName(ChatColor.RED + "");
        //item0.setItemMeta(item0meta);

        ItemStack item17 = new ItemStack(Material.DIAMOND);
        //ItemMeta item0meta = item0.getItemMeta();
        //item0meta.setDisplayName(ChatColor.RED + "");
        //item0.setItemMeta(item0meta);

        //set the items in the GUI
        inv.setItem(31,close);

        /**
        inv.setItem(0,nothing);
        inv.setItem(1,nothing);
        inv.setItem(2,nothing);
        inv.setItem(3,nothing);
        inv.setItem(4,nothing);
        inv.setItem(5,nothing);
        inv.setItem(6,nothing);
        inv.setItem(7,nothing);
        inv.setItem(8,nothing);
        inv.setItem(9,nothing);
        inv.setItem(17,nothing);
        inv.setItem(18,nothing);
        inv.setItem(26,nothing);
        inv.setItem(27,nothing);
        inv.setItem(28,nothing);
        inv.setItem(34,nothing);
        inv.setItem(35,nothing);
        inv.setItem(36,nothing);
        inv.setItem(37,nothing);
        inv.setItem(38,nothing);
        inv.setItem(39,nothing);
        inv.setItem(40,nothing);
        inv.setItem(41,nothing);
        inv.setItem(42,nothing);
        inv.setItem(43,nothing);
        inv.setItem(44,nothing);
         */

        inv.setItem(10,item0);
        inv.setItem(11,item1);
        inv.setItem(12,item2);
        inv.setItem(13,item3);
        inv.setItem(14,item4);
        inv.setItem(15,item5);
        inv.setItem(16,item6);
        inv.setItem(19,item7);
        inv.setItem(20,item8);
        inv.setItem(21,item9);
        inv.setItem(22,item10);
        inv.setItem(23,item11);
        inv.setItem(24,item12);
        inv.setItem(25,item13);
        inv.setItem(29,item14);
        inv.setItem(30,item15);
        inv.setItem(32,item16);
        inv.setItem(33,item17);


        player.openInventory(inv);
    }

}
