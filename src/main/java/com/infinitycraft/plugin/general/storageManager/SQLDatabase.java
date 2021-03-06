package com.infinitycraft.plugin.general.storageManager;

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
        connection = DriverManager.getConnection("jdbc:mysql://75.40.16.210:3306/main?autoReconnect=true", "InfinityCraftServer", "jwSXefq82ZAD4eS9gaAdHjUWqmVHfHKLrmL4NeCD3KcuESurFuhcKn8SCAw9HdHxXj4exy6k4KcCLgberevb5caD6FX9cnKwaTvRGbTzKbfXE4x42VjXrEVE3sE39TWr");
        statement = connection.createStatement();
    }

    /**
     * Disconnect from database
     */
    public static void disconnect() throws Exception {
        statement.close();
    }
}
