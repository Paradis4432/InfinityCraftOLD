package com.infinitycraft.plugin.itemManager.affixes.events;

import com.infinitycraft.plugin.main;
import com.infinitycraft.plugin.storageManager.EditObject;
import net.kyori.adventure.text.Component;
import net.wesjd.anvilgui.AnvilGUI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class AffixesGUIEvents implements Listener {
    /**
     * Changes the affixes of the player to their choice.
     * @param e The event.
     */
    @EventHandler
    public void inventoryEvent(InventoryClickEvent e) {
        String modification = "";
        if (e.getView().title().contains(Component.text("Edit your"))) {
            if (e.getView().title().contains(Component.text("suffix"))) {
                modification = "suffix";
            } else if (e.getView().title().contains(Component.text("prefix"))) {
                modification = "prefix";
            }
            if (Objects.equals(Objects.requireNonNull(e.getCursor()).getItemMeta().displayName(), Component.text("Bob")) && !modification.equals("")) {
                EditObject.editPlayer(e.getWhoClicked().getUniqueId(), modification, "Bob");
            } else if (Objects.equals(Objects.requireNonNull(e.getCursor()).getItemMeta().displayName(), Component.text("Jeff")) && !modification.equals("")) {
                EditObject.editPlayer(e.getWhoClicked().getUniqueId(), modification, "Jeff");
            } else if (Objects.equals(Objects.requireNonNull(e.getCursor()).getItemMeta().displayName(), Component.text("Custom")) && !modification.equals("")) {
                String finalModification = modification;
                new AnvilGUI.Builder()
                        .onComplete((player, text) -> {
                            EditObject.editPlayer(e.getWhoClicked().getUniqueId(), finalModification, text);
                            return AnvilGUI.Response.close();
                        })
                        .text("Enter your " + modification + ".")
                        .itemLeft(new ItemStack(Material.PAPER))
                        .title("Enter your " + modification + ".")
                        .plugin(main.getInstance())
                        .open((Player) e.getWhoClicked());
            }
        }
        if (!modification.equals("")) {
            e.setCancelled(true);
            e.getWhoClicked().sendMessage("Your " + modification + " was changed.");
        }
    }
}
