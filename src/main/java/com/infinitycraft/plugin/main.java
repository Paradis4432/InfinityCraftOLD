package com.infinitycraft.plugin;

import com.infinitycraft.plugin.chatManager.events.BasicChatEvent;
import com.infinitycraft.plugin.chatManager.chatColor.commands.ChatColorChangerCommand;
import com.infinitycraft.plugin.chatManager.chatColor.events.ChatColorChangerEvent;
import com.infinitycraft.plugin.chatManager.affixes.commands.affixesCommand;
import com.infinitycraft.plugin.chatManager.affixes.events.AffixesGUIEvents;
import com.infinitycraft.plugin.chatManager.affixes.events.PositionSelectorEvents;
import com.infinitycraft.plugin.storageManager.DatabaseManager;
import com.infinitycraft.plugin.storageManager.StorageAutomation;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class main extends JavaPlugin {
    /**
     * Global instance of plugin.
     */
    private static main instance;

    /**
     * Makes plugin global
     *
     * @return plugin
     */
    public static main getInstance() {
        return instance;
    }

    /**
     * Plugin startup logic
     */
    @Override
    public void onEnable() {
        // Setup global instance
        instance = this;
        // Connect to database
        try {
            DatabaseManager.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Register Events
        registerEvents();
        // Register Commands
        registerCommands();
        // Send message
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "InfinityCraft Enabled");
    }

    /**
     * Plugin shutoff logic
     */
    @Override
    public void onDisable() {
        // Disconnect from database
        try {
            DatabaseManager.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Send message
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "InfinityCraft Disabled");
    }

    /**
     * Registers all the events!
     */
    public void registerEvents() {
        getServer().getPluginManager().registerEvents(new AffixesGUIEvents(), this);
        getServer().getPluginManager().registerEvents(new PositionSelectorEvents(), this);
        getServer().getPluginManager().registerEvents(new ChatColorChangerEvent(), this);
        getServer().getPluginManager().registerEvents(new BasicChatEvent(), this);
        getServer().getPluginManager().registerEvents(new StorageAutomation(), this);
    }

    /**
     * Registers all the commands!
     */
    public void registerCommands() {
        Objects.requireNonNull(this.getCommand("chatcolor")).setExecutor(new ChatColorChangerCommand());
        Objects.requireNonNull(this.getCommand("affixes")).setExecutor(new affixesCommand());
    }


}