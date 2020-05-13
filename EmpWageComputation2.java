class EmpWageComputation2 {

	public static void main(String args[]) {
		// CONSTANTS
		int IS_FULL_TIME = 1;
		int EMP_RATE_PER_HOUR = 20;
		//VARIABLES
		int empHrs = 0;
		int empWage = 0;
		//COMPUTATION
		int empCheck = (int) ( Math.random() * 10 ) % 2;
		if ( empCheck == IS_FULL_TIME )

			empHrs = 8;
		else 
			empHrs = 0;
		empWage = empHrs * EMP_RATE_PER_HOUR;
		System.out.println("Employee Wage: " + empWage);
	}
}
