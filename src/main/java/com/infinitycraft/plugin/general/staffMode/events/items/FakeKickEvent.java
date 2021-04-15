package com.infinitycraft.plugin.general.staffMode.events.items;

import com.infinitycraft.plugin.general.staffMode.items.FakeKickItem;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import static com.infinitycraft.plugin.general.staffMode.events.MainStaffEvent.staffModeList;

public class FakeKickEvent implements Listener {
    @EventHandler
    public void playerUseItem(PlayerInteractEntityEvent e) {
        if (staffModeList.contains(e.getPlayer().getUniqueId()) && e.getPlayer().getInventory().getItemInMainHand().hashCode() == FakeKickItem.fakeKick.hashCode()) {
            Player p = e.getPlayer();
            if (e.getRightClicked() instanceof Player) {
                e.getPlayer().sendMessage(ChatColor.GOLD + "Disconnected: " + e.getRightClicked().getName() + "!");
                ((Player) e.getRightClicked()).kickPlayer("Internal Exception: java.io.IOException: An existing connection was forcibly closed by the remote host");
            }
            e.setCancelled(true);
        }
    }
}
