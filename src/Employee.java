/*Name:	Aarsh Doshi
 *Student Number: 040988423
 *Course: CST8110
 *Semester: W20
 *Assignment 02
 *Due date: April 12, 2020, 11:59pm
 */


//This application will enable a small business owner to manage employees

public class Employee {

	//DECLARING VARIABLES
	private String name;
	private int number;
	private double salary;
	
	double annualTax;
	double weeklyPay;
	final double TAX1 = (0.15*48535);
	final double TAX2 = (0.205*48534);
	final double TAX3 = (0.26*53404);
	final double TAX4 = (0.29*63895);
	final double TAX5 = (0.33*214368);
	
	//DEFAULT CONSTRUCTOR (CHAINED)
	public Employee() {
		this("unknown", -1, 0.0);
	}
	
	//PARAMETERIZED CONSTRUCTOR
	public Employee(String name, int number, double salary) {
		this.name=name;
		this.number=number;
		this.setSalary(salary);
	}
	
	//GETTERS AND SETTERS FOR 3 VARIABLES
		public String getName() {
		return name;
		}

		private void setName(String name) {
		this.name = name;
		}

		public int getNumber() {
		return number;
		}

		private void setNumber(int number) {
		this.number = number;
		}

		public double getSalary() {
		return salary;
		}
		//setting salary to $52000 if entered negative input
		private void setSalary(double salary) {
		if(salary<0) {
		this.salary = 52000;
		}
		else {
		this.salary=salary;
		}
		}

		
	//ToSTRING METHOD
	@Override
	public String toString() {
		return String.format("Name: %s\nNumber: %d\nSalary: %.2f\n",this.name,this.number,this.salary);
	}
	
	//CALCULATE WEEKLY PAY METHOD TO CALCULATE EMPLOYEE'S WEEKLY PAY AFTER DEDUCTING TAXES
	public double calculateWeeklyPay() {
		if(salary > 214368) {
			annualTax=((salary-214368)*0.33) + TAX1 + TAX2 + TAX3 + TAX4;
			weeklyPay = (salary-annualTax)/52;
			return weeklyPay;
			}
			
		else if (salary>150473) {
			annualTax=((salary-150473)*0.29) + TAX1 + TAX2 + TAX3;
			weeklyPay = (salary-annualTax)/52;
			return weeklyPay;
		}
			
		else if (salary>97069) {
			annualTax=((salary-97069)*0.26) + TAX1 + TAX2;
			weeklyPay = (salary-annualTax)/52;
			return weeklyPay;
		}
			
		else if (salary>48535) {
			annualTax=(((salary-48535)*0.205) + TAX1);
			weeklyPay = (salary-annualTax)/52;
			return weeklyPay;
		}
			
		else {
			annualTax=(salary*0.15);
			weeklyPay = (salary-annualTax)/52;
			return weeklyPay;
		}	
	}
	
}//END OF EMPLOYEE CLASS
