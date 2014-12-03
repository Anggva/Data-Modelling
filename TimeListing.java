import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * Created by Frank on 11/28/2014.
 */
public class TimeListing extends Relationship {

    int SectionNumber;


    public String getFormData() {

        return "Time Listing\n" +
                "===================================================================\n" +
                "Section Number\t" + "Course Number\t" + "Days\t" + "Time\t" + "Student\t" + "Instructor\n" +
                SectionNumber + "\t" + getCourseNumber() + "\t" + getDays() + "\t" + getTime() + "\t" + getStudents() + "\t" + getInstructor();

    }

    public void getDBData() {

        Connection connection;
        Scanner scanner = new Scanner(System.in);
        String selectedTime = scanner.nextLine().trim();


        try {
            connection = DBConnection.connect();

            // query for getting the student and course information as it relates to days the student is
            // taking classes.
            String query = "SELECT * FROM Sections WHERE Time = " + selectedTime;

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
