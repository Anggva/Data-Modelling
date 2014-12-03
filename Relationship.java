import java.util.HashMap;
import java.util.Map;

/**
 * Created by Frank on 11/27/2014.
 *
 * You can set and retrieve relationships between entities here if you like.
 * It's not necessarily required, but it might come in handy later.
 *
 * You must make your own getDBData() method in your relationship class.
 */
public abstract class Relationship {

    private int courseNumber;
    private String days;
    private String time;
    private String students;
    private String instructor;

    public String getDays() {

        return days;
    }

    public String getTime() {
        return time;
    }

    public String getStudents() {

        return students;
    }

    public String getInstructor() {

        return instructor;
    }

    public int getCourseNumber() {

        return courseNumber;
    }

    public void setCourseNumber(int fcourseNum) {

        courseNumber = fcourseNum;
    }

    public void setDays(String fdays) {

        days = fdays;
    }

    public void setTime(String ftime) {

        time = ftime;
    }

    public void setStudents(String fstudents) {

        students = fstudents;
    }

    public void setInstructor(String finstructor) {

        instructor = finstructor;

    }


    private Map<String, Integer> er = new HashMap<String, Integer>();

    public abstract void getDBData();

    // create some relationships among two or more entities.
    public Map<String, Integer> makeRelations() {

        return er;
    }

    // list some relationships that have been made between two or more entities.
    public void listRelations() {

    }



}
