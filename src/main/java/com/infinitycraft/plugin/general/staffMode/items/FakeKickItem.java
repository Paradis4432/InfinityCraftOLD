package com.infinitycraft.plugin.general.staffMode.items;

import com.infinitycraft.plugin.general.tools.items.ItemCreator;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class FakeKickItem {
    public static void generate() {
        fakeKick = ItemCreator.createItem(Material.NETHERITE_AXE, 1, ChatColor.RED + "Fake Kick", "Disconnects a player.");
    }
    public static ItemStack fakeKick;
}
