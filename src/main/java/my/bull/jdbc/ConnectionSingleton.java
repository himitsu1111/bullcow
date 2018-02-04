package my.bull.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by book on 25.02.2017.
 */
public class ConnectionSingleton {
    private static Connection instance;

    public static synchronized Connection getInstance() {
        if (instance == null) {
            try {
                Class.forName("org.postgresql.Driver");
                instance = DriverManager.getConnection("jdbc:postgresql://localhost:5432" +
                        "/osource?user=postgres&password=admin");
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
}
