package com.infinitycraft.plugin.general.storageManager;

import org.bukkit.entity.Player;

import javax.annotation.Nullable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;

public class NewObject {
    /**
     * Creates a new player in the database!
     * @param prefix Optional variable containing the prefix of the player.
     * @param suffix Optional variable containing the suffix of the player.
     * @param chatColor The color of chat
     * @param balance The amount of money they have.
     * @param flyTime The amount of time they can fly
     */
    public static void newPlayer(Player player) {
        try (PreparedStatement newPlayer = SQLDatabase.connection.prepareStatement("INSERT INTO players (UUID, prefix, suffix, chatColor, balance, flyTime, name, online, playTime, staffMode, staffInventory, staffArmor) VALUES ( UNHEX(?), '', '', '', 0, 0, ?, true, 0, false, '', '')")) {
            newPlayer.setString(1, String.valueOf(player.getUniqueId()).replaceAll("-", ""));
            newPlayer.setString(2, player.getName());
            newPlayer.execute();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Creates a new block!
     * @param permission The permission required to use the blocks
     * @return ID of block.
     */
    public static int newItem(@Nullable String permission) {
        if (permission == null) {
            permission = "";
        }
        try (PreparedStatement newItem = SQLDatabase.connection.prepareStatement("INSERT INTO items (permission) values (?);")) {
            newItem.setString(1, permission);
            newItem.execute();
            ResultSet rs = SQLDatabase.statement.executeQuery("SELECT LAST_INSERT_ID();");
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    /**
     * Create a new item!
     * @param permission The permission required to use the item.
     * @return ID of item.
     */
    public static int newBlock(@Nullable String permission) {
        if (permission == null) {
            permission = "";
        }
        try (PreparedStatement newBlock = SQLDatabase.connection.prepareStatement("INSERT INTO blocks (permission) values (?);")) {
            newBlock.setString(1, permission);
            newBlock.execute();
            ResultSet rs = SQLDatabase.statement.executeQuery("SELECT LAST_INSERT_ID();");

            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    /**
     * Creates a new setting for the server!
     * @param ID The name or ID of the setting.
     * @param Value The value of the setting.
     */
    public static void newSetting(String ID, String Value) {
        try (PreparedStatement newSetting = SQLDatabase.connection.prepareStatement("INSERT INTO settings (ID, Value) VALUES (?, ?)")) {
            newSetting.setString(1, ID);
            newSetting.setString(2, Value);
            newSetting.execute();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }
}
