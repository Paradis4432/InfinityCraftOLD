package com.infinitycraft.plugin.skyblock.market;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MainGUI implements CommandExecutor {

    /**
     * every 5 seconds update GUI
     *
     */

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        ArrayList items = new ArrayList<>();

        Player player = (Player) sender;

        //Inventory marketGUI = Bukkit.createInventory(null,54, ChatColor.GOLD + "Market!");

        MarketRequestInformationFromSQL market = new MarketRequestInformationFromSQL();

        market.getPriceItemBlaze();

        for(int i = 0 ; i < items.size() ; i++){
            Bukkit.getLogger().info(String.valueOf(items.get(i)));
        }

        //player.openInventory(marketGUI);

        return true;
    }
}
