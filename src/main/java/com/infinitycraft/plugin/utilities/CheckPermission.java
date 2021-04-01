package com.infinitycraft.plugin.utilities;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class CheckPermission {
    public static Boolean checkPerm(String permission, Player player) {
        if(player.hasPermission(permission)) {
            return true;
        }
        else {
            player.sendMessage(ChatColor.DARK_RED + "You don't have the permissions required to do this!");
            player.closeInventory();
            return false;
        }
    }
}
