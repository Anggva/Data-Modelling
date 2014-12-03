import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


/**
 * Created by Frank on 11/28/2014.
 *
 *  The order in using the auth methods is important.
 *  isAdministrator() should be called after checkUser(), and checkUser() requires
 *  user's username and pass with showLogin().
 *
 */
public class Login {

    private String username;
    private String password;
    private boolean authenticated;

    private char getUsertype() {

        return username.charAt(0);
    }

    public void logout() {

        username = null;
        password = null;
        authenticated = false;
        System.out.println("You are now logged out.");
    }

    public char isAdministrator(String FacultyNumber) throws SQLException {

        Connection connection = DBConnection.connect();
        char chadmin = '0';

        String query = "SELECT isAdministrator FROM FacultyMembers HERE FacultyNumber='" + FacultyNumber+"'";

        ResultSet resultSet = connection.createStatement().executeQuery(query);

        while (resultSet.next()) chadmin = resultSet.getString(1).charAt(0);


        // if our check-admin variable contains a Y, we have a user in the database who is an
        // administrator, return true for this user.

        /* if our check-admin variable contains a Y, we have a user in the database who is an
         administrator, return true for this user.

          it is better to have the isAdministrator column type BOOLEAN, but this will do..
         */
        if (chadmin == '1')
            return '1';

        resultSet.close();
        connection.close();

        return '0';
    }

    public String getUsername() {

        return username;
    }


    public String getPassword() {

        return password;
    }


    public boolean checkUser(String number) throws SQLException {

        new DBConnection();
        Connection connection = DBConnection.connect();

        char usertype = getUsertype();
        String dbpasswd = "default";

        //  String dbpasswd = null;

        if (usertype == 'F') {

            String query = "SELECT Password FROM FacultyMembers WHERE FacultyNumber = " + number;

            ResultSet resultSet = connection.createStatement().executeQuery(query);


            while (resultSet.next()) dbpasswd = resultSet.getString(1);

            if (password.equals(dbpasswd)) {
                System.out.println("You are logged in with role, 'faculty'");
                authenticated = true;

                return true;
            }

            resultSet.close();
            connection.close();

        } else if (usertype == 'S') {

            String query = "SELECT Password FROM Students WHERE StudentNumber = " + number;

            ResultSet resultSet = connection.createStatement().executeQuery(query);


            while (resultSet.next()) dbpasswd = resultSet.getString(1);

            // if the password matches the password in the database column, we are authenticated.
            if (password.equals(dbpasswd)) {
                System.out.println("You are logged in with role, 'student'");
                authenticated = true;
                return true;
            }
            resultSet.close();
            connection.close();
        }

        // no password, so no authentication.
        // the user of Login class should treat value of false here as a failure and
        // reject the user.
        return false;

    }

    public void showLogin() {


        System.out.println("Username: ");
        Scanner scanCredentials = new Scanner(System.in);

        username = scanCredentials.nextLine().trim();

        System.out.println("Password: ");
        password = scanCredentials.nextLine().trim();

    }


    public boolean isAuthenticated() {

        return authenticated;

    }
}
