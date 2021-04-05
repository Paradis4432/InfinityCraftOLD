package com.infinitycraft.plugin.general.staffMode.events.items;

import com.infinitycraft.plugin.general.staffMode.items.LauncherItem;
import com.infinitycraft.plugin.general.staffMode.items.VanishItem;
import com.infinitycraft.plugin.general.storageManager.GetObject;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class VanishEvent implements Listener {
    @EventHandler
    public void playerUseItem(PlayerInteractEvent e) {
        if ((boolean) GetObject.getPlayer(e.getPlayer().getUniqueId(), "staffMode")) {
            if (e.getPlayer().getInventory().getItemInMainHand().hashCode() == VanishItem.vanish0.hashCode()) {
                vanish(e.getPlayer());
                e.getPlayer().getInventory().setItemInMainHand(VanishItem.vanish1);
            }
            else if (e.getPlayer().getInventory().getItemInMainHand().hashCode() == VanishItem.vanish1.hashCode()) {
                unvanish(e.getPlayer());
                e.getPlayer().getInventory().setItemInMainHand(VanishItem.vanish0);
            }
        }
    }
    public static void vanish(Player player) {
        for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
            if (!(pl == player)) {
                pl.hidePlayer(player);
                pl.sendMessage(ChatColor.YELLOW + player.getName() + " left the game.");
            }
        }
        player.sendMessage(ChatColor.GOLD + "You are now vanished.");
    }
    public static void unvanish(Player player) {
        for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
            if (!(pl == player)){
                pl.sendMessage(ChatColor.YELLOW + player.getName() + " joined the game.");
            }
        }
        player.sendMessage(ChatColor.GOLD + "You are now visible.");
    }

}
