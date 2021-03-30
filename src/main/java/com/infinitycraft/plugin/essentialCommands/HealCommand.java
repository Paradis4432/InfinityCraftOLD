package com.infinitycraft.plugin.essentialCommands;

import com.infinitycraft.plugin.chatManager.ColorCoder;
import com.infinitycraft.plugin.utilities.CheckPermission;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HealCommand implements CommandExecutor {

    /**
     * A simple /heal command
     * @param sender The sender of the command
     * @param cmd The command
     * @param label The label of the command
     * @param args The commands arguments
     * @return Whether or not the command was used successfully
     */
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("You can't run this command in the console!");
            return true;
        }

        Player player = (Player) sender;
            if (args.length == 0) {
                if (CheckPermission.checkPerm("essentials.heal", player)) {
                    player.setHealth(player.getHealthScale() * 20);
                    player.sendMessage(ColorCoder.convertColor("&6You have been healed"));
                    return true;
                }
            }
            Player target = Bukkit.getServer().getPlayer(args[0]);
            if (target == null) {
                sender.sendMessage(ColorCoder.convertColor("&cCould not find player!"));
                return true;
            }
            if (CheckPermission.checkPerm("essentials.heal.others", player)) {
                target.setHealth(player.getHealthScale() * 20);
                target.sendMessage(ColorCoder.convertColor("&6You have been healed by " + player.getName() + "."));
                sender.sendMessage(ColorCoder.convertColor("&6You healed " + target.getName() + "."));
                return true;
            }
        return false;
    }
}
