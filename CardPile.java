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
   public void add(Card c)
   {
      pile.add(0,c);
   }
   
   /**
      addbottom method adds to the bottom of the pile
   */
   public void addBottom(Card c)
   {
      pile.add(c);
   }   
   
   /**
      dealCard method returns top card
      @return card c
   */
   public Card dealCard()
   {
      Card c=(Card)(pile.remove(0));
      return c;
   }      
   
   /**
      size method returns the size of the card pile
      @return int size
   */
   public int size()
   {
      return pile.size();
   }   

}