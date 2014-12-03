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

    private String courseNumber;
    private int sectionNumber;
    private String days;
    private String time;
    private String students;
    private String instructor;




    public int getSectionNumber() {

        return this.sectionNumber;
    }
    public String getDays() {

        return this.days;
    }

    public String getTime() {
        return time;
    }

    public String getStudents() {

        return this.students;
    }

    public String getInstructor() {

        return this.instructor;
    }

    public String getCourseNumber() {

        return this.courseNumber;
    }

    public void setCourseNumber(String fcourseNum) {

        this.courseNumber = fcourseNum;
    }

    public void setSectionNumber(int fSectionNumber) {

        this.sectionNumber = fSectionNumber;
    }

    public void setDays(String fdays) {

        this.days = fdays;
    }

    public void setTime(String ftime) {

        this.time = ftime;
    }

    public void setStudents(String fstudents) {

        this.students = fstudents;
    }

    public void setInstructor(String finstructor) {

        this.instructor = finstructor;

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
