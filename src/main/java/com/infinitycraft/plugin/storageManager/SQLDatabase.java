package com.infinitycraft.plugin.storageManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SQLDatabase {

    /**
     * Setup all variables
     */
    public static Connection connection;
    public static Statement statement;

    /**
     * Connect to database and run tests
     */
    public static void connect() throws Exception {
        DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
        connection = DriverManager.getConnection("jdbc:mysql://192.168.68.124:3306/main", "ThinkAlex", "aHD12006");
        statement = connection.createStatement();
    }

    /**
     * Disconnect from database
     */
    public static void disconnect() throws Exception {
        statement.close();
    }
}
