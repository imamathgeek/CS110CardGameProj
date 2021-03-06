/* Rachel Bayersdorfer
CS 110
Homework 10: Final Project
War CW class
*/

public class WarCW
{
   //instance vars
   private War game;
   
   /**
      WarCW constructor
   */
   public WarCW()
   {
      game=new War();
   }   
   
   /**
      go method plays the game
      @return int winner
   */
   public int go()
   {
      while (game.getWinner()==0)
      {
         int w=game.turn();
         if (w==1)
            System.out.println("Player 1 wins this round");
         else if (w==2)
            System.out.println("Player 2 wins this round"); 
         else if (w==3)
            System.out.println("Player 1 wins this war"); 
         else if (w==4)
            System.out.println("Player 2 wins this war");        
      }
      
      return game.getWinner();
   }   
   
   /**
      getMoves() returns number of moves that have been taken in the game
      @return int moves
   */
   public int getMoves()
   {
      return game.getMoves();
   }      
}