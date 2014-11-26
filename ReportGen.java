/**
 * Created by Frank on 11/25/2014.
 *
 */
public class ReportGen {



    /*  publicly accessible method for gathering the desired
        information based on user types, student, faculty, or
        administrator
     */
    public String getReport(byte choice, char usertype) {


            switch (choice) {
                case 1: return getCourseListing(usertype);

                case 2: return getDayListing(usertype);
                case 3: return getTimeListing(usertype);
                case 4: return getStudentListing();
                case 5: return getFacultyListing(usertype);
                default: System.out.println("getReport() provided with" +
                        " an invalid or out-of-bounds menu option.");
                        break;

            }
          return "";
    }
    /* retrieve course listing from some DB.
       General: course information, student days and times;

       Privileged: information for faculty who request to teach
       course; faculty days and times.
     */

    private String getCourseListing(char usertype) {

        // do nothing for now.
        return "";
    }

    /*
        get the day, course information, times with
        related student information.

        Privileged: times related to faculty information
     */
    private String getDayListing(char usertype) {

        // do nothing for now.
        return "";
    }

    /*
        get the time; the course information with days and
        related student information.

        Privileged: days with related faculty information.
     */
    private String getTimeListing(char usertype) {

        // do nothing for now.
        return "";
    }

    /*
        gets a match for all student courses.

        matches for any courses, days, times given by
        faculty information.
     */
    private String getStudentListing() {

        // do nothing for now.
        return "";
    }

    /*
        gets all student courses and matches list with
        any courses, days, and times in the student
        information...

        Is this only intended for faculty members?
     */
    private String getFacultyListing(char usertype) {

        // are only faculty members or administrators allowed to retrieve certain information?
        if (usertype != 'F' && usertype != 'A') {
            return "You do not have sufficient credentials to retrieve this information.";
        }
        // send back the results of a query in a stylized fashion.
        return "";
    }
}
