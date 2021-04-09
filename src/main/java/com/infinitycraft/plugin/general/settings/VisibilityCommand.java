package com.infinitycraft.plugin.general.settings;

import com.infinitycraft.plugin.main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class VisibilityCommand implements CommandExecutor {
    public static List<Player> visibilityPlayers = new ArrayList<>();
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("You can't run this command in the console!");
            return true;
        }
        Player player = (Player) sender;
        if (visibilityPlayers.contains(player)) {
            visibilityPlayers.remove(player);
            for (Player players : Bukkit.getOnlinePlayers()) {
                player.showPlayer(main.getInstance(), players);
            }
        }
        else {
            visibilityPlayers.add(player);
            for (Player players : Bukkit.getOnlinePlayers()) {
                player.hidePlayer(main.getInstance(), players);
            }
        }
        return true;
    }
}
