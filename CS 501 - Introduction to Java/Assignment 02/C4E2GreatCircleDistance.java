/*
 * CS501 - Introduction to Java Programming
 * C4E2GreatCircleDistance.java
 * Submitted by Chaitanya Pawar
 * */

import java.util.Scanner;

public class C4E2GreatCircleDistance {

	public static void main(String[] args) {

		// Defining input variable to fetch user values
		Scanner inputVar = new Scanner(System.in);
		
		//Getting inputs from the user
		System.out.print("Enter point 1 (latitude and longitude) in degrees: ");

		double x1_Degree = inputVar.nextDouble();
		double y1_Degree = inputVar.nextDouble();

		System.out.print("Enter point 2 (latitude and longitude) in degrees: ");

		double x2_Degree = inputVar.nextDouble();
		double y2_Degree = inputVar.nextDouble();

		// Radius of earth referred from the question
		double radius = 6371.01;

		//Converting Degrees into Radians
		double x1 = Math.toRadians(x1_Degree);
		double y1 = Math.toRadians(y1_Degree);
		double x2 = Math.toRadians(x2_Degree);
		double y2 = Math.toRadians(y2_Degree);

		//Calculating Great circle distance from equation given in question
		double d = radius
				* Math.acos(Math.sin(x1) * Math.sin(x2) + Math.cos(x1) * Math.cos(x2) * Math.cos(y1 - y2));

		//Printing output in kilometers as per question
		System.out.println("The distance between the two points is " + d + " km");

		System.out.println("");
		System.out.println("End of program...");

		// Closing Scanner class to avoid memory leaks
		inputVar.close();

	}

}
