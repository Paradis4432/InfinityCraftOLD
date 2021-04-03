package com.infinitycraft.plugin.essentialCommands.automatedEvents;

import com.infinitycraft.plugin.main;
import com.infinitycraft.plugin.storageManager.SQLDatabase;

import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

import java.sql.PreparedStatement;

public class FlyTime extends BukkitRunnable {
    @Override
    public void run() {
        try (PreparedStatement reduceTime = SQLDatabase.connection.prepareStatement("UPDATE players set flyTime = players.flyTime-1 where flyTime > 0 AND online = true")) {
            reduceTime.execute();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }
}

