package com.infinitycraft.plugin.general.storageManager;

import java.sql.PreparedStatement;
import java.util.UUID;

public class EditObject {
    /**
     * Edit a player in the database.
     * @param ID The UUID of the player.
     * @param setting The setting to change.
     * @param value The value to set the setting to.
     */
    public static void editPlayer(UUID ID, String setting, Object value) {
        try (PreparedStatement editPlayer = SQLDatabase.connection.prepareStatement("UPDATE players SET " + setting + " = ? WHERE UUID = UNHEX(?)")) {
            editPlayer.setObject(1, value);
            editPlayer.setString(2, String.valueOf(ID).replaceAll("-", ""));
            editPlayer.execute();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }
    /**
     * Edit an item in the database.
     * @param ID The ID of the item.
     * @param setting The setting to change.
     * @param value The value to set the setting to.
     */
    public static void editItem(Integer ID, String setting, Object value) {
        try (PreparedStatement editItem = SQLDatabase.connection.prepareStatement("UPDATE items SET " + setting + " = ? WHERE ID = ?")) {
            editItem.setObject(1, value);
            editItem.setInt(2, ID);
            editItem.execute();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }
    /**
     * Edit a block in the database.
     * @param ID The ID of the block.
     * @param setting The setting to change.
     * @param value The value to set the setting to.
     */
    public static void editBlock(Integer ID, String setting, Object value) {
        try (PreparedStatement editBlock = SQLDatabase.connection.prepareStatement("UPDATE blocks SET " + setting + " = ? WHERE ID = ?")) {
            editBlock.setObject(1, value);
            editBlock.setInt(2, ID);
            editBlock.execute();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }
    /**
     * Edit a setting in the database.
     * @param ID The ID of the setting.
     * @param value The value to set the setting to.
     */
    public static void editSetting(String ID, Object value) {
        try (PreparedStatement editSetting = SQLDatabase.connection.prepareStatement("UPDATE settings SET Value = ? WHERE ID = ?")) {
            editSetting.setObject(1, value);
            editSetting.setString(2, ID);
            editSetting.execute();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }
}
