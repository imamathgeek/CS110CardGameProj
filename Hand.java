/* Rachel Bayersdorfer
CS 110
Homework 10: Final Project
Hand class
*/

public class Hand extends Deck
{
   public static final int START_HAND_NUM=27;
   private CardPile hand;
   private Deck deck;
   
   /**
      Hand default Constructor
   */   
   public Hand()
   {
      //create two hands and set the num of cards in each to START_HAND_NUM
      hand=new CardPile();
      hand.setNumCards(START_HAND_NUM);
   }
   /**
      dealHand method deals the deck into how every many cards need to be in the hand
      @return CardPile object The hand
   */   
   public CardPile dealHand()
   {
      // create new deck
      deck=new Deck ();
      
      deck.shuffle();
      
      //deal START_HAND_NUM cards into hand
      for (int i=1;i<=START_HAND_NUM;i++)
      {
         hand.add(deck.dealCard()); //deal to hand 1
      }
      
      return hand;
   }
   
   
}