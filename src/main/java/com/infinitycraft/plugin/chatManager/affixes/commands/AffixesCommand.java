package com.infinitycraft.plugin.chatManager.affixes.commands;

import com.infinitycraft.plugin.chatManager.affixes.GUIs.PositionSelectorGUI;
import com.infinitycraft.plugin.utilities.CheckPermission;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class AffixesCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("You can't run this command in the console!");
            return true;
        }
        if (CheckPermission.checkPerm("chat.affixes", (Player) sender)) {
            PositionSelectorGUI.openGUI((Player) sender);
        }
        return true;
    }
}
