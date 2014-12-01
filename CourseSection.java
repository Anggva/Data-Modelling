
import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Created by Frank on 11/26/2014.
 *
 * performs DB operations for CourseSection (insertion, update, and retrieval)
 * this is an example that can be extended for any kind of functionality the group
 * project requires.
 *
 * say you want to retrieve or set data on a different kind of relationship (students taking
 * a course), a general purpose class can be made for that.
 *
 *
 */
public class CourseSection extends Relationship {


    public CourseSection() {

    }

    public CourseSection(int courseNumber, String days, String time, String students, String instructor) {
        setCourseNumber(courseNumber);
        setDays(days);
        setTime(time);
        setStudents(students);
        setInstructor(instructor);
    }

    public String getFormData() {

        return "Course Listing\n" +
               "===================================================================\n" +
               "Course Number\t" + "Days\t" + "Time\t" + "Student\t" + "Instructor\n" +
        getCourseNumber() + "\t" + getDays() + "\t" + getTime() + "\t" + getStudents() + "\t" + getInstructor();

    }


    public void getDBData() {




        try {
            Connection connection = DBConnection.connect();

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



