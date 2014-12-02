import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Frank on 11/27/2014.
 *
 * src: http://blog.ngopal.com.np/2011/06/19/piechart-data-from-database-in-javafx-2-0/
 * now with Brittany's DB information.
 */
public class DBConnection {

    final private static String user = "teamlostinerwin";
    final private static String passwd = "team3bdpsvv";

    public static Connection connect() throws SQLException {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();

        } catch (ClassNotFoundException cnfe) {
            System.err.println("JDBC driver not found.");
        } catch (InstantiationException ie) {
            System.err.println("Failed to create DB connection object" + ie.getMessage());
        } catch (IllegalAccessException iae) {
            System.err.println(iae.getMessage());
        }

        String url = "jdbc:oracle:thin:@olympia.unfcsd.unf.edu:1521:dworcl";
        return DriverManager.getConnection(url, user, passwd);
    }

    /*public static Connection getConnection() throws SQLException {

        if(connection != null && !connection.isClosed())
            return connection;
        connect();
        return connection;
    }*/
}
