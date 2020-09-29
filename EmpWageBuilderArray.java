package EmpWage;

public class EmpWageBuilderArray {
	public static final int IS_PART_TIME =1;
	public static final int IS_FULL_TIME = 2;
            private int numOfCompany = 0;
            private CompanyEmpWage[] comapanyEmpWageArray;

            public EmpWageBuilderArray(){
               comapanyEmpWageArray = new CompanyEmpWage[5];
            }
            private void addCompanyEmpWage(String company, int empRatePerHour,
                                  int numOfWorkingDays, int maxHoursPerMonth){
                comapanyEmpWageArray[numOfCompany] = new CompanyEmpWage(company, empRatePerHour,
                                                                       numOfWorkingDays,maxHoursPerMonth);
                numOfCompany++;
            }

            private void computeEmpWage() {
                for (int i = 0; i < numOfCompany; i++){
                     comapanyEmpWageArray[i].setTotalEmpWage(this.computeEmpWage(comapanyEmpWageArray[i]));
                     System.out.println(comapanyEmpWageArray[i]);
                }
            }
            private int computeEmpWage(CompanyEmpWage companyEmpWage){

            // Variables
	int empHrs = 0;
	int totalEmpHrs = 0;
	int totalWorkingDays = 0;
	// Computation
	while (totalEmpHrs <= companyEmpWage.maxHoursPerMonth && totalWorkingDays <companyEmpWage.numOfWorkingDays) {
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
          return totalEmpHrs * companyEmpWage.empRatePerHour;
        }
       public static void main (String[] args) {
             EmpWageBuilderArray empWageBuilder = new EmpWageBuilderArray();
             empWageBuilder.addCompanyEmpWage("BigBazar", 30, 4, 15);
             empWageBuilder.addCompanyEmpWage("StarBazar", 20, 2, 10);
             empWageBuilder.computeEmpWage();
        }
    }


