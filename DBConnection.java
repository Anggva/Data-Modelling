import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {

    private static Connection connection;
    private static String url = "jdbc:oracle://olympia/";
    final private static String user = "who";
    final private static String passwd = "what";

    public static Connection connect() throws SQLException {

        Connection connection;
        // gets connection to olympia
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@olympia.unfcsd.unf.edu:1521:dworcl", "teamlostinerwin", "team3bdpsvv");
        } catch (SQLException e) {
            System.out.println("Connection to Olympia Failed!");
            return null;
        }
        if (connection == null) {
            System.out.println("Failed to establish connection.");
            return null;
        } else {
            return connection;
        }

    }

    public static Connection getConnection() throws SQLException {

        if (connection != null && !connection.isClosed())
            return connection;
        connect();
        return connection;
    }
}