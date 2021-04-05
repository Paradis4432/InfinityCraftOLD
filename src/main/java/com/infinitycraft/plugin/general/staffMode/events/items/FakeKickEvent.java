package com.infinitycraft.plugin.general.staffMode.events.items;

import com.infinitycraft.plugin.general.staffMode.items.FakeKickItem;
import com.infinitycraft.plugin.general.staffMode.items.LauncherItem;
import com.infinitycraft.plugin.general.storageManager.GetObject;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class FakeKickEvent implements Listener {
    @EventHandler
    public void playerUseItem(PlayerInteractEntityEvent e) {
        e.getPlayer().sendMessage("yes, no, maybe");
        if ((boolean) GetObject.getPlayer(e.getPlayer().getUniqueId(), "staffMode") && e.getPlayer().getInventory().getItemInMainHand().hashCode() == FakeKickItem.fakeKick.hashCode()) {
            Player p = e.getPlayer();
            p.sendMessage("yes");
            if (e.getRightClicked() instanceof Player) {
                p.sendMessage("also yes");
                ((Player) e.getRightClicked()).kickPlayer("Internal Exception: java.io.IOException: An existing connection was forcibly closed by the remote host");
            }
            e.setCancelled(true);
        }
    }
}
