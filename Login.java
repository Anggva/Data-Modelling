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

    public static Character getUsertype() {


        return username.charAt(0);
    }

    public boolean isAdministrator(String FacultyNumber) throws SQLException {

        Connection connection = DBConnection.connect();


        String query = "SELECT isAdministrator FROM Faculty WHERE FacultyNumber = " + FacultyNumber;

        ResultSet resultSet = connection.createStatement().executeQuery(query);
        resultSet.close();
        connection.close();

        return true;
    }

    public String getUsername() {

        return username;
    }

    public String getPassword() {

        return password;
    }

    private void checkUser(String number) throws SQLException {


        new DBConnection();
        Connection connection = DBConnection.connect();

        char usertype = getUsertype();

        if (usertype == 'F') {

            String query = "SELECT Password FROM Faculty WHERE FacultyNumber = " + number;

            ResultSet resultSet = connection.createStatement().executeQuery(query);

            while (resultSet.next()) resultSet.getString(1);

            resultSet.close();
            connection.close();

        } else if (usertype == 'S') {

            String query = "SELECT Password FROM Student WHERE StudentNumber = " + number;

            ResultSet resultSet = connection.createStatement().executeQuery(query);

            while (resultSet.next()) resultSet.getString(1);

            resultSet.close();
            connection.close();
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
