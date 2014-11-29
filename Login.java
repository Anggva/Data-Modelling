import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by Frank on 11/28/2014.
 */
public class Login {

    private static String username;
    private static String password;
    private char usertype;

    public char getUsertype() {

        return usertype;
    }

    public String getUsername() {

        return username;
    }

    public String getPassword() {

        return password;
    }

    private static char computeUsertype() throws SQLException {

        Connection connection = new DBConnection().connect();

        String query = "SELECT type FROM Users WHERE username = " + username;
        ResultSet resultSet = connection.createStatement().executeQuery(query);

        char[] arrtype = resultSet.getString(1).toCharArray();

        return arrtype[0];
    }

    public void showLogin() {


        System.out.println("Username: ");
        Scanner scanCredentials = new Scanner(System.in);

        username = scanCredentials.nextLine();

        System.out.println("Password: ");
        password = scanCredentials.nextLine();


    }
}
