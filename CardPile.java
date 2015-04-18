/* Rachel Bayersdorfer
CS 110
Homework 10: Final Project
CardPile class
*/

public class CardPile extends Deck
{
   //instance variables
   private Card [] pile;
   private int numCards;
   private int ct=0;
   
   /**
      CardPile constructor
   */   
   public CardPile(int num)
   {
      numCards=num;
      pile=new Card[numCards];
   }
//    
//    /**
//       setNumCards method
//       @param numCards int The number of cards in the pile
//    */   
//    public void setNumCards(int numCards)
//    {
//       this.numCards=numCards;
//    }
   
   /**
      add method adds a card to the pile
      @param Card c
   */   
   public void add(Card c)
   {
      pile[ct]=new Card(c);
      ct = ct + 1;

   }
   
   /**
      addbottom method adds to the bottom of the pile
   */
   public void addBottom(Card c)
   {
      
   }   
   
   /**
      dealCard method returns top card
      @return card c
   */
   public Card dealCard()
   {
      ct--;
      return pile[ct];
   }      
   
   
}