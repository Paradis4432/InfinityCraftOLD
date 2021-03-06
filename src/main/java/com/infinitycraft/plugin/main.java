package com.infinitycraft.plugin;

import com.infinitycraft.plugin.general.authentication.TwoFactorAuthEvent;
import com.infinitycraft.plugin.general.authentication.TwoFactorAuthGen;
import com.infinitycraft.plugin.general.chat.ChatHandler;
import com.infinitycraft.plugin.general.chat.chatColor.commands.ChatColorChangerCommand;
import com.infinitycraft.plugin.general.chat.chatColor.events.ChatColorChangerEvent;
import com.infinitycraft.plugin.general.chat.affixes.commands.AffixesCommand;
import com.infinitycraft.plugin.general.chat.affixes.events.AffixesGUIEvents;
import com.infinitycraft.plugin.general.chat.affixes.events.PositionSelectorEvents;
import com.infinitycraft.plugin.general.essentials.*;
import com.infinitycraft.plugin.general.essentials.automatedEvents.FlyTime;
import com.infinitycraft.plugin.general.essentials.automatedEvents.PlayTime;
import com.infinitycraft.plugin.general.fun.BetterPearls;
import com.infinitycraft.plugin.general.settings.VisibilityCommand;
import com.infinitycraft.plugin.general.staffMode.commands.NickCommand;
import com.infinitycraft.plugin.general.staffMode.commands.StaffCommand;
import com.infinitycraft.plugin.general.staffMode.commands.VanishCommand;
import com.infinitycraft.plugin.general.staffMode.events.GUIs.*;
import com.infinitycraft.plugin.general.staffMode.events.MainStaffEvent;
import com.infinitycraft.plugin.general.staffMode.events.items.*;
import com.infinitycraft.plugin.general.storageManager.*;
import com.infinitycraft.plugin.skyblock.craftingSystem.commands.CraftsCommand;
import com.infinitycraft.plugin.skyblock.craftingSystem.commands.CreateCraftCommand;
import com.infinitycraft.plugin.skyblock.craftingSystem.events.CraftSelectorEvents;
import com.infinitycraft.plugin.skyblock.craftingSystem.events.CreateCraftEvents;
import com.infinitycraft.plugin.skyblock.craftingSystem.events.TierGUIEvents;
import com.infinitycraft.plugin.skyblock.IslandSystem.commands.IslandCommand;
import com.infinitycraft.plugin.skyblock.market.AddItemsToMarketCommand;
import com.infinitycraft.plugin.skyblock.market.MainGUI;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

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
        // Register Schedgules
        registerSchedgules();
        // Send message
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "InfinityCraft Plugin Enabled");

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
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "InfinityCraft Plugin Disabled");
    }

    /**
     * Registers all the events!
     */
    public void registerEvents() {
        getServer().getPluginManager().registerEvents(new AffixesGUIEvents(), this);
        getServer().getPluginManager().registerEvents(new PositionSelectorEvents(), this);
        getServer().getPluginManager().registerEvents(new ChatColorChangerEvent(), this);
        getServer().getPluginManager().registerEvents(new ChatHandler(), this);
        getServer().getPluginManager().registerEvents(new StorageAutomation(), this);
        getServer().getPluginManager().registerEvents(new LauncherEvent(), this);
        getServer().getPluginManager().registerEvents(new VanishEvent(), this);
        getServer().getPluginManager().registerEvents(new RandomTeleportEvent(), this);
        getServer().getPluginManager().registerEvents(new FakeKickEvent(), this);
        getServer().getPluginManager().registerEvents(new MainStaffEvent(), this);
        getServer().getPluginManager().registerEvents(new StaffMenuItemEvent(), this);
        getServer().getPluginManager().registerEvents(new StaffMenuEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerMenuEvent(), this);
        getServer().getPluginManager().registerEvents(new StaffPlayerMenuEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerInfoMenuEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerActionMenuEvent(), this);
        getServer().getPluginManager().registerEvents(new TwoFactorAuthEvent(), this);
        getServer().getPluginManager().registerEvents(new CraftSelectorEvents(), this);
        getServer().getPluginManager().registerEvents(new TierGUIEvents(), this);
        getServer().getPluginManager().registerEvents(new BetterPearls(), this);
        getServer().getPluginManager().registerEvents(new CreateCraftEvents(), this);
    }

    /**
     * Registers all the commands!
     */
    public void registerCommands() {
        Objects.requireNonNull(this.getCommand("chatcolor")).setExecutor(new ChatColorChangerCommand());
        Objects.requireNonNull(this.getCommand("affixes")).setExecutor(new AffixesCommand());
        Objects.requireNonNull(this.getCommand("feed")).setExecutor(new FeedCommand());
        Objects.requireNonNull(this.getCommand("fly")).setExecutor(new FlyCommand());
        Objects.requireNonNull(this.getCommand("heal")).setExecutor(new HealCommand());
        Objects.requireNonNull(this.getCommand("time")).setExecutor(new TimeCommand());
        Objects.requireNonNull(this.getCommand("day")).setExecutor(new DayCommand());
        Objects.requireNonNull(this.getCommand("night")).setExecutor(new NightCommand());
        Objects.requireNonNull(this.getCommand("invsee")).setExecutor(new InvseeCommand());
        Objects.requireNonNull(this.getCommand("balance")).setExecutor(new BalanceCommand());
        Objects.requireNonNull(this.getCommand("editbalance")).setExecutor(new BalanceEditCommand());
        Objects.requireNonNull(this.getCommand("baltop")).setExecutor(new BalTopCommand());
        Objects.requireNonNull(this.getCommand("gm")).setExecutor(new GamemodeCommand());
        Objects.requireNonNull(this.getCommand("full")).setExecutor(new FullCommand());
        Objects.requireNonNull(this.getCommand("GetPos")).setExecutor(new GetPosCommand());
        Objects.requireNonNull(this.getCommand("broadcast")).setExecutor(new BroadcastCommand());
        Objects.requireNonNull(this.getCommand("upvote")).setExecutor(new UpvoteCommand());
        Objects.requireNonNull(this.getCommand("report")).setExecutor(new ReportCommand());
        Objects.requireNonNull(this.getCommand("playtime")).setExecutor(new PlayTimeCommand());
        Objects.requireNonNull(this.getCommand("staff")).setExecutor(new StaffCommand());
        Objects.requireNonNull(this.getCommand("vanish")).setExecutor(new VanishCommand());
        Objects.requireNonNull(this.getCommand("nick")).setExecutor(new NickCommand());
        Objects.requireNonNull(this.getCommand("2fa")).setExecutor(new TwoFactorAuthGen());
        Objects.requireNonNull(this.getCommand("crafts")).setExecutor(new CraftsCommand());
        Objects.requireNonNull(this.getCommand("visibility")).setExecutor(new VisibilityCommand());
        Objects.requireNonNull(this.getCommand("is")).setExecutor(new IslandCommand());
        Objects.requireNonNull(this.getCommand("market")).setExecutor(new MainGUI());
        Objects.requireNonNull(this.getCommand("add")).setExecutor(new AddItemsToMarketCommand());
        Objects.requireNonNull(this.getCommand("rename")).setExecutor(new RenameCommand());
        Objects.requireNonNull(this.getCommand("fix")).setExecutor(new FixCommand());
        Objects.requireNonNull(this.getCommand("createcraft")).setExecutor(new CreateCraftCommand());

    }

    /**
     * Schedule all the events!
     */
    public void registerSchedgules() {
        BukkitScheduler scheduler = getServer().getScheduler();
        BukkitTask flyTime = new FlyTime().runTaskTimer(this, 1200, 1200);
        BukkitTask playTime = new PlayTime().runTaskTimer(this, 1200, 1200);
    }
}