/* Rachel Bayersdorfer
CS 110
Homework 10: Final Project
Hand class
*/
import java.util.*;

public class Hand extends CardPile
{
   //instance vars
   private static Deck deck;
   private CardPile pile;
   
      
   /**
      Hand constructor
   */
   public Hand(int num)
   {
      deck=new Deck(); //create deck
      
      for (int i=0;i<num;i++) //add num cards into the hand from the deck
      {
         Card c1=deck.dealCard();
         pile.add(c1);
      }  
   }   
   
   /**
      getHand method returns the hand
      @return CardPile object
   */
   public CardPile getHand()
   {
      return pile;
   }   
   
   /**
      isEmpty returns true if hand is empty and false otherwise
      @return boolean tf
   */
   public boolean isEmpty()
   {
      return (pile.size()==0);
   }       
   
   public static void main(String [] args)
   {
      Hand hand=new Hand(5);
   }
}