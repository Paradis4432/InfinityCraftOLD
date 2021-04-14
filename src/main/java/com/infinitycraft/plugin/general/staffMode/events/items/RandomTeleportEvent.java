package com.infinitycraft.plugin.general.staffMode.events.items;

import com.infinitycraft.plugin.general.staffMode.items.RandomTeleportItem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static com.infinitycraft.plugin.general.staffMode.events.MainStaffEvent.staffModeList;

public class RandomTeleportEvent implements Listener {
    @EventHandler
    public void playerUseItem(PlayerInteractEvent e) {
        if (staffModeList.contains(e.getPlayer().getUniqueId()) && e.getPlayer().getInventory().getItemInMainHand().hashCode() == RandomTeleportItem.randomTeleport.hashCode()) {
            List list = Arrays.asList(Bukkit.getOnlinePlayers().toArray());
            Random random = new Random();
            Player randomPlayer = (Player) list.get(random.nextInt(list.size()));
            e.getPlayer().teleport(randomPlayer);
            e.getPlayer().sendMessage(ChatColor.GOLD + "Teleported To: " + randomPlayer.getName() + "!");
            e.setCancelled(true);
        }
    }
}
