public class EmpWageComputation8 {
        //CONSTANTS
        public static final int IS_PART_TIME = 1;
        public static final int IS_FULL_TIME = 2;

         public static int computeEmpWage(String company, int empRatePerHours, int numOfWorkingDays,
                                        int maxHoursPerMonth){
                //VARIABLES
                int empHrs = 0, totalEmpHrs = 0, totalWorkingDays = 0;
                //COMPUTATION
                while ( totalEmpHrs <=  maxHoursPerMonth && totalWorkingDays < numOfWorkingDays )
                {
                        totalWorkingDays++;
                        int empCheck = (int) Math.floor( Math.random() * 10 ) % 3;
                        switch (empCheck)
                        {
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
                        System.out.println("Day#: " + totalWorkingDays + " Emp Hr: " +  empHrs);
                }
                int totalEmpWage = totalEmpHrs * empRatePerHours;
                System.out.println("Total Emp Wage for company: "+company+" is:" + totalEmpWage);
                return totalEmpWage;
        }
        public static void main(String[] args){
        computeEmpWage("DMart",20,2,10);
        computeEmpWage("Reliance",10,4,20);
        }
}
