package com.infinitycraft.plugin.itemManager.affixes.events;

import com.infinitycraft.plugin.itemManager.affixes.GUIs.AffixesGUI;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Objects;

public class PositionSelectorEvents implements Listener {

    /**
     * Checks what item the user clicked to proceed to the next step
     * @param e The event
     */
    @EventHandler
    public void inventoryEvent(InventoryClickEvent e) {
        if (e.getView().title().equals(Component.text("Choose a position!"))) {
            if (Objects.equals(Objects.requireNonNull(e.getCursor()).getItemMeta().displayName(), Component.text("Prefix"))) {
                AffixesGUI.openGUI((Player) e.getWhoClicked(), "prefix");
            }
            else if (Objects.equals(e.getCursor().getItemMeta().displayName(), Component.text("Suffix"))) {
                AffixesGUI.openGUI((Player) e.getWhoClicked(), "suffix");
            }
            e.setCancelled(true);
        }
    }
}
