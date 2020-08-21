/* 
Course Name: CST8284
Student Name: Aarsh Doshi
Class name: RegControl
Date: June 19, 2020
*/

/* Assignment 1 starter code provided by Prof. D. Houtman
 * for use in CST8284 Assignment 2, due July 11, 2020.
 * This code is for one-time use only during the Summer 2020 semester.
 * (c) D. Houtman.  All rights reserved
 */

package cst8284.asgmt1.landRegistry;


public class RegControl {
	private Registrant[] registrants = new Registrant[3];
	private Property[] properties = new Property[5];
	
	private static int lastRegistrantIndex = 0;  
	private static int lastPropertyIndex = 0;  
	
	public int getLastRegistrantIndex() { return lastRegistrantIndex; }
	public int getLastPropertyIndex() { return lastPropertyIndex; }
	
    private Registrant[] getRegistrants() {	return registrants;}   
    private Property[] getProperties() { return properties; }
	
    public Registrant addNewRegistrant(Registrant reg) {
    	if (getRegistrants().length <= getLastRegistrantIndex()) return null;
    	getRegistrants()[getLastRegistrantIndex()]= reg;
    	lastRegistrantIndex++;
    	return reg;
    }
    
    public Registrant findRegistrant(int regNum) {
    	for (int i = 0; i < getLastRegistrantIndex(); i++) {
    		if (getRegistrants()[i].getRegNum() == regNum) return getRegistrants()[i];
    	}
    	return null;
    }
    
    public Registrant[] listOfRegistrants() {
    	Registrant[] listRegs = new Registrant[getLastRegistrantIndex()];
    	for(int listRegCtr = 0, regCtr = 0; regCtr < getLastRegistrantIndex(); regCtr++)
    		if (getRegistrants()[regCtr] !=null) listRegs[listRegCtr++] = getRegistrants()[regCtr];
    	return listRegs;
    }
    
    public Property changePropertyRegistrant(Property oldRegNumProp, int newRegNum) {
    	return (new Property(oldRegNumProp, newRegNum));
    }
    
    public Property addNewProperty(Property prop) {  
    	Property overlapProperty = checkPropertyOverlap(prop);
    	if (overlapProperty == null) {
        	if (getProperties().length <= getLastPropertyIndex()) return null;
        	getProperties()[getLastPropertyIndex()] = prop;
        	lastPropertyIndex++;
    	}
    	else
    		prop = overlapProperty;
    	return prop;

    }
    
    public Property[] listOfProperties(int RegistrationNumber) {
    	Property[] listProps = new Property[getLastPropertyIndex()];
    	int propCtr = 0;
    	for (Property prop: listOfAllProperties()) 
    		if (prop.getRegNum() == RegistrationNumber) listProps[propCtr++] = prop;
    	return listProps;
    }
    
    public Property[] listOfAllProperties() {
    	int maxIndex = getLastPropertyIndex();
    	if (maxIndex  > 0) {
    	Property[] listProps = new Property[maxIndex];
    	for(int listPropCtr = 0, propCtr = 0; propCtr < maxIndex; propCtr++)
    		if (getProperties()[propCtr] !=null) listProps[listPropCtr++] = getProperties()[propCtr];
    	return listProps;
    	}
    	else return null;
    }
    
    private Property checkPropertyOverlap(Property newProp) {
    	if (getLastPropertyIndex() > 0) {
	    	for (int ctr = 0; ctr < getLastPropertyIndex(); ctr++) {
	    		Property existingProp = getProperties()[ctr];
	    		if (existingProp.overlaps(newProp)) return existingProp;
	    	}
    	}
    	return null;
    }
  
	
}