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
     */
    public static void newPlayer(UUID ID, @Nullable String prefix, @Nullable String suffix, @Nullable String chatColor) {
        if (prefix == null) {
            prefix = "";
        }
        if (suffix == null) {
            suffix = "";
        }
        if (chatColor == null) {
            chatColor = "";
        }
        try (PreparedStatement newPlayer = SQLDatabase.connection.prepareStatement("INSERT INTO players (UUID, prefix, suffix, chatColor) VALUES (?, ?, ?, ?)")) {
            newPlayer.setString(1, String.valueOf(ID));
            newPlayer.setString(2, prefix);
            newPlayer.setString(3, suffix);
            newPlayer.setString(3, chatColor);
            newPlayer.execute();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Creates a new block!
     * @return ID of block.
     */
    public static int newItem() {
        try (PreparedStatement newItem = SQLDatabase.connection.prepareStatement("INSERT INTO items () output inserted.ID values ()")) {
            ResultSet rs = newItem.executeQuery();
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
     * @return ID of item.
     */
    public static int newBlock() {
        try (PreparedStatement newBlock = SQLDatabase.connection.prepareStatement("INSERT INTO blocks () output inserted.ID values ()")) {
            ResultSet rs = newBlock.executeQuery();
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
