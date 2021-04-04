package com.infinitycraft.plugin.general.staffMode.items;

import com.infinitycraft.plugin.general.tools.items.ItemCreator;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class RandomTeleport {
    public static void generate() {
        randomTeleport = ItemCreator.createItem(Material.ENDER_EYE, 1, ChatColor.DARK_PURPLE + "Teleport to Random Player", "Teleports to a random player!");
    }
    public static ItemStack randomTeleport;
}
