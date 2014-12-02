import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * Created by Frank on 11/28/2014.
 *
 * days, student times related to the days the student is taking his courses.
 */

public class DayListing extends Relationship {

    public void getDBData() {

        Connection connection;

        Scanner scanDays = new Scanner(System.in);
        System.out.println("Please enter the days for which the student is attending courses: ");
        String selectedDays = scanDays.nextLine().trim();

        try {
            connection = DBConnection.connect();

            String query = "SELECT * FROM Sections WHERE DaysOfTheWeek = " + selectedDays;

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

    public String getFormData() {

        return "Course Listing\n" +
                "===================================================================\n" +
                "Course Number\t" + "Days\t" + "Time\t" + "Student\t" + "Instructor\n" +
                getCourseNumber() + "\t" + getDays() + "\t" + getTime() + "\t" + getStudents() + "\t" + getInstructor();

    }

}
