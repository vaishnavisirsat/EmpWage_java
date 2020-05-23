import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

interface IComputeEmpWage{
	public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth);
	public void computeEmpWage();
	public int getTotalWage(String company);
}

class CompanyEmpWage{
	
	public final String company;
	public final int empRatePerHour;
	public final int numOfWorkingDays;
	public final int maxHoursPerMonth;
	public int totalEmpWage;
	
	public CompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
		this.company=company;
		this.empRatePerHour=empRatePerHour;
		this.numOfWorkingDays=numOfWorkingDays;
		this.maxHoursPerMonth=maxHoursPerMonth;
		totalEmpWage =0;
	}
	
	public void setTotalEmpWage(int totalEmpWage) {
		this.totalEmpWage=totalEmpWage;
	}
	
	@Override
	public String toString() {
		return "Total Emp Wage for company: " +company+ " is: " + totalEmpWage;
	}
}

public class EmpWageComputation14 implements IComputeEmpWage {
	public static final int IS_FULL_TIME=1;
	public static final int IS_PART_TIME=2;
	
	private int numOfCompany=0;
	private ArrayList<CompanyEmpWage> companyEmpWageArrayList;
	private Map<String,CompanyEmpWage> companyToEmpWageMap;
	
	public EmpWageComputation14() {
		companyEmpWageArrayList = new ArrayList<>();
		companyToEmpWageMap = new HashMap<>();
	}
	
	public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
		CompanyEmpWage companyEmpWage=new CompanyEmpWage(company, empRatePerHour, numOfWorkingDays, maxHoursPerMonth);
		companyEmpWageArrayList.add(companyEmpWage);
		companyToEmpWageMap.put(company, companyEmpWage);
	}
	
	public void computeEmpWage() {
		for(int i=0;i<companyEmpWageArrayList.size();i++) {
			CompanyEmpWage companyEmpWage = companyEmpWageArrayList.get(i);
			companyEmpWage.setTotalEmpWage(this.computeEmpWage(companyEmpWage));
			System.out.println(companyEmpWage);
		}
	}
	
	public int getTotalWage(String company) {
		return companyToEmpWageMap.get(company).totalEmpWage;
	}
	
	private int computeEmpWage(CompanyEmpWage companyEmpWage) {
		int empHrs=0, totalEmpHrs=0, totalWorkingDays=0;
		Random rand = new Random();
		while(totalEmpHrs <= companyEmpWage.maxHoursPerMonth && totalWorkingDays < companyEmpWage.numOfWorkingDays)
		{
			int empCheck=rand.nextInt(3);
			totalWorkingDays++;
			switch (empCheck) {
			case IS_FULL_TIME:
				empHrs=8;
				break;
			case IS_PART_TIME:
				empHrs=4;
				break;
			default:
				empHrs=0;	
			}
			totalEmpHrs += empHrs;
			System.out.println("Day#: " + totalWorkingDays + " Emp Hr: " +empHrs);
		}
		return totalEmpHrs * companyEmpWage.empRatePerHour;
	}
	

	public static void main(String[] args) {
		EmpWageComputation14 empWage = new EmpWageComputation14();
		empWage.addCompanyEmpWage("DMart",20,2,10);
		empWage.addCompanyEmpWage("Reliance",10,4,20);
		empWage.computeEmpWage();
		System.out.println("Total wage for DMart company: " +empWage.getTotalWage("Reliance"));
	}
}	
