public class EmpWageBuilderObject{
      	
	        public static final int IS_PART_TIME =1;
		public static final int IS_FULL_TIME = 2;
                private final String company;
                private final int empRatePerHour;
                private final int numOfWorkingDays;
                private final int maxHoursPerMonth;
                private int totalEmpWage;

		public EmpWageBuilderObject(String company, int empRatePerHour,
                                                int numOfWorkingDays, int maxHoursPerMonth) {
		this.company = company;
                this.empRatePerHour = empRatePerHour;
                this.numOfWorkingDays = numOfWorkingDays;
                this.maxHoursPerMonth = maxHoursPerMonth;
                }
                public void computeEmpWage(){

                // Variables
		int empHrs = 0;
		int totalEmpHrs = 0;
		int totalWorkingDays = 0;
		// Computation
		while (totalEmpHrs <= maxHoursPerMonth && totalWorkingDays < numOfWorkingDays) {
		totalWorkingDays++;
		int empCheck = (int) Math.floor (Math.random() * 10) % 3;
		switch (empCheck) {
		case IS_PART_TIME:
			empHrs = 4;
			break;
		case IS_FULL_TIME:
			empHrs = 8;
			break;
		default:
		empHrs = 0;
		}
		totalEmpHrs += empHrs;
		System.out.println("Day#:"+ totalWorkingDays + " Emp Hr:"+ empHrs);
              }
		int totalEmpwage = totalEmpHrs * empRatePerHour;
                 
 	}
        @Override
        public String toString() {
            return "Total Emp Wage for company:"+company+" is: "+ totalEmpWage;
      }                
        public static void main(String[] args) {
            EmpWageBuilderObject bigbazar = new EmpWageBuilderObject ("Bigbazar" , 30, 3, 15);
            EmpWageBuilderObject starbazar = new EmpWageBuilderObject ("Starbazar" , 10, 4, 20);
            bigbazar.computeEmpWage();
            System.out.println(bigbazar);
            starbazar.computeEmpWage();
            System.out.println(starbazar);

}
}