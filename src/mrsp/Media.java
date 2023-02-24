package mrsp;

import java.util.Calendar;

/**
 * 
 * @author Andrew
 *
 */


public abstract class Media {
	private int id;
	private int year;
	private String title;
	private boolean isAvailable;
	
//Constructor: Overloading, set media to a default of isAvailable to true when an instance is created.
	public Media() {
		isAvailable = true;
	}
	
//Constructor: Set the values for the current object to that of the input values.
	public Media(int id, int year, String title, boolean isAvailable) {
		this.id = id;
		this.year = year;
		this.title = title;
		this.isAvailable = isAvailable;
		
	}
	
	
	/*SET METHODS*/

//Method: Update the current value of id to the value of the input.
	public void setId(int id) {
		this.id = id;
	}
	
//Method: Update the current value of year to the value of the input.
	public void setYear(int year) {
		this.year = year;
	}
	
//Method: Update the current value of title to the value of the input.
	public void setTitle(String title) {
		this.title = title;
	}
	
//Method: Update the current value of isAvailable to the value of the input.
	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	
	/*GET METHODS*/

//Method: Retrieve the current value of id and return it to the caller.
	public int getId() {
		return this.id;
	}
	
//Method: Retrieve the current value of year and return it to the caller.
	public int getYear() {
		return this.year;
	}
	
//Method: Retrieve the current value of title and return it to the caller.
	public String getTitle() {
		return this.title;
	}
	
//Method: Retrieve the current value of isAvailable and return it to the caller.
	public boolean getIsAvailable() {
		return isAvailable;
	}
	

//Method: Return the flat fee to the caller.
	public double calculateRentalFee() {
		return 3.50;
	}
}




/*==== CLASS: EBook ====*/

class EBook extends Media {
	private int chapterCount;

//Constructor: Set an entire object to that of the input values.
	public EBook(int id, String title, int year, boolean isAvailable, int chapterCount) {
		super(id, year, title, isAvailable);
		this.chapterCount = chapterCount;
	}
	
	/*SET METHOD*/
//Method: Update the current number of chapters to the value of the input.
	public void setChapterCount(int chapterCount) {
		this.chapterCount = chapterCount;
	}
	
	
	/*GET METHOD*/
//Method: Retrieve the current number of chapters and send it to the caller.
	public int getChapterCount() {
		return this.chapterCount;
	}
	
//Method: Display the information for the EBook.
	@Override
	public String toString() {
		return "EBook [id: "+ this.getId() +" title: "+ this.getTitle() +" chapter: "+ this.getChapterCount() +" year: "+ this.getYear() +" available: "+ this.getIsAvailable() +"]\n";
	}
	
//Method: Calculate the EBook rental fee on top of the standard flat fee of $3.50.
	@Override
	public double calculateRentalFee() {
		double fee = chapterCount * 0.10;//basic fee
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		
		if(this.getYear() == currentYear) {
			fee += 1;//Add a $1.00 fee
		}
		
		return fee;
	}
}



/*==== CLASS: MovieDVD ====*/

class MovieDVD extends Media {
	private double size;
	
	
//Constructor: Set the value of the entire object to the input values.
	public MovieDVD(int id, String title, int year, boolean available, double size) {
		super(id, year, title, available);//set the input values to the values in the Media class (superclass)
		this.size = size;
	}
	
	/*SET METHODS*/
//Method: Update the current size to the value of the input.
	public void setSize(double size) {
		this.size = size;
	}
	
	/*GET METHODS*/
//Method: Retrieve the current value of size and send to the caller.
	public double getSize() {
		return this.size;
	}
	
//Method: Display the information for the MovieDVD.
	@Override
	public String toString() {
		return "MovieDVD [id: "+ this.getId() +" title: "+ this.getTitle() +" size: "+ this.getSize() +" year: "+ this.getYear() +" available: "+ this.getIsAvailable() +"]\n";
	}
	
//Method: Proceed to calculate the default rental fee.
	@Override
	public double calculateRentalFee() {
		return super.calculateRentalFee();
	}
}



/*==== CLASS: MusicCD ====*/

class MusicCD extends Media {
	private int length;
	
//Constructor: Set the value of the entire object to the input values.
	public MusicCD(int id, String title, int year, boolean available, int length) {
		super(id, year, title, available);//set the input values to the values in the Media class (superclass)
		this.length = length;
	}
	
	/*SET METHODS*/
//Method: Update the current length to the value of the input.
	public void setLength(int length) {
		this.length = length;
	}
	
	/*GET METHODS*/
//Method: Retrieve the current value of length and send to the caller.
	public int getLength() {
		return this.length;
	}
	
//Method: Display the information for the MovieDVD.
	@Override
	public String toString() {
		return "MusicCD [id: "+ this.getId() +" title: "+ this.getTitle() +" length: "+ this.getLength() +" year: "+ this.getYear() +" available: "+ this.getIsAvailable() +"]\n";
	}
	
//Method: Proceed to calculate the default rental fee.
	@Override
	public double calculateRentalFee() {
		double fee = length * 0.02;//Basic Fee
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		
		if(this.getYear() == currentYear) {
			fee += 1;//Add $1.00 to the fee
		}
		
		return fee;
	}
	
}