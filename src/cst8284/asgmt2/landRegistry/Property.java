/* 
Course Name: CST8284
Student Name: Aarsh Doshi
Class name: Property
Date: July 5, 2020
*/

/* Assignment 1 starter code provided by Prof. D. Houtman
 * for use in CST8284 Assignment 2, due July 11, 2020.
 * This code is for one-time use only during the Summer 2020 semester.
 * (c) D. Houtman.  All rights reserved
 */

package cst8284.asgmt2.landRegistry;

public class Property {
	
	private static final double TAX_RATE_PER_M2 = 12.50;
	private static final int DEFAULT_REGNUM = 999;
	//This constant (public static final long serialversionUID=1L) was provided by Dave Houtman in Assignment 2 itself
	public static final long serialVersionUID=1L;
	private int xLeft, yTop;
	private int xLength, yWidth;
	private int regNum = DEFAULT_REGNUM;
	private int area = getArea();
	private double taxes = getTaxes();
	
	public Property() {this (0, 0, 0, 0);}
	
	public Property(int xLength, int yWidth, int xLeft, int yTop) {
		this (xLength, yWidth, xLeft, yTop, DEFAULT_REGNUM);
	}
	
	public Property(Property prop, int regNum) {
		this (prop.getXLength(), prop.getYWidth(), prop.getXLeft(), prop.getYTop(), regNum);
	}
	
	public Property(int xLength, int yWidth, int xLeft, int yTop, int regNum) {
		setXLength(xLength); setYWidth(yWidth); setXLeft(xLeft); setYTop(yTop); setRegNum(regNum);
	}
	
	public int getXLeft() { return xLeft;}
	public void setXLeft(int left) { this.xLeft = left; }
	
	public int getXRight(){return getXLeft() + getXLength();}

	public int getYTop() { return yTop; }
	public void setYTop(int top) { this.yTop = top; }
	
	public int getYBottom() { return getYTop() + getYWidth(); }

	public int getYWidth() { return yWidth; }
	public void setYWidth(int yWidth) { this.yWidth = yWidth; }
	
	public int getXLength() { return xLength;}
	public void setXLength(int xLength) { this.xLength = xLength; }
	
	public int getRegNum() {return regNum;}
	private void setRegNum(int regNum) { this.regNum = regNum; }
	
	public int getArea() {return (getXLength() * getYWidth()); }
	public double getTaxes() {return getArea() * TAX_RATE_PER_M2;}

	@Override
	public String toString() {
		return "Coordinates: " + getXLeft() + ", " + getYTop() + "\n" +
			   "Length: " + getXLength() + " m  Width: " + getYWidth() + " m\n" +
			   "Registrant #: " + getRegNum() + "\n" +
			   "Area: " + getArea() + " m2\nProperty Taxes : $" + getTaxes();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Property)) return false;
		Property prop = (Property)obj;
		return 
			prop.getYTop()==this.getYTop() &&
			prop.getXLeft()==this.getXLeft() &&
			hasSameSides(prop);
	}
	
	public boolean hasSameSides(Property prop) {
		return prop.getXLength()==this.getXLength() && prop.getYWidth()==this.getYWidth();
	}
	
	public boolean overlaps(Property prop) {
		return  prop.getXRight() > this.getXLeft() && prop.getXLeft() < this.getXRight() &&
				prop.getYTop() < this.getYBottom() && prop.getYBottom() > this.getYTop();
	}
	
}