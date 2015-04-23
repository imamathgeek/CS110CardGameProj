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
   private Card p1, p2, warDown1, warDown2, p1War, p2War,p1dWar,p2dWar,warDown1d,warDown2d,p1tWar,p2tWar,warDown1t,warDown2t;
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
      try {
         if ((hand1.isEmpty()) || (hand2.isEmpty()))
            getWinner();
         else   
         {
            //deal one card each face down
            warDown1=hand1.dealCard();
            warDown2=hand2.dealCard();
         }   
         
         if ((hand1.isEmpty()) || (hand2.isEmpty()))
            getWinner();
         else   
         {
            //deal next card face up
            p1War=hand1.dealCard();
            p2War=hand2.dealCard();
         }   
         
         if ((p1War.compareTo(p2War))>0) //player 1 wins round
         {
            hand1.addBottom(p1); //add p1 card to bottom of hand 1
            hand1.addBottom(p2); //add p2 card to bottom of hand 1
            hand1.addBottom(warDown1); //add warDown1 to bottom of hand 1
            hand1.addBottom(warDown2); //add warDown2 to bottom of hand 1
            hand1.addBottom(p1War); //add p1War to bottom of hand 1
            hand1.addBottom(p2War); //add p2War to bottom of hand 1
            return 3;      
         }
         else if ((p1War.compareTo(p2War))<0) //player 2 wins round
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
            return doubleWar();
         }
      }
      catch (StackOverflowError e)
      {
         System.out.println("StackOverflowError: "+e.getMessage());
      }   
      return 0;

   }
   
   /**
      doubleWar method is when there's a double war
      @return int 5 if p1 wins 6 if p2 wins
   */
   public int doubleWar()
   {
      
      if ((hand1.isEmpty()) || (hand2.isEmpty()))
         getWinner();
      else   
      {
         //deal one card each face down
         warDown1d=hand1.dealCard();
         warDown2d=hand2.dealCard();
      }   
      
      if ((hand1.isEmpty()) || (hand2.isEmpty()))
         getWinner();
      else   
      {
         //deal next card face up
         p1dWar=hand1.dealCard();
         p2dWar=hand2.dealCard();
      }   

        
      
      if ((p1dWar.compareTo(p2dWar))>0) //player 1 wins round
      {
         hand1.addBottom(p1); //add p1 card to bottom of hand 1
         hand1.addBottom(p2); //add p2 card to bottom of hand 1
         hand1.addBottom(warDown1); //add warDown1 to bottom of hand 1
         hand1.addBottom(warDown2); //add warDown2 to bottom of hand 1
         hand1.addBottom(p1War); //add p1War to bottom of hand 1
         hand1.addBottom(p2War); //add p2War to bottom of hand 1
         hand1.addBottom(warDown1d); //add warDown1d to bottom of hand 1
         hand1.addBottom(warDown2d); //add warDown2d to bottom of hand 1
         hand1.addBottom(p1dWar); //add p1dWar to bottom of hand 1
         hand1.addBottom(p2dWar); //add p2dWar to bottom of hand 1
         return 5;      
      }
      else if ((p1dWar.compareTo(p2dWar))<0) //player 2 wins round
      {
         hand2.addBottom(p1); //add p1 card to bottom of hand 2
         hand2.addBottom(p2); //add p2 card to bottom of hand 2
         hand2.addBottom(warDown1); //add warDown1 to bottom of hand 2
         hand2.addBottom(warDown2); //add warDown2 to bottom of hand 2
         hand2.addBottom(p1War); //add p1War to bottom of hand 2
         hand2.addBottom(p2War); //add p2War to bottom of hand 2
         hand1.addBottom(warDown1d); //add warDown1d to bottom of hand 2
         hand1.addBottom(warDown2d); //add warDown2d to bottom of hand 2
         hand1.addBottom(p1dWar); //add p1dWar to bottom of hand 2
         hand1.addBottom(p2dWar); //add p2dWar to bottom of hand 2

         return 6;
      }
      else
      {
         return tripleWar();
      }
   }
   
   /**
      tripleWar() simulates a triple war
      @return int 7 if p1 wins 8 if p2 wins
   */
   public int tripleWar()
   {
      if ((hand1.isEmpty()) || (hand2.isEmpty()))
         getWinner();
      else   
      {
         //deal one card each face down
         warDown1t=hand1.dealCard();
         warDown2t=hand2.dealCard();
      }   
      
      if ((hand1.isEmpty()) || (hand2.isEmpty()))
         getWinner();
      else   
      {
         //deal next card face up
         p1tWar=hand1.dealCard();
         p2tWar=hand2.dealCard();
      }   

        
      
      if ((p1tWar.compareTo(p2tWar))>0) //player 1 wins round
      {
         hand1.addBottom(p1); //add p1 card to bottom of hand 1
         hand1.addBottom(p2); //add p2 card to bottom of hand 1
         hand1.addBottom(warDown1); //add warDown1 to bottom of hand 1
         hand1.addBottom(warDown2); //add warDown2 to bottom of hand 1
         hand1.addBottom(p1War); //add p1War to bottom of hand 1
         hand1.addBottom(p2War); //add p2War to bottom of hand 1
         hand1.addBottom(warDown1d); //add warDown1d to bottom of hand 1
         hand1.addBottom(warDown2d); //add warDown2d to bottom of hand 1
         hand1.addBottom(p1dWar); //add p1dWar to bottom of hand 1
         hand1.addBottom(p2dWar); //add p2dWar to bottom of hand 1
         hand1.addBottom(warDown1t); //add warDown1d to bottom of hand 1
         hand1.addBottom(warDown2t); //add warDown2d to bottom of hand 1
         hand1.addBottom(p1tWar); //add p1dWar to bottom of hand 1
         hand1.addBottom(p2tWar); //add p2dWar to bottom of hand 1
         return 7;      
      }
      else if ((p1tWar.compareTo(p2tWar))<0) //player 2 wins round
      {
         hand2.addBottom(p1); //add p1 card to bottom of hand 2
         hand2.addBottom(p2); //add p2 card to bottom of hand 2
         hand2.addBottom(warDown1); //add warDown1 to bottom of hand 2
         hand2.addBottom(warDown2); //add warDown2 to bottom of hand 2
         hand2.addBottom(p1War); //add p1War to bottom of hand 2
         hand2.addBottom(p2War); //add p2War to bottom of hand 2
         hand1.addBottom(warDown1d); //add warDown1d to bottom of hand 2
         hand1.addBottom(warDown2d); //add warDown2d to bottom of hand 2
         hand1.addBottom(p1dWar); //add p1dWar to bottom of hand 2
         hand1.addBottom(p2dWar); //add p2dWar to bottom of hand 2
         hand1.addBottom(warDown1t); //add warDown1d to bottom of hand 2
         hand1.addBottom(warDown2t); //add warDown2d to bottom of hand 2
         hand1.addBottom(p1tWar); //add p1dWar to bottom of hand 2
         hand1.addBottom(p2tWar); //add p2dWar to bottom of hand 2

         return 8;
      }
      else
      {
         return 9;
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
   
   /**
      getPlayer1Card method returns player1's card (non-war)
      @return Card c
   */
   public Card getPlayer1Card()
   {
      return p1;
   }         

   /**
      getPlayer2Card method returns player2's card (non-war)
      @return Card c
   */
   public Card getPlayer2Card()
   {
      return p2;
   }
   
   /**
      getPlayer1CardWarDown method returns player1's war down card 
      @return Card c
   */
   public Card getPlayer1CardWarDown()
   {
      return warDown1;
   }
   
 
    /**
      getPlayer2CardWarDown method returns player1's war card 
      @return Card c
   */
   public Card getPlayer2CardWarDown()
   {
      return warDown2;
   }
   
   
   /**
      getPlayer2CardWarDown method returns player2's war card 
      @return Card c
   */
   public Card getPlayer1CardWar()
   {
      return p1War;
   }
   
  
     /**
      getPlayer2CardWarDown method returns player2's war down card 
      @return Card c
   */
   public Card getPlayer2CardWar()
   {
      return p2War;
   } 
   
   /**
      getPlayer1CardDWar method returns player1's double war card
      @return Card c
   */
   public Card getPlayer1CardDWar()
   {
      return p1dWar;
   }  
   
   /**
      getPlayer2CardDWar method returns player2's double war card
      @return Card c
   */
   public Card getPlayer2CardDWar()
   {
      return p2dWar;
   }  
   
   /**
      getPlayer1CardDWarDown method returns player1's double war down card
      @return Card c
   */
   public Card getPlayer1CardDWarDown()
   {
      return warDown1d;
   }  
   
   /**
      getPlayer2CardDWarDown method returns player2's double war down card
      @return Card c
   */
   public Card getPlayer2CardDWarDown()
   {
      return warDown2d;
   }  
   
   /**
      getPlayer1CardTWar method returns player1's double war card
      @return Card c
   */
   public Card getPlayer1CardTWar()
   {
      return p1tWar;
   }  
   
   /**
      getPlayer2CardTWar method returns player2's double war card
      @return Card c
   */
   public Card getPlayer2CardTWar()
   {
      return p2tWar;
   }  
   
   /**
      getPlayer1CardTWarDown method returns player1's double war down card
      @return Card c
   */
   public Card getPlayer1CardTWarDown()
   {
      return warDown1t;
   }  
   
   /**
      getPlayer2CardTWarDown method returns player2's double war down card
      @return Card c
   */
   public Card getPlayer2CardTWarDown()
   {
      return warDown2t;
   } 

   
   /**
      getCards1 method returns how many cards are in each player's hand
      @return int
   */
   public int getCards1()
   {
      return hand1.size();
   }   
   
   /**
      getCards2 method returns how many cards are in each player's hand
      @return int
   */
   public int getCards2()
   {
      return hand2.size();
   }  
   
        
}