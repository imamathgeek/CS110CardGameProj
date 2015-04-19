/* Rachel Bayersdorfer
CS 110
Homework 10: Final Project
CardPile class
*/

import java.util.*;

public class CardPile
{

   //instance variables
   private ArrayList<Card> pile;

   /**
      CardPile constructor
   */   
   public CardPile()
   {
      pile=new ArrayList<Card>();
   }
   
   /**
      add method adds a card to the pile
      @param Card c
   */   
   public void add(int i,Card c)
   {
      pile.add(i,c);
   }
   
   /**
      size method returns the size of the pile
      @return int
   */
   public int size()
   {
      return pile.size();
   }   
   
   /**
      dealCard method returns top card
      @return card c
   */
   public Card dealCard()
   {
      Card c=pile.get(0);
      pile.remove(0);
      return c;
   }  
   
   /**
      get() method returns the card at specified index
      @return Card object
      @param int index
   */
   public Card get(int i)
   {
      return pile.get(i);
   } 
   
   /**
      remove() method removes the card at the specifed index
      @param int Index
   */
   public void remove(int i)
   {
      pile.remove(i);
   }         
}