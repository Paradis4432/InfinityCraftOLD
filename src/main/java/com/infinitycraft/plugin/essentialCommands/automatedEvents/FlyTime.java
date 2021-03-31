package com.infinitycraft.plugin.essentialCommands.automatedEvents;

import com.infinitycraft.plugin.storageManager.SQLDatabase;

import org.bukkit.scheduler.BukkitRunnable;

import java.sql.PreparedStatement;

public class FlyTime extends BukkitRunnable {

    @Override
    public void run() {
        try (PreparedStatement reduceTime = SQLDatabase.connection.prepareStatement("UPDATE players SET flyTime = players.flyTime - 1 where players.flyTime > 0")) {
            reduceTime.execute();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }
}
