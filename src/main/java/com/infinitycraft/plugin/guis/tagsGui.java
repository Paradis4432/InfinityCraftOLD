package com.infinitycraft.plugin.guis;

import com.infinitycraft.plugin.utilsManager.utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("deprecation")
public class tagsGui extends JavaPlugin implements Listener {

    public static Inventory tagsInv;
    public static String tagsInvName;
    public static int rows = 6 * 9;

    public static void start(){
        tagsInvName = utils.chat("Choose Your Tag");

        tagsInv = Bukkit.createInventory(null, rows);
    }

    public static Inventory gui (Player p){
        Inventory toReturn = Bukkit.createInventory(null, rows,tagsInvName);

        //add tags
        utils.createItem(tagsInv, "NAME_TAG", 1, 0, "Fuck Covid", "&7right click to use this tag");


        toReturn.setContents(tagsInv.getContents());

        return toReturn;
    }

    public static void click(Player p, int slot, ItemStack click, Inventory inv){
        if(click.getItemMeta().getDisplayName().equalsIgnoreCase(utils.chat("TAG NAME HERE"))){
            //set the players tag using sql
            //send message
        }
    }
}
