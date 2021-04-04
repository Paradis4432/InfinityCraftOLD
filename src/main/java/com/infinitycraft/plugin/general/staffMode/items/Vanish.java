package com.infinitycraft.plugin.general.staffMode.items;

import com.infinitycraft.plugin.general.tools.items.ItemCreator;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Vanish {
    public static void generate() {
        vanish0 = ItemCreator.createItem(Material.GRAY_DYE, 1, ChatColor.DARK_RED + "Vanish Off", "Toggles Vanish!");
        vanish1 = ItemCreator.createItem(Material.LIME_DYE, 1, ChatColor.DARK_GREEN + "Vanish On", "Toggles Vanish!");
    }
    public static ItemStack vanish0;
    public static ItemStack vanish1;
}
