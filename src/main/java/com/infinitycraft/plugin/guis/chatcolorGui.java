package com.infinitycraft.plugin.guis;

import com.infinitycraft.plugin.utilsManager.utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class chatcolorGui extends JavaPlugin implements Listener {

    public static Inventory chatcolorInv;
    public static String chatcolorInvName;
    public static int rows = 6 * 9;

    public static void start(){
        chatcolorInvName = utils.chat("Choose Your Chat Color");

        chatcolorInv = Bukkit.createInventory(null, rows);
    }

    public static Inventory gui (Player p){
        Inventory toReturn = Bukkit.createInventory(null, rows, chatcolorInvName);

        utils.createItem(chatcolorInv, "BLACK_STAINED_GLASS_PANE", 1, 0, "&0Black", "&7right click to use this color");
        utils.createItem(chatcolorInv, "BLUE_STAINED_GLASS_PANE", 1, 1, "&1Dark Blue", "&7right click to use this color");
        utils.createItem(chatcolorInv, "GREEN_STAINED_GLASS_PANE", 1, 2, "&2Dark Green", "&7right click to use this color");
        utils.createItem(chatcolorInv, "CYAN_STAINED_GLASS_PANE", 1, 3, "&3Cyan", "&7right click to use this color");
        utils.createItem(chatcolorInv, "RED_STAINED_GLASS_PANE", 1, 4, "&4Red", "&7right click to use this color");
        utils.createItem(chatcolorInv, "PURPLE_STAINED_GLASS_PANE", 1, 5, "&5Purple", "&7right click to use this color");
        utils.createItem(chatcolorInv, "GRAY_STAINED_GLASS_PANE", 1, 6, "&8Gray", "&7right click to use this color");
        utils.createItem(chatcolorInv, "LIGHT_GRAY_STAINED_GLASS_PANE", 1, 7, "&7Light Gray", "&7right click to use this color");
        utils.createItem(chatcolorInv, "LIGHT_BLUE_STAINED_GLASS_PANE", 1, 8, "&9Blue", "&7right click to use this color");
        utils.createItem(chatcolorInv, "LIME_STAINED_GLASS_PANE", 1, 9, "&aLight Green", "&7right click to use this color");
        utils.createItem(chatcolorInv, "MAGENTA_STAINED_GLASS_PANE", 1, 10, "&dLight Purple", "&7right click to use this color");
        utils.createItem(chatcolorInv, "YELLOW_STAINED_GLASS_PANE", 1, 11, "&eYellow", "&7right click to use this color");

        toReturn.setContents(chatcolorInv.getContents());

        return toReturn;
    }

    public static void click(Player p, int slot, ItemStack click, Inventory inv){
        if(click.getItemMeta().getDisplayName().equalsIgnoreCase(utils.chat("CHAT COLOR HERE"))){
            //set the players chatcolor using sql
            //send message
        }
    }
}
