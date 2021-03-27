package com.infinitycraft.plugin.storageManager;

import java.sql.PreparedStatement;
import java.util.UUID;

public class EditObject {

    public static void editPlayer(UUID ID, String setting, Object value) {
        try (PreparedStatement editPlayer = SQLDatabase.connection.prepareStatement("UPDATE players SET " + setting + " = ? WHERE UUID = ?")) {
            editPlayer.setObject(1, value);
            editPlayer.setString(2, String.valueOf(ID));
            editPlayer.execute();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }

    public static void editItem(Integer ID, String setting, Object value) {
        try (PreparedStatement editItem = SQLDatabase.connection.prepareStatement("UPDATE items SET " + setting + " = ? WHERE ID = ?")) {
            editItem.setObject(1, value);
            editItem.setInt(2, ID);
            editItem.execute();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }

    public static void editBlock(Integer ID, String setting, Object value) {
        try (PreparedStatement editBlock = SQLDatabase.connection.prepareStatement("UPDATE blocks SET " + setting + " = ? WHERE ID = ?")) {
            editBlock.setObject(1, value);
            editBlock.setInt(2, ID);
            editBlock.execute();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }

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
