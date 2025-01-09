package com.mini_Proj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class Connection_Pool {

    private static String url = "jdbc:postgresql://localhost:5432/library manage_JDBC_Proj?user=postgres&password=root";
    private static String driveString = "org.postgresql.Driver";
    private static final int POOL_SIZE = 5;
    private static List<Connection> connectionPoolList = new ArrayList<>();

    static {
        for (int i = 0; i < POOL_SIZE; i++) {
            connectionPoolList.add(createConnection());
        }
    }

    private static Connection createConnection() {
        Connection connection = null;
        try {
            Class.forName(driveString);
            connection = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static Connection giveConnection() {
        if (!connectionPoolList.isEmpty()) {
            return connectionPoolList.remove(0);
        } else {
            return createConnection();
        }
    }

    public static void submitConnection(Connection connection) {
        if (connectionPoolList.size() < POOL_SIZE) {
            connectionPoolList.add(connection);
        } else {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
