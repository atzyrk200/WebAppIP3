package WebApp;

import java.sql.*;

public class MySQLConnUtils {

    public static Connection getMySQLConnection()
            throws ClassCastException, SQLException, ClassNotFoundException {

        String hostName = "localhost";
        String dbName = "ip3";
        String userName = "root2";
        String password = "ip3db";
        return getMySQLConnection(hostName, dbName, userName, password);
    }

    public static Connection getMySQLConnection(String hostName, String dbName, String userName, String password) throws SQLException,
            ClassNotFoundException {

        // Declare the class Driver for MySQL DB
        // This is necessary with Java 5 (or older)
        // Java6 (or newer) automatically find the appropriate driver.
        // If you use Java> 5, then this line is not needed.
        Class.forName("com.mysql.jdbc.Driver");


        // URL Connection for MySQL
        // Example: jdbc:mysql://localhost:3306/s
        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;

        Connection conn = DriverManager.getConnection(connectionURL, userName,
                password);
        return conn;
    }
}





