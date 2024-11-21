// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
			
		if (x1 >= 0 && x2 >= 0){
			for (int i = 0; i < x2 ; i++) x1++;
			return x1;
		}
		else if (x1 >= 0 && x2 < 0){
			for (int i = 0; i < x1 ; i++) x2++;
			return x2;
		}
		else if (x2 >= 0 && x1 < 0){
			for (int i = 0; i < x2 ; i++) x1++;
			return x1;
		}
		else{
			for (int i = 0; i > x2 ; i--) x1--;
			return x1;
		}
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		if (x1 >= 0 && x2 >= 0){
			for (int i = 0; i < x2 ; i++) x1--;
			return x1;
		}
		else if (x1 >= 0 && x2 < 0){
			for (int i = 0; i > x2 ; i--) x1++;
			return x1;
		}
		else if (x2 >= 0 && x1 < 0){
			for (int i = 0; i > x1 ; i--) x2++;
			return x2;
		}
		else{
			for (int i = 0; i > x2 ; i--) x1++;
			return x1;
		}
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		
		int result = 0;
		
		if (x1 >= 0 && x2 >= 0){
			for (int i = 0; i < x2 ; i++) result = plus(result, x1);
			return result;
		}
		else if (x1 >= 0 && x2 < 0){
			for (int i = 0; i < x1 ; i++) result = plus(result, x2);
			return result;
		}
		else if (x2 >= 0 && x1 < 0){
			for (int i = 0; i < x2 ; i++) result = plus(result, x1);
			return result;
		}
		else{
			x1 = minus(0, x1);
			x2 = minus(0, x2);
			for (int i = 0; i < x2 ; i++) result = plus(result, x1);
			return result;
		}

	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int result = 1;
		
		for (int i = 0; i < n ; i++) result = times(result, x);
		return result;
		
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int counter = 0;
		int currentNumber = 0;
		
		boolean postiiveResult = false;

		
		// when x1 positive and x2 negative
		if (x1 >= 0 && x2 < 0){
			x2 = minus(0, x2);
			postiiveResult = false;
		}
			
		// when x1 negative and x2 positive
		else if (x2 >= 0 && x1 < 0){
			x1 = minus(0, x1);
			postiiveResult = false;
		}
		
		// when both negative
		else if (x2 < 0 && x1 < 0){
			x1 = minus(0, x1);
			x2 = minus(0, x2);
		}
		
		while (currentNumber < x1){
			counter ++;
			currentNumber = plus(currentNumber, x2);
		}
			
		if (currentNumber > x1) counter --;
		
		if (postiiveResult) counter = minus(0, counter);

		return counter;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {

		

		// when both positive
		if (x1 >= 0 && x2 >= 0){
			
		}
		// when x1 positive and x2 negative
		else if (x1 >= 0 && x2 < 0){
			
			
		}
		// when x1 negative and x2 positive
		else if (x2 >= 0 && x1 < 0){
			
			
		}
		// when both negative
		else{
			
		}

		int divider = div(x1, x2);
		if (times(divider, x2) == x1) return 0;
		else return x1 - times(divider, x2);
		
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int i = 0;
		int currentNumber = 0;
		
		int whenError = -11111;
		if (x < 0) return whenError;
		
		while (currentNumber < x){
			i++;
			currentNumber = pow(i, 2);
		}


		if (currentNumber == x) return i;
		else {
			i--;
			return i;
		}
	}	  	  
}