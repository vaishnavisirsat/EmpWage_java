public class EmpWageComputation9 
{
        //CONSTANTS
        public static final int IS_PART_TIME = 1;
        public static final int IS_FULL_TIME = 2;

        private final String company;
        private final int empRatePerHours;
        private final int numOfWorkingDays;
        private final int maxHoursPerMonth;
        private int totalEmpWage;

         public  EmpWageComputation9(String company, int empRatePerHours, int numOfWorkingDays,
                                        int maxHoursPerMonth){
                this.company = company;
                this.empRatePerHours = empRatePerHours;
                this. numOfWorkingDays =  numOfWorkingDays;
                this. maxHoursPerMonth =  maxHoursPerMonth;
		}
	public void computeEmpWage(){
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
			totalEmpWage = totalEmpHrs * empRatePerHours;
}

		@Override
		public String toString()
		{
			return "Total Emp Wage for company: "+company+" is: "+totalEmpWage;
		}
		public static void main(String args[]) 
		{
        	        //CREATING OBJECTS FOR COMPANY
                	EmpWageComputation9 dMart = new EmpWageComputation9( "dmart", 20, 2, 10 );
			 EmpWageComputation9 reliance = new EmpWageComputation9( "Reliance", 10, 4, 20 );
			dMart.computeEmpWage();
			System.out.println(dMart);
                	reliance.computeEmpWage();
			System.out.println(reliance);
		}

