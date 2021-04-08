package com.infinitycraft.plugin.skyblock.craftsGUIs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CraftsGUI1 implements CommandExecutor {

    //first page of the custom crafts

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        if(sender instanceof Player){
            Player player = (Player) sender;
            //create inv
            Inventory inv = Bukkit.createInventory(null,54,"Test GUI");

            //create items
            ItemStack nothing = new ItemStack(Material.GRAY_STAINED_GLASS);
            ItemMeta nothingMeta = nothing.getItemMeta();
            nothingMeta.setDisplayName(ChatColor.GOLD + "Infinity Craft");
            nothing.setItemMeta(nothingMeta);

            ItemStack item0 = new ItemStack(Material.STONE);
            ItemMeta item0meta = item0.getItemMeta();
            item0meta.setDisplayName("test");
            item0.setItemMeta(item0meta);

            //set the items in the GUI
            inv.setItem(45,nothing);
            inv.setItem(47,nothing);
            inv.setItem(49,nothing);
            inv.setItem(51,nothing);
            inv.setItem(53,nothing);

            inv.setItem(0,item0);

            player.openInventory(inv);
        }
        return true;
    }
}
