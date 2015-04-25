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
   private JLabel p1Label,p2Label,warDown1Label,warDown2Label,p1WarLabel,p2WarLabel,warDown1dLabel,warDown2dLabel,p1dWarLabel,p2dWarLabel,warDown1tLabel,warDown2tLabel,p1tWarLabel,p2tWarLabel;//labels with card images
   private ImageIcon blue,purple; //blank JLabels colored as background
   private ImageIcon rollEyes,win; //image icons for end
   private JLabel winLabel,rollEyesLabel; //labels for end
   
   
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
 
      //ending gifs
      rollEyes=new ImageIcon("rolleyes.gif");
      win=new ImageIcon("win.gif");
      rollEyesLabel=new JLabel("You lose",rollEyes,JLabel.CENTER);
      winLabel=new JLabel("You win",win,JLabel.CENTER);
      rollEyesLabel.setHorizontalTextPosition(SwingConstants.CENTER);
      winLabel.setHorizontalTextPosition(SwingConstants.CENTER);
      rollEyesLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
      winLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
 
      //create empty labels for cards labels
      blue=new ImageIcon("blue.jpg");
      purple=new ImageIcon("purple.jpg");
      p1Label=new JLabel("Regular Card Played",blue,JLabel.LEFT);
      p2Label=new JLabel("Regular Card Played",purple,JLabel.LEFT);
      warDown1Label=new JLabel("War Card Played Face Down",blue,JLabel.CENTER);
      warDown2Label=new JLabel("War Card Played Face Down",purple,JLabel.CENTER);
      p1WarLabel=new JLabel("War Card Played Face Up",blue,JLabel.RIGHT);
      p2WarLabel=new JLabel("War Card Played Face Up",purple,JLabel.RIGHT);
      warDown1dLabel=new JLabel("Double War Card Played Face Down",blue,JLabel.CENTER);
      warDown2dLabel=new JLabel("Double War Card Played Face Down",purple,JLabel.CENTER);
      p1dWarLabel=new JLabel("Double War Card Played Face Up",blue,JLabel.RIGHT);
      p2dWarLabel=new JLabel("Double War Card Played Face Up",purple,JLabel.RIGHT);
      warDown1tLabel=new JLabel("Triple War Card Played Face Down",blue,JLabel.CENTER);
      warDown2tLabel=new JLabel("Triple War Card Played Face Down",purple,JLabel.CENTER);
      p1tWarLabel=new JLabel("Triple War Card Played Face Up",blue,JLabel.RIGHT);
      p2tWarLabel=new JLabel("Triple War Card Played Face Up",purple,JLabel.RIGHT);

      
              
              
      title1 = new JLabel("Rachel's Game of War:"); //add title
      title1.setFont(new Font("HELVETICA",Font.ITALIC,36));//set font of title
      title1.setHorizontalAlignment(JLabel.CENTER); //put title in center
      topPanel.add(title1,BorderLayout.NORTH); //add title in north panel of top panel
      
      status=new JLabel("ready?"); //starting status says "ready"
      status.setFont(new Font("HELVETICA",Font.BOLD,16));
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
      
      
         //remove cards from right and left panel and revalidate and repaint
         rightPanel.removeAll();
         leftPanel.removeAll();
         rightPanel.revalidate();
         leftPanel.revalidate();
         rightPanel.repaint();
         leftPanel.repaint();
         
            
         //do a turn and store the winner of the round as w
         int w=game.turn();
         
         //set War cards to null
         Card warDown1=null;
         Card warDown2=null;
         Card p1War=null;
         Card p2War=null;
         Card p1dWar=null;
         Card p2dWar=null;
         Card warDown1d=null;
         Card warDown2d=null;
         Card p1tWar=null;
         Card p2tWar=null;
         Card warDown1t=null;
         Card warDown2t=null;

         
         //store each of the cards for the turn, last 4 are null if it's not a war turn
         Card p1=game.getPlayer1Card();
         Card p2=game.getPlayer2Card();
         if ((w==3) || (w==4)) //single war turn
         {
            warDown1=game.getPlayer1CardWarDown();
            warDown2=game.getPlayer2CardWarDown();
            p1War=game.getPlayer1CardWar();
            p2War=game.getPlayer2CardWar();
         }   
         
         
         if ((w==5) || (w==6)) //double war turn
         {
            warDown1=game.getPlayer1CardWarDown();
            warDown2=game.getPlayer2CardWarDown();
            p1War=game.getPlayer1CardWar();
            p2War=game.getPlayer2CardWar();
            warDown1d=game.getPlayer1CardDWarDown();
            warDown2d=game.getPlayer2CardDWarDown();
            p1dWar=game.getPlayer1CardDWar();
            p2dWar=game.getPlayer2CardDWar();
            
         }   
         
          if ((w==7) || (w==8)) //triple war turn
         {
            warDown1=game.getPlayer1CardWarDown();
            warDown2=game.getPlayer2CardWarDown();
            p1War=game.getPlayer1CardWar();
            p2War=game.getPlayer2CardWar();
            warDown1d=game.getPlayer1CardDWarDown();
            warDown2d=game.getPlayer2CardDWarDown();
            p1dWar=game.getPlayer1CardDWar();
            p2dWar=game.getPlayer2CardDWar();
            warDown1t=game.getPlayer1CardTWarDown();
            warDown2t=game.getPlayer2CardTWarDown();
            p1tWar=game.getPlayer1CardTWar();
            p2tWar=game.getPlayer2CardTWar();
         }   


          
            
         //create all the JLabels
         p1Label.setIcon(p1.showCardIcon());
         p2Label.setIcon(p2.showCardIcon());
         
         


      
         //set icons of war cards to actual card pix
         if (w>=11)
         {
         }
         else if ((w>=3))
         {
            warDown1Label.setIcon(warDown1.showBackIcon());
            p1WarLabel.setIcon(p1War.showCardIcon());
            warDown2Label.setIcon(warDown2.showBackIcon());
            p2WarLabel.setIcon(p2War.showCardIcon()); 
            
            if (w>=5)
            {
               warDown1dLabel.setIcon(warDown1d.showBackIcon());
               p1dWarLabel.setIcon(p1dWar.showCardIcon());
               warDown2dLabel.setIcon(warDown2d.showBackIcon());
               p2dWarLabel.setIcon(p2dWar.showCardIcon());
               
               if (w>=7)
               {
                  warDown1tLabel.setIcon(warDown1t.showBackIcon());
                  p1tWarLabel.setIcon(p1tWar.showCardIcon());
                  warDown2tLabel.setIcon(warDown2t.showBackIcon());
                  p2tWarLabel.setIcon(p2tWar.showCardIcon()); 
               }
            }
            
         }   
         
          
                
      
         warDown1Label.addMouseListener(new FlipCardMouseListener());
         warDown2Label.addMouseListener(new FlipCardMouseListener());
         warDown1dLabel.addMouseListener(new FlipCardMouseListener());
         warDown2dLabel.addMouseListener(new FlipCardMouseListener());
         warDown1tLabel.addMouseListener(new FlipCardMouseListener());
         warDown2tLabel.addMouseListener(new FlipCardMouseListener());
          
         
         //set text to be at top
         p1Label.setVerticalTextPosition(SwingConstants.TOP);
         p2Label.setVerticalTextPosition(SwingConstants.TOP);
         p1WarLabel.setVerticalTextPosition(SwingConstants.TOP);
         p2WarLabel.setVerticalTextPosition(SwingConstants.TOP);
         warDown1Label.setVerticalTextPosition(SwingConstants.TOP);
         warDown2Label.setVerticalTextPosition(SwingConstants.TOP);
     
         //set text to be in center
         p1Label.setHorizontalTextPosition(SwingConstants.CENTER);
         p2Label.setHorizontalTextPosition(SwingConstants.CENTER);
         p1WarLabel.setHorizontalTextPosition(SwingConstants.CENTER);
         p2WarLabel.setHorizontalTextPosition(SwingConstants.CENTER);
         warDown1Label.setHorizontalTextPosition(SwingConstants.CENTER);
         warDown2Label.setHorizontalTextPosition(SwingConstants.CENTER);
         
         //add card labels to panel if they exist
         leftPanel.add(p1Label);
         if ((warDown1!=null) && (p1War!=null))
         {
            leftPanel.add(warDown1Label);
            leftPanel.add(p1WarLabel);
            
            if ((warDown1d!=null) && (p1dWar!=null))
            {
               leftPanel.add(warDown1dLabel);
               leftPanel.add(p1dWarLabel);
               
               if ((warDown1t!=null) && (p1tWar!=null))
               {
               leftPanel.add(warDown1tLabel);
               leftPanel.add(p1tWarLabel);
               }
            }
         }
   
         
         //add card labels to panel if they exist
         rightPanel.add(p2Label);
         if ((warDown2!=null) && (p2War!=null))
         {
            rightPanel.add(warDown2Label);
            rightPanel.add(p2WarLabel);
            
            if ((warDown2d!=null) && (p2dWar!=null))
            {
               rightPanel.add(warDown2dLabel);
               rightPanel.add(p2dWarLabel);
               
               if ((warDown2t!=null) && (p2tWar!=null))
               {
                  rightPanel.add(warDown2tLabel);
                  rightPanel.add(p2tWarLabel);
               }
            }
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
         else if (w==5)
            status.setText("Player 1 wins this double war"); 
         else if (w==6)
            status.setText("Player 2 wins this double war");
         else if (w==7)
            status.setText("Player 1 wins this triple war");
         else if (w==8)
            status.setText("Player 2 wins this triple war"); 
         else if (w==9)
         {
            status.setText(""); 
            moves.setText("Quadruple war. Error.");
            playCard.setEnabled(false);
            skipToEnd.setEnabled(false);           
         }
         else if (w==11)
         {
            moves.setText("Player 1 wins the GAME!"); //disp who won
            status.setText(""); //get rid of status count
            playCard.setEnabled(false); //disable the button
            skipToEnd.setEnabled(false); //disable the button
            
            //get rid of the cards
            rightPanel.removeAll();
            leftPanel.removeAll();
            rightPanel.revalidate();
            leftPanel.revalidate();
            rightPanel.repaint();
            leftPanel.repaint();
            
            //add ending gifs
            leftPanel.add(winLabel);
            rightPanel.add(rollEyesLabel);
            
         }   
         else if (w==12)
         {
            moves.setText("Player 2 wins the GAME!"); //disp who won
            status.setText(""); //get rid of status count
            playCard.setEnabled(false); //disable the button
            skipToEnd.setEnabled(false); //disable the button 
            
            //get rid of the cards
            rightPanel.removeAll();
            leftPanel.removeAll();
            rightPanel.revalidate();
            leftPanel.revalidate();
            rightPanel.repaint();
            leftPanel.repaint();  
            
            //add ending gifs
            rightPanel.add(winLabel);
            leftPanel.add(rollEyesLabel);
            
         }     

         //update how many cards each player has in their hands
         numCards1.setText("Player 1 has "+game.getCards1());
         numCards2.setText("Player 2 has "+game.getCards2());      
                          
      
      }
   } 
   
   private class SkipWarButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {  
      
         //remove cards from right and left panel and revalidate and repaint
         rightPanel.removeAll();
         leftPanel.removeAll();
         rightPanel.revalidate();
         leftPanel.revalidate();
         rightPanel.repaint();
         leftPanel.repaint();
      
         //while there is no winner and while moves is less than an unreasonable number of terms   
         while ((game.getMoves()<10000) && (game.turn()!=11) && (game.turn()!=12))
         {
            game.turn(); //do a turn
         }
         
         if (game.getMoves()<10000)//it's a finite game, not infinite
         {
            moves.setText("Moves: "+game.getMoves()); //update moves text
            
            int w=game.getWinner(); //get winner
   
            //display winner
            if (w==11)
            {
               status.setText("Player 1 wins this game");
               leftPanel.add(winLabel);
               rightPanel.add(rollEyesLabel);
            }
            else if (w==12)
            {
               status.setText("Player 2 wins this game"); 
               rightPanel.add(winLabel);
               leftPanel.add(rollEyesLabel);
            }
         }
         else //it's an infinite game
         {
            moves.setText("Moves exceeded 10,000...No winner");
            status.setText("");
         }      
         
         
         
         
         
         
         //update how many cards each player has
         numCards1.setText("");
         numCards2.setText("");
         
         //disable the buttons
         skipToEnd.setEnabled(false);  
         playCard.setEnabled(false);
         
          
 
      }
   }
   
   private class FlipCardMouseListener implements MouseListener //flips middle face down war card
   {
      public void mouseEntered(MouseEvent e)
      { 
         JLabel source=(JLabel)(e.getSource()); //get source
         
         if ((source==warDown1Label) || (source==warDown1dLabel) || (source==warDown1tLabel)) //if mouse if over the left face down card
         {
            warDown1Label.setIcon((game.getPlayer1CardWarDown()).showCardIcon()); //flip it
         }   
         else //otherwise mouse if over right face down card
         {
            warDown2Label.setIcon((game.getPlayer2CardWarDown()).showCardIcon()); //flip it
         }   
         
      }
      
      public void mousePressed(MouseEvent e)
      {
      }
      
      public void mouseClicked(MouseEvent e)
      {
      }
      
      public void mouseReleased(MouseEvent e)
      {
      }
      
      public void mouseExited(MouseEvent e)
      {
               
         JLabel source=(JLabel)(e.getSource()); //get source
         
         
         if ((source==warDown1Label) || (source==warDown1dLabel) || (source==warDown1tLabel)) //if mouse if exiting warDown1Label
         {
            warDown1Label.setIcon((game.getPlayer1CardWarDown()).showBackIcon()); //flip it back
         }   
         else //otherwise
         {
            warDown2Label.setIcon((game.getPlayer2CardWarDown()).showBackIcon()); //flip it back
         } 
         

      }

   }
   
   

}