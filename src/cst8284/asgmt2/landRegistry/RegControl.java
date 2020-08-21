/* 
Course Name: CST8284
Student Name: Aarsh Doshi
Class name: RegControl
Date: July 12, 2020
*/

/* Assignment 1 starter code provided by Prof. D. Houtman
 * for use in CST8284 Assignment 2, due July 11, 2020.
 * This code is for one-time use only during the Summer 2020 semester.
 * (c) D. Houtman.  All rights reserved
 */

package cst8284.asgmt2.landRegistry;

import java.util.ArrayList;
import java.io.*;

public class RegControl {
	
	private ArrayList<Registrant> registrants = new ArrayList<>();
	private ArrayList<Property> properties = new ArrayList<>();
	
	public RegControl(){
	}
	
	private ArrayList<Registrant> getRegistrants(){return registrants;}
	private ArrayList<Property> getProperties(){return properties;}
	
    // This method uses code supplied by Prof. Dave Houtman
  	// at Algonquin College in the 2020 summer semester
    public Registrant addNewRegistrant(Registrant reg) {
    	getRegistrants().add(reg);
    	return reg;
    }
    
    // This method uses code supplied by Prof. Dave Houtman
  	// at Algonquin College in the 2020 summer semester
    // Replacing Array with ArrayList was the only thing done by me in this method
    public Registrant findRegistrant(int regNum) {
    	for (int i = 0; i < registrants.size(); i++) {
    		if (getRegistrants().get(i).getRegNum() == regNum) return getRegistrants().get(i);
    	}
    	return null;
    }
    
    
    public Registrant deleteRegistrant(int regNum) {
    	getRegistrants().remove(findRegistrant(regNum));
    	return findRegistrant(regNum);
    }
    
    // This method uses code supplied by Prof. Dave Houtman
  	// at Algonquin College in the 2020 summer semester
    public ArrayList<Registrant> listOfRegistrants() {
    	return getRegistrants();
    }
    
    // This method uses code supplied by Prof. Dave Houtman
  	// at Algonquin College in the 2020 summer semester
    public Property changePropertyRegistrant(Property oldRegNumProp, int newRegNum) {
    	return (new Property(oldRegNumProp, newRegNum));
    }
    
    // This method uses code supplied by Prof. Dave Houtman
  	// at Algonquin College in the 2020 summer semester
    public Property addNewProperty(Property prop) {  
    	Property overlapProperty = PropertyOverlaps(prop);
    	if (overlapProperty == null) {
    		getProperties().add(prop);
    	}
    	else
    		prop = overlapProperty;
    	return prop;
    }
    
    
    public boolean deleteProperties(ArrayList<Property> props) {
    		for(Property delProp : props) {
    		listOfAllProperties().remove(delProp);
    	}
    	return true;
    }
    
    // This method uses code supplied by Prof. Dave Houtman
  	// at Algonquin College in the 2020 summer semester
    // Replacing Array with ArrayList was the only thing done by me in this method
    public ArrayList<Property> listOfProperties(int regNum) {
    	ArrayList<Property> listProps = new ArrayList<>();
    	//int propCtr = 0;
    	for (Property prop: listOfAllProperties()) {
    		if(prop.getRegNum()==regNum) 
    		listProps.add(prop);}
    	return listProps;
    }
    
    
    
    // This method uses code supplied by Prof. Dave Houtman
  	// at Algonquin College in the 2020 summer semester
    public ArrayList<Property> listOfAllProperties() {
    	return getProperties();
    }
    
    // This method uses code supplied by Prof. Dave Houtman
  	// at Algonquin College in the 2020 summer semester
    private Property PropertyOverlaps(Property prop) {
	    	for (int ctr = 0; ctr < properties.size(); ctr++) {
	    		Property existingProp = getProperties().get(ctr);
	    		if (existingProp.overlaps(prop)) return existingProp;
	    	}
    	return null;
    }
  
    
   //This method uses code provided by Prof. Dave Houtman in File_IO (Part 1 and Part 2)Hybrid Notes 
	public <T> boolean saveToFile(ArrayList<T> source, String fileName) {
		boolean b = false;
		File file = new File(fileName);
		if (file.exists()) {
			//System.out.println("File already exists");
			file.delete();
		}
	
		try {
			FileOutputStream fos = new FileOutputStream(new File(fileName));
			ObjectOutputStream oos = new ObjectOutputStream(fos);
		{
			for(T src: source)
			oos.writeObject(src);
		}
			b=true;
			fos.close();
			oos.close();
			return b;
		}
		catch(IOException ioe){
			//System.err.println("IO Exception");
			return false;
		}
		
	}
		
		
	//This method uses code provided by Prof. Dave Houtman in File_IO (Part 1 and Part 2)Hybrid Notes
	/* Kasyap, K. (2019). How to handle EOFException in java? [Webpage]. Retrieved from 
	   https://www.tutorialspoint.com/how-to-handle-eofexception-in-java */
    public <T> ArrayList<T> loadFromFile(String fileName){

		ArrayList<T> load = new ArrayList<T>();
		try {
			FileInputStream fos = new FileInputStream(fileName);
			ObjectInputStream oos = new ObjectInputStream(fos);
			
		load.add((T)oos.readObject());
		oos.close();
		return load;
		}
		catch(EOFException eof) {
			//System.err.println("EOF Exception");
			return load;
	}
		catch(IOException ioe) {
			//System.err.println("IO Exception");
			return load;
		}
		catch(ClassNotFoundException cnfe) {
			//System.err.println("CLASS NOT FOUND Exception");
			return load;
		}
	}
	
	
}