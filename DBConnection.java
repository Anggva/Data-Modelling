import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Frank on 11/27/2014.
 *
 * src: http://blog.ngopal.com.np/2011/06/19/piechart-data-from-database-in-javafx-2-0/
 *
 */
public class DBConnection {

    private static Connection connection;
    private static String url = "jdbc:oracle://olympia/";
    final private static String user = "who";
    final private static String passwd = "what";

    public static Connection connect() throws SQLException {

        try {
            Class.forName("com.oracle.jdbc.Driver").newInstance();

        } catch (ClassNotFoundException cnfe) {
            System.err.println("JDBC driver not found.");
        } catch (InstantiationException ie) {
            System.err.println("Failed to create DB connection object" + ie.getMessage());
        } catch (IllegalAccessException iae) {
            System.err.println(iae.getMessage());
        }

        connection = DriverManager.getConnection(url, user, passwd);
        return connection;
    }

    public static Connection getConnection() throws SQLException {

        if(connection != null && !connection.isClosed())
            return connection;
        connect();
        return connection;
    }
}
