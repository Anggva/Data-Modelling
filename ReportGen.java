

/**
 * Created by Frank on 11/25/2014.
 *
 */
public class ReportGen {




    public ReportGen() {

    }


    /*  publicly accessible method for gathering the desired
        information based on user types, student, faculty, or
        administrator
     */
    public String getReport(byte choice) {


            switch (choice) {
                    case 1: System.out.println(getCourseListing());
                        break;
                    case 2: System.out.println(getDayListing());
                        break;
                    case 3: System.out.println(getTimeListing());
                        break;
                    case 4: System.out.println(getStudentListing());
                        break;
                    case 5: System.out.println(getFacultyListing());
                        break;
                    default: System.out.println("getReport() provided with" +
                            " an invalid or out-of-bounds menu option.");


            }

        return "";

    }
    /* retrieve course listing from some DB.
       General: course information, student days and times;

       Privileged: information for faculty who request to teach
       course; faculty days and times.
     */

    private String getCourseListing() {

        CourseSection courseListing = new CourseSection();
        courseListing.getDBData();


        // pass the report form data to the screen (out).
        return courseListing.getFormData();
    }

    /*
        get the day, course information, times with
        related student information.

        Privileged: times related to faculty information
     */
    private String getDayListing() {

        DayListing dayListing = new DayListing();
        dayListing.getDBData();


        // pass the report form data to the screen (out).
        return dayListing.getFormData();
    }

    /*
        get the time; the course information with days and
        related student information.

        Privileged: days with related faculty information.
     */
    private String getTimeListing() {

        TimeListing timeListing = new TimeListing();
        timeListing.getDBData();


        // pass the report form data to the screen (out).
        return timeListing.getFormData();
    }

    /*
        gets a match for all student courses.

        matches for any courses, days, times given by
        faculty information.
     */
    private String getStudentListing() {

        StudentListing studentListing = new StudentListing();
        studentListing.getDBData();


        // pass the report form data to the screen (out).
        return studentListing.getFormData();
    }

    /*
        gets all student courses and matches list with
        any courses, days, and times in the student
        information...

        Is this only intended for faculty members?
     */
    private String getFacultyListing() {


        // send back the results of a query in a stylized fashion.
        FacultyListing facultyListing = new FacultyListing();
        facultyListing.getDBData();


        // pass the report form data to the screen (out).
        return facultyListing.getFormData();
    }
}
