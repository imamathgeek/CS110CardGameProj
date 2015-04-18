/* Rachel Bayersdorfer
CS 110
Homework 10: Final Project
Hand class
*/

public class Hand extends Deck
{
   public static final int START_HAND_NUM=26;
   private CardPile hand1,hand2;
   private static Deck deck;
   private int ct1=START_HAND_NUM,c2=START_HAND_NUM;
   
   /**
      Hand default Constructor
   */   
   public Hand()
   {
      //create two hands and set the num of cards in each to START_HAND_NUM
      hand1=new CardPile(START_HAND_NUM);
      hand2=new CardPile(START_HAND_NUM);
      
      //create deck
      deck=new Deck ();
      
      //shuffle deck
      deck.shuffle();
   }
   /**
      dealHand method deals the deck into how every many cards need to be in the hand
      @return CardPile object The hand
   */   
   public void dealHand()
   {      
      //deal START_HAND_NUM cards into hand
      for (int i=0;i<START_HAND_NUM;i++)
      {
         Card c1=deck.dealCard();
         Card c2=deck.dealCard();
         hand1.add(c1); //deal to hand1
         hand2.add(c2); //deal to hand2
      }
      
   }
   
   /**
      getHand1 method returns hand1
      @return CardPile hand1
   */   
   public CardPile getHand1()
   {
      return hand1;
   }
   
   /**
      getHand2 method returns hand1
      @return CardPile hand2
   */   
   public CardPile getHand2()
   {
      return hand2;
   }
   
   /**
      dealCardHand1() method deals the top card of the hand1
      @return Card
   */
   public Card dealCardHand1()
   {
      return hand1.dealCard();   
   }   
   
   /**
      dealCardHand2() method deals the top card of the hand2
      @return Card
   */
   public Card dealCardHand2()
   {
      return hand2.dealCard();
   }  

   
   
}