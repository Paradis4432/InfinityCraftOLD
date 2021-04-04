package com.infinitycraft.plugin.general.chat.chatColor.events;

import com.infinitycraft.plugin.general.chat.chatColor.GUIs.ChatColorChanger;
import com.infinitycraft.plugin.general.storageManager.EditObject;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Objects;

public class ChatColorChangerEvent implements Listener {
    /**
     * Changes the chat color of a player!
     * @param e The event.
     */
    @EventHandler
    public void inventoryEvent(InventoryClickEvent e) {
        if (e.getInventory() == ChatColorChanger.inv) {
            if (Objects.requireNonNull(e.getInventory().getItem(e.getSlot())).hashCode() == ChatColorChanger.darkRed.hashCode()){
                EditObject.editPlayer(e.getWhoClicked().getUniqueId(), "chatColor", "&4");
                e.getWhoClicked().closeInventory();
                e.getWhoClicked().sendMessage(ChatColor.DARK_GREEN + "Successfully set your chat color to dark red!");
            }
            else if (Objects.requireNonNull(e.getInventory().getItem(e.getSlot())).hashCode() == ChatColorChanger.red.hashCode()){
                EditObject.editPlayer(e.getWhoClicked().getUniqueId(), "chatColor", "&c");
                e.getWhoClicked().closeInventory();
                e.getWhoClicked().sendMessage(ChatColor.DARK_GREEN + "Successfully set your chat color to red!");
            }
            else if (Objects.requireNonNull(e.getInventory().getItem(e.getSlot())).hashCode() == ChatColorChanger.gold.hashCode()){
                EditObject.editPlayer(e.getWhoClicked().getUniqueId(), "chatColor", "&6");
                e.getWhoClicked().closeInventory();
                e.getWhoClicked().sendMessage(ChatColor.DARK_GREEN + "Successfully set your chat color to gold!");
            }
            else if (Objects.requireNonNull(e.getInventory().getItem(e.getSlot())).hashCode() == ChatColorChanger.yellow.hashCode()){
                EditObject.editPlayer(e.getWhoClicked().getUniqueId(), "chatColor", "&e");
                e.getWhoClicked().closeInventory();
                e.getWhoClicked().sendMessage(ChatColor.DARK_GREEN + "Successfully set your chat color to yellow!");
            }
            else if (Objects.requireNonNull(e.getInventory().getItem(e.getSlot())).hashCode() == ChatColorChanger.darkGreen.hashCode()){
                EditObject.editPlayer(e.getWhoClicked().getUniqueId(), "chatColor", ChatColor.DARK_GREEN + "");
                e.getWhoClicked().closeInventory();
                e.getWhoClicked().sendMessage(ChatColor.DARK_GREEN + "Successfully set your chat color to dark green!");
            }
            else if (Objects.requireNonNull(e.getInventory().getItem(e.getSlot())).hashCode() == ChatColorChanger.green.hashCode()){
                EditObject.editPlayer(e.getWhoClicked().getUniqueId(), "chatColor", "&a");
                e.getWhoClicked().closeInventory();
                e.getWhoClicked().sendMessage(ChatColor.DARK_GREEN + "Successfully set your chat color to green!");
            }
            else if (Objects.requireNonNull(e.getInventory().getItem(e.getSlot())).hashCode() == ChatColorChanger.aqua.hashCode()){
                EditObject.editPlayer(e.getWhoClicked().getUniqueId(), "chatColor", "&7");
                e.getWhoClicked().closeInventory();
                e.getWhoClicked().sendMessage(ChatColor.DARK_GREEN + "Successfully set your chat color to aqua!");
            }
            else if (Objects.requireNonNull(e.getInventory().getItem(e.getSlot())).hashCode() == ChatColorChanger.darkAqua.hashCode()){
                EditObject.editPlayer(e.getWhoClicked().getUniqueId(), "chatColor", "&3");
                e.getWhoClicked().closeInventory();
                e.getWhoClicked().sendMessage(ChatColor.DARK_GREEN + "Successfully set your chat color to dark aqua!");
            }
            else if (Objects.requireNonNull(e.getInventory().getItem(e.getSlot())).hashCode() == ChatColorChanger.darkBlue.hashCode()){
                EditObject.editPlayer(e.getWhoClicked().getUniqueId(), "chatColor", "&1");
                e.getWhoClicked().closeInventory();
                e.getWhoClicked().sendMessage(ChatColor.DARK_GREEN + "Successfully set your chat color to dark blue!");
            }
            else if (Objects.requireNonNull(e.getInventory().getItem(e.getSlot())).hashCode() == ChatColorChanger.blue.hashCode()){
                EditObject.editPlayer(e.getWhoClicked().getUniqueId(), "chatColor", "&9");
                e.getWhoClicked().closeInventory();
                e.getWhoClicked().sendMessage(ChatColor.DARK_GREEN + "Successfully set your chat color to blue!");
            }
            else if (Objects.requireNonNull(e.getInventory().getItem(e.getSlot())).hashCode() == ChatColorChanger.lightPurple.hashCode()){
                EditObject.editPlayer(e.getWhoClicked().getUniqueId(), "chatColor", "&d");
                e.getWhoClicked().closeInventory();
                e.getWhoClicked().sendMessage(ChatColor.DARK_GREEN + "Successfully set your chat color to light purple!");
            }
            else if (Objects.requireNonNull(e.getInventory().getItem(e.getSlot())).hashCode() == ChatColorChanger.darkPurple.hashCode()){
                EditObject.editPlayer(e.getWhoClicked().getUniqueId(), "chatColor", "&5");
                e.getWhoClicked().closeInventory();
                e.getWhoClicked().sendMessage(ChatColor.DARK_GREEN + "Successfully set your chat color to dark purple!");
            }
            else if (Objects.requireNonNull(e.getInventory().getItem(e.getSlot())).hashCode() == ChatColorChanger.white.hashCode()){
                EditObject.editPlayer(e.getWhoClicked().getUniqueId(), "chatColor", "&f");
                e.getWhoClicked().closeInventory();
                e.getWhoClicked().sendMessage(ChatColor.DARK_GREEN + "Successfully set your chat color to white!");
            }
            else if (Objects.requireNonNull(e.getInventory().getItem(e.getSlot())).hashCode() == ChatColorChanger.gray.hashCode()){
                EditObject.editPlayer(e.getWhoClicked().getUniqueId(), "chatColor", "&7");
                e.getWhoClicked().closeInventory();
                e.getWhoClicked().sendMessage(ChatColor.DARK_GREEN + "Successfully set your chat color to gray!");
            }
            else if (Objects.requireNonNull(e.getInventory().getItem(e.getSlot())).hashCode() == ChatColorChanger.darkGray.hashCode()){
                EditObject.editPlayer(e.getWhoClicked().getUniqueId(), "chatColor", "&8");
                e.getWhoClicked().closeInventory();
                e.getWhoClicked().sendMessage(ChatColor.DARK_GREEN + "Successfully set your chat color to dark gray!");
            }
            else if (Objects.requireNonNull(e.getInventory().getItem(e.getSlot())).hashCode() == ChatColorChanger.black.hashCode()){
                EditObject.editPlayer(e.getWhoClicked().getUniqueId(), "chatColor", "&0");
                e.getWhoClicked().closeInventory();
                e.getWhoClicked().sendMessage(ChatColor.DARK_GREEN + "Successfully set your chat color to black!");
            }
            e.setCancelled(true);
        }
    }
}
