package EmpWage;

public interface IComputeEmpWaage {
	public void addCompanyEmpWage(String company, int empRatePerHour,
            int numOfWorkingDays, int maxHoursPerMonth);
	public void computeEmpWage();

}
