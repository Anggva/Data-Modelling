/**
 * Created by Brittany Dinneen on 11/24/2014.
 * This is currently a work in progress so code is NOT complete!
 *
 * TODO:
 * 1. Link to working menu
 * 2. Figure out login
 * 3. Once Queries are finished add in where necessary
 */


import java.sql.*;
import java.util.*;
import java.sql.*;


public class AdminMenu {
    public static void main (String[] args) {

        //this will connect code to Olympia
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

        showAdminMenu();
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
        String crsneed;
        String prefcourse;
        String days;
        String time;
        String gender;
        String pnum;
        String position;
        String aoe;
        String coursesTaught;
        String isAdmin;///DOES THIS NEED TO BE GLOBAL??
        Scanner scan = new Scanner(System.in);

        choice = scan.nextLine();

        if(choice.equals("S")){
            System.out.println("------Creating New Student User------");
            System.out.println("Please enter new user information for EVERY field");

            System.out.print("First Name: ");
            fn = scan.nextLine();
            newUserInfo.add(fn);

            System.out.print("Last Name: ");
            ln = scan.nextLine();
            newUserInfo.add(ln);

            System.out.print("Semester (Fall-Spring-Summer):");
            sem = scan.nextLine();
            newUserInfo.add(sem);

            System.out.print("Courses Needed: ");
            crsneed = scan.nextLine();
            newUserInfo.add(crsneed);

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

            System.out.println("New User: " + newUserInfo.toString());
            System.out.println("Is this correct Y or N? ");
            Scanner choicescan = new Scanner(System.in);
            String stdadd = choicescan.nextLine();

            if(stdadd.equals("Y")){
                //add query
                //INSERT INTO Student VALUES (‘studentnumber’, ‘firstname’, ‘lastname’, ‘Fall/Spring/Summer’, ‘coursesneeded’, ‘MW/MWF/TH’, ‘Morning (9 am – Noon)/Afternoon (Noon – 4:15 pm)/Evening (4:30 pm – 9:10 pm)’, ‘M/F’, ‘phonenumber’);
                //success
                System.out.println("User successfully added!");
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
            System.out.println("Please enter new user information for EVERY field with NO spaces");

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

            System.out.println("New User: " + newUserInfo.toString());
            System.out.println("Is this correct Y or N? ");
            Scanner choicescan = new Scanner(System.in);
            String stdadd = choicescan.nextLine();

            if(stdadd.equals("Y")){
                //add query
                //INSERT INTO Faculty VALUES (‘facultynumber’, ‘firstname’, ‘lastname’, ‘position’, ‘areaofexpertise’, ‘coursestaught’, ‘MW/MWF/TH’,  ‘Morning (9 am – Noon)/Afternoon (Noon – 4:15 pm)/Evening (4:30 pm – 9:10 pm)’, ‘M/F’, ‘phonenumber’, ‘Y/N’);
                //success
                System.out.println("User successfully added!");
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

        first = userInQuestion.charAt(0);

        if(first == 'F'){
            //SELECT from Faculty WHERE FacultyNumber = userInQuestion;
            if(found){
                //Found: List all info pertaining to that user
                System.out.println("User Information: ");

                System.out.println("Are you sure you wish to delete user listed above? Y or N");
                Scanner newScan = new Scanner(System.in);
                choice = scan.nextLine();

                if(choice.equals("Y")){
                    System.out.println("You chose yes");
                    // DELETE from Faculty WHERE FacultyNumber = userInQuestion;
                    //Call to DELETE QUERY
                    //success and return to admin main menu
                }
                else if (choice.equals("N")){
                    System.out.println("You chose no");
                    // Return to Admin main menu
                    showAdminMenu();
                }
                else {
                    System.out.println("Command Not recognized");
                    // Return to Admin main menu
                    showAdminMenu();
                }
            }

            if(!found){
                System.out.println("We did not find who you were looking for.");
                // Return to Admin main menu
                showAdminMenu();
            }
        }
        if(first == 'S'){
            //   SELECT from Student WHERE StudentNumber = userInQuestion;
            if(found){
                //Found: List all info pertaining to that user
                System.out.println("User Information: ");

                System.out.println("Are you sure you wish to delete user listed above? Y or N");
                Scanner newScan = new Scanner(System.in);
                choice = scan.nextLine();

                if(choice.equals("Y")){
                    System.out.println("You chose yes");
                    // DELETE from Student WHERE StudentNumber = userInQuestion;
                    //Call to DELETE QUERY
                    //success and return to admin main menu
                    showAdminMenu();
                }
                else if (choice.equals("N")){
                    System.out.println("Student will not be deleted");
                    // Return to Admin main menu
                    showAdminMenu();
                }
                else {
                    System.out.println("Command Not recognized");
                    // Return to Admin main menu
                    showAdminMenu();
                }
            }

            if(!found){
                System.out.println("We did not find who you were looking for.");
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
        String choice;

        System.out.println("Please enter the Faculty User Number: ");
        Scanner scan = new Scanner(System.in);
        boolean found = true;

        if(found){
            //NEED AN ADMIN CHECK
            //Found: List all info pertaining to that user
            System.out.println("User Information: ");

            System.out.println("Are you sure you wish to change user privileges? Y or N");
            Scanner newScan = new Scanner(System.in);
            choice = scan.nextLine();

            if(choice.equals("Y")){
                //what are we changing???
                //change/alter DB
                //success and return to admin main menu
                //success
                System.out.println("User successfully updated!");
                showAdminMenu();
            }
            else if (choice.equals("N")){
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
