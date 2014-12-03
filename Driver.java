import java.sql.SQLException;

/**
 * Created by Frank on 11/24/2014.
 *
 * This is a basic driver for the MenuGen class which generates menus for
 * user DB action.
 *
 */
public class Driver {

    public static void main (String[] args) throws SQLException {

        Login login = new Login();
        login.showLogin();
        login.checkUser(login.getUsername());

        RootMenu menu = new RootMenu();
        menu.showMainMenu();
    }
}
