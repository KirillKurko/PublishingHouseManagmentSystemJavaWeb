package utilities;

import java.sql.*;

public class DatabaseUtility {

    private static final String jdbcDriver  = "com.mysql.jdbc.Driver";
    private static final String jdbcURL =  "jdbc:mysql://localhost/publishingHouses";
    private static final String jdbcUsername = "root";
    private static final String jdbcPassword = "12qazwsx";
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName(jdbcDriver);
                connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            } catch (SQLException | ClassNotFoundException exception) {
                exception.printStackTrace();
            }
        }
        return connection;
    }
}
