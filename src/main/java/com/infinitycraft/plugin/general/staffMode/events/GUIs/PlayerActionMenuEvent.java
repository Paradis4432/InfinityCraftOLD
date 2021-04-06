package com.infinitycraft.plugin.general.staffMode.events.GUIs;

import com.infinitycraft.plugin.general.staffMode.GUIs.PlayerActionMenu;
import com.infinitycraft.plugin.general.staffMode.GUIs.StaffPlayerMenu;
import com.infinitycraft.plugin.main;
import net.wesjd.anvilgui.AnvilGUI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.time.LocalDateTime;
import java.util.Date;

public class PlayerActionMenuEvent implements Listener {
    @EventHandler
    public static void InventoryClickEvent(InventoryClickEvent e) {
        if (e.getInventory().getType() != InventoryType.CREATIVE) {
            if (e.getView().getTitle().contains("Taking Action On: ")) {
                // Exit
                if (e.getInventory().getItem(e.getSlot()).hashCode() == PlayerActionMenu.exit.hashCode()) {
                    e.getWhoClicked().closeInventory();
                    e.setCancelled(true);
                }
                else if (e.getInventory().getItem(e.getSlot()).hashCode() == PlayerActionMenu.fakeKick.hashCode()) {
                    SkullMeta skullMeta = (SkullMeta) e.getInventory().getItem(4).getItemMeta();
                    Player target = (Player) skullMeta.getOwningPlayer();
                    target.kickPlayer("Internal Exception: java.io.IOException: An existing connection was forcibly closed by the remote host");
                    e.setCancelled(true);
                    e.getWhoClicked().closeInventory();
                    e.getWhoClicked().sendMessage(ChatColor.GOLD + target.getName() + " was kicked.");
                }
                else if (e.getInventory().getItem(e.getSlot()).hashCode() == PlayerActionMenu.weekBan.hashCode()) {
                    SkullMeta skullMeta = (SkullMeta) e.getInventory().getItem(4).getItemMeta();
                    Player target = (Player) skullMeta.getOwningPlayer();
                    target.banPlayerFull("You have been temporarily banned. You will be able to rejoin in 1 week.", new Date(System.currentTimeMillis()+24*7*60*60*1000));
                    e.setCancelled(true);
                    e.getWhoClicked().closeInventory();
                    e.getWhoClicked().sendMessage(ChatColor.GOLD + target.getName() + " was banned for 1 week.");
                }
                else if (e.getInventory().getItem(e.getSlot()).hashCode() == PlayerActionMenu.permBan.hashCode()) {
                    SkullMeta skullMeta = (SkullMeta) e.getInventory().getItem(4).getItemMeta();
                    Player target = (Player) skullMeta.getOwningPlayer();
                    target.banPlayerFull("You have been permanently banned.");
                    e.setCancelled(true);
                    e.getWhoClicked().closeInventory();
                    e.getWhoClicked().sendMessage(ChatColor.GOLD + target.getName() + " was permanently banned.");
                }
                else if (e.getInventory().getItem(e.getSlot()).hashCode() == PlayerActionMenu.customKick.hashCode()) {
                    SkullMeta skullMeta = (SkullMeta) e.getInventory().getItem(4).getItemMeta();
                    Player target = (Player) skullMeta.getOwningPlayer();
                    e.setCancelled(true);
                    e.getWhoClicked().closeInventory();
                    new AnvilGUI.Builder()
                            .onComplete((player, text) -> {
                                e.getWhoClicked().sendMessage(ChatColor.GOLD + target.getName() + " was kicked for reason \"" + text + "\".");
                                target.kickPlayer(text);
                                return AnvilGUI.Response.close();
                            })
                            .text("Please enter kick message.")
                            .itemLeft(new ItemStack(Material.PAPER))
                            .title("Please enter kick message.")
                            .plugin(main.getInstance())
                            .open((Player) e.getWhoClicked());
                }
                else if (e.getInventory().getItem(e.getSlot()).hashCode() == PlayerActionMenu.customBan.hashCode()) {
                    SkullMeta skullMeta = (SkullMeta) e.getInventory().getItem(4).getItemMeta();
                    Player target = (Player) skullMeta.getOwningPlayer();
                    e.setCancelled(true);
                    e.getWhoClicked().closeInventory();
                    new AnvilGUI.Builder()
                            .onComplete((player, text) -> {
                                player.closeInventory();
                                new AnvilGUI.Builder()
                                        .onComplete((player2, text2) -> {
                                            Integer days = Integer.valueOf(text2);
                                            target.banPlayerFull(text, new Date(System.currentTimeMillis()+days*24*60*60*1000));
                                            e.getWhoClicked().sendMessage(ChatColor.GOLD + target.getName() + " was banned for " + days + " for reason \"" + text + "\".");
                                            return AnvilGUI.Response.close();
                                        })
                                        .text("Please enter ban length in days.")
                                        .itemLeft(new ItemStack(Material.PAPER))
                                        .title("Please enter ban length in days.")
                                        .plugin(main.getInstance())
                                        .open((Player) e.getWhoClicked());
                                return AnvilGUI.Response.close();
                            })
                            .text("Please enter ban message.")
                            .itemLeft(new ItemStack(Material.PAPER))
                            .title("Please enter ban message.")
                            .plugin(main.getInstance())
                            .open((Player) e.getWhoClicked());
                }
            }
        }
    }
}
