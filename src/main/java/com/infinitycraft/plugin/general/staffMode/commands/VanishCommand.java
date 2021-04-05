package com.infinitycraft.plugin.general.staffMode.commands;

import com.infinitycraft.plugin.general.staffMode.events.items.VanishEvent;
import com.infinitycraft.plugin.general.storageManager.GetObject;
import com.infinitycraft.plugin.general.tools.permissions.CheckPermission;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class VanishCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("You can't run this command in the console!");
            return true;
        }
        Player player = (Player) sender;
        if (CheckPermission.checkPerm("essentials.vanish", player)) {
            if ((boolean) GetObject.getPlayer(player.getUniqueId(), "vanished")) {
                VanishEvent.unvanish(player);
                return true;
            }
            else {
                VanishEvent.vanish((Player) sender);
                return true;
            }
        }
        return false;
    }
}
