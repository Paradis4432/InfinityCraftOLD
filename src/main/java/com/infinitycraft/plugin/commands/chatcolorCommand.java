package com.infinitycraft.plugin.commands;

import com.infinitycraft.plugin.guis.chatcolorGui;
import com.infinitycraft.plugin.main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class chatcolorCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender,Command cmd,String label,String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("You cant do that on console!");
            return true;
        }

        Player p = (Player) sender;

        p.openInventory(chatcolorGui.gui(p));
        return false;
    }


}
