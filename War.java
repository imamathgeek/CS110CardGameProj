/* Rachel Bayersdorfer
CS 110
Homework 10: Final Project
War class
*/

public class War
{
   private Hand hand1,hand2;
   private int moves;
   
   /**
      War constructor creates two hands, deals into the two hands, and sets moves to zero
   */   
   public War()
   {
      //create two hands
      hand1=new Hand();
      hand2=new Hand();
      
      //deal the deck into the two hands
      hand1.dealHand();
      hand2.dealHand();
      
      //set moves to zero
      moves=0;
   }
   
   /**
      turn method simulates one turn
      @return int who won
   */      
   public int turn()
   {
      //deal the top card of each player
      Card player1=hand1.dealCard();
      Card player2=hand2.dealCard();
      
      if (player1.compareTo(player2)>0)
         return 1;
      else if (player1.compareTo(player2)<0)
         return 2;
      else
      {
         while (player1.compareTo(player2)==0)
         {
            //deal one card face down
            hand1.dealCard();
            hand2.dealCard();
            
            //deal the war card
            Card player1War=hand1.dealCard();
            Card player2War=hand2.dealCard();
            
            if (player1War.compareTo(player2War)>0)
               return 1;
            else if (player1War.compareTo(player2War)<0)
               return 2;
         }      
      }  
      moves++; 
      return 1;
   }
   
   
   /**
      getMoves() method returns the number of moves so far
      @return int moves
   */
   public int moves()
   {
      return moves;
   }      
   
   /**
      getWinner() method returns the winner
      @return int winner, 1 if player1 wins, 2 if player2 wins and 0 if no winner yet
   */   
   public int getWinner()
   {
      if ((hand1.isEmpty())||(hand2.isEmpty()))
         if (hand1.isEmpty())
            return 2;
         if (hand2.isEmpty()) 
            return 1;
      else
         return 0;        
            
   }
}