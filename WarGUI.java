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
      
      
         //remove cards from right and left panel and revalidate and repaint
         rightPanel.removeAll();
         leftPanel.removeAll();
         rightPanel.revalidate();
         leftPanel.revalidate();
         rightPanel.repaint();
         leftPanel.repaint();
         
            
         //do a turn and store the winner of the round as w
         int w=game.turn();
         
         //store each of the cards for the turn, last 4 are null if it's not a war turn
         Card p1=game.getPlayer1Card();
         Card p2=game.getPlayer2Card();
         Card warDown1=game.getPlayer1CardWarDown();
         Card warDown2=game.getPlayer2CardWarDown();
         Card p1War=game.getPlayer1CardWar();
         Card p2War=game.getPlayer2CardWar();
          
            
         //create all the JLabels
         JLabel p1Label=p1.showCard("Regular Card Played",1);
         JLabel p2Label=p2.showCard("Regular Card Played",1);
         
         //create empty labels for war cards
         JLabel warDown1Label=new JLabel();
         JLabel warDown2Label=new JLabel();
         JLabel p1WarLabel=new JLabel();
         JLabel p2WarLabel=new JLabel();


         if ((warDown1!=null) && (p1War!=null) && (warDown2!=null) && (p2War!=null))
         {
            //set icons of war cards to actual card pix
            warDown1Label=warDown1.showBack("War Card Played Face Down");
            p1WarLabel=(p1War.showCard("War Card Played Face Up",2));
            warDown2Label=(warDown2.showBack("War Card Played Face Down"));
            p2WarLabel=p2War.showCard("War Card Played Face Up",2);           
         
            // warDown1Label.addMouseListener(new FlipCardMouseListener());
//             warDown2Label.addMouseListener(new FlipCardMouseListener());
         }   
         
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
         }
   
         
         //add card labels to panel if they exist
         rightPanel.add(p2Label);
         if ((warDown2!=null) && (p2War!=null))
         {
            rightPanel.add(warDown2Label);
            rightPanel.add(p2WarLabel);
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
         

         
         
         // Component [] l=(leftPanel.getComponents()); //get all components and put them in array
// 
//          for (int i=0;i<leftPanel.getComponentCount();i++) //for however many components there are
//          {  
//             l[i].setVisible(false); //for each component setVisible to false
//             leftPanel.repaint(); //repaint
//             leftPanel.revalidate(); //revalidate
// 
//          }
//          
//          Component [] r=(rightPanel.getComponents());//get all components and put them in array
//          
//          for (int i=0;i<rightPanel.getComponentCount();i++)//for however many components there are
//          {
//             r[i].setVisible(false);//for each component setVisible to false
//             rightPanel.repaint(); //repaint
//             rightPanel.revalidate(); //revalidate
// 
//          }   
// 
//          
// 
//          //create JLabels out of purple and blue "blank" cards
//          ImageIcon purple=new ImageIcon("purple.jpg");
//          ImageIcon blue=new ImageIcon("blue.jpg");         
//          
//          int w=game.turn(); //do a turn and store the result as w
//          
//          //store each of the cards for the turn, last 4 are null if it's not a war turn
//          Card p1=game.getPlayer1Card();
//          Card p2=game.getPlayer2Card();
//          Card warDown1=game.getPlayer1CardWarDown();
//          Card warDown2=game.getPlayer2CardWarDown();
//          Card p1War=game.getPlayer1CardWar();
//          Card p2War=game.getPlayer2CardWar();
//        
//          //create all the JLabels
//          JLabel p1Label=p1.showCard("Regular Card Played",1);
//          JLabel p2Label=p2.showCard("Regular Card Played",1);
//          
//          //create empty labels for war cards
//          JLabel warDown1Label=new JLabel();
//          JLabel warDown2Label=new JLabel();
//          JLabel p1WarLabel=new JLabel();
//          JLabel p2WarLabel=new JLabel();
//         //  
// //          //setvisible of war card to false
// //          warDown1Label.setVisible(false);
// //          p1WarLabel.setVisible(false);
// //          warDown2Label.setVisible(false);
// //          p2WarLabel.setVisible(false);
//          
//          //repaint and revalidate war cards
//          warDown1Label.repaint();
//          warDown1Label.revalidate();
//          warDown2Label.repaint();
//          warDown2Label.revalidate();
//          p1WarLabel.repaint();
//          p1WarLabel.revalidate();
//          p2WarLabel.repaint();
//          p2WarLabel.revalidate();
//          
//          if ((warDown1!=null) && (p1War!=null))
//          {
//             //set icons of war cards to actual card pix
//             warDown1Label.setIcon(warDown1.showBackIcon());
//             p1WarLabel.setIcon(p1War.showCardIcon());
//             
//             warDown2Label.setIcon(warDown2.showBackIcon());
//             p2WarLabel.setIcon(p2War.showCardIcon());
//             
//             //set visible to true
//             warDown1Label.setVisible(true);
//             p1WarLabel.setVisible(true);
//             warDown2Label.setVisible(true);
//             p2WarLabel.setVisible(true);            
//             
//             
//             // warDown1Label.addMouseListener(new FlipCardMouseListener());
// //             warDown2Label.addMouseListener(new FlipCardMouseListener());
//          }   
//          
//          //set text to be at top
//          p1Label.setVerticalTextPosition(SwingConstants.TOP);
//          p2Label.setVerticalTextPosition(SwingConstants.TOP);
//          p1WarLabel.setVerticalTextPosition(SwingConstants.TOP);
//          p2WarLabel.setVerticalTextPosition(SwingConstants.TOP);
//          warDown1Label.setVerticalTextPosition(SwingConstants.TOP);
//          warDown2Label.setVerticalTextPosition(SwingConstants.TOP);
//      
//          //set text to be in center
//          p1Label.setHorizontalTextPosition(SwingConstants.CENTER);
//          p2Label.setHorizontalTextPosition(SwingConstants.CENTER);
//          p1WarLabel.setHorizontalTextPosition(SwingConstants.CENTER);
//          p2WarLabel.setHorizontalTextPosition(SwingConstants.CENTER);
//          warDown1Label.setHorizontalTextPosition(SwingConstants.CENTER);
//          warDown2Label.setHorizontalTextPosition(SwingConstants.CENTER);
//      
//      
//      
//          //add card labels to panel if they exist
//          leftPanel.add(p1Label);
//         //  if ((warDown1!=null) && (p1War!=null))
// //          {
//             leftPanel.add(warDown1Label);
//             leftPanel.add(p1WarLabel);
//       //    }
//         //  if (((warDown1==null) && (p1War==null)) || (p1WarLabel.getIcon()!=p1War.showCard("War Card Played face up",2)))
// //          {
// //             warDown1Label=blue1;
// //             p1WarLabel=blue2;
// //             leftPanel.add(warDown1Label);
// //             leftPanel.add(p1WarLabel);
// //          }  
//          
//          //add card labels to panel if they exist
//          rightPanel.add(p2Label);
//         //  if ((warDown2!=null) && (p2War!=null))
// //          {
//             rightPanel.add(warDown2Label);
//             rightPanel.add(p2WarLabel);
//       //    }   
// //          if (((warDown2==null) && (p2War==null)) || (p2WarLabel.getIcon()!=p2War.showCard("War Card Played face up",2)))
// //          {
// //             warDown2Label=purple1;
// //             p2WarLabel=purple2;
// //             rightPanel.add(warDown2Label);
// //             rightPanel.add(p2WarLabel);
// //          }  
//          
//          moves.setText("Moves: "+game.getMoves()); //update moves
//          
//          
//          //decide who wins round and update status with the corresponding text
//          if (w==1)
//             status.setText("Player 1 wins this round");
//          else if (w==2)
//             status.setText("Player 2 wins this round");
//          else if (w==3)
//             status.setText("Player 1 wins this war");
//          else if (w==4)
//             status.setText("Player 2 wins this war");         
// 
// 
//          //update how many cards each player has in their hands
//          numCards1.setText("Player 1 has "+game.getCards1());
//          numCards2.setText("Player 2 has "+game.getCards2());
//          
//          //repaint and revalidate
//          leftPanel.revalidate();
//          rightPanel.revalidate();
//          leftPanel.repaint();
//          rightPanel.repaint();
//          
//          
                          
      
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
   
  //  private class FlipCardMouseListener implements MouseListener
//    {
//       public void mouseEntered(MouseEvent e)
//       { 
//          JLabel source=(JLabel)(e.getSource());
//          
//          if (source==(game.getPlayer1CardWarDown()).showBack("War card played face down"))
//          {
//             JLabel warDown1Label=((game.getPlayer1CardWarDown()).showCard("War card played face down",3));
//             leftPanel.add(warDown1Label);
//          }   
//          else
//          {
//             JLabel warDown2Label=((game.getPlayer2CardWarDown()).showCard("War card played face down",3));
//             rightPanel.add(warDown2Label);
//          }   
//          
//       }
//       
//       public void mousePressed(MouseEvent e)
//       {
//       }
//       
//       public void mouseClicked(MouseEvent e)
//       {
//       }
//       
//       public void mouseReleased(MouseEvent e)
//       {
//                }
//       
//       public void mouseExited(MouseEvent e)
//       {
//                
//          JLabel source=(JLabel)(e.getSource());
//          
//          
//          if (source==(game.getPlayer1CardWarDown()).showBack("War card played face down"))
//          {
//             JLabel warDown1Label=((game.getPlayer1CardWarDown()).showBack("War card played face down"));
//             leftPanel.add(warDown1Label);
//          }   
//          else
//          {
//             JLabel warDown2Label=((game.getPlayer2CardWarDown()).showBack("War card played face down"));
//             rightPanel.add(warDown2Label);
//          } 
//          
// 
//       }
// 
//    }
//    
   

}