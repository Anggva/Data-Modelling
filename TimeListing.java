import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * Created by Frank on 11/28/2014.
 */
public class TimeListing extends Relationship {

    public void getDBData() {

        Connection connection;


        try {
            connection = DBConnection.connect();

            Scanner scanTime = new Scanner(System.in);
            System.out.println("Please enter the time for which the student is attending courses: ");
            String selectedTime = scanTime.nextLine().trim();

            // query for getting the student and course information as it relates to times the student is
            // taking classes.
            String query = "SELECT * FROM Sections WHERE Time = " + selectedTime;

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
