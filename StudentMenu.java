import java.io.*;
import java.util.*;

public class StudentMenu {
   public static String SNumber = "x", FirstName = "", LastName = "", Phone = "", Year = "";
   public static char Gender = ' ';
   public static String[] DaysChosen = new String [7];
   public static String[] AvailableTimes = new String[7];
   public static String[] TermSched = new String[7];
	public static String[] PreferredSchedule = new String[7];
   
   public static void menu ()throws Exception {
      int choice = 0;
      
      /*String SNumber = "", FirstName = "", LastName = "", Phone = "", Year = "";
      char Gender = ' ';
      String[] DaysChosen = new String [7];
      String[] AvailableTimes = new String[7];
      String[] TermSched = new String[7];*/
      
      InputStreamReader is = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(is);
      String line;
      
		while (choice != 7){
      System.out.println("Student Menu|");
      System.out.println("------------/");
      System.out.println("1)Student Information");
      System.out.println("2)Courses needed");
      System.out.println("3)Preferred Days");
      System.out.println("4)Preferred Times");
      System.out.println("5)Preferred Schedule");
      System.out.println("6)Statistics");
      System.out.println("7)Main Menu");
      System.out.println("Please input a menu option: ");
      line = br.readLine();
      
      choice = Integer.parseInt(line);
      while(choice < 1 || choice > 7){
         System.out.println("That menu option doesn't exist, please try again:");
         line = br.readLine();
         choice = Integer.parseInt(line);
      }
      switch(choice){
         case 1:
            StudentInfo(StudentMenu.SNumber, StudentMenu.FirstName, StudentMenu.LastName, StudentMenu.Gender, StudentMenu.Phone);
            System.out.println("Press Enter");
            line = br.readLine();
            System.out.println(StudentMenu.SNumber);
            break;
         case 2:
            CoursesNeeded(StudentMenu.Year);
            System.out.println("Press Enter");
            line = br.readLine();
            break;
         case 3:
            PreferredDays(StudentMenu.DaysChosen);
            System.out.println("Press Enter");
            line = br.readLine();
            break;
         case 4:
            PreferredTimes(StudentMenu.DaysChosen, StudentMenu.AvailableTimes);
            System.out.println("Press Enter");
            line = br.readLine();
            break;
         case 5:
            PreferredSchedule();
            System.out.println("Press Enter");
            line = br.readLine();
            break;
         case 6:
            Stats();
            System.out.println("Press Enter");
            line = br.readLine();
            break;
  		}    
		}
   }
//STUDENT INFO
	public static void StudentInfo(String SNumber, String FirstName, String LastName, char Gender, String Phone) throws Exception{
      //String SNumber, FirstName, LastName, Gender, Phone;
      InputStreamReader is = new InputStreamReader (System.in);
      BufferedReader br = new BufferedReader (is);
      String line;
      
      System.out.println("STUDENT INFORMATION");
      System.out.println("Please enter your Student Number:");
      line = br.readLine();
      StudentMenu.SNumber = line.toUpperCase();
      System.out.println("First Name:");
      line = br.readLine();
      StudentMenu.FirstName = line.toUpperCase();
      System.out.println("Last Name:");
      line = br.readLine();
      StudentMenu.LastName = line.toUpperCase();
      System.out.println("Do you have a penis or a vagina:");
      line = br.readLine();
      StudentMenu.Gender = line.toUpperCase().charAt(0);
      System.out.println("Phone Number:");
      line = br.readLine();
      StudentMenu.Phone = line.toUpperCase();
   }
//COURSES NEEDED
	public static void CoursesNeeded(String Year) throws Exception{
		int year;
      
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (is);
		String line, semester, year1;
		
		System.out.println("Please enter a school year: ");
		line = br.readLine();
      year1 = line;
		year = Integer.parseInt(line);
		
		System.out.println("Wonderful. Fall semester or Spring semester?");
		line = br.readLine();
		semester = line.toUpperCase();
		
		System.out.println("You've chosen " + semester +  " of " + year);
      
      StudentMenu.Year = semester.charAt(0) + year1;
		
		if (year % 2 == 0){
			if (semester.compareTo("SPRING") == 0){
				System.out.println("REQUIRED COURSES");
				System.out.println("COT3100: COMP STRUCTURES");
				System.out.println("COP3538: DATA STRUCTURES USING OOP");
				System.out.println("COP3855: WEB ACCESS & SYSTS. DESIGN");
				System.out.println("COP4640: OS ENVIRON. & ADMIN.");
				System.out.println("COP4504: NTWK & DIST PROC");
				System.out.println("CIS4328: SR. PROJECT II");
				if (year >= 2009){
					System.out.println("ISM4011: INTRO TO MGMT INFO SYSTEMS");
				}
				System.out.println("ELECTIVES");
				System.out.println("COP4770: DATA MINING");
				System.out.println("CDA3101: INTRO TO COMP HRDWR");
				System.out.println("CIS4100: SYSTEM PERF & EVAL");
				System.out.println("CEN4801: SYSTEM INTEGERATION");
				System.out.println("CIS4362: COMPUTER CRYPTOGRAPHY");
            System.out.println("COP4813: INTERNET PROGRAMMING");
				System.out.println("Choose One:");
				System.out.println("CAP4774: DATA WAREHOUSING");
            System.out.println("COP4722: DATABASE SYSTEMS II");
            System.out.println("COP4723: DATABASE ADMIN");
			}
			else if (semester.compareTo("FALL") == 0){
				System.out.println("REQUIRED COURSES");
				System.out.println("COT3100: COMP STRUCTURES");
				System.out.println("COP3538: DATA STRUCTURES USING OOP");
				System.out.println("COP3855: WEB ACCESS & SYST DESIGN");
				System.out.println("COP4720: DATABASE SYSTEMS");
				System.out.println("CIS4253: LEGAL/ETHICAL ISSUES");
				System.out.println("CIS4327: SR. PROJECT I");
				if (year >= 2009){
					System.out.println("ISM4011: INTRO TO MGMT INFO SYSTEMS");
				}
            System.out.println("ELECTIVES");
            System.out.println("CDA3101: INTRO TO COMP HARDWARE");
            System.out.println("CDA4010: HUMAN FACTORS/COLLAB");
            System.out.println("CIS4510: EXPERT SYS/DECISION SUPPT");
            System.out.println("Choose One:");
            System.out.println("COT4111: COMP STRUCTURES II");
            System.out.println("COT4461: COMP BIOLOGY");
            System.out.println("COT4560: APPLIED GRAPH THRY");
			}
         else{
            System.out.println("You have chosen an invalid semester.");
         }
      }
      else{
         if (semester.compareTo("SPRING") == 0){
				System.out.println("REQUIRED COURSES");
            System.out.println("COT3100: COMP STRUCTURES");
            System.out.println("COP3538: DATA STRUCTURES USING OOP");
            System.out.println("COP3855: WEB ACCESS & SYSTS. DESIGN");
				System.out.println("COP4640: OS ENVIRON. & ADMIN.");
				System.out.println("COP4504: NTWK & DIST PROC");
            System.out.println("CIS4328: SR. PROJECT II");
            if (year >= 2009){
					System.out.println("ISM4011: INTRO TO MGMT INFO SYSTEMS");
				}
            System.out.println("ELECTIVES");
				System.out.println("COP4770: DATA MINING");
            System.out.println("CDA3101: INTRO TO COMP HRDWR");
				System.out.println("CIS4100: SYSTEM PERF & EVAL");
				System.out.println("CEN4801: SYSTEM INTEGERATION");
				System.out.println("CIS4362: COMPUTER CRYPTOGRAPHY");
            System.out.println("COP4813: INTERNET PROGRAMMING");
            System.out.println("Choose One:");
				System.out.println("CAP4774: DATA WAREHOUSING");
            System.out.println("COP4722: DATABASE SYSTEMS II");
            System.out.println("COP4723: DATABASE ADMIN");
         }
         else if (semester.compareTo("FALL") == 0){
				System.out.println("REQUIRED COURSES");
				System.out.println("COT3100: COMP STRUCTURES");
				System.out.println("COP3538: DATA STRUCTURES USING OOP");
				System.out.println("COP3855: WEB ACCESS & SYST DESIGN");
				System.out.println("COP4720: DATABASE SYSTEMS");
				System.out.println("CIS4253: LEGAL/ETHICAL ISSUES");
				System.out.println("CIS4327: SR. PROJECT I");
				if (year >= 2009){
					System.out.println("ISM4011: INTRO TO MGMT INFO SYSTEMS");
				}
            System.out.println("ELECTIVES");
            System.out.println("CDA3101: INTRO TO COMP HARDWARE");
            System.out.println("CDA4010: HUMAN FACTORS/COLLAB");
            System.out.println("CIS4510: EXPERT SYS/DECISION SUPPT");
            System.out.println("Choose One:");
            System.out.println("COT4111: COMP STRUCTURES II");
            System.out.println("COT4461: COMP BIOLOGY");
            System.out.println("COT4560: APPLIED GRAPH THRY");
			}
         else{
            System.out.println("You have chosen an invalid semester.");
         }
		}
	}
//PREFERRED DAYS
   public static void PreferredDays(String[] DaysChosen) throws Exception{
      InputStreamReader is = new InputStreamReader (System.in);
      BufferedReader br = new BufferedReader (is);
      String line;
      
      System.out.println("What are your preferred days?");
      System.out.println("M, T, W, R, F, S (Separate with spaces)");
      line = br.readLine();
      StudentMenu.DaysChosen = line.toUpperCase().split("\\s+");
      System.out.println(StudentMenu.DaysChosen.length);
      System.out.println("The days you have chosen are: ");
      for (int i = 0; i < StudentMenu.DaysChosen.length; i++){
         if (StudentMenu.DaysChosen[i].compareTo("M") == 0){
            System.out.println("MONDAY");
         }
         else if (StudentMenu.DaysChosen[i].compareTo("T") == 0){
            System.out.println("TUESDAY");
         }
         else if (StudentMenu.DaysChosen[i].compareTo("W") == 0){
            System.out.println("WEDNESDAY");
         }
         else if (StudentMenu.DaysChosen[i].compareTo("R") == 0){
            System.out.println("THURSDAY");
         }
         else if (StudentMenu.DaysChosen[i].compareTo("F") == 0){
            System.out.println("FRIDAY");
         }
         else if (StudentMenu.DaysChosen[i].compareTo("S") == 0){
            System.out.println("SATURDAY");
         }
         else{
            System.out.println("The day " + StudentMenu.DaysChosen[i] + " is not a valid day.");
         }
      }
   }
//PREFERRED TIMES
   public static void PreferredTimes(String[] DaysChosen, String[] AvailableTimes) throws Exception{
      InputStreamReader is = new InputStreamReader (System.in);
      BufferedReader br = new BufferedReader (is);
      String line;

      String [] StartTime = new String[StudentMenu.DaysChosen.length];
      String [] EndTime = new String[StudentMenu.DaysChosen.length];

      for (int i = 0; i < StudentMenu.DaysChosen.length; i++){
         System.out.println("What time can you start on " + StudentMenu.DaysChosen[i] + "?");
         line = br.readLine();
         StartTime[i] = line;
         System.out.println("What time do you have to leave on " + StudentMenu.DaysChosen[i] + "?");
         line = br.readLine();
         EndTime[i] = line;
      }
      for (int i = 0; i < StudentMenu.DaysChosen.length; i++){
         StudentMenu.AvailableTimes[i] = (StartTime[i] + " - " + EndTime[i]);
      }
      System.out.println("This is your Preferred Schedule: ");
      for (int i = 0; i < StudentMenu.DaysChosen.length; i++){
         System.out.println(StudentMenu.DaysChosen[i] + ": " + StudentMenu.AvailableTimes[i]);
      }
   }
//PREFERRED SCHEDULE
   public static void PreferredSchedule() throws Exception{
      System.out.println("Your preferred schedule: ");
      for (int i = 0; i < StudentMenu.DaysChosen.length; i++){
         StudentMenu.PreferredSchedule[i] = (StudentMenu.DaysChosen[i] + ": " + StudentMenu.AvailableTimes[i]);
			System.out.println(StudentMenu.PreferredSchedule[i]);
      }
   }
//STATS
//StudentMenu.Phone, StudentMenu.Year, StudentMenu.DaysChosen, StudentMenu.AvailableTimes
	public static void Stats() throws Exception{
		System.out.println(StudentMenu.SNumber);
		System.out.println(StudentMenu.FirstName + " " + StudentMenu.LastName);
		System.out.println("Gender: " + StudentMenu.Gender);
		System.out.println(StudentMenu.Phone);
		System.out.println("Student has chosen to view for the " + StudentMenu.Year + " school year.");
		System.out.println("Student's preferred schedule: ");
		int i = 0;
		while (StudentMenu.PreferredSchedule[i] != null){
			System.out.println(StudentMenu.PreferredSchedule[i]);
			i++;
		}
	}
      
}