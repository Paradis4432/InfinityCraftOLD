package com.infinitycraft.plugin.essentialCommands;

import com.infinitycraft.plugin.utilities.CheckPermission;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class InvseeCommand  implements CommandExecutor {


    /**
     * A simple /invsee command
     * @param sender The sender of the command
     * @param cmd The command
     * @param label The label of the command
     * @param args The commands arguments
     * @return Whether or not the command was used successfully
     * invsee [Player]
     */


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("You can't run this command in the console!");
            return true;
        }
        Player player = (Player) sender;
        if(CheckPermission.checkPerm("essentials.invsee",player)){
            if(args.length == 0){
                player.sendMessage("To use this command, run: invsee [Player]");
            }
            else{
                Player targetPlayer = Bukkit.getServer().getPlayer(args[0]);
                Inventory targetInv = targetPlayer.getInventory();
                player.openInventory(targetInv);
            }
        }

        return true;
    }
}
