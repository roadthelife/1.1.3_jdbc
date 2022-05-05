package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "short";
    private static final String URL = "jdbc:mysql://localhost:3306/users";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static Connection conn = Util.activeConnection();

    public static Connection activeConnection() {
        Connection connection = null;

        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connection is OK");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
        return connection;
    }

    public static void closeConnect() {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Connection close");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
