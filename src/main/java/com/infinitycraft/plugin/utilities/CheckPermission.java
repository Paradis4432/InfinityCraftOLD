package com.infinitycraft.plugin.utilities;

import com.infinitycraft.plugin.chatManager.ColorCoder;
import org.bukkit.entity.Player;

public class CheckPermission {
    public static Boolean checkPerm(String permission, Player player) {
        if(player.hasPermission(permission)) {
            return true;
        }
        else {
            player.sendMessage(ColorCoder.convertColor("&4You don't have the permissions required to do this!"));
            player.closeInventory();
            return false;
        }
    }
}
