import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * Created by Frank on 11/28/2014.
 */
public class FacultyListing extends Relationship {

    String facultyNumber, firstName, lastName, position, areaOfExpertise, PreferredCourseDays, PreferredCourseTimes;
    String gender, phoneNumber;


    public void setFacultyNumber(String fFacultyNum) {

        this.facultyNumber = fFacultyNum;

    }

    public void setFirstName(String fFirstName) {

        this.firstName = fFirstName;
    }

    public void setLastName(String fLastName) {

        this.lastName = fLastName;
    }

    public void setPosition(String fPosition) {

        this.position = fPosition;
    }

    public void setAreaOfExpertise(String fAreaOfExpertise) {

        this.areaOfExpertise = fAreaOfExpertise;
    }

    public void setPreferredCourseDays(String fPreferredCourseDays) {

        this.PreferredCourseDays = fPreferredCourseDays;
    }

    public void setPreferredCourseTimes(String fPreferredCourseTimes) {

        this.PreferredCourseTimes = fPreferredCourseTimes;
    }

    public void setGender(String fGender) {

        this.gender = fGender;

    }

    public void setPhoneNumber(String fPhoneNumber) {

        this.phoneNumber = fPhoneNumber;
    }

    public void getDBData() {

        Connection connection;


        try {
            connection = DBConnection.connect();


            // get the list of faculty members teaching courses, the days they are teaching, etc.
            String query = "SELECT FacultyNumber, FirstName, LastName, Position, " +
                    "AreaOfExpertise, PreferredCourseDays, PreferredCourseTimes, Gender," +
                    " PhoneNumber FROM Faculty";

            ResultSet resultSet = connection.createStatement().executeQuery(query);

            while (resultSet.next()) {
                setFacultyNumber(resultSet.getString(1));
                setFirstName(resultSet.getString(2));
                setLastName(resultSet.getString(3));
                setPosition(resultSet.getString(4));
                setAreaOfExpertise(resultSet.getString(5));
                setPreferredCourseDays(resultSet.getString(6));
                setPreferredCourseTimes(resultSet.getString(7));
                setGender(resultSet.getString(8));
                setPhoneNumber(resultSet.getString(9));
            }

        } catch (Exception e) {
            System.err.println("DB connection error.");
        }
    }
}
