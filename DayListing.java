import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Created by Frank on 11/28/2014.
 *
 * days, student times related to the days the student is taking his courses.
 */

public class DayListing extends Relationship {

    public void getDBData() {

        Connection connection;


        try {
            connection = DBConnection.connect();

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
