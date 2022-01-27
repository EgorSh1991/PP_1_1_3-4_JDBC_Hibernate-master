package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/dbtest?autoReconnect=true&useSSL=false";
    private static final String DB_USER_NAME = "root";
    private static final String DB_PASSWORD = "root";

    public static Connection getConnect(){
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DB_URL,DB_USER_NAME,DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
