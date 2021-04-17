package com.infinitycraft.plugin.skyblock.craftingSystem.commands;

import com.infinitycraft.plugin.general.tools.permissions.CheckPermission;
import com.infinitycraft.plugin.skyblock.craftingSystem.customGUIs.CreateCraftGUI;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CreateCraftCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {



        if(!(sender instanceof Player)){
            sender.sendMessage("You can't run this command on console");
            return true;
        }

        Player player = (Player) sender;

        if(CheckPermission.checkPerm("crafts.create", player)){
            if(args.length == 0){
                new CreateCraftGUI().OpenGUI(player);
                return true;
            }

        }



        return true;
    }
}
