/*
 * CS501 - Introduction to Java Programming
 * C11E1TriangleClass.java
 * Submitted by Chaitanya Pawar
 * */

import java.util.Scanner;

public class C11E1TriangleClass {

	public static void main(String[] args) {
		Scanner inputVar = new Scanner(System.in);

		// Declaring parameters
		double s1, s2, s3;
		String color; 
		boolean isfilled;
		int filledInt;
		int repeat = 1; // To allow user to continue testing
		Triangle tri = new Triangle();

		// Program description
		System.out.println("The following program allows you to test the 'Triangle' "
				+ "class which extend 'GeometricObjects'. ");
		System.out.println("You will enter values for each side length, color and "
				+ "whether or not to fill the triangle\n"
				+ "The program then displays perimeter and area of your Triangle object");

		while (repeat != 0) {
			// Prompt user input
			System.out.print("\nEnter side1 length: ");
			s1 = inputVar.nextDouble();
			System.out.print("Enter side2 length: ");
			s2 = inputVar.nextDouble();
			System.out.print("Enter side3 length: ");
			s3 = inputVar.nextDouble();
			System.out.print("Enter color: ");
			color = inputVar.next();
			System.out.print("Enter '1' to set as filled (any other integer to not fill): ");
			filledInt = inputVar.nextInt();
			isfilled = (filledInt == 1); // Sets filled to true if user entered a 1

			// Testing for valid input by user
			try {
				tri = new Triangle(s1, s2, s3, color, isfilled);
				System.out.println("\nYour Triangle(toString): " + tri.toString() + "\n");
				tri.print();
				System.out.print("\nEnter 0 to exit or any other number to test another Triangle: ");
				repeat = inputVar.nextInt();
			} catch (IllegalTriangleException e) {
				System.out.println("Test failed..." + e + "\nPlease try again");
			}
		}
		inputVar.close();
	}

}
