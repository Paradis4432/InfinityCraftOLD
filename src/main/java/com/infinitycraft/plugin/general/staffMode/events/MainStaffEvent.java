package com.infinitycraft.plugin.general.staffMode.events;

import com.infinitycraft.plugin.general.storageManager.GetObject;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.player.PlayerAttemptPickupItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;

import java.util.Objects;

public class MainStaffEvent implements Listener {
    @EventHandler
    public void ItemUseEvent(PlayerInteractEvent e) {
        if ((boolean) GetObject.getPlayer(e.getPlayer().getUniqueId(), "staffMode")){
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void dropItemEvent(PlayerDropItemEvent e) {
        if ((boolean) GetObject.getPlayer(e.getPlayer().getUniqueId(), "staffMode")) {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void InventoryClickEvent(InventoryClickEvent e) {
        if ((boolean) GetObject.getPlayer(e.getWhoClicked().getUniqueId(), "staffMode")) {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void damageItemEvent(PlayerItemDamageEvent e) {
        if ((boolean) GetObject.getPlayer(e.getPlayer().getUniqueId(), "staffMode")) {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void damageEvent(PlayerDeathEvent e) {
        if ((boolean) GetObject.getPlayer(e.getEntity().getUniqueId(), "staffMode")) {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void pickupEvent(PlayerAttemptPickupItemEvent e) {
        if ((boolean) GetObject.getPlayer(e.getPlayer().getUniqueId(), "staffMode")) {
            e.setCancelled(true);
        }
    }
}
