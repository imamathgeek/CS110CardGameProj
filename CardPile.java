/* Rachel Bayersdorfer
CS 110
Homework 10: Final Project
CardPile class
*/

public class CardPile
{
   //instance variables
   private Card [] pile;
   private int numCards;
   private int ct=0;
   
   /**
      setNumCards method
      @param numCards int The number of cards in the pile
   */   
   public void setNumCards(int numCards)
   {
      this.numCards=numCards;
   }
   
   /**
      add method adds a card to the pile
      @param Card c
   */   
   public void add(Card c)
   {
      pile = new Card[numCards];
      pile[ct]=new Card(c);
      ct = ct + 1;
   }
   
   
}