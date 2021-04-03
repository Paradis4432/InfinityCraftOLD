package com.infinitycraft.plugin.storageManager;

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
    public static void newPlayer(UUID ID, @Nullable String prefix, @Nullable String suffix, @Nullable String chatColor, @Nullable Integer balance,  @Nullable Integer flyTime, @Nullable boolean online) {
        if (prefix == null) {
            prefix = "";
        }
        if (suffix == null) {
            suffix = "";
        }
        if (chatColor == null) {
            chatColor = "";
        }
        if (balance == null) {
            balance = 0;
        }
        if (flyTime == null) {
            flyTime = 0;
        }
        try (PreparedStatement newPlayer = SQLDatabase.connection.prepareStatement("INSERT INTO players (UUID, prefix, suffix, chatColor, balance, flyTime, name, online) VALUES ( UNHEX(?), ?, ?, ?, ?, ?, ?, ?)")) {
            newPlayer.setString(1, String.valueOf(ID).replaceAll("-", ""));
            newPlayer.setString(2, prefix);
            newPlayer.setString(3, suffix);
            newPlayer.setString(4, chatColor);
            newPlayer.setInt(5 , balance);
            newPlayer.setInt(6 ,flyTime);
            newPlayer.setString(7, "");
            newPlayer.setBoolean(8, online);
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
