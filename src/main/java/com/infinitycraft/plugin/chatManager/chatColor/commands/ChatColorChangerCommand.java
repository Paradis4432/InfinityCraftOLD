package com.infinitycraft.plugin.chatManager.chatColor.commands;

import com.infinitycraft.plugin.chatManager.chatColor.GUIs.ChatColorChanger;
import com.infinitycraft.plugin.utilities.CheckPermission;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ChatColorChangerCommand implements CommandExecutor {

    /**
     * Command to open the chatColor GUI!
     * @param sender The sender of the command
     * @param cmd The command
     * @param label The label of the command
     * @param args The arguments supplied
     * @return Whether or not the command was used properly
     */
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args) {
        // Check if terminal is being used
        if(!(sender instanceof Player)){
            sender.sendMessage("You can't run this command in the console!");
            return true;
        }
        if (CheckPermission.checkPerm("chat.color", (Player) sender)) {
            ChatColorChanger.openGUI((Player) sender);
        }
        return true;
    }


}
