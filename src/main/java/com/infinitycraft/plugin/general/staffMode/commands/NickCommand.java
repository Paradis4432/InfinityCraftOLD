package com.infinitycraft.plugin.general.staffMode.commands;

import com.infinitycraft.plugin.general.storageManager.GetObject;
import com.infinitycraft.plugin.general.tools.permissions.CheckPermission;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class NickCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("You can't run this command in the console!");
            return true;
        }
        Player player = (Player) sender;
        if (args.length == 0) {
            if (CheckPermission.checkPerm("essentials.nick", player)) {
                player.sendMessage(ChatColor.GOLD + "Successfully reset your nick.");
                player.setDisplayName(player.getName());
                player.setCustomName(player.getName());
                player.setPlayerListName(player.getName());
                player.setCustomNameVisible(false);
                return true;
            }
        }
        if(CheckPermission.checkPerm("essentials.nick", player)){
            player.sendMessage("Successfully set your nick!");
            player.setDisplayName(args[0]);
            player.setCustomName(args[0]);
            player.setPlayerListName(args[0]);
            player.setCustomNameVisible(true);
            return true;
        }
        return false;
    }
}
