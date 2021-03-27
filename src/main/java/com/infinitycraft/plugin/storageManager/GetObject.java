package com.infinitycraft.plugin.storageManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;

public class GetObject {
    /**
     * Get a setting from a player
     * @param ID The ID of the player
     * @param setting The setting to get
     * @return The setting in its original form (string, int, object, bool, etc.)
     */
    public static Object getPlayer(UUID ID, String setting) {
        try (PreparedStatement getPlayer = SQLDatabase.connection.prepareStatement("SELECT " + setting + " FROM players WHERE UUID = ?")) {
            getPlayer.setString(1, String.valueOf(ID));
            ResultSet rs = getPlayer.executeQuery();if (rs.next()) {
                return rs.getObject(1);
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * Get a setting from a item
     * @param ID The ID of the item
     * @param setting The setting to get
     * @return The setting in its original form (string, int, object, bool, etc.)
     */
    public static Object getItem(Integer ID, String setting) {
        try (PreparedStatement getItem = SQLDatabase.connection.prepareStatement("SELECT " + setting + " FROM items WHERE ID = ?")) {
            getItem.setInt(1, ID);
            ResultSet rs = getItem.executeQuery();if (rs.next()) {
                return rs.getObject(1);
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * Get a setting from a block
     * @param ID The ID of the block
     * @param setting The setting to get
     * @return The setting in its original form (string, int, object, bool, etc.)
     */
    public static Object getBlock(Integer ID, String setting) {
        try (PreparedStatement getBlock = SQLDatabase.connection.prepareStatement("SELECT " + setting + " FROM blocks WHERE ID = ?")) {
            getBlock.setInt(1, ID);
            ResultSet rs = getBlock.executeQuery();if (rs.next()) {
                return rs.getObject(1);
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * Get a setting from a setting
     * @param ID The ID of the setting
     * @return The setting in its original form (string, int, object, bool, etc.)
     */
    public static String getSetting(String ID) {
        try (PreparedStatement getSetting = SQLDatabase.connection.prepareStatement("SELECT Value FROM settings WHERE ID = ?")) {
            getSetting.setString(1, ID);
            ResultSet rs = getSetting.executeQuery();if (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
