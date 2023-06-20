package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Database {
    private static final Database database = new Database();
    private Connection connection;
    private final ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
    private static final String JDBC_URL = "jdbcURL";

    private Database() {
        try {
            connection = DriverManager.getConnection(resourceBundle.getString(JDBC_URL));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Database getInstance() {
        return database;
    }

    public Connection getConnection() {
        return connection;
    }
}
