public class EmployeeCompute{
      	public static final int part_time = 1;
	public static final int full_time = 2;
	
	public static void main(String[] args){
		//constants
		int wage_per_hour = 20;
		//variables
		int hours_worked = 0;
		int emp_wage = 0;
		int emp_check = (int)Math.floor(Math.random()*10)%3;
		switch(emp_check){
			case part_time:
				hours_worked = 5;
				break;
			case full_time:
				hours_worked = 10;
				break;
			default:
				hours_worked = 0;
		}
		
		emp_wage = hours_worked * wage_per_hour;
		System.out.println("Daily emp wage is : " + emp_wage);
	
	}

}

