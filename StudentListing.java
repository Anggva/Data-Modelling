import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Created by Frank on 11/28/2014.
 */
public class StudentListing extends Relationship {

    public String getFormData() {

        return "Student Listing\n" +
                "===================================================================\n" +
                "Course Number\t" + "Days\t" + "Time\t" + "Student\t" + "Instructor\n" +
                getCourseNumber() + "\t" + getDays() + "\t" + getTime() + "\t" + getStudents() + "\t" + getInstructor();

    }

    public void getDBData() {

        Connection connection;


        try {
            connection = DBConnection.connect();

            // query for getting the list of students and their relation to the courses they are
            // taking, their times, etc.
            String query = "SELECT * FROM Section";

            ResultSet resultSet = connection.createStatement().executeQuery(query);

            while (resultSet.next()) {
                setCourseNumber(resultSet.getString(1));
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
