package com.infinitycraft.plugin.skyblock.market;

import com.infinitycraft.plugin.general.tools.permissions.CheckPermission;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class AddItemsToMarketCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        //add command args:
        // /add [desired price] [desired stock]
        // name will be the same as the item in hand,

        if(!(sender instanceof Player)){
            sender.sendMessage("You can't run this command on console");
        }

        Player player = (Player) sender;


        if(CheckPermission.checkPerm("market.add", player)){
            player.sendMessage("test");
            if(args.length != 1){
                player.sendMessage(ChatColor.DARK_RED + "To use this command do: /add [desired price] [desired stock]");
                return true;
            }

            String itemInHand = player.getInventory().getItemInMainHand().getItemMeta().getDisplayName();

            player.sendMessage(itemInHand);

        }


        return true;
    }
}
