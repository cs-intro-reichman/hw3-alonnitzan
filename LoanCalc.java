// Computes the periodical payment necessary to pay a given loan.
public class LoanCalc {
	
	static double epsilon = 0.001;  // Approximation accuracy
	static int iterationCounter;    // Number of iterations 
	
	// Gets the loan data and computes the periodical payment.
    // Expects to get three command-line arguments: loan amount (double),
    // interest rate (double, as a percentage), and number of payments (int).  
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

		// Computes the periodical payment using brute force search
		System.out.print("\nPeriodical payment, using brute force: ");
		System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("\nPeriodical payment, using bi-section search: ");
		System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);

	}

	// Computes the ending balance of a loan, given the loan amount, the periodical
	// interest rate (as a percentage), the number of periods (n), and the periodical payment.
	private static double endBalance(double loan, double rate, int n, double payment) {	
		

		rate = rate / 100;
		
		double endingBalanceOfLoan = loan; 
		
		for (int i = 0; i < n; i++) endingBalanceOfLoan = (endingBalanceOfLoan - payment) * (1 + rate);
		
		return endingBalanceOfLoan;
	}
	
	// Uses sequential search to compute an approximation of the periodical payment
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {

		iterationCounter = 0;

		double currentPayment = loan / n;
		
		while (endBalance(loan, rate, n, currentPayment) > 0){
			currentPayment += epsilon;
			iterationCounter += 1;
		}

		// if the current payment is negative
		if (endBalance(loan, rate, n, currentPayment) < 0) currentPayment -= epsilon;
		
		return currentPayment;
    }
    
    // Uses bisection search to compute an approximation of the periodical payment 
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
		iterationCounter = 0;

		double L = (loan / n), H = loan;
		double g = (L + H) / 2;

		while ((H - L) > epsilon) {
			
			if ((endBalance(loan, rate, n, L) * endBalance(loan, rate, n, g)) > 0) L = g;
			else H = g;

			g = (L + H) / 2;
			iterationCounter += 1;

		}
		
		return g;
    }
}