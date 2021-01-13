package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static DBConnection single;

    private Connection connection;

    private DBConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/compta", "root", "");
    }

    public static DBConnection getSingle() throws SQLException {
        if ( null == single ) {
            single = new DBConnection();
        }
        return single;
    }

    public Connection getConnection() {
        return connection;
    }
}
