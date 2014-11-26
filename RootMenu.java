/*
    This menu design is not ideal because the try-catch blocks and the menus themselves are
    copy-paste replications of the first menu... I have an interface for a menu. I'll make
    this a lot better tomorrow (11/25).

        -- Frank
 */

/*
    This works but it's very sloppy. My main focus here is showReportMenu().
    Some query ideas:

        For example, take the first victim, Course listing.

            SELECT CourseNumber, DaysOfTheWeek, Time, FacultyTeaching
            FROM Section
            WHERE StudentsEnrolled = "someStudent";

    (I also might need to know how students are related to their courses.
    Is StudentsEnrolled a column that keeps student names, and we can just
    COUNT() them to get the section occupancy? Something to think about)
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class RootMenu {

    public void showMainMenu() {

        // main menu

        while (true) {

            System.out.println("   LOST IN ERWIN ");
            System.out.println("________________________");
            System.out.println("1) Student Menu\n" +
                               "2) Faculty Menu\n" +
                               "3) Reporting Menu\n" +
                               "4) Administrative Menu\n" +
                               "------------------------\n" +
                               "5) EXIT\n");

            Scanner option = new Scanner(System.in);
            try {

                byte opt = option.nextByte();

                switch (opt) {

                    case 1:
                        showStudentMenu();
                        break;

                    case 2:  //showFacultyMenu();
                        break;

                    case 3:
                        showReportMenu();
                        break;

                    case 4:  //showAdminMenu();
                        break;

                    case 5:
                        System.out.println("Bye!");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("error: a menu selection specified is" +
                                " out of bounds. Select 1-5.\n");

                }

            } catch (InputMismatchException ex) {
                // clear for the next input attempt.
                option.nextLine();
                System.out.println("You did not choose a proper number between 1 and 5. Please" +
                        " try again.");

            }




        }


    }

    private void showStudentMenu() {

        /* Student Menu while loop
        *  reminder! a new while loop is required for
        *  each sub-menu. Is there a better method? */

          while (true) {

            System.out.println("\t     Student Menu");
            System.out.println("\t======================");
            System.out.println("\t1)New Student\n" +
                               "\t2)Courses Needed\n" +
                               "\t3)Preferred Schedule\n" +
                               "\t4)Term Schedule\n" +
                               "\t5)Statistics\n" +
                               "\t-----------------------\n" +
                               "\t6)RETURN to Main Menu");

            Scanner option = new Scanner(System.in);
              try {
                  byte opt = option.nextByte();

                  switch (opt) {

                      case 1:
                          System.out.println("Creating new student...\n");
                          break;

                      case 2:
                          System.out.println("Ask DB for courses needed.\n");
                          break;

                      case 3:
                          System.out.println("Ask student for preferred course schedule.\n");
                          break;

                      case 4:
                          System.out.println("Get term schedule for student.\n");
                          break;

                      case 5:
                          System.out.println("Get student stats.\n");
                          break;

                      case 6:
                          System.out.println("Going up to main menu.\n");
                          return;


                      default:
                          System.out.println("error: a menu selection specified is" +
                                  " out of bounds. Select 1-6.\n");
                  } // end switch
              } catch (InputMismatchException ex) {
                  // clear for the next input attempt.
                  option.nextLine();
                  System.out.println("You did not choose a proper number between 1 and 6. Please" +
                          " try again.");
              }

        } // end while


        }
/*  showReportMenu() calls and displays all of the RowSets from the queries
    to the Oracle DB.
 */
    private void showReportMenu() {

        while (true) {
            System.out.println("--------------------\n" +
                            "   REPORTING MENU\n" +
                            "====================\n" +
                            "\n" +
                            "1) Course listing\n" +
                            "2) Day listing\n" +
                            "3) Time listing\n" +
                            "4) Student listing\n" +
                            "5) Faculty listing\n" +
                            "---------------------\n" +
                            "6) Back to main menu"
            );

            // instantiate the ReportGen class and prepare its methods for
            // usage.

            ReportGen reportGen = new ReportGen();




            Scanner option = new Scanner(System.in);
            try {
                byte opt = option.nextByte();

                switch (opt) {

                    case 1:
                        System.out.println("Getting course listing...\n");
                        System.out.println(reportGen.getReport(opt, 's'));
                        break;

                    case 2:
                        System.out.println("Getting current day information...\n");
                        System.out.println(reportGen.getReport(opt, 's'));
                        break;

                    case 3:
                        System.out.println("Getting current time related information" +
                                "for student...\n");
                        System.out.println(reportGen.getReport(opt, 's'));
                        break;

                    case 4:
                        System.out.println("Getting the student's course information...\n");
                        System.out.println(reportGen.getReport(opt, 's'));
                        break;

                    case 5:
                        System.out.println("Getting the faculty list for student...\n");
                        System.out.println(reportGen.getReport(opt, 's'));
                        break;

                    case 6:
                        System.out.println("Going up to main menu.\n");
                        return;
                    default:
                        System.out.println("error: a menu selection specified is" +
                                " out of bounds. Select 1-6.\n");
                } // end switch
            } catch (InputMismatchException ex) {
                // clear for the next input attempt.
                option.nextLine();
                System.out.println("You did not choose a proper number between 1 and 6. Please" +
                        " try again.");
            }
        } // end while(true)
    }

    }



   
   
