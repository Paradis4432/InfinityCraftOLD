package com.infinitycraft.plugin.skyblock.IslandSystem.tools;

import com.infinitycraft.plugin.main;
import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Island {
    /** Creates a new island for a player
     *
     * @param player The player
     */
    public static void create(Player player) {
        if (!check(player)) {
            // Go To World Path
            File dataFolder = new File(main.getInstance().getDataFolder().getAbsolutePath());
            String strData = dataFolder.toString();
            File root = new File(strData.substring(0, strData.length() - 21));
            // Copy World
            File srcDir = new File(root+"\\island_template");
            // Check if exists
            if (!srcDir.exists()) {
                Bukkit.getLogger().warning("Backup does not exist!");
                return;
            }
            // Paste World
            File destDir = new File(root+"\\"+player.getUniqueId());
            // Make sure an exception doesnt occur
            try {
                FileUtils.copyDirectory(srcDir, destDir);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            // Setup World
            Bukkit.getServer().createWorld(new WorldCreator(String.valueOf(player.getUniqueId())));
            player.sendMessage(ChatColor.GREEN + "Successfully created an island for you!");
        }
        teleport(player);
    }

    /** Check's if a player has an island
     *
     * @param player The player
     * @return true: player has island, false: player doesn't have island
     */
    public static boolean check(Player player) {
        return Bukkit.getServer().getWorlds().contains(Bukkit.getWorld(player.getUniqueId().toString()));
    }

    /**
     * Deletes a player's world
     * @param player The player
     */
    public static void delete(Player player) {
        if (check(player)) {
            player.teleport(Bukkit.getWorld("world").getSpawnLocation());
            // Go To World Path
            File dir = new File(Bukkit.getServer().getWorld(player.getUniqueId().toString()).getWorldFolder().getPath());
            // Unload World
            Bukkit.getServer().unloadWorld(String.valueOf(player.getUniqueId()), true);
            // Delete World
            try {
                FileUtils.deleteDirectory(dir);
                player.sendMessage(ChatColor.GREEN + "Successfully deleted your island!");
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else {
            player.sendMessage(ChatColor.DARK_RED + "You don't have an island! Use /is to make one!");
        }
    }

    public static void teleport(Player player) {
        if (check(player)) {
            player.teleport(Bukkit.getWorld(String.valueOf(player.getUniqueId())).getSpawnLocation());
        }
    }
}
