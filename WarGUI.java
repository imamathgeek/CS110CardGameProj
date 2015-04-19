/* Rachel Bayersdorfer
CS 110
Homework 10: Final Project
War GUI
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WarGUI extends JFrame
{
   private War game; // the guts
   private JPanel leftPanel,rightPanel,topPanel;  // break up regions
   private JButton playCard; //button to play next card
   private JButton skipToEnd,playAgain;    //button to skip to end
   private JLabel moves;  // num of moves
   private JLabel title1,status;   //title and status
   
   
   // build the GUI
   
   public WarGUI()
   {
      setLayout(new GridLayout(1,2));
      
      // create game instance
      game =new War();
      
      // setup containers and components
      leftPanel = new JPanel();
      rightPanel=new JPanel();
      topPanel=new JPanel();
      leftPanel.setBackground(new Color(147,202,227));
      rightPanel.setBackground(new Color(202,147,227));
      
      topPanel.setLayout(new FlowLayout());
      
      playCard=new JButton("Play a Card");
      skipToEnd=new JButton("Skip to End");
      playAgain=new JButton("Play Again?");
      playCard.addActionListener(new PlayWarButtonListener());
      skipToEnd.addActionListener(new SkipWarButtonListener());
      playAgain.addActionListener(new PlayAgainButtonListener());
      playAgain.setEnabled(false);
      
              
              
      title1 = new JLabel("Rachel's Game of War:");
      title1.setFont(new Font("HELVETICA",Font.ITALIC,36));
      topPanel.add(title1);
      
      status=new JLabel("ready?");
      
      topPanel.add(playCard);
      topPanel.add(skipToEnd);
      topPanel.add(playAgain);
      
      moves = new JLabel("Moves: "+game.getMoves());
      moves.setFont(new Font("ARIAL",Font.BOLD,24));
      topPanel.add(moves);
      
      topPanel.add(status);

      
      setLayout(new BorderLayout());
      add(leftPanel,BorderLayout.WEST);
      add(rightPanel,BorderLayout.EAST);
      add(topPanel,BorderLayout.NORTH);
      

   }
   
   // handle button events
   private class PlayWarButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {     
                  
         game.turn();
         
         Card p1=game.getPlayer1Card();
         Card p2=game.getPlayer2Card();
         Card warDown1=game.getPlayer1CardWarDown();
         Card warDown2=game.getPlayer2CardWarDown();
         Card p1War=game.getPlayer1CardWar();
         Card p2War=game.getPlayer2CardWar();
         
         leftPanel.add(p1.showCard());
         if ((warDown1!=null) && (p1War!=null))
         {
            leftPanel.add(warDown1.showBack());
            leftPanel.add(p1War.showCard());
         }
         
         
         rightPanel.add(p2.showCard());
         if ((warDown1!=null) && (p1War!=null))
         {
            rightPanel.add(warDown2.showBack());
            leftPanel.add(p2War.showCard());
         }   

         
         
         
         
         
                          
      
      }
   } 
   
   private class SkipWarButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {  
      
      }
   }
   
   private class PlayAgainButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {     
      
      }
   }
   

}