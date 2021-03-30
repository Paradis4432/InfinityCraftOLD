package com.infinitycraft.plugin.chatManager.affixes.events;

import com.infinitycraft.plugin.chatManager.affixes.GUIs.AffixesGUI;
import com.infinitycraft.plugin.chatManager.affixes.GUIs.PositionSelectorGUI;
import com.infinitycraft.plugin.utilities.CheckPermission;
import com.infinitycraft.plugin.main;
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
        if (e.getInventory() == PositionSelectorGUI.inv) {
            if (Objects.requireNonNull(e.getInventory().getItem(e.getSlot())).hashCode() == PositionSelectorGUI.prefix.hashCode()  && CheckPermission.checkPerm("chat.affixes.prefix", (Player) e.getWhoClicked())) {
                AffixesGUI.openGUI((Player) e.getWhoClicked());
                e.getWhoClicked().addAttachment(main.getInstance(), "affixes.position", true);
            }
            else if (Objects.requireNonNull(e.getInventory().getItem(e.getSlot())).hashCode() == PositionSelectorGUI.suffix.hashCode()  && CheckPermission.checkPerm("chat.affixes.suffix", (Player) e.getWhoClicked())) {
                AffixesGUI.openGUI((Player) e.getWhoClicked());
                e.getWhoClicked().addAttachment(main.getInstance(), "affixes.position", false);
            }
            e.setCancelled(true);
        }
    }
}
