package com.infinitycraft.plugin.general.fun;

import com.destroystokyo.paper.event.entity.ProjectileCollideEvent;
import org.bukkit.Material;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTeleportEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.spigotmc.event.entity.EntityDismountEvent;

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
            if (!e.getPlayer().isInsideVehicle()) {
                e.getPlayer().teleport(e.getPlayer().getLocation().add(0, 1, 0));
            }
            e.setCancelled(true);
        }
    }


}
