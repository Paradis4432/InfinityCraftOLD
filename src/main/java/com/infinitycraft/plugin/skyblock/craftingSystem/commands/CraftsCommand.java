package com.infinitycraft.plugin.skyblock.craftingSystem.commands;

import com.infinitycraft.plugin.skyblock.craftingSystem.customGUIs.CraftGUI;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CraftsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {

        if(!(sender instanceof Player)){
            sender.sendMessage("You  can't run this command on console!");

            return true;
        }

        //sender.sendMessage("test");

        Player player = (Player) sender;

        if (args.length == 0) {
            new CraftGUI().ShowGUI(player);

            return true;
        }

        if(args.length == 1){
            switch (args[0]){
                default:
                    break;

            }

        }

        if(args.length == 2){
            player.sendMessage(ChatColor.RED + "Please add the tier of the item you want to check: /crafts [Item] [Tier = Number]");

            return true;
        }

        if(args.length == 3){
            //open the tier on args[3] of the item in args[1]
        }

        return true;
    }
}
