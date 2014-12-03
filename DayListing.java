import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * Created by Frank on 11/28/2014.
 *
 * days, student times related to the days the student is taking his courses.
 */

public class DayListing extends Relationship {

    int SectionNumber;

    public String getFormData() {

        return "Time Listing\n" +
                "===================================================================\n" +
                "Section Number\t" + "Course Number\t" + "Days\t" + "Time\t" + "Student\t" + "Instructor\n" +
                SectionNumber + "\t" + getCourseNumber() + "\t" + getDays() + "\t" + getTime() + "\t" + getStudents() + "\t" + getInstructor();

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
                SectionNumber = resultSet.getInt(1);
                setCourseNumber(resultSet.getString(2));
                setDays(resultSet.getString(3));
                setTime(resultSet.getString(4));
                setInstructor(resultSet.getString(5));
            }

        } catch (Exception e) {
            System.err.println("DB connection error.");
        }
    }

}
