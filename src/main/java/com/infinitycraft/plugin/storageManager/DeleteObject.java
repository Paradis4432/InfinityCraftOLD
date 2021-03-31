package com.infinitycraft.plugin.storageManager;

import java.sql.PreparedStatement;
import java.util.UUID;

public class DeleteObject {
    /**
     * Deletes the player with the specified UUID
     * @param ID The UUID of the player
     */
    public static void deletePlayer(UUID ID) {
        try (PreparedStatement deletePlayer = SQLDatabase.connection.prepareStatement("DELETE FROM players WHERE UUID = UNHEX(?)")) {
            deletePlayer.setString(1, String.valueOf(ID).replaceAll("-", ""));
            deletePlayer.execute();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Deletes the item with the specified ID
     * @param ID The ID of the item
     */
    public static void deleteItem(Integer ID) {
        try (PreparedStatement deleteItem = SQLDatabase.connection.prepareStatement("DELETE FROM items WHERE ID = ?")) {
            deleteItem.setInt(1, ID);
            deleteItem.execute();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Deletes the block with the specified ID
     * @param ID The ID of the block
     */
    public static void deleteBlock(Integer ID) {
        try (PreparedStatement deleteBlock = SQLDatabase.connection.prepareStatement("DELETE FROM blocks WHERE ID = ?")) {
            deleteBlock.setInt(1, ID);
            deleteBlock.execute();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Deletes the setting with the specified ID
     * @param ID The ID of the setting
     */
    public static void deleteSetting(String ID) {
        try (PreparedStatement deleteSetting = SQLDatabase.connection.prepareStatement("DELETE FROM settings WHERE ID = ?")) {
            deleteSetting.setString(1, ID);
            deleteSetting.execute();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }
}
