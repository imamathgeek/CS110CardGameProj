/* Rachel Bayersdorfer
CS 110
Homework 10: Final Project
Hand class
*/

public class Hand extends CardPile
{
   public static final int START_HAND_NUM=27;
   private CardPile hand1,hand2;
   private Deck deck;
   
   /**
      Hand default Constructor
   */   
   public Hand()
   {
      //create two hands and set the num of cards in each to START_HAND_NUM
      hand1=new CardPile();
      hand2=new CardPile();
      hand1.setNumCards(START_HAND_NUM);
      hand2.setNumCards(START_HAND_NUM);
      
      // create new deck
      deck=new Deck ();
      
      //deal 27 cards into each hand
      for (int i=1;i<=START_HAND_NUM;i++)
      {
         hand1.add(deck.dealCard()); //deal to hand 1
         hand2.add(deck.dealCard()); //deal to hand 2
      }
   }
}