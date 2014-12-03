/**
 * Created by: Brittany Dinneen
 * Group Name: LostInERwin
 * Due 12/03/2014
 *
 * TODO:
 * 1. ChangePriv()
 * 2. Ensure only admin get into this menu
 */

import java.sql.*;
import java.util.*;

public class AdminMenu {

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
                // not anymore -- frank.
                // return to root menu with usertype 'F' for Faculty
                RootMenu root = new RootMenu();
                root.showMainMenu();
                return;
            default:
                System.out.println("error: a menu selection specified is out of bounds. Select 1-4.");
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

            System.out.print("Preferred Course Days (MTWRF): ");
            days = scan.nextLine();
            newUserInfo.add(days);

            System.out.print("Preferred Course Time (Morning-Afternoon-Night):");
            time = scan.nextLine();
            newUserInfo.add(time);

            System.out.print("Gender (M or F): ");
            gender = scan.nextLine();
            newUserInfo.add(gender);

            System.out.print("Phone Number (XXXAAAXXXX): ");
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
                String insertQuery = "INSERT INTO Students VALUES('" + newSNumber + "','" + newFirstName + "','" + newLastName + "','" + newSemester + "','" + newDays + "','" + newTime + "','" + newGender + "','" + newPhoneNumber + "')";

                //add query

                try {
                    Connection connection;
                    connection = DBConnection.connect();
                    Statement stmt = connection.createStatement();
                    stmt.executeUpdate(insertQuery);
                }
                catch(SQLException e){e.printStackTrace();}

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
            newUserInfo.add(facNum);

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

            System.out.print("Preferred Course Days (MTWRF):");
            days = scan.nextLine();
            newUserInfo.add(days);

            System.out.print("Preferred Course Times (Morning-Afternoon-Night):");
            time = scan.nextLine();
            newUserInfo.add(time);

            System.out.print("Gender (M or F): ");
            gender = scan.nextLine();
            newUserInfo.add(gender);

            System.out.print("Phone Number (XXXAAAXXXX): ");
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
                String insertQuery = "INSERT INTO FacultyMembers VALUES('"+newFacultyNumber+"','"+newFirstName+"','"+newLastName+"','"+newPosition+"','"+newAreaOfExpertise+"','"+newDays+"','"+newTimes+"','"+newGender+"','"+newPhone+"','"+newPriveleges+"','"+newPassword+"')";

                //add query
                try {
                    Connection connection;
                    connection = DBConnection.connect();
                    Statement stmt = connection.createStatement();
                    stmt.executeUpdate(insertQuery);
                }
                catch(SQLException e){e.printStackTrace();}

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
       // Connection connection;

        System.out.println("Please enter the User Number you would like to delete: ");
        Scanner scan = new Scanner(System.in);
        userInQuestion = scan.nextLine();

        first = userInQuestion.charAt(0);

        if (first == 'F') {
            System.out.println("Are you sure you wish to delete Faculty member " + userInQuestion+"? Y or N");
            Scanner newScan = new Scanner(System.in);
            choice = scan.nextLine();

            if (choice.equals("Y")) {
                String deleteQuery = "DELETE FROM FacultyMembers WHERE FacultyNumber='"+ userInQuestion+"'";
                System.out.println("query "+deleteQuery);

                try {
                    Connection connection;
                    System.out.println("got into try");
                    connection = DBConnection.connect();
                    Statement stmt = connection.createStatement();
                    stmt.execute(deleteQuery);//Call to DELETE QUERY
                } catch(SQLException e){e.printStackTrace();}

                //success and return to admin main menu
                showAdminMenu();
            } else if (choice.equals("N")) {
                System.out.println("Faculty was not be deleted");
                // Return to Admin main menu
                showAdminMenu();
            } else {
                System.out.println("Command Not recognized");
                // Return to Admin main menu
                showAdminMenu();
            }

        }
        if (first == 'S') {
            System.out.println("Number entered: "+userInQuestion);

            System.out.println("Are you sure you wish to delete Student listed above? Y or N");
            Scanner newScan = new Scanner(System.in);
            choice = scan.nextLine();

            if (choice.equals("Y")) {
                String deleteQuery = "DELETE FROM Students WHERE StudentNumber='" + userInQuestion + "'";

                try {
                    Connection connection;
                    connection = DBConnection.connect();
                    Statement stmt = connection.createStatement();
                    stmt.execute(deleteQuery);
                } catch(SQLException e){e.printStackTrace();}

                //success and return to admin main menu
                showAdminMenu();
            } else if (choice.equals("N")) {
                System.out.println("Student was not be deleted");
                // Return to Admin main menu
                showAdminMenu();
            } else {
                System.out.println("Command Not recognized");
                // Return to Admin main menu
                showAdminMenu();
            }
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

        Login britsLogin = new Login();
        char isAdmin = '0';
        String option;

        System.out.println("Please enter the Faculty User Number: ");
        Scanner scan = new Scanner(System.in);
        facultyInQuestion = scan.nextLine();

        try {
            isAdmin = britsLogin.isAdministrator(facultyInQuestion);
        }catch(SQLException e){e.printStackTrace();}

        System.out.println("Are you sure you wish to change user privileges for " +facultyInQuestion+"? Y or N");
        Scanner newScan = new Scanner(System.in);
        option = newScan.nextLine();

        if(option.equals("Y")) {
            if (isAdmin == '1') {
                String no = "0";
                String updateQuery = "UPDATE FacultyMembers SET isAdministrator='"+no+"' WHERE FacultyNumber='"+facultyInQuestion+"'";
                try {
                    Connection connection;
                    connection = DBConnection.connect();
                    Statement stmt = connection.createStatement();
                    stmt.execute(updateQuery);
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
            if (isAdmin == '0') {
                String yes = "1";
                String updateQuery = "UPDATE FacultyMembers SET isAdministrator='" + yes + "' WHERE FacultyNumber='"+facultyInQuestion+"'";
                try {
                    Connection connection;
                    connection = DBConnection.connect();
                    Statement stmt = connection.createStatement();
                    stmt.execute(updateQuery);
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }
        if(option.equals("N")){
            System.out.println("Faculty was not updated");
            // Return to Admin main menu
            showAdminMenu();
        }
/*        else{
            System.out.println("Command Not Recognized");
            // Return to Admin main menu
            showAdminMenu();
        }*/
    }
}
