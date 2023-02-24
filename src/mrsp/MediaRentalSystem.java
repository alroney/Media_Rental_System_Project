package mrsp;

import java.io.File;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import java.awt.*;
import java.awt.event.*;

/**
 * 
 * @author Andrew Roney
 * Date: 07/02/2022
 * Purpose: This project is to demonstrate my knowledge and skills I have acquired over the course of this class.
 * Description: This program will allow a user to select and rent a media object through a GUI.
 *
 */





public class MediaRentalSystem extends javax.swing.JFrame{
	private Manager manager = new Manager();
	
	public static void main(String[] args) {
		new MediaRentalSystem();
		
	}
	
	public MediaRentalSystem() {
		gui();//Run through the gui method
	}
	
	
//Method: Create the structure and action events for the GUI.
	private void gui() {
		JMenuBar menuBar = new JMenuBar();//Create the bar at the top.
			JMenu menu1 = new JMenu();//Place drop-down menu on bar.
				JMenuItem m1I1 = new JMenuItem();
				JMenuItem m1I2 = new JMenuItem(); 
				JMenuItem m1I3 = new JMenuItem(); 
				JMenuItem m1I4 = new JMenuItem();
			
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
		setTitle("Welcome to Media Rental System");
		setVisible(true);//Display the window.
		
		
		menu1.setText("Menu");//Set name of menu
		
		
		/*ITEM 1*/
			m1I1.setText("Load Media Objects");
			m1I1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					m1I1_ActionPerformed(ae);
				}
			});
			menu1.add(m1I1);//Put item 1 into drop-down.
		
		/*ITEM 2*/
			m1I2.setText("Find Media Objects");
			m1I2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					m1I2_ActionPerformed(ae);
				}
			});
			menu1.add(m1I2);//Put item 2 into drop-down.
		
		/*ITEM 3*/
			m1I3.setText("Rent Media Objects");
			m1I3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					m1I3_ActionPerformed(ae);
				}
			});
			menu1.add(m1I3);//Put item 3 into drop-down.
		
		
		/*ITEM 4*/
			m1I4.setText("Quit");
			m1I4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					m1I4_ActionPerformed(ae);
				}
			});
			menu1.add(m1I4);//Put item 4 into drop-down.
		
		
		setJMenuBar(menuBar);//Create the top bar.
		menuBar.add(menu1);//Add the menu to the top bar.
		
		/*WINDOW MANIPULATION*/
			GroupLayout gLayout = new GroupLayout(getContentPane());//Create a group layout in the current window.
			getContentPane().setLayout(gLayout);//Assign the window layout to the group layout.
			
			gLayout.setHorizontalGroup(gLayout.createParallelGroup(Alignment.LEADING).addGap(0, 400, Short.MAX_VALUE));//Width of window
			gLayout.setVerticalGroup(gLayout.createParallelGroup(Alignment.LEADING).addGap(0, 279, Short.MAX_VALUE));//Height of window
			
			pack();//Sets the size of the inner components to fit properly automatically.
			setLocationRelativeTo(null);//Set the default location of the window to display in the middle of the screen.
		
		
	}
	
//Method: When button is clicked, open a file explorer to select a file.
	private void m1I1_ActionPerformed(ActionEvent ae) {
		
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("Select File to be Opened");
		chooser.setSelectedFile(null);//No file is initially selected.
		
		int fChooser = chooser.showOpenDialog(this);
		
		if(fChooser != JFileChooser.APPROVE_OPTION) {
			return;//User has chosen to cancel selection
		}
		
		System.out.println("You chose to open this file: "+ chooser.getSelectedFile().getName());
		
		File selectedFile = chooser.getSelectedFile();
		
		String filename = selectedFile.getPath();
			manager.createMediaFiles(filename);
			manager.LoadMedia(filename);//Use the file selected for the media loading
	}
	
	
//Method: When the button is clicked ask user for input.
	private void m1I2_ActionPerformed(ActionEvent ae) {
		
		String title = JOptionPane.showInputDialog(null, "Enter the Title");
			manager.findMedia(title);
		
	}
	
//Method: When the button is clicked ask user for input.
	private void m1I3_ActionPerformed(ActionEvent ae) {
		
		String id = JOptionPane.showInputDialog(null, "Enter the Id");
			manager.rentMedia(Integer.parseInt(id));
		
	}
	

//Method: When the button is clicked stop the program.
	private void m1I4_ActionPerformed(ActionEvent ae) {
		
		System.exit(0);
		
	}
	
}
