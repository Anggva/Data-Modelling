import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Created by Frank on 11/28/2014.
 */
public class FacultyListing extends Relationship {

    public void getDBData() {

        Connection connection;


        try {
            connection = DBConnection.connect();

            // get the list of faculty members teaching courses, the days they are teaching, etc.
            String query = "SELECT * FROM Section";

            ResultSet resultSet = connection.createStatement().executeQuery(query);

            while (resultSet.next()) {
                setCourseNumber(resultSet.getInt(1));
                setDays(resultSet.getString(2));
                setTime(resultSet.getString(3));
                setStudents(resultSet.getString(4));
                setInstructor(resultSet.getString(5));
            }

        } catch (Exception e) {
            System.err.println("DB connection error.");
        }
    }
}
