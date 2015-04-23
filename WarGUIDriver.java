/* Rachel Bayersdorfer
CS 110
Homework 10: Final Project
War GUI Driver
*/

import javax.swing.*;

public class WarGUIDriver
{
   public static void main(String [] args)
   {
      JFrame frame = new WarGUI(); //create JFrame
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //set closing action
	   frame.setSize(1050,550); //set size of frame to accommodate 3 cards in lower panels
      frame.validate(); //validate
      frame.setVisible(true); //make it visible


   
   
   }


}