import java.util.ArrayList;

/**
 * Created by Frank on 11/27/2014.
 *
 * You can set and retrieve relationships between entities here if you like.
 * It's not necessarily required, but it might come in handy later.
 *
 * You must make your own getDBData() method in your relationship class.
 */
public abstract class Relationship {

    private ArrayList<String> er = new ArrayList<String>();

    public abstract void getDBData();

    // create some relationships among two or more entities.
    public ArrayList<String> makeRelations() {

        return er;
    }

    // list some relationships that have been made between two or more entities.
    public void listRelations() {

    }



}
