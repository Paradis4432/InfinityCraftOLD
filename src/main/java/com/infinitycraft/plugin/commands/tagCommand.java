package com.infinitycraft.plugin.commands;

import com.infinitycraft.plugin.guis.tagsGui;
import com.infinitycraft.plugin.main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tagCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender,Command cmd,String label,String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("You cant do that on console!");
            return true;
        }

        Player p = (Player) sender;

        p.openInventory(tagsGui.gui(p));
        return false;
    }
}
