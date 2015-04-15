/* Rachel Bayersdorfer
 CS 110
 Homework 1: Programming Challenge 9
*/
import java.util.*;

public class Hw1ProgChal9a
{
   
   public static void main(String [] args)
   {
   
      // declare variables
      double miles,gal,MPG;
      
      // create Scanner
      Scanner s;
      s=new Scanner(System.in);
      
      // prompt for miles and save value to miles
      System.out.print("Enter number of miles driven: ");
      miles=s.nextDouble();
      
      //prompt for gallons and save value to gal
      System.out.print("Enter gallons of gas used: ");
      gal=s.nextDouble();

      // calculate MPG
      MPG=miles/gal;
      
      // print MPG;
      System.out.printf("Total miles per gallon: %.1f", MPG);
            
   }
}