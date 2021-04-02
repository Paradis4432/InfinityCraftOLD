package com.infinitycraft.plugin.essentialCommands;

import com.infinitycraft.plugin.chatManager.ColorCoder;
import com.infinitycraft.plugin.utilities.CheckPermission;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GetPossCommand implements CommandExecutor {
    /**
     * A simple /getposs command
     * @param sender The sender of the command
     * @param cmd The command
     * @param label The label of the command
     * @param args The commands arguments
     * @return Whether or not the command was used successfully
     * usage: /getposs [Player]
     * this will return players world, X, Y , Z,
     */

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if(!(sender instanceof Player)){
            sender.sendMessage("You can't do that in the console!");
            return true;
        }

        Player player = (Player) sender;

        if(CheckPermission.checkPerm("essentials.getposs", player)){
            if(args.length == 0){
                player.sendMessage(ChatColor.DARK_RED + "Usage: getposs [Player]");
                return true;
            }

            Player target = Bukkit.getServer().getPlayer(args[0]);

            if(target == null){
                player.sendMessage(ChatColor.DARK_RED + "Player not found");
                return true;
            }else{
                Location loc = target.getLocation();
                player.sendMessage(ChatColor.DARK_GREEN + "The location of " + target.getName() + " is " + loc.getX() + loc.getY() + loc.getZ() + " in world " + loc.getWorld());
                return true;
            }

        }

        return true;
    }
}
