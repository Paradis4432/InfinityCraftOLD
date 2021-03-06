package com.infinitycraft.plugin.general.storageManager;

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
        tables.put("players", "create table players (UUID Binary(16) not null, constraint players_pk primary key (UUID) );");
        // Blocks Table
        tables.put("blocks", "create table blocks ( ID int auto_increment, constraint blocks_pk primary key (ID) );");
        // Items Table
        tables.put("items", "create table items ( ID int auto_increment, constraint blocks_pk primary key (ID) );");
        // Settings Table
        tables.put("settings", "create table settings ( ID TEXT not null )");
        // Reports Table
        tables.put("reports", "create table reports ( time timestamp default current_timestamp() not null, player binary(16) not null, target binary(16) not null );");
        // Upvotes table
        tables.put("upvotes", "create table upvotes ( time timestamp default current_timestamp() not null, player binary(16) not null, target binary(16) not null );");
        // Orders Table
        tables.put("orders", "create table orders ( player binary(16) not null, item text not null, amount int not null, time timestamp default current_timestamp not null, action boolean not null);");
        // Market Table
        tables.put("market", "create table market (item varchar(255) not null, stock int not null, price int not null, desiredPrice int not null, desiredStock int not null, constraint market_pk primary key (item));");
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
        // Player Tables
        ArrayList<String> prefix = new ArrayList<>(Arrays.asList("players", "prefix"));
        columns.put(prefix, "alter table players add prefix TEXT");
        ArrayList<String> name = new ArrayList<>(Arrays.asList("players", "name"));
        columns.put(name, "alter table players add name TEXT");
        ArrayList<String> suffix = new ArrayList<>(Arrays.asList("players", "suffix"));
        columns.put(suffix, "alter table players add suffix TEXT");
        ArrayList<String> chatColor = new ArrayList<>(Arrays.asList("players", "chatColor"));
        columns.put(chatColor, "alter table players add chatColor TEXT");
        ArrayList<String> balance = new ArrayList<>(Arrays.asList("players", "balance"));
        columns.put(balance, "alter table players add balance INT");
        ArrayList<String> flyTime = new ArrayList<>(Arrays.asList("players", "flyTime"));
        columns.put(flyTime, "alter table players add flyTime INT");
        ArrayList<String> online = new ArrayList<>(Arrays.asList("players", "online"));
        columns.put(online, "alter table players add online boolean");
        ArrayList<String> playTime = new ArrayList<>(Arrays.asList("players", "playTime"));
        columns.put(playTime, "alter table players add playTime int");
        ArrayList<String> staffMode = new ArrayList<>(Arrays.asList("players", "staffMode"));
        columns.put(staffMode, "alter table players add staffMode boolean");
        ArrayList<String> staffInventory = new ArrayList<>(Arrays.asList("players", "staffInventory"));
        columns.put(staffInventory, "alter table players add staffInventory TEXT");
        ArrayList<String> staffArmor = new ArrayList<>(Arrays.asList("players", "staffArmor"));
        columns.put(staffArmor, "alter table players add staffArmor TEXT");
        ArrayList<String> vanished = new ArrayList<>(Arrays.asList("players", "vanished"));
        columns.put(vanished, "alter table players add vanished boolean");
        ArrayList<String> secret = new ArrayList<>(Arrays.asList("players", "secret"));
        columns.put(secret, "alter table players add secret TEXT");
        // Blocks Table
        ArrayList<String> blockPerm = new ArrayList<>(Arrays.asList("blocks", "permission"));
        columns.put(blockPerm, "alter table blocks add permission TEXT");
        // Items Table
        ArrayList<String> itemPerm = new ArrayList<>(Arrays.asList("items", "permission"));
        columns.put(itemPerm, "alter table items add permission TEXT");
        // Settings Table
        ArrayList<String> value = new ArrayList<>(Arrays.asList("settings", "value"));
        columns.put(value, "alter table settings add value TEXT");
        // Reports Table
        ArrayList<String> reportTime = new ArrayList<>(Arrays.asList("reports", "time"));
        columns.put(reportTime, "alter table reports add time timestamp default current_timestamp() not null");
        ArrayList<String> reportPlayer = new ArrayList<>(Arrays.asList("reports", "player"));
        columns.put(reportPlayer, "alter table reports add player binary(16) not null");
        ArrayList<String> reportTarget = new ArrayList<>(Arrays.asList("reports", "target"));
        columns.put(reportTarget, "alter table reports add target binary(16) not null");
        ArrayList<String> reportReason = new ArrayList<>(Arrays.asList("reports", "reason"));
        columns.put(reportReason, "alter table reports add reason TEXT not null");
        // Upvotes Table
        ArrayList<String> upvoteTime = new ArrayList<>(Arrays.asList("upvotes", "time"));
        columns.put(upvoteTime, "alter table upvotes add time timestamp default current_timestamp() not null");
        ArrayList<String> upvotePlayer = new ArrayList<>(Arrays.asList("upvotes", "player"));
        columns.put(upvotePlayer, "alter table upvotes add player binary(16) not null");
        ArrayList<String> upvoteTarget = new ArrayList<>(Arrays.asList("upvotes", "target"));
        columns.put(upvoteTarget, "alter table upvotes add target binary(16) not null");
        // Orders Table
        ArrayList<String> orderPlayer = new ArrayList<>(Arrays.asList("orders", "player"));
        columns.put(orderPlayer, "alter table orders add player binary(16) not null");
        ArrayList<String> orderItem = new ArrayList<>(Arrays.asList("orders", "item"));
        columns.put(orderItem, "alter table orders add item text not null");
        ArrayList<String> orderQuantity = new ArrayList<>(Arrays.asList("orders", "quantity"));
        columns.put(orderQuantity, "alter table orders add quantity int not null");
        ArrayList<String> orderTime = new ArrayList<>(Arrays.asList("orders", "time"));
        columns.put(orderTime, "alter table orders add time timestamp default current_timestamp() not null");
        ArrayList<String> orderAction = new ArrayList<>(Arrays.asList("orders", "action"));
        columns.put(orderAction, "alter table orders add action boolean not null");
        // Market Table
        ArrayList<String> marketItem = new ArrayList<>(Arrays.asList("market", "item"));
        columns.put(marketItem, "alter table market add item varchar(255) not null");
        ArrayList<String> marketStock = new ArrayList<>(Arrays.asList("market", "stock"));
        columns.put(marketStock, "alter table market add stock int not null");
        ArrayList<String> marketPrice = new ArrayList<>(Arrays.asList("market", "price"));
        columns.put(marketPrice, "alter table market add price int not null");
        ArrayList<String> marketDesiredPrice = new ArrayList<>(Arrays.asList("market", "desiredPrice"));
        columns.put(marketDesiredPrice, "alter table market add desiredPrice int not null");
        ArrayList<String> marketDesiredStock = new ArrayList<>(Arrays.asList("market", "desiredStock"));
        columns.put(marketDesiredStock, "alter table market add desiredStock int not null");
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
