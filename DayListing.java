import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * Created by Frank on 11/28/2014.
 *
 * days, student times related to the days the student is taking his courses.
 */

public class DayListing extends Relationship {

    public String getFormData() {

        return "Day Listing\n" +
                "===================================================================\n" +
                "Course Number\t" + "Days\t" + "Time\t" + "Student\t" + "Instructor\n" +
                getCourseNumber() + "\t" + getDays() + "\t" + getTime() + "\t" + getStudents() + "\t" + getInstructor();

    }


    public void getDBData() {

        Connection connection;


        try {
            connection = DBConnection.connect();


            System.out.println("Enter the desired days to search for listing: ");
            Scanner scanner = new Scanner(System.in);
            String selectedDays = scanner.nextLine().trim();

            String query = "SELECT *" +
                    " FROM Sections" +
                    " WHERE DaysOfTheWeek = " + selectedDays;

            ResultSet resultSet = connection.createStatement().executeQuery(query);

            while (resultSet.next()) {
                setSectionNumber(resultSet.getInt(1));
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
