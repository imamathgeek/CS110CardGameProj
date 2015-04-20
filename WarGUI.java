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
   private JPanel leftPanel,rightPanel,topPanel,bottomPanel;  // break up regions
   private JButton playCard; //button to play next card
   private JButton skipToEnd;    //button to skip to end
   private JLabel moves;  // num of moves
   private JLabel title1,status;   //title and status
   
   
   // build the GUI
   
   public WarGUI()
   {
      setLayout(new GridLayout(2,1));
      
      // create game instance
      game =new War();
      
      // setup containers and components
      bottomPanel=new JPanel();
      leftPanel = new JPanel();
      rightPanel=new JPanel();
      topPanel=new JPanel();
      leftPanel.setBackground(new Color(147,202,227));
      rightPanel.setBackground(new Color(202,147,227));
      topPanel.setBackground(new Color(160,234,150));
      
      topPanel.setLayout(new BorderLayout());
      bottomPanel.setLayout(new GridLayout(1,2));
      
      
      playCard=new JButton("Play a Card");
      skipToEnd=new JButton("Skip to End");
      playCard.addActionListener(new PlayWarButtonListener());
      skipToEnd.addActionListener(new SkipWarButtonListener());
      playCard.setHorizontalAlignment(JLabel.CENTER);
      skipToEnd.setHorizontalAlignment(JLabel.CENTER);
 
      
              
              
      title1 = new JLabel("Rachel's Game of War:");
      title1.setFont(new Font("HELVETICA",Font.ITALIC,36));
      title1.setHorizontalAlignment(JLabel.CENTER);
      topPanel.add(title1,BorderLayout.NORTH);
      
      status=new JLabel("ready?");
      
      topPanel.add(playCard,BorderLayout.WEST);
      topPanel.add(skipToEnd,BorderLayout.EAST);
      
      moves = new JLabel("Moves: "+game.getMoves());
      moves.setFont(new Font("ARIAL",Font.BOLD,24));
      moves.setHorizontalAlignment(JLabel.CENTER);
      topPanel.add(moves,BorderLayout.CENTER);
      
      status.setHorizontalAlignment(JLabel.CENTER);
      topPanel.add(status,BorderLayout.SOUTH);

      
      bottomPanel.add(leftPanel);
      bottomPanel.add(rightPanel);
      add(topPanel);
      add(bottomPanel);
      

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
         
         JLabel p1label=p1.showCard();
         JLabel backlabel1=warDown1.showBack();
         JLabel p1Warlabel=p1War.showCard();
         JLabel p2label=p2.showCard();
         JLabel backlabel2=warDown2.showBack();
         JLabel p2Warlabel=p2War.showCard();
         
         leftPanel.add(p1label);
         if ((warDown1!=null) && (p1War!=null))
         {
            leftPanel.add(backlabel1);
            leftPanel.add(p1Warlabel);
         }
         
         
         rightPanel.add(p2label);
         if ((warDown1!=null) && (p1War!=null))
         {
            rightPanel.add(backlabel2);
            leftPanel.add(p2Warlabel);
         }   

         
         
         
         
         
                          
      
      }
   } 
   
   private class SkipWarButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {  
      
         while (game.getWinner()==0)
         {
            int w=game.turn();
         }
         moves.setText("Moves: "+game.getMoves());
         
         int w=game.getWinner();

         if (w==1)
            status.setText("Player 1 wins this game");
         else if (w==2)
            status.setText("Player 2 wins this game"); 
 
      }
   }
   
   

}