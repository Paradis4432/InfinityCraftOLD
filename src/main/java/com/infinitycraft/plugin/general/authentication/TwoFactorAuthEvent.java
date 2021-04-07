package com.infinitycraft.plugin.general.authentication;

import io.papermc.paper.event.player.AsyncChatEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.*;

import java.util.ArrayList;
import java.util.List;

public class TwoFactorAuthEvent implements Listener {
    public static List<Player> authing = new ArrayList<>();
    @EventHandler
    public void BlockPlaceEvent(BlockPlaceEvent e) {
        if (authing.contains(e.getPlayer())){
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void BlockBreakEvent(BlockBreakEvent e) {
        if (authing.contains(e.getPlayer())){
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void AsyncPlayerChatEvent(AsyncPlayerChatEvent e) {
        if (authing.contains(e.getPlayer())){
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void PlayerMoveEvent(PlayerMoveEvent e) {
        if (authing.contains(e.getPlayer())){
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void PlayerDamageEvent(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            if (authing.contains(p)) {
                e.setCancelled(true);
            }
        }
    }
    @EventHandler
    public void PlayerInteractEvent(PlayerInteractEvent e) {
        if (authing.contains(e.getPlayer())){
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void PlayerAttemptPickupItemEvent(PlayerAttemptPickupItemEvent e) {
        if (authing.contains(e.getPlayer())){
            e.setCancelled(true);
        }
    }
}
