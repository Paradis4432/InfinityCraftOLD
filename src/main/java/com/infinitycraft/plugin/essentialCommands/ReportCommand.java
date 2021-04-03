package com.infinitycraft.plugin.essentialCommands;

import com.infinitycraft.plugin.storageManager.EditObject;
import com.infinitycraft.plugin.storageManager.GetObject;
import com.infinitycraft.plugin.utilities.CheckPermission;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ReportCommand implements CommandExecutor {
    /**
     * A simple /upvote command
     * @param sender The sender of the command
     * @param cmd The command
     * @param label The label of the command
     * @param args The commands arguments
     * @return Whether or not the command was used successfully
     */
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("You can't run this command in the console!");
            return true;
        }

        Player player = (Player) sender;
        if (args.length == 0) {
            if (CheckPermission.checkPerm("essentials.report", player)) {
                player.sendMessage(ChatColor.DARK_RED + "Please specify a player when running this command.");
                return true;
            }
        }
        Player target = Bukkit.getServer().getPlayer(args[0]);
        if (target == null) {
            player.sendMessage(ChatColor.DARK_RED + "Looks like that player is offline or hasn't joined this server yet!");
            return true;
        }
        if(CheckPermission.checkPerm("essentials.report", player)){
            if (player.getName().equals(args[0])) {
                player.sendMessage(ChatColor.DARK_RED + "You can't report yourself!");
            }
            else {
                EditObject.editPlayer(target.getUniqueId(), "reports", (Integer) GetObject.getPlayer(target.getUniqueId(), "reports") + 1);
                target.sendMessage(ChatColor.DARK_GREEN + "You reported " + player.getName() + "!");
            }
            return true;
        }
        return false;
    }
    public static void checkPunishment(Player target) {
        Integer reports = (Integer) GetObject.getPlayer(target.getUniqueId(), "reports");
        Integer upvotes = (Integer) GetObject.getPlayer(target.getUniqueId(), "upvotes");
        Integer score = upvotes - reports;
    }
}
