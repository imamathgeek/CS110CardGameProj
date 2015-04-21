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
   private JPanel leftPanel,rightPanel,topPanel,bottomPanel,eastPanel,westPanel;  // break up regions
   private JButton playCard; //button to play next card
   private JButton skipToEnd;    //button to skip to end
   private JLabel moves;  // num of moves
   private JLabel title1,status,numCards1,numCards2;   //title and status
   
   
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
      eastPanel=new JPanel();
      westPanel=new JPanel();
      eastPanel.setBackground(new Color(160,234,150));
      westPanel.setBackground(new Color(160,234,150));
      leftPanel.setBackground(new Color(147,202,227));
      rightPanel.setBackground(new Color(202,147,227));
      topPanel.setBackground(new Color(160,234,150));
      
      topPanel.setLayout(new BorderLayout());
      bottomPanel.setLayout(new GridLayout(1,2));
      eastPanel.setLayout(new GridLayout(2,1));
      westPanel.setLayout(new GridLayout(2,1));
      
      
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
      numCards1=new JLabel("Player 1 has "+game.getCards1());
      numCards2=new JLabel("Player 2 has "+game.getCards2());
      
      westPanel.add(playCard);
      eastPanel.add(skipToEnd);
      
      moves = new JLabel("Moves: "+game.getMoves());
      moves.setFont(new Font("ARIAL",Font.BOLD,24));
      moves.setHorizontalAlignment(JLabel.CENTER);
      topPanel.add(moves,BorderLayout.CENTER);
      
      status.setHorizontalAlignment(JLabel.CENTER);
      numCards1.setVerticalAlignment(JLabel.BOTTOM);
      numCards2.setVerticalAlignment(JLabel.BOTTOM);
      topPanel.add(status,BorderLayout.SOUTH);
      westPanel.add(numCards1);
      eastPanel.add(numCards2);

      topPanel.add(westPanel,BorderLayout.WEST);
      topPanel.add(eastPanel,BorderLayout.EAST);
      
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
         for (int i=0;i<leftPanel.getComponentCount();i++)
         {  
            Component [] c=(leftPanel.getComponents());
            leftPanel.remove(c[i]);
         }   
         for (int i=0;i<rightPanel.getComponentCount();i++)
         {
            Component [] c=(rightPanel.getComponents());
            rightPanel.remove(c[i]);
         }   

          
         
         int w=game.turn();
         
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
         if ((warDown2!=null) && (p2War!=null))
         {
            rightPanel.add(warDown2.showBack());
            rightPanel.add(p2War.showCard());
         }   
         
         moves.setText("Moves: "+game.getMoves());
         
         
         if (w==1)
            status.setText("Player 1 wins this round");
         else if (w==2)
            status.setText("Player 2 wins this round");
         else if (w==3)
            status.setText("Player 1 wins this war");
         else if (w==4)
            status.setText("Player 2 wins this war");         

         numCards1.setText("Player 1 has "+game.getCards1());
         numCards2.setText("Player 2 has "+game.getCards2());
         
         leftPanel.revalidate();
         rightPanel.revalidate();
         leftPanel.repaint();
         rightPanel.repaint();
         
         
                          
      
      }
   } 
   
   private class SkipWarButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {  
      
         while ((game.getWinner()==0) && (game.getMoves()<3000))
         {
            game.turn();
         }
         
         if (game.getMoves()!=3000)
         {
            moves.setText("Moves: "+game.getMoves());
            
            int w=game.getWinner();
   
            if (w==1)
               status.setText("Player 1 wins this game");
            else if (w==2)
               status.setText("Player 2 wins this game"); 
         }
         else
         {
            status.setText("Infinite Game...No winner");
         }      
         
         rightPanel.removeAll();
         leftPanel.removeAll();
         rightPanel.validate();
         leftPanel.validate();
         
         numCards1.setText("Player 1 has "+game.getCards1());
         numCards2.setText("Player 2 has "+game.getCards2());
         
         skipToEnd.setEnabled(false);  
         
          
 
      }
   }
   
   

}