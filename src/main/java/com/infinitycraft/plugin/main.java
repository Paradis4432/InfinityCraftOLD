package com.infinitycraft.plugin;

import com.infinitycraft.plugin.commands.chatcolorCommand;
import com.infinitycraft.plugin.commands.tagCommand;
import com.infinitycraft.plugin.guis.chatcolorGui;
import com.infinitycraft.plugin.guis.tagPossGui;
import com.infinitycraft.plugin.guis.tagsGui;
import com.infinitycraft.plugin.storageManager.SQLDatabase;
import com.infinitycraft.plugin.events.inventoryClickListener;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin{

    @Override
    public void onEnable() {
        try { SQLDatabase.connect(); } catch (Exception e) { e.printStackTrace(); }

        getCommand("tags").setExecutor(new tagCommand());
        getCommand("chatcolor").setExecutor(new chatcolorCommand());

        new inventoryClickListener(this);

        chatcolorGui.start();
        tagsGui.start();
        tagPossGui.start();

        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Infinity Chat Enabled");
    }

    @Override
    public void onDisable() {
        try { SQLDatabase.disconnect
                (); } catch (Exception e) { e.printStackTrace(); }

        getServer().getConsoleSender().sendMessage(ChatColor.RED + "Infinity Chat Disabled");
    }


}
