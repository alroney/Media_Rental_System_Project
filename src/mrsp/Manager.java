package mrsp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * 
 * @author Andrew
 *
 */

public class Manager {
	static List<Media> mediaList = new ArrayList<>();//Create a list that refers to the Media class.
	
	Manager() {
		
	}

//Method: Attempt to find and retrieve a media object file, return the fate of success.
	public boolean LoadMedia(String path) {
		try {
			File file = new File(path);
			JOptionPane.showMessageDialog(null, mediaList);
			return true;
		}
		
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "File cannot be opened: Could not load, no such directory.");
			return false;
		}
	}
	
//Method: Setup the file and the array list.
	public void createMediaFiles(String path) {
		
		try {
			FileWriter writeFile = new FileWriter(path);
			
			//Create instances of media.
			EBook eb1 = new EBook(123, "Forever Young", 2018, true, 20);
			MovieDVD dvd1 = new MovieDVD(126, "Forever Young", 2020, false, 140.0);
			MusicCD cd1 = new MusicCD(150, "First Song", 1994, true, 2);
			
			//Add the instances to the list.
			mediaList.add(eb1);
			mediaList.add(dvd1);
			mediaList.add(cd1);
			
			writeFile.write(eb1.toString());//Overwrite
			writeFile.append(dvd1.toString());//add on
			writeFile.append(cd1.toString());//add on
			writeFile.flush();//Ensure file gets written
			writeFile.close();
		}
		catch(Exception e) {
			System.out.println("Error printing to file: "+ path);
		}
		
	}
		

	
//Method: Search through the array to match the title to the input value.
	public void findMedia(String title) {//File searching
		String result = "";
		boolean isFound = false;
		
		for(int i = 0; i < mediaList.size(); i++) {//Continue through the loop as much as there are objects.
			if(mediaList.get(i).getTitle().equals(title)) {
				result += mediaList.get(i).toString();
				System.out.print(mediaList.get(i).toString());
				isFound = true;
			}
		}
		
		if(!result.isEmpty()) {//If not empty
			JOptionPane.showMessageDialog(null, result);
		}
		
		if(!isFound) {//If not found
			JOptionPane.showMessageDialog(null, "There is no media with this title: "+ title);
		}
	}
	
	
//Method: Get an Id from the user, search for the id in file, display price and change availability.
	public void rentMedia(int id) {
		boolean isFound = false;
		try {
			for(Media m : mediaList) {
				if(m.getId() == id) {
					isFound = true;
					
					if(m.getIsAvailable()) {
						JOptionPane.showMessageDialog(null, "media successfully rented out. Rental Fee = $"+ m.calculateRentalFee());
						m.setIsAvailable(false);
					}
					else {
						JOptionPane.showMessageDialog(null,  "Media with id = "+ id +" is not available for rent.");
						break;
					}
				}
			}//End for-loop
			
			if(!isFound) {
				JOptionPane.showMessageDialog(null, "The media object id = "+ id +" is not found.");
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid");
		}
		
	}
}
