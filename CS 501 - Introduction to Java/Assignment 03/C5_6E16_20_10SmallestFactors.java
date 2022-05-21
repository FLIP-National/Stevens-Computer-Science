/*
 * CS501 - Introduction to Java Programming
 * C5_6E16_20_10SmallestFactors.java
 * Submitted by Chaitanya Pawar
 * */

/*
5.16:
	Find the factors of an integer) Write a program that reads an integer and displays
	all its smallest factors in increasing order. For example, if the input integer is
	120, the output should be as follows: 2, 2, 2, 3, 5.

5.20:
	(Display prime numbers between 2 and 1,000) Modify the program given in Listing 5.15 
	to display all the prime numbers between 2 and 1,000, inclusive. Display eight prime 
	numbers per line. Numbers are separated by exactly one space.

6.10:
	(Use the isPrime Method) Listing 6.7, PrimeNumberMethod.java, provides the
	isPrime(int number) method for testing whether a number is prime. Use this
	method to find the number of prime numbers less than 1000.
 */

import java.util.Scanner;

public class C5_6E16_20_10SmallestFactors {

	// Check whether number is prime
	public static boolean isPrime(int number) {
		if (number == 1) {
			return false;
		}
		for (int divisor = 2; divisor <= number / 2; divisor++) {
			if (number % divisor == 0)
				// If false, number is not prime
				return false;
		}
		// If true, number is prime
		return true;
	}
	
	/*
	 * To satisfy Q6.10 isPrime() function is defined above and used in the code
	 * rather than a separate file to avoid errors.
	 */

	// Print prime numbers for given range in question
	public static int countPrimes(int first, int last) {
		int count = 0;
		for (int i = first; i <= last; i++)
			if (isPrime(i)) {
				// Increment count when a prime is found
				count++;
			}
		return count;
	}

	// Store primes in a given range in an array
	public static void storePrimes(int first, int last, int[] a) {
		int i = 0;
		while (first <= last && i < a.length) // Store the range from first to last, don't go over arrays size
		{
			if (isPrime(first))
				a[i++] = first; // Set current element to the prime number, then increment i to point to next
								// element
			first++;
		}
	}

	/** Display a given number of elements in an array */
	public static void displayElements(int numElements, int[] a) {
		if (numElements > a.length) {
			numElements = a.length;
		} // Make sure program does not try to print more elements than the array contains
		System.out.print("First " + numElements + " Primes are printed below:");
		for (int i = 0; i < numElements; i++) {
			if (i % 10 == 0) {
				System.out.print('\n');
			} // New line every 10 elements
			System.out.print(a[i] + "\t");
		}
	}

	/** Search for a number in array sorted in ascending order */
	public static boolean binarySearch(int[] list, int key) {
		int low = 0;
		int high = list.length - 1;
		while (high >= low) {
			int mid = (low + high) / 2;
			if (key < list[mid])
				high = mid - 1;
			else if (key > list[mid])
				low = mid + 1;
			else
				return true;
		}
		return false; // Not found
	}

	/** Recursive function to display the prime factors of the given number */
	public static void displayPrimeFactors(int number) {
		if (number == 1)
			return;
		for (int i = 2; i <= number; i++) {
			if (number % i == 0) {
				System.out.print(i + "\t");
				displayPrimeFactors(number / i);
				return;
			}
		}
	}

	public static void main(String[] args) {
		Scanner inputVar = new Scanner(System.in);

		//Program Description for easy understanding as multiple questions are implemented in single file
		System.out.println("This program allows you check numbers between 1 to 1000 whether it is a prime number.");
		System.out.println("");
		System.out.println("If your number is not prime, the program will display its prime factors in ascending order");
		System.out.println("");
		int repeat = 1; // Variable to check if user wants to go again
		int searchValue; // Holds the number the user wants to check
		int numPrimes = countPrimes(1, 1000); // Holds the total no. of prime numbers in the range of 1 to 1000 inclusively
		int[] primes = new int[numPrimes]; // Array to prime numbers between 1 and 1000, sized to fit exact amount

		// Insert primes into array and display the first 50 elements
		storePrimes(1, 1000, primes);
		displayElements(50, primes);
		System.out.println("");
		while (repeat != 0) {
			// Prompt user input
			System.out.println("");
			System.out.print("Enter a number between 1 and 1000 to check if it is prime: ");
			searchValue = inputVar.nextInt();

			// Validate input and act accordingly
			if (searchValue > 1000 || searchValue < 0)
				System.out.println("Input out of range. Must be a number between 1 and 1000 inclusively.");
			else if (binarySearch(primes, searchValue))
				System.out.println("Congrats! " + searchValue + " is a prime number!");
			else {
				System.out.println("Sorry, " + searchValue + " is NOT a prime number! Here are its prime factors:");
				displayPrimeFactors(searchValue);
				System.out.println("");
			}

			// Prompt user input for another search
			System.out.print("Want to try again? enter \'0\' to stop else enter any other number: ");
			repeat = inputVar.nextInt();
			if(repeat == 0) {
				System.out.println("Thank you.");
				System.out.println("End of Program...");
			}
		}
		//Closing scanner class to avoid memory leaks
		inputVar.close();
	}

}
