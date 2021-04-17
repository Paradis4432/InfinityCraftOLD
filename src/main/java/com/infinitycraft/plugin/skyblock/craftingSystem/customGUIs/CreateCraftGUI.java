package com.infinitycraft.plugin.skyblock.craftingSystem.customGUIs;

import com.infinitycraft.plugin.general.tools.inventories.CreateInventory;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nullable;
import java.util.Map;

public class CreateCraftGUI {

    public void OpenGUI(Player player){
        Inventory inv = Bukkit.createInventory(null, 27, "Create the custom craft");

        ItemStack pane = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta paneMeta = pane.getItemMeta();
        paneMeta.setDisplayName("test");
        pane.setItemMeta(paneMeta);

        inv.setItem(3, pane);
        inv.setItem(12, pane);
        inv.setItem(21, pane);

        player.openInventory(inv);

    }
}


//ItemStack nothing = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
//ItemMeta nothingMeta = nothing.getItemMeta();
//nothingMeta.setDisplayName(ChatColor.GOLD + "Infinity Craft");
//nothing.setItemMeta(nothingMeta);