package utilities;

import java.sql.*;

public class DatabaseUtility {

    private static final String jdbcDriver  = "com.mysql.jdbc.Driver";
    private static final String jdbcURL =  "jdbc:mysql://localhost/publishingHouses";
    private static final String jdbcUserame = "root";
    private static final String jdbcPassword = "12qazwsx";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(jdbcDriver);
            connection = DriverManager.getConnection(jdbcURL, jdbcUserame, jdbcPassword);
        }
        catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
        return connection;
    }
}
