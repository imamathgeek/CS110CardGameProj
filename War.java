/* Rachel Bayersdorfer
CS 110
Homework 10: Final Project
War class
*/

public class War
{
   //instance vars
   private Hand hand1, hand2;
   private int moves;
   private Card p1, p2, warDown1, warDown2, p1War, p2War;
   public static final int START_HAND=26;
   
   public War()
   {
      //create hands
      hand1=new Hand(START_HAND);
      hand2=new Hand(START_HAND);
      
      //set moves to zero
      moves=0;
   }
   
   /**
      turn method simulates one turn
      @return int who won: 1 if player1 wins on regular round, 2 if player2 wins on regular round,
         3 if player1 wins on war and 4 if player2 wins on war
   */  
   public int turn()
   {
      moves++; //increment moves
      
      //deal top card of each player
      p1=hand1.dealCard();
      p2=hand2.dealCard();
      
      //compare cards
      if ((p1.compareTo(p2))>0) //player 1 wins round
      {
         hand1.addBottom(p1); //add p1 card to bottom of hand 1
         hand1.addBottom(p2); //add p2 card to bottom of hand 1
         return 1;      
      }
      else if ((p1.compareTo(p2))<0) //player 2 wins round
      {
         hand2.addBottom(p1); //add p1 card to bottom of hand 2
         hand2.addBottom(p2); //add p2 card to bottom of hand 2
         return 2;
      }
      else
      {
         return war();
      }
      

   }
   
   /**
      war method simulates a war
      @return int winner 3 if player1 wins, 4 if player2 wins
   */
   public int war()
   {
      //deal one card each face down
      warDown1=hand1.dealCard();
      warDown2=hand2.dealCard();
      
      //deal next card face up
      p1War=hand1.dealCard();
      p2War=hand2.dealCard();
      
      if ((p1.compareTo(p2))>0) //player 1 wins round
      {
         hand1.addBottom(p1); //add p1 card to bottom of hand 1
         hand1.addBottom(p2); //add p2 card to bottom of hand 1
         hand1.addBottom(warDown1); //add warDown1 to bottom of hand 1
         hand1.addBottom(warDown2); //add warDown2 to bottom of hand 1
         hand1.addBottom(p1War); //add p1War to bottom of hand 1
         hand1.addBottom(p2War); //add p2War to bottom of hand 1
         return 3;      
      }
      else if ((p1.compareTo(p2))<0) //player 2 wins round
      {
         hand2.addBottom(p1); //add p1 card to bottom of hand 2
         hand2.addBottom(p2); //add p2 card to bottom of hand 2
         hand2.addBottom(warDown1); //add warDown1 to bottom of hand 1
         hand2.addBottom(warDown2); //add warDown2 to bottom of hand 1
         hand2.addBottom(p1War); //add p1War to bottom of hand 1
         hand2.addBottom(p2War); //add p2War to bottom of hand 1

         return 4;
      }
      else
      {
         return war();
      }

   }
   
   /**
      getMoves returns the number of moves so far
      @return int moves
   */
   public int getMoves()
   {
      return moves;
   }      
   
   /**
      getWinner returns the winner of the game
      @return int 1 if player 1 wins, 2 if player2 wins and 0 if neither has won yet
   */
   public int getWinner()
   {
      if (hand1.isEmpty())
         return 2;
      else if (hand2.isEmpty())
         return 1;
      else
         return 0;      
   }         

}