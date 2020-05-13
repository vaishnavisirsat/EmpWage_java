class EmpWageComputation {
	public static void main(String args[]) {
		// CONSTANTS
		int IS_FULL_TIME = 1;
		//COMPUTATION
		int empCheck = (int) ( Math.random() * 10 ) % 2;
		System.out.println(empCheck);
		if ( empCheck == IS_FULL_TIME )
			System.out.println( "Emplyee is Present" );
		else
			System.out.println( "Employee is Absent" ); 
	}
}
