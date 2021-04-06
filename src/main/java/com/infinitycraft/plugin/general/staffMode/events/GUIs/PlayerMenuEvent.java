package com.infinitycraft.plugin.general.staffMode.events.GUIs;

import com.infinitycraft.plugin.general.staffMode.GUIs.PlayerMenu;
import com.infinitycraft.plugin.general.storageManager.SQLDatabase;
import com.infinitycraft.plugin.general.tools.inventories.CreateInventory;
import com.infinitycraft.plugin.general.tools.items.templates.Fillers;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerMenuEvent implements Listener {
    @EventHandler
    public void InventoryClickEvent(InventoryClickEvent e) {
        // Exit
        if (e.getInventory().getItem(e.getSlot()).hashCode() == PlayerMenu.exit.hashCode()) {
            e.getWhoClicked().closeInventory();
            e.setCancelled(true);
        }
        // Inventory See
        else if (e.getInventory().getItem(e.getSlot()).hashCode() == PlayerMenu.viewInventory.hashCode()) {
            String name = "";
            name = e.getView().getTitle().substring(e.getView().getTitle().indexOf("Viewing ") + 10);
            e.getWhoClicked().sendMessage(name);
            Player target = Bukkit.getPlayer(name);
            PlayerInventory inv = target.getInventory();
            e.getWhoClicked().closeInventory();
            e.getWhoClicked().openInventory(inv);
        }
        // Ender Chest See
        else if (e.getInventory().getItem(e.getSlot()).hashCode() == PlayerMenu.viewEnderChest.hashCode()) {
            String name = "";
            name = e.getView().getTitle().substring(e.getView().getTitle().indexOf("Viewing ") + 10);
            Player target = Bukkit.getPlayer(name);
            Inventory inv = target.getEnderChest();
            e.getWhoClicked().closeInventory();
            e.getWhoClicked().openInventory(inv);
        }
        // Armor View
        else if (e.getInventory().getItem(e.getSlot()).hashCode() == PlayerMenu.viewArmor.hashCode()) {
            String name = "";
            name = e.getView().getTitle().substring(e.getView().getTitle().indexOf("Viewing ") + 10);
            Player target = Bukkit.getPlayer(name);
            Map<ItemStack, Integer> items = new HashMap<>();
            Integer position = 0;
            for (ItemStack i : target.getInventory().getArmorContents()) {
                items.put(i, position);
                position++;
            }
            items.put(target.getInventory().getItemInOffHand(), position);
            Inventory inv = CreateInventory.createCustomInventory(null, 1, "Viewing " + name + "'s Armor", Fillers.filler, items);
            e.getWhoClicked().closeInventory();
            e.getWhoClicked().openInventory(inv);
        }
        // Report View
        else if (e.getInventory().getItem(e.getSlot()).hashCode() == PlayerMenu.viewReports.hashCode()) {
            String name = "";
            name = e.getView().getTitle().substring(e.getView().getTitle().indexOf("Viewing ") + 10);
            Player target = Bukkit.getPlayer(name);
            String UUID = String.valueOf(target.getUniqueId()).replaceAll("-", "");
            e.getWhoClicked().sendMessage(ChatColor.GOLD + "Here are the 5 most recent reports:\n");
            try (PreparedStatement getreports = SQLDatabase.connection.prepareStatement("SELECT reason, time, HEX(player) as player FROM reports WHERE target = UNHEX(?) ORDER BY time LIMIT 5")) {
                getreports.setString(1, UUID);
                ResultSet rs = getreports.executeQuery();
                while (rs.next()) {
                    String trimmedUUID = String.valueOf(rs.getString("player"));
                    String playerUUID = trimmedUUID.replaceAll("(\\w{8})(\\w{4})(\\w{4})(\\w{4})(\\w{12})", "$1-$2-$3-$4-$5");
                    playerUUID = playerUUID.toLowerCase();
                    Bukkit.getLogger().info(playerUUID);
                    Player player = Bukkit.getPlayer(java.util.UUID.fromString(playerUUID));
                    e.getWhoClicked().sendMessage("\nFrom: " + player.getName() + "\nTo: " + name + "\nAt: "+ rs.getString("time") + "\nReason: " + rs.getString("reason"));
                }
            }
            catch (Exception throwables) {
                throwables.printStackTrace();
            }
            e.getWhoClicked().closeInventory();
        }
    }
}
