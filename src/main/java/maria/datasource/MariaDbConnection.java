package maria.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDbConnection {
    private static final String URL = "jdbc:mariadb://localhost:3306/currency_converter";
    private static final String USER = "appuser";
    private static final String PASSWORD = "password";
    
    private static Connection connection = null;
    
    private MariaDbConnection() {
        // Private constructor to prevent instantiation
    }
    
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException e) {
                throw new SQLException("MariaDB JDBC Driver not found", e);
            }
        }
        return connection;
    }
    
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}