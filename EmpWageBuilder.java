package com.capgemini.empwage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EmpWageBuilder implements IComputeEmpWaage {
	public static final int IS_PART_TIME =1;
	public static final int IS_FULL_TIME = 2;
	private ArrayList<CompanyEmpWage> companyEmpWageList;
	private Map<String,CompanyEmpWage> companyToEmpWageMap;


	public EmpWageBuilder(){
		companyEmpWageList = new ArrayList<>();
		companyToEmpWageMap = new HashMap<>();

	}
	public void addCompanyEmpWage(String company, int empRatePerHour,
			int numOfWorkingDays, int maxHoursPerMonth){
		CompanyEmpWage companyEmpWage = new CompanyEmpWage(company, empRatePerHour,
				numOfWorkingDays,maxHoursPerMonth);
		companyEmpWageList.add(companyEmpWage);
		companyToEmpWageMap.put(company, companyEmpWage);
	}

	public void computeEmpWage() {
		for (int i = 0; i < companyEmpWageList.size(); i++){
			companyEmpWageList.get(i).setTotalEmpWage(computeEmpWage(companyEmpWageList.get(i)));
			System.out.println(companyEmpWageList);
		}
	}
	@Override
	public int getTotalWage(String company) {
		return companyToEmpWageMap.get(company).totalEmpWage;
	}
	public int computeEmpWage(CompanyEmpWage companyEmpWage){

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
		IComputeEmpWaage empWageBuilder = new EmpWageBuilder();
		empWageBuilder.addCompanyEmpWage("BigBazar", 30, 4, 15);
		empWageBuilder.addCompanyEmpWage("StarBazar", 20, 2, 10);
		empWageBuilder.computeEmpWage();
		System.out.println("Total Wage for BigBazar Company:" + empWageBuilder.getTotalWage("BigBazar"));

	}
}


