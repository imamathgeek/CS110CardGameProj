/* Rachel Bayersdorfer
CS 110
Homework 10: Final Project
Card class
*/

import javax.swing.*;
import java.awt.*;

public class Card
{
    //instance variables
   public static final int SPADES=1, CLUBS=2, HEARTS=3, DIAMONDS=4, ACE=1, JACK=11, QUEEN=12, KING=13;
   private int rank, suit;
   
   
   /**
      Card constructor constructs a card with a given suit and rank
      @param suit Suit of card, int
      @param rank Rank of card, int
   */   
   public Card(int rank, int suit)
   {
      this.rank=rank;
      this.suit=suit;
   }
   
   /**
      Card Copy constructor
      @param Card card
   */
   public Card(Card card)
   {
      this.rank=card.rank;
      this.suit=card.suit;
   }   

   /**
      getSuit() method will return the suit
      @return int
   */
   public int getSuit()
   {
      return suit;
   }   
   
   /**
      getRank method will return the rank
      @return int
   */
   public int getRank()
   {
      return rank;
   }   
   
   
   /**
      getSuitString() method will return the suit
      @return String
   */
   public String getSuitString()
   {
      String suitString="";
      
      if (suit==SPADES)
         suitString="s";
      else if (suit==CLUBS)
         suitString="c";
      else if (suit==HEARTS)
         suitString="h";    
      else if (suit==DIAMONDS)
         suitString="d"; 
      return suitString;       
   }   
   
   /**
      showCard() returns a JLabel with the image of the card on it
      @reutrn JLabel
   */   
   public JLabel showCard()
   {
      if (this!=null)
      {
         String s=this.getRank()+this.getSuitString()+".jpg";
         ImageIcon i=new ImageIcon(s);
         JLabel label=new JLabel(i);
         return label;
      }
      else
      {
         JLabel label=new JLabel();
         return label;
      }   
   }
   
   /**
      showBack() method shows the back of the card
      @return JLabel with back of the card
   */      
   public JLabel showBack()
   {
   
      if (this!=null)
      {
         JLabel label=new JLabel(new ImageIcon("back.jpg"));
         return label;      
      }
      else
      {   
         JLabel label=new JLabel(new ImageIcon());
         return label;
      } 
      
   }
   
      
   /**
      showCard() returns a ImageIcon with the image of the card on it
      @reutrn ImageIcon
   */   
   public ImageIcon showCardIcon()
   {
      if (this!=null)
      {
         String s=this.getRank()+this.getSuitString()+".jpg";
         ImageIcon i=new ImageIcon(s);
         return i;
      }
      else
      {
         ImageIcon i=new ImageIcon();
         return i;
      }   
   }
   
   /**
      showBack() method shows the back of the card as ImageIcon
      @return ImageIcon with back of the card
   */      
   public ImageIcon showBackIcon()
   {
      if (this!=null)
      {
         ImageIcon i=new ImageIcon("back.jpg");
         return i;
      }
      else
      {   
         ImageIcon i=new ImageIcon();
         return i;
      }      
   }
  

   
   /**
      toString method returns string representing card
      @return String
   */
   public String toString()
   {
      String SuitString, RankString;
      
      if (suit==1)
         SuitString="Spades";
      else if (suit==2) 
         SuitString="Clubs"; 
      else if (suit==3)
         SuitString="Hearts";
      else
         SuitString="Diamonds";
         
      if (rank==1)
         RankString="Ace";
      else if (rank==2)
         RankString="Two";
      else if (rank==3)
         RankString="Three";
      else if (rank==4)
         RankString="Four";
      else if (rank==5)
         RankString="Five";
      else if (rank==6)
         RankString="Six";
      else if (rank==7)
         RankString="Seven";
      else if (rank==8)
         RankString="Eight";
      else if (rank==9)
         RankString="Nine";
      else if (rank==10)
         RankString="Ten";
      else if (rank==11)
         RankString="Jack";
      else if (rank==12)
         RankString="Queen";
      else
         RankString="King";
         
      return RankString+" of "+SuitString ;  
                           
   }    

   /**
      equals method determines if a card's rank equals another card's rank
      @param otherCard Card object
      @return boolean
   */
   public boolean equals(Card otherCard)
   {
      if (this.getRank()==otherCard.getRank())
         return true;
      else
         return false;   
   }   
   
   public int compareTo(Card otherCard)
   {
      if (this.getRank()==otherCard.getRank())
         return 0;
      else if (this.getRank()>otherCard.getRank())
         return 1;
      else
         return -1;   
   }

   
   
}