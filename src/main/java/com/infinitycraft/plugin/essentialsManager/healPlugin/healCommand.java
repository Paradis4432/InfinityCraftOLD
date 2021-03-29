package com.infinitycraft.plugin.essentialsManager.healPlugin;

import com.infinitycraft.plugin.chatManager.ColorCoder;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class healCommand extends JavaPlugin {

    public void onEnable() {
        Bukkit.getServer().getLogger().info("Heal Command Enabled");
    }

    public void onDisable() {
        Bukkit.getServer().getLogger().info("Heal Command Disabled");
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("You cant do that");
        }

        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("heal")) {
            if (args.length == 0) {
                if (player.hasPermission("essentials.heal")) {
                    player.setHealth(20);
                    player.sendMessage(ColorCoder.convertColor("&6You have been healed"));
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
            if (sender.hasPermission("essentials.heal.others")) {
                target.setHealth(20);
                target.sendMessage(ColorCoder.convertColor("&6You have been healed by " + player.getName()));
                sender.sendMessage(ColorCoder.convertColor("&6You healed " + target.getName()));
            }
            else{
                player.sendMessage(ColorCoder.convertColor("&cYou don't have permission to use that command!"));
            }
        }
        return false;
    }
}
