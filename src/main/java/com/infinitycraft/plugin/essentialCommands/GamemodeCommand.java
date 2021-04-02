package com.infinitycraft.plugin.essentialCommands;

import com.infinitycraft.plugin.chatManager.ColorCoder;
import com.infinitycraft.plugin.utilities.CheckPermission;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GamemodeCommand implements CommandExecutor {

    /**
     * A simple /gm command
     * @param sender The sender of the command
     * @param cmd The command
     * @param label The label of the command
     * @param args The commands arguments
     * @return Whether or not the command was used successfully
     * usage: /[gm/gamemode] [0/1/2] [Player]
     */

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args){

        if(!(sender instanceof Player)){
            sender.sendMessage("You can't run this command in the console");
            return true;
        }

        Player player = (Player) sender;

        if(args.length == 0){
            if(CheckPermission.checkPerm("essentials.gamemode", player)){
                player.sendMessage(ColorCoder.convertColor("&cUsage: gamemode [0/1/2] [player]"));
            }
        }
        if(args[2] == null){
            switch (args[1]) {
                case "0":
                    if (CheckPermission.checkPerm("essentials.gamemode.0", player)) {
                        player.setGameMode(GameMode.SURVIVAL);
                        player.sendMessage(ChatColor.DARK_GREEN + "Gamemode set to Survival.");
                        return true;
                    }
                    break;
                case "1":
                    if (CheckPermission.checkPerm("essentials.gamemode.1", player)) {
                        player.setGameMode(GameMode.CREATIVE);
                        player.sendMessage(ChatColor.DARK_GREEN + "Gamemode set to Creative.");
                        return true;
                    }
                    break;
                case "2":
                    if (CheckPermission.checkPerm("essentials.gamemode.2", player)) {
                        player.setGameMode(GameMode.SPECTATOR);
                        player.sendMessage(ChatColor.DARK_GREEN + "Gamemode set to Spectator.");
                        return true;
                    }
                    break;
                default:
                    player.sendMessage(ChatColor.DARK_RED + "Invalid Argument!");
                    return true;
            }
        }

        Player target = Bukkit.getServer().getPlayer(args[2]);

        if(target != null){
            if(CheckPermission.checkPerm("essentials.gamemode.admin", player)){
                switch (args[1]) {
                    case "0":
                        target.setGameMode(GameMode.SURVIVAL);
                        target.sendMessage(ChatColor.DARK_GREEN + "Your gamemode has been changed to Survival by " + player.getName());
                        player.sendMessage(ChatColor.DARK_GREEN + "You changed the gamemode of " + target.getName() + " to Survival");
                        return true;
                    case "1":
                        target.setGameMode(GameMode.CREATIVE);
                        target.sendMessage(ChatColor.DARK_GREEN + "Your gamemode has been changed to Creative by " + player.getName());
                        player.sendMessage(ChatColor.DARK_GREEN + "You changed the gamemode of " + target.getName() + " to Creative");
                        return true;
                    case "2":
                        target.setGameMode(GameMode.SPECTATOR);
                        target.sendMessage(ChatColor.DARK_GREEN + "Your gamemode has been changed to Spectator by " + player.getName());
                        player.sendMessage(ChatColor.DARK_GREEN + "You changed the gamemode of " + target.getName() + " to Spectator");
                        return true;
                    default:
                        player.sendMessage(ChatColor.DARK_RED + "Invalid Argument!");
                        break;
                }
            }
        }

        return false;
    }
}
