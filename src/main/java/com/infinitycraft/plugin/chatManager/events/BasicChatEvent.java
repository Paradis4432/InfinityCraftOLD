package com.infinitycraft.plugin.chatManager.events;

import com.infinitycraft.plugin.chatManager.ColorCoder;
import com.infinitycraft.plugin.storageManager.GetObject;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class BasicChatEvent implements Listener {
    @EventHandler
    public void onChatEvent(AsyncPlayerChatEvent e) {
        String message = e.getMessage();
        message = ChatColor.stripColor(ColorCoder.convertColor(message));
        String prefix = ChatColor.stripColor(String.valueOf(GetObject.getPlayer(e.getPlayer().getUniqueId(), "prefix")));
        String suffix = ChatColor.stripColor(String.valueOf(GetObject.getPlayer(e.getPlayer().getUniqueId(), "suffix")));
        String chatColor = String.valueOf(GetObject.getPlayer(e.getPlayer().getUniqueId(), "chatColor"));
        if (!prefix.equals("")) {
            prefix = "[" + prefix + "] ";
        }
        if (!suffix.equals("")) {
            suffix = " [" + suffix + "] ";
        }
        e.setFormat(prefix + "<" + e.getPlayer().getName() + ">" + suffix + ": " + ColorCoder.convertColor(chatColor + message));
    }
}
