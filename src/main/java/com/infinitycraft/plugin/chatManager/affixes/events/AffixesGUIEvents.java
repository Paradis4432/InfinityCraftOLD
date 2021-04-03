package com.infinitycraft.plugin.chatManager.affixes.events;

import com.infinitycraft.plugin.chatManager.affixes.GUIs.AffixesGUI;
import com.infinitycraft.plugin.utilities.CheckPermission;
import com.infinitycraft.plugin.main;
import com.infinitycraft.plugin.storageManager.EditObject;
import net.wesjd.anvilgui.AnvilGUI;
import org.bukkit.ChatColor;
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
     *
     * @param e The event.
     */
    @EventHandler
    public void inventoryEvent(InventoryClickEvent e) {
        String modification;
        if (e.getInventory() == AffixesGUI.inv) {
            if (e.getWhoClicked().hasPermission("affixes.position")) {
                modification = "prefix";
            } else {
                modification = "suffix";
            }

            if (Objects.requireNonNull(e.getInventory().getItem(e.getSlot())).hashCode() == AffixesGUI.option1.hashCode()) {
                EditObject.editPlayer(e.getWhoClicked().getUniqueId(), modification, "EPIC");
                e.getWhoClicked().sendMessage(ChatColor.DARK_GREEN + "Successfully set your affixes to EPIC!");
                e.getWhoClicked().closeInventory();
            } else if (Objects.requireNonNull(e.getInventory().getItem(e.getSlot())).hashCode() == AffixesGUI.option2.hashCode()) {
                EditObject.editPlayer(e.getWhoClicked().getUniqueId(), modification, "");
                e.getWhoClicked().sendMessage(ChatColor.DARK_GREEN + "Successfully reset your affixes!");
                e.getWhoClicked().closeInventory();
            } else if (Objects.requireNonNull(e.getInventory().getItem(e.getSlot())).hashCode() == AffixesGUI.custom.hashCode() && CheckPermission.checkPerm("chat.affixes.custom", (Player) e.getWhoClicked())) {
                new AnvilGUI.Builder()
                        .onComplete((player, text) -> {
                            EditObject.editPlayer(e.getWhoClicked().getUniqueId(), modification, text);
                            e.getWhoClicked().sendMessage(ChatColor.DARK_GREEN +  "Successfully set your custom affixes!");
                            return AnvilGUI.Response.close();
                        })
                        .text("Enter your " + modification + ".")
                        .itemLeft(new ItemStack(Material.PAPER))
                        .title("Enter your " + modification + ".")
                        .plugin(main.getInstance())
                        .open((Player) e.getWhoClicked());
            }
            e.setCancelled(true);
        }
    }
}
