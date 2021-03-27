package com.infinitycraft.plugin.guis;

import com.infinitycraft.plugin.utilsManager.utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

public class tagPossGui extends JavaPlugin implements Listener {

    public static Inventory tagPossInv;
    public static String tagPossInvName;
    public static int rows = 3 * 9;

    public static void start(){
        tagPossInvName = utils.chat("Choose Your Tag Possition");

        tagPossInv = Bukkit.createInventory(null, rows);
    }

    public static Inventory inv(Player p){
        Inventory toReturn = Bukkit.createInventory(null,rows,tagPossInvName);


        //inv slot11 12 13 15
        utils.createItem(tagPossInv, "EMERALD_BLOCK" , 1 ,11, "Prefix 0" , "&7Click here to set this as your first prefix");
        utils.createItem(tagPossInv, "EMERALD_BLOCK" , 1 ,12, "Prefix 0" , "&7Click here to set this as your second prefix");
        utils.createItem(tagPossInv, "EMERALD_BLOCK" , 1 ,13, "Prefix 0" , "&7Click here to set this as your third prefix");
        utils.createItem(tagPossInv, "REDSTONE_BLOCK" , 1 ,15, "Prefix 0" , "&7Click here to set this as your first prefix");

        toReturn.setContents(tagPossInv.getContents());

        return toReturn;

    }
}
