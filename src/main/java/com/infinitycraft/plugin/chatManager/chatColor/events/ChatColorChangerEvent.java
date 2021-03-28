package com.infinitycraft.plugin.chatManager.chatColor.events;

import com.infinitycraft.plugin.itemManager.affixes.GUIs.AffixesGUI;
import com.infinitycraft.plugin.storageManager.EditObject;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Objects;

public class ChatColorChangerEvent implements Listener {
    /**
     * Changes the chat color of a player!
     * @param e The event.
     */
    public void inventoryEvent(InventoryClickEvent e) {
        if (e.getView().title().equals(Component.text("Pick a chat color!"))) {
            String char1 = String.valueOf(Objects.requireNonNull(e.getCursor()).getItemMeta().displayName()).substring(0, 1);
            String char2 = String.valueOf(Objects.requireNonNull(e.getCursor()).getItemMeta().displayName()).substring(0, 2);
            if (char1.equals("&")) {
                EditObject.editPlayer(e.getWhoClicked().getUniqueId(), "chatColor", char2);
            }
            e.getWhoClicked().sendMessage(char2 + "Your chat color was changed.");
            e.setCancelled(true);
        }
    }
}
