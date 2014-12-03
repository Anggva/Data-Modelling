import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Created by Frank on 11/28/2014.
 */
public class StudentListing extends Relationship {

    String studentnumber, firstName, lastName, semester, PreferredCourseDays, PreferredCourseTimes, gender, phone;

    public String getFormData() {

        return "Student Listing\n" +
                "===================================================================\n" +
                "Student Number\t" + "First Name\t" + "Last Name\t" + "Semester\t" + "Preferred Days\t" +
                "Preferred Times\t" + "Gender\t" + "Phone\t" +
                studentnumber + "\t" + firstName + "\t" + lastName + "\t" + semester + "\t" + PreferredCourseDays
                + "\t" + PreferredCourseTimes + "\t" + gender + "\t" + phone;

    }

    public void getDBData() {

        Connection connection;


        try {
            connection = DBConnection.connect();

            // query for getting the list of students and their relation to the courses they are
            // taking, their times, etc.
            String query = "SELECT * FROM Students";

            ResultSet resultSet = connection.createStatement().executeQuery(query);

            while (resultSet.next()) {
                studentnumber = (resultSet.getString(1));
                firstName = (resultSet.getString(2));
                lastName = (resultSet.getString(3));
                semester = (resultSet.getString(4));
                PreferredCourseDays = (resultSet.getString(5));
                PreferredCourseTimes = resultSet.getString(6);
                gender = resultSet.getString(7);
                phone = resultSet.getString(8);
            }

        } catch (Exception e) {
            System.err.println("DB connection error.");
        }
    }
}
