/* Rachel Bayersdorfer
CS 110
Homework 10: Final Project
Hand class
*/
import java.util.*;

public class Hand extends CardPile
{
   //instance vars
   private static final Deck deck=new Deck();
   private CardPile pile;
   
      
   /**
      Hand constructor
      @param num Number of starting cards in hand
   */
   public Hand(int num)
   {
      
      pile=new CardPile(); //create pile
      
      for (int i=0;i<num;i++) //add num cards into the hand from the deck
      {
         Card c1=deck.dealCard();
         pile.add(0,c1);
      }  
   }   
   
   /**
      add method adds a card to the pile
      @param c Card
   */   
   public void add(Card c)
   {
      pile.add(0,c);
   }
      
   /**
      add method adds a card to the pile
      @param c Card
   */   
   public void addBottom(Card c)
   {
      pile.add(pile.size(),c);
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
   
   /**
      dealCard()
      @return Card Object
   */
   public Card dealCard()
   {
      Card c=pile.get(0);
      pile.remove(0);
      return c;
   }  
   
   /**
      size method returns the size of the hand
      @return int
   */
   public int size()
   {
      return pile.size();
   }       
   
   public static void main(String [] args)
   {
      Hand hand=new Hand(5);
      System.out.println(hand.dealCard());
   }
}