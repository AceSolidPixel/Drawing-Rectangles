/*
Prince Angulo 
Giovanni Contreras
Jafet Oidor Ortega
Date: 9/15/2020
CECS 277
Description: Display rectangles at coordinates and sizes decided by the user.
*/
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;


public class Main
{
   public static void main(String[] args)
   {
      ArrayList <Rect> tangles = new ArrayList <Rect> (); //Declare an ArrayList of rectangles
      char [][] grid = new char [30][30]; //Declare a 2D array of characters
      for(int i = 0; i < 30; i++) //Make all of the elements a period to indicate an empty space
      {
         for(int j = 0; j < 30 ; j++)
         {
            grid [i][j] = '.';
         }
      }
      
      System.out.println("How many rectangles would you like to draw (1-5)?"); //Prompt user
      Scanner in = new Scanner(System.in);
      int input = getIntRange(1,5); //Call getIntRange to make sure that the input is valid
      
      for(int i = 0; i < input; i++) //Prompt user for rectangle specs and add them to the ArrayList
      {
         tangles.add(getRect(i)); 
      }
      
      char fill = '0'; //Character that will fill in the area filled in by the rectangle
      
      for(int i = 0; i < input; i++)
      {
         switch(i) //The character will be decided by which triangle is being printed
         {         //For example, the first inputted rectangle will fill its area with a 1, up to 5 rectangles are supported
            case 0:
               fill = '1';
               break;
               
            case 1:
               fill = '2';
               break;
               
            case 2:
               fill = '3';
               break;
               
            case 3:
               fill = '4';
               break;
               
            case 4:
               fill = '5';
               break;
               
            default:
               break;
         }
         fillRect(grid, tangles.get(i), fill); //Facilitates the writing into the array.
      }
      displayGrid(grid); //Displays the grid at the end
   }

/* The displayGrid method displays the grid at the end of the program to reflect what the user's rectangle's area 

   @param map - 2D array that is passed by reference so that its data may be diplayed for the user 
*/

   public static void displayGrid(char map [][])
   {
      for(int i = 0; i < 30; i++)
      {
         for(int j = 0; j < 30 ; j++)
         {
            System.out.print(map [i][j]);
         }
         System.out.println(); //This statement moves the cursor to the next line
      }
   }
  
/* The getRect method prompts the user to input the specifications of the rectangle they want to build

   @param iterator - This parameter only serves the function of labeling the rectangle that the user is currently creating
   @return Rect - return a Rect object to be added to an ArrayList
*/  
   
   public static Rect getRect(int iterator)
   {  
      Scanner in = new Scanner(System.in);
      int xInput = 0;
      int yInput = 0;
      int widthInput = 0;
      int heightInput = 0;
      
      System.out.print("Please enter x location of rectangle " + (iterator + 1) + " (1-30): "); 
      xInput = getIntRange(1,30); //Input validation
      System.out.print("Please enter y location of rectangle " + (iterator + 1) + " (1-30): ");
      yInput = getIntRange(1,30); //Input validation
      System.out.print("Please enter width of rectangle " + (iterator + 1) + " (1-" + (31-xInput) + "): ");
      widthInput = getIntRange(1, (31-xInput)); //Input validation
      System.out.print("Please enter height of rectangle " + (iterator + 1) + " (1-" + (31-yInput) + "): ");
      heightInput = getIntRange(1, (31-yInput)); //Input validation
      
      Rect map = new Rect((yInput - 1), (xInput - 1), (widthInput - 1), (heightInput - 1));
      return map;
   }

/* The fillRect method facilitates the filling of the 2D array that will be displayed at the end, 
   using a character based on which rectangle it is.
   
   @param map - 2D array that is passed by reference so that its data may be formatted to reflect the user's rectangles
   @param box - A Rect object which is contained and passed by an ArrayList containing the specs of a user-created rectangle
   @param fill - a character passed by a switch statment in the main method that shows which reactangle is occypying that space(s).
*/
   
   public static void fillRect(char map [][], Rect box, char fill)
   {
      for(int i = box.getX(); i <= (box.getX() + box.getHeight()); i++)
      {
         for(int j = box.getY(); j <= (box.getY() + box.getWidth()); j++)
         {
            map[i][j] = fill;
         }
      }
   }
    
/*
   The getIntRange function prompts the user to enter a number between a start number
   and an end number and continues looping until the user does so
   
   @param startNum Lower Bounds of integer range the user can enter
   @param endNum Upper Bounds of integer range the user can enter
   @return Integer entered by user within passed in range
*/   
   public static int getIntRange(int startNum, int endNum)
   {
      Scanner input = new Scanner(System.in);
      boolean repeat = true;
      int returnVal = 0;
      while (repeat)
      {
         returnVal = 0;
         try
         {
            returnVal = input.nextInt();
            if (returnVal <= endNum && returnVal >= startNum)
            {
               repeat = false;
            }
            else
            {
               System.out.println("Invalid Input");
            }
         }catch(InputMismatchException e)
          {
            if (input.hasNext())
            {
               String stuff = input.next();
            }
            System.out.println("Invalid Input");
          }
        
       }
      return returnVal; 
   }  
}