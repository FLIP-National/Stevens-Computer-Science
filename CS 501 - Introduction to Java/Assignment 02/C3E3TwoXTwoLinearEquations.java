/*
 * CS501 - Introduction to Java Programming
 * C3E3TwoXTwoLinearEquations.java
 * Submitted by Chaitanya Pawar
 * */

import java.text.DecimalFormat;
import java.util.Scanner;

public class C3E3TwoXTwoLinearEquations {

	public static void main(String[] args) {
		// Getting input from the user
		Scanner inputVar = new Scanner(System.in);

		// Setting fractional digit limit to two
		DecimalFormat decf = new DecimalFormat();
		decf.setMaximumFractionDigits(2);

		System.out.println("Enter input variable for equestions ax + by = e and cx + dy = f");
		System.out.print("Enter values for a, b, c, d, e and f: ");
		double a = inputVar.nextDouble();
		double b = inputVar.nextDouble();
		double c = inputVar.nextDouble();
		double d = inputVar.nextDouble();
		double e = inputVar.nextDouble();
		double f = inputVar.nextDouble();

		if ((a * d - b * c) == 0) {
			System.out.println("The equation has no solution");
		} else {
			// Using Cramer's Rule to solve linear equations and find value for x and y
			double x = (e * d - b * f) / (a * d - b * c);

			double y = (a * f - e * c) / (a * d - b * c);

			System.out.println("Solution for x is " + decf.format(x) + " and y is " + decf.format(y));
		}

		System.out.println("");
		System.out.println("End of program...");

		// Closing Scanner class to avoid memory leaks
		inputVar.close();

	}

}
