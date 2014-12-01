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
    private static char usertype;

    public static char getUsertype() {

        return usertype;
    }

    public boolean isAdministrator(String FacultyNumber) throws SQLException {

        Connection connection = DBConnection.connect();


        String query = "SELECT isAdministrator FROM Faculty WHERE FacultyNumber = " + FacultyNumber;

        ResultSet resultSet = connection.createStatement().executeQuery(query);

        return true;
    }

    public String getUsername() {

        return username;
    }

    public String getPassword() {

        return password;
    }

    private void checkUser(String facultyNumber) throws SQLException {


        new DBConnection();
        Connection connection = DBConnection.connect();

        char usertype = getUsertype();

        if (usertype == 'F') {

            String query = "SELECT Password FROM Faculty WHERE FacultyNumber = " + facultyNumber;

            ResultSet resultSet = connection.createStatement().executeQuery(query);

            while(resultSet.next()) {
                resultSet.getString(1);
                
            }
        }

    }

    public void showLogin() {


        System.out.println("Username: ");
        Scanner scanCredentials = new Scanner(System.in);

        username = scanCredentials.nextLine();

        System.out.println("Password: ");
        password = scanCredentials.nextLine();


    }
}
