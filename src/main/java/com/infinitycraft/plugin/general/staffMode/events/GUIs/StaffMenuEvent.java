package com.infinitycraft.plugin.general.staffMode.events.GUIs;

import com.infinitycraft.plugin.general.staffMode.GUIs.StaffMenu;
import com.infinitycraft.plugin.main;
import net.wesjd.anvilgui.AnvilGUI;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class StaffMenuEvent implements Listener {
    @EventHandler
    public void InventoryClickEvent(InventoryClickEvent e) {
        // Exit
        if (e.getInventory().getItem(e.getSlot()).hashCode() == StaffMenu.exit.hashCode()) {
            e.getWhoClicked().closeInventory();
            e.setCancelled(true);
        }
        // Next Page
        else if (e.getInventory().getItem(e.getSlot()).hashCode() == StaffMenu.nextPage.hashCode()) {
            String title = e.getView().getTitle();
            String pageString = title.replaceAll("[^0-9]","");
            int page = Integer.parseInt(pageString);
            e.getWhoClicked().closeInventory();
            String query = "";
            if (title.contains("Searching For ")) {
                query = title.substring(title.indexOf("Searching For ") + 14);
            }
            if (title.contains("Showing Staff")) {
                StaffMenu.GenerateInventory((Player) e.getWhoClicked(), page + 1, true,query);
            }
            else {
                StaffMenu.GenerateInventory((Player) e.getWhoClicked(), page + 1, false, query);
            }
            e.setCancelled(true);
        }
        // Previous Page
        else if (e.getInventory().getItem(e.getSlot()).hashCode() == StaffMenu.previousPage.hashCode()) {
            String title = e.getView().getTitle();
            String pageString = title.replaceAll("[^0-9]","");
            int page = Integer.parseInt(pageString);
            if (page != 1) {
                e.getWhoClicked().closeInventory();
                String query = "";
                if (title.contains("Searching For ")) {
                     query = title.substring(title.indexOf("Searching For ") + 14);
                }
                if (title.contains("Showing Staff")) {
                    StaffMenu.GenerateInventory((Player) e.getWhoClicked(), page - 1, true, query);
                }
                else {
                    StaffMenu.GenerateInventory((Player) e.getWhoClicked(), page - 1, false, query);
                }
            }
            e.setCancelled(true);
        }
        // Fly
        else if (e.getInventory().getItem(e.getSlot()).hashCode() == StaffMenu.fly0.hashCode()) {
            Player player = (Player) e.getWhoClicked();
            player.setAllowFlight(true);
            player.setFlying(true);
            e.getInventory().setItem(e.getSlot(), StaffMenu.fly1);
            e.setCancelled(true);
        }
        else if (e.getInventory().getItem(e.getSlot()).hashCode() == StaffMenu.fly1.hashCode()) {
            Player player = (Player) e.getWhoClicked();
            player.setAllowFlight(false);
            player.setFlying(false);
            e.getInventory().setItem(e.getSlot(), StaffMenu.fly0);
            e.setCancelled(true);
        }
        // Nickname
        else if (e.getInventory().getItem(e.getSlot()).hashCode() == StaffMenu.nickName.hashCode()) {
            e.getWhoClicked().closeInventory();
            new AnvilGUI.Builder()
                    .onComplete((player, text) -> {
                        player.setDisplayName(text);
                        player.setCustomName(text);
                        player.setPlayerListName(text);
                        player.setCustomNameVisible(true);
                        e.getWhoClicked().sendMessage(ChatColor.DARK_GREEN +  "You have been successfully nicked.");
                        return AnvilGUI.Response.close();
                    })
                    .text("Please enter your nick.")
                    .itemLeft(new ItemStack(Material.PAPER))
                    .title("Please enter your nick.")
                    .plugin(main.getInstance())
                    .open((Player) e.getWhoClicked());
            e.setCancelled(true);
        }
        else if (e.getInventory().getItem(e.getSlot()).hashCode() == StaffMenu.showStaff.hashCode()) {
            e.getWhoClicked().closeInventory();
            StaffMenu.GenerateInventory((Player) e.getWhoClicked(), 1, true, "");
            e.setCancelled(true);
        }
        else if (e.getInventory().getItem(e.getSlot()).hashCode() == StaffMenu.showPlayers.hashCode()) {
            e.getWhoClicked().closeInventory();
            StaffMenu.GenerateInventory((Player) e.getWhoClicked(), 1, false, "");
            e.setCancelled(true);
        }
        else if (e.getInventory().getItem(e.getSlot()).hashCode() == StaffMenu.search.hashCode()) {
            e.getWhoClicked().closeInventory();
            new AnvilGUI.Builder()
                    .onComplete((player, text) -> {
                        if (e.getView().getTitle().contains("Showing Staff")) {
                            StaffMenu.GenerateInventory((Player) e.getWhoClicked(), 1 , true, text);
                        }
                        else {StaffMenu.GenerateInventory((Player) e.getWhoClicked(), 1, false, text);}
                        return AnvilGUI.Response.close();
                    })
                    .text("Please enter search query.")
                    .itemLeft(new ItemStack(Material.PAPER))
                    .title("Please enter search query.")
                    .plugin(main.getInstance())
                    .open((Player) e.getWhoClicked());
        }
    }
}
