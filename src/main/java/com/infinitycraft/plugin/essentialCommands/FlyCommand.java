package com.infinitycraft.plugin.essentialCommands;

import com.infinitycraft.plugin.chatManager.ColorCoder;
import com.infinitycraft.plugin.utilities.CheckPermission;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FlyCommand implements CommandExecutor {

    /**
     * A simple /fly command
     * @param sender The sender of the command
     * @param cmd The command
     * @param label The label of the command
     * @param args The commands arguments
     * @return Whether or not the command was used successfully
     */
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("You can't run this command in the console!");
            return true;
        }
        Player player =(Player) sender;
            if (args.length == 0) {
                // if players has flyTime left enable or has perm essentials.fly
                // enable fly

                // else you cant use that
                    if (CheckPermission.checkPerm("essentials.fly", player)) {
                        if (player.isFlying()) {
                            player.setAllowFlight(false);
                            player.setFlying(false);
                            player.sendMessage(ColorCoder.convertColor("&6Fly disabled"));
                            return true;
                        } else {
                            player.setAllowFlight(true);
                            player.setFlying(true);
                            player.sendMessage(ColorCoder.convertColor("&6Fly enabled"));
                            return true;
                        }
                    }
            }
            // fly for other players
            Player target = Bukkit.getServer().getPlayer(args[0]);
            if(target == null){
                sender.sendMessage("&cPlayer not found");
                return true;
            }
            //
            if(CheckPermission.checkPerm("essentials.fly.others", player)){
                target.setAllowFlight(true);
                target.setFlying(true);
                target.sendMessage(ColorCoder.convertColor("&6Fly enabled by " + player.getName()));
                player.sendMessage(ColorCoder.convertColor("&6Fly enabled for " + target.getName()));
                return true;
            }


        return false;
    }
}
