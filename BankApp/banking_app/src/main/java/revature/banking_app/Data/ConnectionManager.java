package revature.banking_app.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static Connection connection;

    private static String connectionString = "jdbc:postgresql://otto.db.elephantsql.com:5432/xjkkgqyh",
            username = "xjkkgqyh",
            password = "4fNXLkK9Zl2M_3is-PZT24_52SgzU0uy";

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {

                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(connectionString, username, password);
            }

            return connection;
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }
}
