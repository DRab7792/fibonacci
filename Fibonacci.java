import java.util.Scanner;

/**
 * This class asks the user for an input number
 * and computes and prints its fibonacci number.
 * This class is capable of computing fibonacci both recursively
 * and iteratively. Also, this class can compute factorials recursively.
 * @author Dan Rabinowitz
 */
public class fibonacciFunctions {

	/**
	 * Compute the fibonacci number for the input value if the
	 * input is positive or zero. If the input is negative the
	 * function returns the <em>erroneous</em> value 1.
	 * The code uses a loop with the invariant:
	 * retVal = fibonacci(count-1)
	 * @param input positive or 0 value to compute fibonacci number
	 * @return the fibonacci number of the input
	 * The method fails by giving a negative value of -6246583658587674878
	 * at 93.
	 */
	public long fibonacci (int input) {
		long retVal = 0;
		long next = 1;
		int count = 1;
		while (count <= input){
			long temp = next;
			next = retVal + next;
			retVal = temp;
			count = count + 1; 
		}
		return retVal;
	}

	/**
	 * Compute the factorial of the input value if the
	 * input is positive or zero. If the input is negative the
	 * function returns the <em>erroneous</em> value 1.
	 * The code uses a loop with the invariant:
	 * retVal = (count-1)!
	 * @param input positive or 0 value to compute factorial
	 * @return the factorial of the input
	 */
	public long factorial(int input) {
		long retVal = 1;
		int count = 1;
		while (count <= input) {
			retVal *= count;
			count++;
		}
		return retVal;
	}
	/**
	 * This method computes Fibonacci numbers through recursion.
	 * @param input positive or 0 value to compute fibonacci
	 * @return the fibonacci of the input
	 */
	public long fibonacciRec(int input){
		return fibonacciRecAux(input,0,0,1);
	}
	
	private long fibonacciRecAux(int limit, int count, long fib, long nextFib) {
		long retVal = 0;
		if (count==limit){
			retVal = fib;
		}else if (count < limit){
			retVal = fibonacciRecAux(limit, count+1, nextFib, fib+nextFib);
		}
		return retVal;
	}

	public static void main(String[] args) {
		fibonacciFunctions testObject = new fibonacciFunctions();
		int k = 0;
		while(testObject.fibonacci(k) >= 0) {
			k++;
		}
		System.out.println("\n\nfirst value where fibonacci " +
				"appears negative = " + k);
		System.out.println("value calculated = " + 
				testObject.fibonacci(k));		
	}
} 