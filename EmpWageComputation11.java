public class CompanyEmpWage {
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
     }

     public void setTotalEmpWage(int totalEmpWage) {
             this.totalEmpWage=totalEmpWage;
     }

     @Override
     public String toString() {
             return "Total Emp Wage for company: " +company+ " is: " + totalEmpWage;
     }

	

}
public interface IComputeEmpWage {
        public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth);
        public void computeEmpWage();
}


import java.util.Random;

public class EmpWageComputation11 implements IComputeEmpWage {
        public static final int IS_FULL_TIME=1;
        public static final int IS_PART_TIME=2;

        private int numOfCompany=0;
        private CompanyEmpWage[] companyEmpWageArray;

        public EmpWageComputation11() {
                companyEmpWageArray = new CompanyEmpWage[5];
        }

        public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
                companyEmpWageArray[numOfCompany]=new CompanyEmpWage(company, empRatePerHour, numOfWorkingDays, maxHoursPerMonth);
                numOfCompany++;
        }

        public void computeEmpWage() {
                for(int i=0;i<numOfCompany;i++) {
                        companyEmpWageArray[i].setTotalEmpWage(this.computeEmpWage(companyEmpWageArray[i]));
                        System.out.println(companyEmpWageArray[i]);
                }
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
                EmpWageComputation11 empWage = new EmpWageComputation11();
                empWage.addCompanyEmpWage("DMart",20,2,10);
                empWage.addCompanyEmpWage("Reliance",10,4,20);
                empWage.computeEmpWage();
        }


}

