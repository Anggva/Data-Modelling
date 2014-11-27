/**
 * Created by Frank on 11/24/2014.
 *
 * This is a basic driver for the MenuGen class which generates menus for
 * user DB action.
 *
 */
public class Driver {



    public static void main (String[] args) {

        char usertype = 'S';

        RootMenu menu = new RootMenu(usertype);
        menu.showMainMenu();
    }
}
