/**
 * Created by Brittany Dinneen on 11/24/2014.
 * This is currently a work in progress so code is NOT complete!
 *
 * TODO:
 * 1. Link to working menu
 * 2. Once Queries are finished add in where necessary
 */

import java.sql.*;
import java.util.*;

public class AdminMenu {


    public static void main(String[] args) {

        //this will connect code to Olympia that we need to add to a main
        Connection connection;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) { 
            System.out.println("Oracle JDBC .jar not found!");
            return;
        }
        // gets connection to olympia
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@olympia.unfcsd.unf.edu:1521:dworcl", "teamlostinerwin", "team3bdpsvv");
        } catch (SQLException e) {
            System.out.println("Connection to Olympia Failed!");
            return;
        }
        if (connection == null) {
            System.out.println("Failed to establish connection.");
            return;
        }

            showAdminMenu();//needs to be called from the ROOT MENU, just here so my code will run

        }


    /*This will be the main Administrator Menu
    * As long as the user logged in has an F# and is and Administrator
    * they will have privileges to view this menu.
    * Options:
    *   1) create/add a new user to the DB
    *   2) delete a current user
    *   3) change the privileges of a faculty member to and from Administrator
    *   4) return to the main menu*/
    public static void showAdminMenu() {
        System.out.println();
        System.out.println("\tAdministrator Menu");
        System.out.println("\t------------");
        System.out.println("1)New User");
        System.out.println("2)Delete User");
        System.out.println("3)Change Privileges");
        System.out.println("4)RETURN to Main Menu");
        System.out.println("Please input a menu option: ");

        Scanner option = new Scanner(System.in);
        byte byopt = option.nextByte();

        switch (byopt) {
            case 1:
                AddUser();
                break;
            case 2:
                DltUser();
                break;
            case 3:
                ChangePriv();
                break;
            case 4:
                System.out.println("Going up to main menu.\n");
                return;
            default:
                System.out.println("Command Not recognized");
        }
    }


    /*AddUser() will walk Administrators through adding a new
    * Student/Faculty member to the DB
    * If at any point and incorrect command OR a 'N' is chosen,
    * they will be return back to the main AdminMenu()*/
    public static void AddUser(){
        System.out.println("------ADD USER------");
        String choice;
        System.out.println("Would you like to add a Student or Faculty User? S or F");
        ArrayList<String> newUserInfo = new ArrayList<String>();
        String fn;
        String ln;
        String sem;
       // String crsneed;
       // String prefcourse;
        String days;
        String time;
        String gender;
        String pnum;
        String position;
        String aoe;
        String pw;
        String coursesTaught;
        String facNum;
        String studNum;
        String isAdmin;///DOES THIS NEED TO BE GLOBAL??
        Scanner scan = new Scanner(System.in);

        choice = scan.nextLine();

        if(choice.equals("S")){
            System.out.println("------Creating New Student User------");
            System.out.println("Please enter new user information for EVERY field");

            System.out.print("Student Number: ");
            studNum = scan.nextLine();
            newUserInfo.add(studNum);

            System.out.print("First Name: ");
            fn = scan.nextLine();
            newUserInfo.add(fn);

            System.out.print("Last Name: ");
            ln = scan.nextLine();
            newUserInfo.add(ln);

            System.out.print("Semester (Fall-Spring-Summer):");
            sem = scan.nextLine();
            newUserInfo.add(sem);

/*            System.out.print("Courses Needed: ");
            crsneed = scan.nextLine();
            newUserInfo.add(crsneed);*/

            System.out.print("Preferred Course Days (MTWRF): ");
            days = scan.nextLine();
            newUserInfo.add(days);

            System.out.print("Preferred Course Time (Morning-Afternoon-Night):");
            time = scan.nextLine();
            newUserInfo.add(time);

            System.out.print("Gender (M or F): ");
            gender = scan.nextLine();
            newUserInfo.add(gender);

            System.out.print("Phone Number (XXX-XXX-XXXX): ");
            pnum = scan.nextLine();
            newUserInfo.add(pnum);

            System.out.println("New Student User: " + newUserInfo.toString());
            System.out.println("Is this correct Y or N? ");
            Scanner choicescan = new Scanner(System.in);
            String stdadd = choicescan.nextLine();

            String newSNumber = newUserInfo.get(0);//do I need to cast any of these?
            String newFirstName = newUserInfo.get(1);
            String newLastName = newUserInfo.get(2);
            String newSemester = newUserInfo.get(3);
            String newDays = newUserInfo.get(4);
            String newTime = newUserInfo.get(5);
            String newGender = newUserInfo.get(6);
            String newPhoneNumber = newUserInfo.get(7);

            if(stdadd.equals("Y")){
                String insertQuery = "INSERT INTO Students VALUES('" + newSNumber + "','" + newFirstName + "','" + newLastName + "','" + newSemester + "','" + newDays + "','" + newTime + "','" + newGender + "','" + newPhoneNumber + "');";

                //add query
                Connection connection;
                try {
                    connection = DBConnection.connect();
                    Statement stmt = connection.createStatement();
                    stmt.executeUpdate(insertQuery);
                }
                catch(Exception e){System.err.println(e.getMessage());}

                //success
                System.out.println("Student successfully added!");
                showAdminMenu();
            }
            if(stdadd.equals("N")){
                System.out.println("User NOT added, please try again.");
                showAdminMenu();
            }
            else{
                System.out.println("Command Not recognized, user NOT added");
                // Return to Admin main menu
                showAdminMenu();
            }
        }
        if(choice.equals("F")){
            System.out.println("------Creating New Faculty User------");
            System.out.println("Please enter new user information for EVERY field");

            System.out.print("Faculty Number: ");
            facNum = scan.nextLine();
            newUserInfo.add('N'+facNum);

            System.out.print("First Name: ");
            fn = scan.nextLine();
            newUserInfo.add(fn);

            System.out.print("Last Name: ");
            ln = scan.nextLine();
            newUserInfo.add(ln);

            System.out.print("Position: ");
            position = scan.nextLine();
            newUserInfo.add(position);

            System.out.print("Area of Expertise: ");
            aoe = scan.nextLine();
            newUserInfo.add(aoe);

            System.out.print("Courses Taught: ");
            coursesTaught = scan.nextLine();
            newUserInfo.add(coursesTaught);

            System.out.print("Preferred Course Days (MW-TR-MWF):");
            days = scan.nextLine();
            newUserInfo.add(days);

            System.out.print("Preferred Course Times (Morning-Afternoon-Night):");
            time = scan.nextLine();
            newUserInfo.add(time);

            System.out.print("Gender (M or F): ");
            gender = scan.nextLine();
            newUserInfo.add(gender);

            System.out.print("Phone Number (XXX-XXX-XXXX): ");
            pnum = scan.nextLine();
            newUserInfo.add(pnum);

            System.out.print("Is this Faculty Member an Administrator? Y or N ");
            isAdmin = scan.nextLine();
            newUserInfo.add(isAdmin);

            System.out.print("Password for new user:  ");
            pw = scan.nextLine();
            newUserInfo.add(pw);

            System.out.println("New Faculty User: " + newUserInfo.toString());
            System.out.println("Is this correct Y or N? ");
            Scanner choicescan = new Scanner(System.in);
            String stdadd = choicescan.nextLine();

            String newFacultyNumber = newUserInfo.get(0);//do I need to cast any of these?
            String newFirstName = newUserInfo.get(1);
            String newLastName = newUserInfo.get(2);
            String newPosition = newUserInfo.get(3);
            String newAreaOfExpertise = newUserInfo.get(4);
            String newDays = newUserInfo.get(5);
            String newTimes = newUserInfo.get(6);
            String newGender = newUserInfo.get(7);
            String newPhone = newUserInfo.get(8);
            String newPriveleges = newUserInfo.get(9);
            String newPassword = newUserInfo.get(10);

            if(stdadd.equals("Y")){
                String insertQuery = "INSERT INTO FacultyMembers VALUES('"+newFacultyNumber+"','"+newFirstName+"','"+newLastName+"','"+newPosition+"','"+newAreaOfExpertise+"','"+newDays+"','"+newTimes+"','"+newGender+"','"+newPhone+"','"+newPriveleges+"','"+newPassword+"');";
                System.out.println("Insert "+insertQuery);

                //add query
                Connection connection;
                try {
                    connection = DBConnection.connect();
                    Statement stmt = connection.createStatement();
                    stmt.executeUpdate(insertQuery);
                }
                catch(Exception e){System.err.println(e.getMessage());}

                //success
                System.out.println("Faculty successfully added!");
                showAdminMenu();
            }
            if(stdadd.equals("N")){
                System.out.println("User NOT added, please try again.");
                showAdminMenu();
            }
            else {
                System.out.println("Command Not recognized, user NOT added");
                // Return to Admin main menu
                showAdminMenu();
            }

        }
        else{
            System.out.println("Command Not recognized");
            // Return to Admin main menu
            showAdminMenu();
        }

    }


    /*DltUser() will walk Administrators through deleting an
    * existing Student/Faculty member from the DB
    * If at any point and incorrect command OR a 'N' is chosen,
    * they will be return back to the main AdminMenu()*/
    public static void DltUser(){
        System.out.println("------DELETE USER------");
        String userInQuestion;
        String choice;
        char first;
        boolean found = true;

        System.out.println("Please enter the User Number you would like to delete: ");
        Scanner scan = new Scanner(System.in);
        userInQuestion = scan.nextLine();

        String searchQuery = "SELECT FROM FacultyMembers WHERE FacultyNumber="+scan+";";

        Connection connection;
        try {
            connection = DBConnection.connect();
            Statement stmt = connection.createStatement();
            found = stmt.execute(searchQuery);
        }
        catch(Exception e){System.err.println(e.getMessage());}
        if(found) {

            first = userInQuestion.charAt(0);

            if (first == 'F') {


                //Found: List all info pertaining to that user
                System.out.println("User Information: ");

                System.out.println("Are you sure you wish to delete Faculty listed above? Y or N");
                Scanner newScan = new Scanner(System.in);
                choice = scan.nextLine();

                if (choice.equals("Y")) {
                    String deleteQuery = "DELETE FROM FacultyMembers WHERE FacultyNumber=" + userInQuestion + ";";

                    try {
                        connection = DBConnection.connect();
                        Statement stmt = connection.createStatement();
                        stmt.execute(deleteQuery);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }

                    //Call to DELETE QUERY
                    //success and return to admin main menu
                    showAdminMenu();
                } else if (choice.equals("N")) {
                    System.out.println("You chose no");
                    // Return to Admin main menu
                    showAdminMenu();
                } else {
                    System.out.println("Command Not recognized");
                    // Return to Admin main menu
                    showAdminMenu();
                }

            }
            if (first == 'S') {
                //   SELECT from Student WHERE StudentNumber = userInQuestion;
                //Found: List all info pertaining to that user
                System.out.println("User Information: ");

                System.out.println("Are you sure you wish to delete Student listed above? Y or N");
                Scanner newScan = new Scanner(System.in);
                choice = scan.nextLine();

                if (choice.equals("Y")) {
                    String deleteQuery = "DELETE FROM Students WHERE StudentNumber=" + userInQuestion + ";";

                    try {
                        connection = DBConnection.connect();
                        Statement stmt = connection.createStatement();
                        stmt.execute(deleteQuery);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }

                    //success and return to admin main menu
                    showAdminMenu();
                } else if (choice.equals("N")) {
                    System.out.println("Student will not be deleted");
                    // Return to Admin main menu
                    showAdminMenu();
                } else {
                    System.out.println("Command Not recognized");
                    // Return to Admin main menu
                    showAdminMenu();
                }
            }
        }
        if(!found){
            System.out.println("We did not find who you were looking for.");
            // Return to Admin main menu
            showAdminMenu();
        }
        else {
            System.out.println("Command Not recognized");
            // Return to Admin main menu
            showAdminMenu();
        }
    }

    /*ChangePriv() will walk Administrators through changing
    *an existing faculty member in the DB to and from Administrators
    * If at any point and incorrect command OR a 'N' is chosen,
    * they will be return back to the main AdminMenu()*/
    public static void ChangePriv(){
        /* This will change a faculties isAdmin privileges back and forth*/
        System.out.println("------CHANGE USER PRIVILEGES------");
        String facultyInQuestion;
        Connection connection;
        boolean found = true;

        System.out.println("Please enter the Faculty User Number: ");
        Scanner scan = new Scanner(System.in);
        facultyInQuestion = scan.nextLine();

        String searchQuery = "SELECT FROM FacultyMembers WHERE FacultyNumber="+facultyInQuestion+";";

        try {
            connection = DBConnection.connect();
            Statement stmt = connection.createStatement();
            found = stmt.execute(searchQuery);
        }
        catch(Exception e){System.err.println(e.getMessage());}


        if(found){
            //NEED AN ADMIN CHECK
            //TODO:
            //Found: List all info pertaining to that user
            System.out.println("User Information: ");

            System.out.println("Are you sure you wish to change user privileges? Y or N");
            Scanner newScan = new Scanner(System.in);
            facultyInQuestion = scan.nextLine();

            if(facultyInQuestion.equals("Y")){

                //check is faculty is admin or not
                String isAdmin = "Y";

                if(isAdmin.equals("Y")){
                    String no = "N";
                    String updateQuery = "UPDATE FacultyMembers SET isAdministrator="+no+" WHERE FacultyNumber="+facultyInQuestion+";";
                    try {
                        connection = DBConnection.connect();
                        Statement stmt = connection.createStatement();
                        found = stmt.execute(updateQuery);
                    }
                    catch(Exception e){System.err.println(e.getMessage());}


                }
                if(isAdmin.equals("N")){
                    String yes = "Y";
                    String updateQuery = "UPDATE FacultyMembers SET isAdministrator="+yes+" WHERE FacultyNumber="+facultyInQuestion+";";
                    try {
                        connection = DBConnection.connect();
                        Statement stmt = connection.createStatement();
                        found = stmt.execute(updateQuery);
                    }
                    catch(Exception e){System.err.println(e.getMessage());}
                }

                //success and return to admin main menu
                System.out.println("User successfully updated!");
                showAdminMenu();
            }
            else if (facultyInQuestion.equals("N")){
                // Return to Admin main menu
                System.out.println("User NOT updated.");
                showAdminMenu();
            }
            else {
                System.out.println("Command Not Recognized");
                // Return to Admin main menu
                showAdminMenu();
            }
        }

        if(!found) {
            System.out.println("We did not find who you were looking for.");
            // Return to Admin main menu
            showAdminMenu();
        }
        else{
            System.out.println("Command Not Recognized");
            // Return to Admin main menu
            showAdminMenu();
        }
    }
}
