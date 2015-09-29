package com.jerry.util;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

//All general settings go here
public class SwingConsole {
	
    //Schedule a job for the event-dispatching thread:
    //creating and showing this application's GUI.
	public static void run(final JFrame f, final String title, final int width, final int height) {
	
	//following code causes button to cover other component.	
	/*	try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(f, e.toString(), "Exception", JOptionPane.ERROR_MESSAGE);
		}
	*/	
		SwingUtilities.invokeLater( new Runnable() {
			@Override
			public void run() {
				f.setTitle(title);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				//Unless user explicitly assign size attribute, 
				//the size of the frame should be managed by layout manager.
				if(width != 0 || height != 0) {
					f.setSize(width, height);
				} else {
					f.pack();
				}
				f.setResizable(false);
				f.setVisible(true);	
			}
		});

	}
}
