package com.infinitycraft.plugin.general.staffMode.GUIs;

import com.infinitycraft.plugin.general.tools.inventories.CreateInventory;
import com.infinitycraft.plugin.general.tools.items.ItemCreator;
import com.infinitycraft.plugin.general.tools.items.templates.Fillers;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StaffPlayerMenu {
    public static void generate(Player player, ItemStack skull) {
        // Create Items
        exit = ItemCreator.createItem(Material.BARRIER, 1, ChatColor.DARK_RED + "Exit", "Exit's this menu.");
        teleport = ItemCreator.createItem(Material.ENDER_PEARL, 1, "Teleport To", "Teleport to this staff member.");
        // Edit Skull
        SkullMeta meta = (SkullMeta) skull.getItemMeta();
        List<String> lore = new ArrayList<String>();
        Player skullOwner = (Player) meta.getOwningPlayer();
        lore.add("Position: " + skullOwner.getLocation().getBlockX() + ", " + skullOwner.getLocation().getBlockY()+ ", " + skullOwner.getLocation().getBlockZ());
        lore.add("World: " + skullOwner.getWorld().getName());
        lore.add("Health: " + skullOwner.getHealth());
        lore.add("Hunger: " + skullOwner.getFoodLevel());
        lore.add("Saturation: " + skullOwner.getSaturation());
        meta.setLore(lore);
        skull.setItemMeta(meta);
        // Add Items
        Map<ItemStack, Integer> items = new HashMap<ItemStack, Integer>();
        items.put(exit, 49);
        items.put(teleport, 31);
        items.put(skull, 4);
        // Create Inventory
        inv = CreateInventory.createCustomInventory(null, 6, "Viewing Staff: " + skullOwner.getName(), Fillers.filler, items);
        player.openInventory(inv);
    }
    public static ItemStack exit;
    public static ItemStack teleport;
    public static Inventory inv;
}
