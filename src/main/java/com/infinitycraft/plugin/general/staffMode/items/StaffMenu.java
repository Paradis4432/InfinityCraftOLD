package com.infinitycraft.plugin.general.staffMode.items;

import com.infinitycraft.plugin.general.tools.items.ItemCreator;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class StaffMenu {
    public static void generate() {
        staffMenu = ItemCreator.createItem(Material.PLAYER_HEAD, 1, ChatColor.GOLD + "Main Menu", "Opens the staff menu!");
    }
    public static ItemStack staffMenu;
}
