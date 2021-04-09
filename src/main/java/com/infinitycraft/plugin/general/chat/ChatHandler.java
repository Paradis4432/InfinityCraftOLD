package com.infinitycraft.plugin.general.chat;

import com.infinitycraft.plugin.general.storageManager.GetObject;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatHandler implements Listener {
    @EventHandler
    public void onChatEvent(AsyncPlayerChatEvent e) {
        String message = e.getMessage();
        message = ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', message));
        String prefix = ChatColor.translateAlternateColorCodes('&', String.valueOf(GetObject.getPlayer(e.getPlayer().getUniqueId(), "prefix")));
        String suffix = ChatColor.translateAlternateColorCodes('&', String.valueOf(GetObject.getPlayer(e.getPlayer().getUniqueId(), "suffix")));
        String chatColor = String.valueOf(GetObject.getPlayer(e.getPlayer().getUniqueId(), "chatColor"));
        if (!prefix.equals("")) {
            prefix = "[" + prefix + "] ";
        }
        if (!suffix.equals("")) {
            suffix = " [" + suffix + "]";
        }
        e.setFormat(prefix + ChatColor.WHITE + e.getPlayer().getDisplayName() + suffix + ": " + ChatColor.translateAlternateColorCodes('&', chatColor + message));
    }
}
