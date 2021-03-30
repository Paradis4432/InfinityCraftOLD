package com.infinitycraft.plugin.storageManager;

import org.bukkit.Bukkit;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DatabaseManager {

    /**
     * Returns a Map containing all the SQL Tables and the command to make them
     *
     * @return Map with String (table name) and String2 (creation command)
     */
    public static Map<String, String> tableConfig() {
        // Setup Variable
        // Format: Table Name, SQL Command for creation
        Map<String, String> tables = new HashMap<>();
        // Player Table
        tables.put("players", "create table players ( UUID UNIQUEIDENTIFIER not null constraint players_pk primary key nonclustered )");
        // Blocks Table
        tables.put("blocks", "create table blocks ( ID int identity constraint blocks_pk primary key nonclustered )");
        // Items Table
        tables.put("items", "create table items ( ID int identity constraint items_pk primary key nonclustered )");
        // Settings Table
        tables.put("settings", "create table settings ( ID TEXT not null, Value TEXT not null )");
        // Return Map
        return tables;
    }

    /**
     * Column configuration for database
     *
     * @return Map containing how to make each column and its location
     */
    public static Map<ArrayList<String>, String> columnConfig() {
        // Setup Variables
        // Format: <Table Name, Column Name>, SQL command for creation
        Map<ArrayList<String>, String> columns = new HashMap<>();
        // Player Table
        ArrayList<String> prefix = new ArrayList<>(Arrays.asList("players", "prefix"));
        columns.put(prefix, "alter table players add prefix TEXT");
        ArrayList<String> suffix = new ArrayList<>(Arrays.asList("players", "suffix"));
        columns.put(suffix, "alter table players add suffix TEXT");
        ArrayList<String> chatColor = new ArrayList<>(Arrays.asList("players", "chatColor"));
        columns.put(chatColor, "alter table players add chatColor TEXT");
        ArrayList<String> balance = new ArrayList<>(Arrays.asList("players", "balance"));
        columns.put(balance, "alter table players add balance INT");
        // Blocks Table

        // Items Table

        // Settings Table

        // Return Map
        return columns;
    }

    /**
     * Simple function that checks whether the database is setup correctly or not
     */
    public static void start() {
        try {
            SQLDatabase.connect();
            for (Map.Entry<String, String> entry : tableConfig().entrySet()) {
                if (!checkTable(entry.getKey())) {
                    SQLDatabase.statement.execute(entry.getValue());
                }
            }
            for (Map.Entry<ArrayList<String>, String> entry : columnConfig().entrySet()) {
                if (!checkColumn(entry.getKey().get(0), entry.getKey().get(1))) {
                    SQLDatabase.statement.execute(entry.getValue());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            crash();
        }
    }

    /**
     * Simple function to stop the database safely in the case of a crash.
     */
    public static void crash() {
        try {
            SQLDatabase.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Bukkit.getLogger().severe("A fatal error occurred while setting up the SQL database. \nPlease make sure the database is fully functioning on azure and that all parameters are set up correctly.");
        Bukkit.getServer().shutdown();
    }

    /**
     * Simple function to stop the database safely.
     */
    public static void stop() {
        try {
            SQLDatabase.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Check if a column is in a database
     *
     * @param table  The table's name
     * @param column The column's name
     * @return Boolean - Whether the table exists or not
     * @throws SQLException SQLException
     */
    public static boolean checkColumn(String table, String column) throws SQLException {
        DatabaseMetaData md = SQLDatabase.connection.getMetaData();
        ResultSet rs = md.getColumns(null, null, table, column);
        return rs.next();
    }

    /**
     * Checks if a table exists in a database
     *
     * @param table The table's name
     * @return Boolean - Whether table exists or not
     * @throws SQLException SQLException
     */
    public static Boolean checkTable(String table) throws SQLException {
        DatabaseMetaData md = SQLDatabase.connection.getMetaData();
        ResultSet rs = md.getTables(null, null, table, null);
        return rs.next();
    }
}
