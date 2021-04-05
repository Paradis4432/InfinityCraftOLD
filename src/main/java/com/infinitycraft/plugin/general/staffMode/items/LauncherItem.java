package com.infinitycraft.plugin.general.staffMode.items;

import com.infinitycraft.plugin.general.tools.items.ItemCreator;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class LauncherItem {
    public static void generate() {
        launcher = ItemCreator.createItem(Material.BLAZE_ROD, 1, ChatColor.YELLOW + "Launcher", "Launches you in the direction you are facing!");
        launcher.addUnsafeEnchantment(Enchantment.KNOCKBACK, 20);
    }
    public static ItemStack launcher;
}
