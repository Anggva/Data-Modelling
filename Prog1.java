import java.io.*;
import java.util.*;

public class Prog1{
   public static void main (String[] args) throws Exception{
      int choice = 0;
      String UserName, Password;
		
      AdminMenu AM = new AdminMenu();
      StudentMenu SM = new StudentMenu();
      
      InputStreamReader is = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(is);
      String line;
//CREATE MASTER LOGIN
		System.out.println("Username: ");
		UserName = br.readLine();
		System.out.println("Password: ");
		Password = br.readLine();
		
		
      while (choice != 5){
      System.out.println("LOST IN ERwIN|");
      System.out.println("-------------/");
      System.out.println("1)Student Menu");
      System.out.println("2)Faculty Menu");
      System.out.println("3)Reporting Menu");
      System.out.println("4)Administrative Menu");
      System.out.println("5)EXIT");
      System.out.println("\n\n");
      System.out.println("Please input a menu option: ");
      line = br.readLine();
      //System.out.println(line);
      choice = Integer.parseInt(line);
      while (choice < 1 || choice > 5){
         System.out.println("That menu option doesn't exist, please try again:");
         line = br.readLine();
         choice = Integer.parseInt(line);
      }
      //while (choice != 5){
      switch(choice){
            case 1:
               //StdMn();
               SM.menu();
               System.out.println("Press Enter");
               line = br.readLine();
               break;
            case 2:
               FcltyMn();
               System.out.println("Press Enter");
               line = br.readLine();
               break;
            case 3:
               RprtMn();
               System.out.println("Press Enter");
               line = br.readLine();
               break;
            case 4:
               //AdmnMn();
               AdminMenu.showAdminMenu();
               System.out.println("Press Enter");
               line = br.readLine();
               break;
            /*case 5:
               System.exit(0);
               return;*/
      }}
   }
   public static void StdMn(){
      System.out.println("Student Menu|");
      System.out.println("------------/");
      System.out.println("1)New Student");
      System.out.println("2)Courses needed");
      System.out.println("3)Preferred Schedule");
      System.out.println("4)Term Schedule");
      System.out.println("5)Statistics");
      System.out.println("6)Main Menu");
   }
   public static void FcltyMn(){
      System.out.println("Faculty Menu|");
      System.out.println("------------/");
      System.out.println("1)Faculty Login");
      System.out.println("2)Course preferences");
      System.out.println("3)See student requested courses");
      System.out.println("4)Display past forms");
      System.out.println("5)Edit course preference form");
      System.out.println("6)Print Forms");
      System.out.println("7)Main Menu");
   }
   public static void RprtMn(){
      System.out.println("Reporting Menu|");
      System.out.println("--------------/");
      System.out.println("1)Course Listing");
      System.out.println("2)Day Listing");
      System.out.println("3)Time Listing");
      System.out.println("4)Student Listing");
      System.out.println("5)Faculty Listing");
      System.out.println("6)Main Menu");
   }
}