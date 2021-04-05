package com.infinitycraft.plugin.general.staffMode.commands;

import com.infinitycraft.plugin.general.staffMode.events.items.VanishEvent;
import com.infinitycraft.plugin.general.staffMode.items.LauncherItem;
import com.infinitycraft.plugin.general.staffMode.items.VanishItem;
import com.infinitycraft.plugin.general.staffMode.tools.InventorySerializer;
import com.infinitycraft.plugin.general.storageManager.EditObject;
import com.infinitycraft.plugin.general.storageManager.GetObject;
import com.infinitycraft.plugin.general.tools.permissions.CheckPermission;
import com.infinitycraft.plugin.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import javax.print.attribute.SetOfIntegerSyntax;
import java.io.IOException;

public class staff implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args) {
    if (!(sender instanceof Player)) {
        sender.sendMessage("You can't run this command in the console!");
        return true;
    }
    Player player = (Player) sender;
    if (args.length == 0) {
        if (CheckPermission.checkPerm("essentials.staff", player)) {
            if ((boolean) GetObject.getPlayer(player.getUniqueId(), "staffMode")) {
                // Disable Staff
                player.sendMessage(ChatColor.GOLD + "Staff mode disabled.");
                EditObject.editPlayer(player.getUniqueId(), "staffMode", false);
                // Load Inventory
                ItemStack[] inventory = new ItemStack[0];
                ItemStack[] armor = new ItemStack[0];
                try {
                    inventory = InventorySerializer.itemStackArrayFromBase64((String) GetObject.getPlayer(player.getUniqueId(), "staffInventory"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    armor = InventorySerializer.itemStackArrayFromBase64((String) GetObject.getPlayer(player.getUniqueId(), "staffArmor"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                player.getInventory().clear();
                player.getInventory().setContents(inventory);
                player.getInventory().setArmorContents(armor);
                // Disable Staff Features
                VanishEvent.unvanish(player);
                player.setAllowFlight(false);
                player.setFlying(false);
            }
            else {
                // Enable Staff
                player.sendMessage(ChatColor.GOLD + "Staff mode enabled.");
                EditObject.editPlayer(player.getUniqueId(), "staffMode", true);
                // Save Inventory
                String[] contents = InventorySerializer.playerInventoryToBase64(player.getInventory());
                EditObject.editPlayer(player.getUniqueId(), "staffInventory", contents[0]);
                EditObject.editPlayer(player.getUniqueId(), "staffArmor", contents[1]);
                player.getInventory().clear();
                // Load Inventory
                LauncherItem.generate();
                player.getInventory().setItem(2, LauncherItem.launcher);
                VanishItem.generate();
                player.getInventory().setItem(8, VanishItem.vanish1);
                // Enable Staff Features
                VanishEvent.vanish(player);
                player.setAllowFlight(true);
                player.setFlying(true);
            }
            return true;
        }
    }
    return false;
}

}
