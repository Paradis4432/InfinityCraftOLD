package com.infinitycraft.plugin.skyblock;

import com.infinitycraft.plugin.skyblock.CraftsGUI.CraftsCommandItemArg.*;
import com.infinitycraft.plugin.skyblock.CraftsGUI.CraftsCommandNoArgs;
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
            new CraftsCommandNoArgs().ShowGUI(player);

            return true;
        }

        if(args.length == 1){
            switch (args[0]){
                case "rabbit":
                    new RawRabbitTierGUI().ShowTiers(player);
                    break;
                case "mutton":
                    new RawMuttonTierGUI().ShowTiers(player);
                    break;
                case "porkchop":
                    new RawPorckchopTierGUI().ShowTiers(player);
                    break;
                case "beef":
                    new RawBeefTierGUI().ShowTiers(player);
                    break;
                case "spider":
                    new SpiderEyeTierGUI().ShowTiers(player);
                    break;
                case "string":
                    new StringTierGUI().ShowTiers(player);
                    break;
                case "coal":
                    new CoalTierGUI().ShowTiers(player);
                    break;
                case "stick":
                    new StickTierGUI().ShowTiers(player);
                    break;
                case "bone":
                    new BoneTierGUI().ShowTiers(player);
                    break;
                case "slimeball":
                    new SlimeBallTierGUI().ShowTiers(player);
                    break;
                case "gold":
                    new GoldIngotTierGUI().ShowTiers(player);
                    break;
                case "redstone":
                    new RedstoneTierGUI().ShowTiers(player);
                    break;
                case "gunpowder":
                    new GunpowderTierGUI().ShowTiers(player);
                    break;
                case "blaze":
                    new BlazeRodTierGUI().ShowTiers(player);
                    break;
                case "emerald":
                    new EmeraldTierGUI().ShowTiers(player);
                    break;
                case "iron":
                    new IronIngotTierGUI().ShowTiers(player);
                    break;
                case "ender":
                    new EnderPearlTierGUI().ShowTiers(player);
                    break;
                case "diamond":
                    new DiamondTierGUI().ShowTiers(player);
                    break;
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
