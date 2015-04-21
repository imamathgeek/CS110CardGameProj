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
      game =new War(); //create War game
      
      // setup containers and components
      bottomPanel=new JPanel();
      leftPanel = new JPanel();
      rightPanel=new JPanel();
      topPanel=new JPanel();
      eastPanel=new JPanel();
      westPanel=new JPanel();
      eastPanel.setBackground(new Color(160,234,150)); //set East panel to green
      westPanel.setBackground(new Color(160,234,150)); //set west panel to green
      leftPanel.setBackground(new Color(147,202,227)); //set left panel to blue
      rightPanel.setBackground(new Color(202,147,227)); //set right panel to purple
      topPanel.setBackground(new Color(160,234,150)); //set top panel to green
      
      topPanel.setLayout(new BorderLayout()); //set topPanel to border layout
      bottomPanel.setLayout(new GridLayout(1,2)); //bottom panel to grid with 1 row and 2 columns
      eastPanel.setLayout(new GridLayout(2,1)); //set east panel to grid layout 2 rows 1 colum
      westPanel.setLayout(new GridLayout(2,1));//set west panel to grid layout 2 rows 1 colum
      
      
      playCard=new JButton("Play a Card"); //create playCard button with text "Play a Card"
      skipToEnd=new JButton("Skip to End"); //create skipToEnd button with text "Skip to End"
      playCard.addActionListener(new PlayWarButtonListener()); //add actionlistener
      skipToEnd.addActionListener(new SkipWarButtonListener()); //add actionlistener
      playCard.setHorizontalAlignment(JLabel.CENTER); //put playCard in center
      skipToEnd.setHorizontalAlignment(JLabel.CENTER); //put skipToEnd in center
 
      
              
              
      title1 = new JLabel("Rachel's Game of War:"); //add title
      title1.setFont(new Font("HELVETICA",Font.ITALIC,36));//set font of title
      title1.setHorizontalAlignment(JLabel.CENTER); //put title in center
      topPanel.add(title1,BorderLayout.NORTH); //add title in north panel of top panel
      
      status=new JLabel("ready?"); //starting status says "ready"
      numCards1=new JLabel("Player 1 has "+game.getCards1()); //starting num of cards in hand 1
      numCards2=new JLabel("Player 2 has "+game.getCards2()); //starting num of cards in hand 2
      
      westPanel.add(playCard); //add button
      eastPanel.add(skipToEnd); //add button
      
      moves = new JLabel("Moves: "+game.getMoves()); //create moves button, starts at 0
      moves.setFont(new Font("HELVETICA",Font.BOLD,24)); //set font of moves
      moves.setHorizontalAlignment(JLabel.CENTER); //put moves in center
      topPanel.add(moves,BorderLayout.CENTER); //add moves to center of topPanel
      
      //set alignments
      status.setHorizontalAlignment(JLabel.CENTER);
      numCards1.setVerticalAlignment(JLabel.BOTTOM);
      numCards2.setVerticalAlignment(JLabel.BOTTOM);
      
      //add status, numCards1 and numCards2 to their respective panels
      topPanel.add(status,BorderLayout.SOUTH);
      westPanel.add(numCards1);
      eastPanel.add(numCards2);

      //add westPanel and eastPanel to topPanel
      topPanel.add(westPanel,BorderLayout.WEST);
      topPanel.add(eastPanel,BorderLayout.EAST);
      
      //add left and right panels to bottom panel
      bottomPanel.add(leftPanel);
      bottomPanel.add(rightPanel);
      
      //add top and bottom panel
      add(topPanel);
      add(bottomPanel);
      

   }
   
   // handle button events
   private class PlayWarButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {     
         for (int i=0;i<leftPanel.getComponentCount();i++) //for however many components there are
         {  
            Component [] c=(leftPanel.getComponents()); //get all components and put them in array
            c[i].setVisible(false); //for each component setVisible to false
            leftPanel.repaint(); //repaint
            leftPanel.revalidate(); //revalidate

         }   
         for (int i=0;i<rightPanel.getComponentCount();i++)//for however many components there are
         {
            Component [] c=(rightPanel.getComponents());//get all components and put them in array
            c[i].setVisible(false);//for each component setVisible to false
            rightPanel.repaint(); //repaint
            rightPanel.revalidate(); //revalidate

         }   

         
         
         
         int w=game.turn(); //do a turn and store the result as w
         
         //store each of the cards for the turn, last 4 are null if it's not a war turn
         Card p1=game.getPlayer1Card();
         Card p2=game.getPlayer2Card();
         Card warDown1=game.getPlayer1CardWarDown();
         Card warDown2=game.getPlayer2CardWarDown();
         Card p1War=game.getPlayer1CardWar();
         Card p2War=game.getPlayer2CardWar();
       
     
         //add card labels to panel if they exist
         leftPanel.add(p1.showCard());
         if ((warDown1!=null) && (p1War!=null))
         {
            leftPanel.add(warDown1.showBack());
            leftPanel.add(p1War.showCard());
         }
         
         //add card labels to panel if they exist
         rightPanel.add(p2.showCard());
         if ((warDown2!=null) && (p2War!=null))
         {
            rightPanel.add(warDown2.showBack());
            rightPanel.add(p2War.showCard());
         }   
         
         moves.setText("Moves: "+game.getMoves()); //update moves
         
         
         //decide who wins round and update status with the corresponding text
         if (w==1)
            status.setText("Player 1 wins this round");
         else if (w==2)
            status.setText("Player 2 wins this round");
         else if (w==3)
            status.setText("Player 1 wins this war");
         else if (w==4)
            status.setText("Player 2 wins this war");         


         //update how many cards each player has in their hands
         numCards1.setText("Player 1 has "+game.getCards1());
         numCards2.setText("Player 2 has "+game.getCards2());
         
         //repaint and revalidate
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
      
         //while there is no winner and while moves is less than an unreasonable number of terms   
         while ((game.getWinner()==0) && (game.getMoves()<3000))
         {
            game.turn(); //do a turn
         }
         
         if (game.getMoves()!=3000)//it's a finite game, not infinite
         {
            moves.setText("Moves: "+game.getMoves()); //update moves text
            
            int w=game.getWinner(); //get winner
   
            //display winner
            if (w==1)
               status.setText("Player 1 wins this game");
            else if (w==2)
               status.setText("Player 2 wins this game"); 
         }
         else //it's an infinite game
         {
            status.setText("Infinite Game...No winner");
         }      
         
         //remove cards from right and left panel and revalidate and repaint
         rightPanel.removeAll();
         leftPanel.removeAll();
         rightPanel.revalidate();
         leftPanel.revalidate();
         rightPanel.repaint();
         leftPanel.repaint();
         
         
         //update how many cards each player has
         numCards1.setText("Player 1 has "+game.getCards1());
         numCards2.setText("Player 2 has "+game.getCards2());
         
         //disable the buttons
         skipToEnd.setEnabled(false);  
         playCard.setEnabled(false);
         
          
 
      }
   }
   
   

}