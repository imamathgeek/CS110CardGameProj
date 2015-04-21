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
      JFrame frame = new WarGUI();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   frame.setSize(1000,550);
      frame.validate();
      frame.setVisible(true);


   
   
   }


}