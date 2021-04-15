package com.infinitycraft.plugin.general.fun;

import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class BetterPearls implements Listener {
    @EventHandler
    public void onPearl(ProjectileLaunchEvent e) {
        if (e.getEntity().getShooter() instanceof Player && e.getEntity() instanceof EnderPearl) {
            e.getEntity().setPassenger((Player)e.getEntity().getShooter());
            EnderPearl pearl = (EnderPearl) e.getEntity();
        }
    }
    @EventHandler
    public void onTeleport(PlayerTeleportEvent e) {
        if(e.getCause().equals(PlayerTeleportEvent.TeleportCause.ENDER_PEARL)) {
            e.getPlayer().teleport(e.getPlayer().getLocation().add(0, 1, 0));
            e.setCancelled(true);
        }
    }


}
