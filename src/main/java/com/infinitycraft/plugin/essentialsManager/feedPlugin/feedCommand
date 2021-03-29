package com.infinitycraft.plugin.essentialsManager.feedPlugin;

import com.infinitycraft.plugin.chatManager.ColorCoder;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class feedCommand extends JavaPlugin {

    public void onEnable() {
        Bukkit.getServer().getLogger().info("Feed Command Enabled");
    }

    public void onDisable() {
        Bukkit.getServer().getLogger().info("Feed Command Disabled");
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("You cant do that");
        }

        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("feed")) {

            if (args.length == 0) {
                if (player.hasPermission("essentials.feed")) {
                    player.setFoodLevel(20);
                    player.sendMessage(ColorCoder.convertColor("&6You have been fed"));
                    return true;
                }
                else{
                    player.sendMessage(ColorCoder.convertColor("&cYou don't have permission to use that command!"));
                }
            }
            Player target = Bukkit.getServer().getPlayer(args[0]);
            if (target == null) {
                sender.sendMessage(ColorCoder.convertColor("&cCould not find player!"));
                return true;
            }
            if(sender.hasPermission("essentials.feed.others")){
                target.setFoodLevel(20);
                target.sendMessage(ColorCoder.convertColor("&6You have fed healed by " + player.getName()));
                sender.sendMessage(ColorCoder.convertColor("&6You fed " + target.getName()));
            }
            else{
                player.sendMessage(ColorCoder.convertColor("&cYou don't have permission to use that command!"));
            }
        }
        return false;
    }
}
