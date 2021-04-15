package com.infinitycraft.plugin.general.tools.permissions;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class CheckPermission {
    public static Boolean checkPerm(String permission, Player player) {
        if(player.hasPermission(permission)) {
            return true;
        }
        else {
            player.sendMessage(ChatColor.DARK_RED + "You don't have the permissions required to do this!");
            //player.closeInventory();
            return true;
        }
    }
}
