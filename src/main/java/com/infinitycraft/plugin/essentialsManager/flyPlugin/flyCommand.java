package com.infinitycraft.plugin.essentialsManager.flyPlugin;

import com.infinitycraft.plugin.chatManager.ColorCoder;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class flyCommand extends JavaPlugin {

    public void onEnable(){
        Bukkit.getServer().getLogger().info("Fly Command Enabled");
    }

    public void onDisable(){
        Bukkit.getServer().getLogger().info("Fly Command Disabled");
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){

        if(!(sender instanceof Player)){
            sender.sendMessage("You cant do that");
        }

        Player player =(Player) sender;

        if(cmd.getName().equalsIgnoreCase("fly")) {
            if (args.length == 0) {
                if (player.hasPermission("essentials.fly")) {
                    if (player.isFlying()) {
                        player.setAllowFlight(false);
                        player.setFlying(false);
                        player.sendMessage(ColorCoder.convertColor("&6Fly disabled"));
                    } else {
                        player.setAllowFlight(true);
                        player.setFlying(true);
                        player.sendMessage(ColorCoder.convertColor("&6Fly enabled"));
                    }
                } else {
                    player.sendMessage(ColorCoder.convertColor("&cYou can't use that command"));
                }
            }
            Player target = Bukkit.getServer().getPlayer(args[0]);

            if(target == null){
                sender.sendMessage("&cPlayer not found");
                return true;
            }
            if(sender.hasPermission("essentials.fly.others")){
                target.setAllowFlight(true);
                target.setFlying(true);
                target.sendMessage(ColorCoder.convertColor("&6Fly enabled by " + player.getName()));
                player.sendMessage(ColorCoder.convertColor("&6Fly enabled for " + target.getName()));
            }else{
                sender.sendMessage(ColorCoder.convertColor("&cYou can't use that command"));
            }
            if(player.hasPermission("test")){
                
            }
        }
        return false;
    }
    // ADD SQL CHECK, RIGHT CLICK VOUNCHER, AND LAST ARG INT TO ADD TIME LEFT TO FlyTimeLeft
}
