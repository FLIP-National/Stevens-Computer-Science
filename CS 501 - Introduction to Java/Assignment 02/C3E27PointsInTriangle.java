/*
 * CS501 - Introduction to Java Programming
 * C3E27PointsInTriangle.java
 * Submitted by Chaitanya Pawar
 * */

import java.util.Scanner;

public class C3E27PointsInTriangle {

	public static void main(String[] args) {

		// Defining input variable to fetch user values
		Scanner inputVar = new Scanner(System.in);
		/*
		 * The right-angle point is placed at (0, 0), and the other two points are
		 * placed at (200, 0), and (0, 100) and line equation passing from (200, 0) and
		 * (0, 100)
		 * 
		 * The mathematical equation for above requirements can be x + 2y = 200
		 */

		// Getting inputs from user
		System.out.print("Enter a point’s x- and y-coordinates: ");
		double x1 = inputVar.nextDouble();
		double y1 = inputVar.nextDouble();

		// Putting values of x and y in x + 2y
		double cal = x1 + 2 * y1;

		// Checking whether point is on right side of y-axis
		if (x1 > 0) {
			// Checking whether point is above x-axis
			if (y1 > 0) {
				// Checking whether point is inside the triangle
				if (cal < 200) {
					System.out.println("The point is in the triangle");
				} else {
					System.out.println("The point is not in the triangle");
				}
			} else {
				System.out.println("The point is not in the triangle");
			}
		} else {
			System.out.println("The point is not in the triangle");
		}
		
		System.out.println("");
		System.out.println("End of program...");

		// Closing Scanner class to avoid memory leaks
		inputVar.close();
	}

}
