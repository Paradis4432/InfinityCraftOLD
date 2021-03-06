package com.infinitycraft.plugin.general.staffMode.events.items;

import com.infinitycraft.plugin.general.staffMode.items.VanishItem;
import com.infinitycraft.plugin.general.storageManager.EditObject;
import com.infinitycraft.plugin.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import static com.infinitycraft.plugin.general.staffMode.events.MainStaffEvent.staffModeList;

public class VanishEvent implements Listener {
    @EventHandler
    public void playerUseItem(PlayerInteractEvent e) {
        if (staffModeList.contains(e.getPlayer().getUniqueId())) {
            if (e.getPlayer().getInventory().getItemInMainHand().hashCode() == VanishItem.vanish0.hashCode()) {
                vanish(e.getPlayer());
                e.getPlayer().getInventory().setItemInMainHand(VanishItem.vanish1);
                e.setCancelled(true);
            }
            else if (e.getPlayer().getInventory().getItemInMainHand().hashCode() == VanishItem.vanish1.hashCode()) {
                unvanish(e.getPlayer());
                e.getPlayer().getInventory().setItemInMainHand(VanishItem.vanish0);
                e.setCancelled(true);
            }
        }
    }
    public static void vanish(Player player) {
        for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
            if (pl == player) {
                pl.hidePlayer(main.getInstance(), player);
                pl.sendMessage(ChatColor.YELLOW + player.getName() + " left the game.");
            }
        }
        EditObject.editPlayer(player.getUniqueId(), "vanished", true);
        player.sendMessage(ChatColor.GOLD + "You are now vanished.");
    }
    public static void unvanish(Player player) {
        for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
            if (pl == player){
                pl.showPlayer(main.getInstance(), player);
                pl.sendMessage(ChatColor.YELLOW + player.getName() + " joined the game.");
            }
        }
        EditObject.editPlayer(player.getUniqueId(), "vanished", false);
        player.sendMessage(ChatColor.GOLD + "You are now visible.");
    }

}
