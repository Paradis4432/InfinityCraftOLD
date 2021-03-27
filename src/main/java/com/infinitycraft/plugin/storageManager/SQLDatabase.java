package com.infinitycraft.plugin.storageManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SQLDatabase {

    /**
     * Setup all variables
     */
    public static String connectionUrl;
    public static Connection connection;
    public static Statement statement;

    /**
     * Connect to database and run tests
     */
    public static void connect() throws Exception {
        connectionUrl =
                "jdbc:sqlserver://infinitycraft.database.windows.net:1433;database=main;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;"
                        + "database=main;"
                        + "user=ThinkAlex;"
                        + "password=?cHWq99WTYxA$kZPfvBN@9*Bz-+=V$a4$C$cq=hrBFA8F@_FF#xn@Pxek-p#^v-gfCYZUJ=TuKKJ6WurzzwUJ=_RS-a!BmL@7#rP$m?%rFGFV+sbQHxRd6N+T5e?j%PS;"
                        + "encrypt=true;"
                        + "trustServerCertificate=false;"
                        + "loginTimeout=30;";

        DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        connection = DriverManager.getConnection(connectionUrl);
        statement = connection.createStatement();
    }

    /**
     * Disconnect from database
     */
    public static void disconnect() throws Exception {
        statement.close();
    }
}
