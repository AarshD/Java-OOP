/*Name:	Aarsh Doshi
 *Student Number: 040988423
 *Course: CST8110
 *Semester: W20
 *Assignment 02
 *Due date: April 12, 2020, 11:59pm
 */

import java.util.Scanner;

public class EmployeeDriver {
	
	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);						//GETTING KEYBOARD INPUT
		final int MAX_NUM_EMPLOYEES=5;								//DECLARING FINAL VARIABLE
		int userInput=0;											//DECLARING AND INSTANTIATING VARIABLE
		int currentNumberEmployees=0;
		
	Employee [] emp1 = new Employee [MAX_NUM_EMPLOYEES];			//DECLARING AN ARRAY OF EMPLOYEE REFERENCE AND INSTANTIATING USING FINAL VARIABLE
		emp1 [0] = new Employee("Thanh Do", 123, 185000.00);		// ARRAY ELEMENTS USING PARAMETERIZED CONSTRUCTOR
		emp1 [1] = new Employee("Jacklyn Jones", 174, 145000.00);
		emp1 [2] = new Employee("Rita Chan", 185, 72000.00);
		emp1 [3] = new Employee("Vikash Singh", 198, 300000.00);
	
		currentNumberEmployees=4;
		
	//SENTINEL CONTROLLED REPETITION STRUCTURE - WHILE LOOP
	while(userInput!=4) {
		
		System.out.println("\nMAKE A SELECTION: \n1. ADD EMPLOYEE \n2. DISPLAY EMPLOYEES \n3. DISPLAY PAYROLL \n4. QUIT");
		userInput=scan.nextInt();									//GETTING USER INPUT FROM KEYBOARD
		
		double total=0;
		
		
	//SELECTION CONTROLLED STRUCTURE - IF ELSE
			if(userInput==1) {										//CHOICE 1 - ADD EMPLOYEE
				if(currentNumberEmployees<MAX_NUM_EMPLOYEES) {
					
					scan.nextLine();
					System.out.print("Enter employee name: ");
					String name5 =scan.nextLine();
					
					System.out.print("Enter employee number: ");
					int number5 =scan.nextInt();
					
					System.out.print("Enter employee salary: ");
					double salary5 =scan.nextDouble();
				
					emp1 [currentNumberEmployees] = new Employee(name5,number5,salary5);
					currentNumberEmployees++;
					}
				else{
					System.out.println("Number of Employees is at the maximum. SORRY! YOU CAN'T ADD MORE EMPLOYEES\n");
					}
			}//END OF CHOICE 1
			
			
			
			if(userInput==2) {										//CHOICE 2 - DISPLAY EMPLOYEES
				
				System.out.println("CURRENT EMPLOYEES:");
				
				for (int j=0; j<currentNumberEmployees; j++) {		//COUNTER CONTROLLED STRUCTURE - FOR LOOP
					System.out.println(emp1[j]);
				}
				
			}//END OF CHOICE 2
			
			
			
			
			if(userInput==3) {										//CHOICE 3 - DISPLAY PAYROLL
				System.out.println("\nNAME OF EMPLOYEES AND WEEKLY PAYROLL");
				
				for (int k=0; k<currentNumberEmployees; k++) {		//COUNTER CONTROLLED STRUCTURE - FOR LOOP
					System.out.printf("\nName: "+ emp1[k].getName()+"\nPayroll: $%.2f\n", emp1[k].calculateWeeklyPay());
					total = total + emp1[k].calculateWeeklyPay();
				}
				
				System.out.printf("\nTOTAL WEEKLY PAYROLL: $%.2f\n\n", total);
			}// END OF CHOICE 3
			
			
			
			
			if(userInput==4) {										//CHOICE 4 - QUIT
				System.out.println("Goodbye");
			}//END OF CHOICE 4
			
			
		}// END OF WHILE LOOP
	
	scan.close();	
	}//END OF MAIN
}//END OF EMPLOYEE DRIVER CLASS
