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
   private JPanel leftPanel,rightPanel;  // break up regions
   private PlayWarButton playCard; //button to play next card
   private SkipWarButton skipToEnd;    //button to skip to end
   private JLabel moves;  // game status
   private JLabel title1;   // static title
   
   // build the GUI
   
   public WarGUI()
   {
      setLayout(new GridLayout(1,2));
      
      // create game instance
      game =new War();
      
      // setup containers and components
      leftPanel = new JPanel();
      rightPanel=new JPanel();
      leftPanel.setBackground(Color.green);
      rightPanel.setBackground(Color.blue);
      playCard=new JButton();
      skipToEnd=new JButton();
              
      title1 = new JLabel("Rachel's Game of War:");
      title1.setFont(new Font("HELVETICA",Font.ITALIC,36));
      leftPanel.add(title1);
         
      moves = new JLabel(game.getMoves()+"");
      moves.setFont(new Font("ARIAL",Font.BOLD,24));
      rightPanel.add(moves);
      
      
      
      add(leftPanel);
      add(rightPanel);

   }
   
   // handle button events
   private class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {     
         int winner;  

         PlayWarButton source = (PlayWarButton)(e.getSource());
         // make a move
         if (game.move(source.getRow(),source.getCol()))
         {
            // react
            if (game.getPlayer() == 'o')
               source.setIcon(new ImageIcon("x.jpg"));
            else
               source.setIcon(new ImageIcon("o.jpg"));
            
            winner = game.winner();
            
            if ((winner !='_')||game.getMoves()==9)
               if (winner != '_')
               {
                  status.setText("Winner is " + winner);
                  disableAll();
                 
               }
               else
               {
                  status.setText("It's a tie");
                  disableAll();
               }
              
         }
      }

}