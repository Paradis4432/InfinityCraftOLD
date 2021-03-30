package com.infinitycraft.plugin.essentialCommands;

import com.infinitycraft.plugin.chatManager.ColorCoder;
import com.infinitycraft.plugin.utilities.CheckPermission;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class TimeSetCommand implements CommandExecutor {

    /**
     * A simple /time command
     * @param sender The sender of the command
     * @param cmd The command
     * @param label The label of the command
     * @param args The commands arguments
     * @return Whether or not the command was used successfully
     * time [set/add] [day/night/dawn/int/ticks]
     */

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args){

        if(!(sender instanceof Player)){
            sender.sendMessage("You can't do that on console");
            return true;
        }

        Player player = (Player) sender;
        if(args.length == 0){
            if(CheckPermission.checkPerm("essentials.time", player)){
                sender.sendMessage("time [set/add] [day/night/dawn/int/ticks]");
                return true;
            }
        } else if(args[1] == "set") {
            if(CheckPermission.checkPerm("essentials.time.set", player)){
                if(args[2] == null){
                    sender.sendMessage("time [set] [day/night/dawn/int/ticks]");
                    return true;
                }else{
                    try{
                        World w = player.getWorld();
                        w.setTime(Long.parseLong(args[2]));
                    }catch (NumberFormatException e){
                        sender.sendMessage(ColorCoder.convertColor("&cThere has been an error, Please contact the developers - Essentials-TimeSetCommand"));
                    }
                }
                if(args[2] == "day"){
                    World w = player.getWorld();
                    w.setTime(Long.parseLong("2000"));
                    return true;
                }
                if(args[2] == "dawn"){
                    World w = player.getWorld();
                    w.setTime(Long.parseLong("23041"));
                    return true;
                }
                if(args[2] == "night"){
                    World w = player.getWorld();
                    w.setTime(Long.parseLong("13000"));
                    return true;
                }


            }

        }else if(args[1] == "add"){
            if(CheckPermission.checkPerm("essentials.time.add", player)) {
                if (args[2] == null) {
                    sender.sendMessage("time [add] [int/ticks]");
                    return true;
                } else {
                    try {
                        World w = player.getWorld();
                        int time = Integer.parseInt(w.getTime() + args[2]);
                        w.setTime(time);
                    } catch (NumberFormatException e) {
                        sender.sendMessage(ColorCoder.convertColor("&cThere has been an error, Please contact the developers - Essentials-TimeSetCommand"));
                    }
                }
            }
        }

        return false;
    }
}
