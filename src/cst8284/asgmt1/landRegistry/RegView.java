/* 
Course Name: CST8284
Student Name: Aarsh Doshi
Class name: RegView
Date: June 21, 2020
*/

/* Assignment 1 starter code provided by Prof. D. Houtman
 * for use in CST8284 Assignment 2, due July 11, 2020.
 * This code is for one-time use only during the Summer 2020 semester.
 * (c) D. Houtman.  All rights reserved
 */

package cst8284.asgmt1.landRegistry;

import java.util.Scanner;

public class RegView {
	
	private static Scanner scan = new Scanner(System.in);
	private static RegControl rc;
	
	private static final int 
		ADD_NEW_REGISTRANT = 1, 
		FIND_REGISTRANT = 2,
		LIST_REGISTRANTS = 3, 
		
		ADD_NEW_PROPERTY = 4, 
		CHANGE_PROPERTY_REGISTRANT = 5,
		LIST_PROPERTY_BY_REGNUM = 6,
		LIST_ALL_PROPERTIES = 7,
		EXIT = 0;
	
	public RegView() {
		rc = new RegControl();
	}
	
	public static void launch() {
		int choice = 0;
		do {
		   choice = displayMenu();
		   executeMenuItem(choice);
		} while (choice != EXIT);		
	}
	
	private static int displayMenu() {
		System.out.println("Enter a selection from the following menu:");
		System.out.println(
				
			ADD_NEW_REGISTRANT +       		". Enter a new registrant\n" +
			FIND_REGISTRANT + 				". Find registrant by registration number\n" +
			LIST_REGISTRANTS +     			". Display list of registrants\n" +
			
			ADD_NEW_PROPERTY +        		". Register a new property\n" +
			CHANGE_PROPERTY_REGISTRANT +	". Change a property's registrant\n" +
			LIST_PROPERTY_BY_REGNUM + 		". Display all properties with the same registration number\n" + 
			LIST_ALL_PROPERTIES  +     		". Display all registered properties\n" +
			
			EXIT +                    		". Exit program\n"
		);
		int ch = scan.nextInt();
		scan.nextLine();      // 'eat' the next line in the buffer
		return ch;
	}
	
	private static void executeMenuItem(int choice) {
		switch (choice) {
		
			case ADD_NEW_REGISTRANT:   			viewAddNewRegistrant();			break;
			case FIND_REGISTRANT:	 			viewFindRegistrant();			break;
			case LIST_REGISTRANTS:    			viewListOfRegistrants();		break;
			
			case ADD_NEW_PROPERTY: 				viewAddNewProperty();			break;
			case CHANGE_PROPERTY_REGISTRANT:	viewChangePropertyRegistrant(); break;
			case LIST_PROPERTY_BY_REGNUM: 		viewListPropertyByRegNum();		break;	
			case LIST_ALL_PROPERTIES:   		viewListAllProperties();		break;  
			
			case EXIT: 	System.out.println("Exiting Land Registry\n\n");		break;
			default: System.out.println("Invalid choice: try again. (Select " + EXIT + " to exit.)\n");
		}
		System.out.println();  // add blank line after each output
	}
				
    private static String getResponseTo(String s) {
    	System.out.print(s);
		return(scan.nextLine());
    }
    
    private static int requestRegNum() {
    	return (Integer.parseInt(getResponseTo("Enter registration number : ")));
    }
    
    public static Registrant makeNewRegistrantFromUserInput() {
    	String firstLast = getResponseTo("Enter registant's first and Last name: ");
    	return (new Registrant(firstLast));  	
    }
    
    public static Property makeNewPropertyFromUserInput() {
    	String topLeftCoords = getResponseTo("Enter top and left coordinates of property (as X, Y): ");
    	String lengthWidth = getResponseTo("Enter length and width of property (as length, width): ");
    	int xLeft = Integer.parseInt(topLeftCoords.split(",")[0].trim());
    	int yTop = Integer.parseInt(topLeftCoords.split(",")[1].trim());
    	int xLength = Integer.parseInt(lengthWidth.split(",")[0].trim());
    	int yWidth = Integer.parseInt(lengthWidth.split(",")[1].trim());
    	return (new Property(xLength, yWidth, xLeft, yTop));  	
    }
    
    public static void viewAddNewRegistrant() {
    	Registrant reg = makeNewRegistrantFromUserInput();	
    	reg = rc.addNewRegistrant(reg);
    	if (reg == null)
    		System.out.println("Could not add new registrant; registrant array is full.");
    	else
    		System.out.println("Registrant added: \n" + reg.toString());
    }
    
    public static void viewFindRegistrant() {
    	int regNum = requestRegNum();
    	Registrant reg = rc.findRegistrant(regNum);
    	System.out.println(""+ ((reg==null)? // Registrant does not exist
    		"A registrant having the registration number\n" + 
    		reg.getRegNum() + " could not be found in the registrants list.\n"
    		:  // Registrant found
    		"The registrant associated with that registration number " + 
    		"is\n"+ reg.toString() + "\n"));
    }
    
    public static void viewListOfRegistrants() {
    	Registrant[] regs = rc.listOfRegistrants();
    	if (rc.getLastRegistrantIndex() == 0) 
    		System.out.println("No Registrants are loaded yet");
    	else {
    		System.out.println("List of registrants:\n");
    		for (Registrant reg: regs)
    			System.out.print(reg.toString()+ "\n");	
    	}
    }
        
    public static void viewChangePropertyRegistrant() {
    	int oldRegNum = Integer.parseInt(getResponseTo("Enter original registrants number: "));
    	if (rc.findRegistrant(oldRegNum) == null)  // Registrant does not exist
     	   System.out.println("Invalid registrant number.  Can't complete request.");
     	else {
     		int newRegNum = Integer.parseInt(getResponseTo("Enter new registrants number: "));
        	if (rc.findRegistrant(newRegNum) == null)  // Registrant does not exist
          	   System.out.println("Invalid registrant number.  Can't complete request.");
        	else {
     		   Property[] props = rc.listOfProperties(oldRegNum);
     		   for (Property prop: props)
     				  rc.changePropertyRegistrant(prop, newRegNum);
     		       System.out.println("Operation completed; the new registration number, " + newRegNum +
     			   ", has replaced the old registration number, " + oldRegNum + 
     			   ", in all affected properties.");
        	}
     	}
    }
        
    public static void viewAddNewProperty() {
    	int regNum = requestRegNum();
    	if (rc.findRegistrant(regNum) == null)  // Registrant does not exist
    	   System.out.println("Invalid registrant number");
    	else {  // Registrant exists
           Property prop = makeNewPropertyFromUserInput();	
    	   prop = new Property(prop, regNum);   	
    	   Property returnProp = rc.addNewProperty(prop); 
    	   if (returnProp == null) // registrant array is full
    		   System.out.println("New property could not be registered; registrant's array is full.");
    	   else if (prop.equals(returnProp))  // Registrant has been registered
    		   System.out.println("New property has been registered as: \n" + prop.toString());
    	   else  // Property already exists at that location
    		   System.out.println("New property could not be registered; \n" +
    		   "There is already a property registered at: \n" + returnProp.toString());   	   
    	}
    }
        
    public static void viewListPropertyByRegNum() { 
    	Property[] props = rc.listOfProperties(requestRegNum());
    	if (rc.getLastPropertyIndex() == 0) 
    		System.out.println("Property Registry empty; no properties to display\n");
    	else
    		for (Property prop: props)
    			System.out.println(prop.toString() + "\n");	   
    }
        
    private static void viewListAllProperties() {
    	Property[] props = rc.listOfAllProperties();
    	if (rc.getLastPropertyIndex() == 0) 
    		System.out.println("Property Registry empty; No properties to display");
    	else
    		for (Property prop: props)
    			System.out.println(prop.toString());
    }
    
    public RegControl getRegControl() {
    	return rc;
    }

}