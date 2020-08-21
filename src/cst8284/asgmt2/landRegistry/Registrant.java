/* 
Course Name: CST8284
Student Name: Aarsh Doshi
Class name: Registrant
Date: July 5, 2020
*/

/* Assignment 1 starter code provided by Prof. D. Houtman
 * for use in CST8284 Assignment 2, due July 11, 2020.
 * This code is for one-time use only during the Summer 2020 semester.
 * (c) D. Houtman.  All rights reserved
 */

package cst8284.asgmt2.landRegistry;

public class Registrant {
	
	private static final int REGNUM_START = 1000;
	private static int currentRegNum = REGNUM_START;
	private final int REGNUM = currentRegNum;
	//This constant (public static final long serialversionUID=1L) was provided by Dave Houtman in Assignment 2 itself
	public static final long serialVersionUID=1L;
	private String firstName, lastName;
	
	public Registrant () {this("unknown unknown");}
	public Registrant (String firstLastName) {
	    incrToNextRegNum();
		setFirstName(firstLastName.split(" ")[0]); 
		setLastName(firstLastName.split(" ")[1]);
	}

	public int getRegNum() {return REGNUM;}
	private static void incrToNextRegNum() {currentRegNum++;}
	
	public String getFirstName() {return firstName;}
	public void setFirstName(String firstName) {this.firstName = firstName;}
	
	public String getLastName() {return lastName;}
	public void setLastName(String lastName) {this.lastName = lastName;}
	
	public boolean equals(Object obj) { 
		if (!(obj instanceof Registrant)) return false;
		Registrant reg = (Registrant)obj;
		return ((reg.getFirstName().equals(this.getFirstName())) &&
		   (reg.getLastName().equals(this.getLastName())) &&
		   (reg.getRegNum()==(this.getRegNum())));
	}
	
	public String toString() {
		return "Name: " + getFirstName() + " " + getLastName() + "\n" +
			   "Registration Number: #" + getRegNum();
	}
	
}