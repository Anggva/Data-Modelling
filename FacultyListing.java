import java.awt.geom.Area;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Created by Frank on 11/28/2014.
 */
public class FacultyListing extends Relationship {

    private String facultyNumber, firstName, lastName, position, AreaOfExpertise;
    private String PreferredCourseDays, PreferredCourseTimes, gender, phone;


    public String getFormData() {

        return "Faculty Listing\n" +
                "===================================================================\n" +
                "Faculty Number\t" + "First Name\t" + "Last Name\t" + "Position\t" + "Area of Expertise\t" +
                "Preferred Days\t" + "Preferred Times\t" + "Gender\t" + "Phone\t" +
                getCourseNumber() + "\t" + getDays() + "\t" + getTime() + "\t" + getStudents() + "\t" + getInstructor();
    }

    public void getDBData() {

        Connection connection;


        try {
            connection = DBConnection.connect();

            // get the list of faculty members teaching courses, the days they are teaching, etc.
            String query = "SELECT * FROM FacultyMembers";

            ResultSet resultSet = connection.createStatement().executeQuery(query);

            while (resultSet.next()) {
                facultyNumber = resultSet.getString(1);
                firstName = resultSet.getString(2);
                lastName = resultSet.getString(3);
                position = resultSet.getString(4);
                AreaOfExpertise = resultSet.getString(5);
                PreferredCourseDays = resultSet.getString(6);
                PreferredCourseTimes = resultSet.getString(7);
                gender = resultSet.getString(8);
                phone = resultSet.getString(9);
            }

        } catch (Exception e) {
            System.err.println("DB connection error.");
        }
    }
}
