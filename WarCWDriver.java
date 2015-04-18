/* Rachel Bayersdorfer
CS 110
Homework 10: Final Project
War CW driver
*/

public class WarCWDriver
{
   public static void main(String [] args)
   {
      WarCW warGame=new WarCW();
      int winner=warGame.go();
      
      if (winner==1)
         System.out.println("Player 1 wins");
      else
         System.out.println("Player 2 wins");   
      
      
   }
}