package com.infinitycraft.plugin.utilsManager;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deprecation")
public class utils {

    public static String chat(String s){
        return ChatColor.translateAlternateColorCodes('&',s);
    }

    public static ItemStack createItem(Inventory inv, String materialId, int amount, int invSlot, String displayName, String... loreString){

        ItemStack item;

        List<String> lore = new ArrayList();
        item = new ItemStack(Material.getMaterial(materialId) , amount);
        //item = new ItemStack(Material.EMERALD_BLOCK)

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(utils.chat(displayName));

        for (String s : loreString){
            lore.add(utils.chat(s));
        }
        meta.setLore(lore);
        item.setItemMeta(meta);

        inv.setItem(invSlot,item);
        return item;
    }

}
