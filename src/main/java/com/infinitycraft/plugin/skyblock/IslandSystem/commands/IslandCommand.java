package com.infinitycraft.plugin.skyblock.IslandSystem.commands;

import com.infinitycraft.plugin.skyblock.IslandSystem.tools.Island;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class IslandCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("You can't run this command in the console!");
            return true;
        }
        Player player = (Player) sender;
        if (args.length == 0) {
            if (!Island.check(player)) {
                Island.create(player);
            }
            Island.teleport(player);
            return true;
        }
        else if (args.length == 1) {
            if (args[0].equals("delete")) {
                Island.delete(player);
                return true;
            }
        }
        player.sendMessage(ChatColor.RED + "Incorrect command usage! Please use \"/is <delete>\"!");
        return true;
    }
}
