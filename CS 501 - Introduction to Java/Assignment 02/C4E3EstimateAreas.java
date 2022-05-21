/*
 * CS501 - Introduction to Java Programming
 * C4E3EstimateAreas.java
 * Submitted by Chaitanya Pawar
 * */

import java.util.Scanner;

public class C4E3EstimateAreas {

	public static void main(String[] args) {
		// Defining input variable to fetch user values
		Scanner inputVar = new Scanner(System.in);

		/*
		 * GPS locations according to (latitude, longitude)
		 * 1. Atlanta, Georgia = 33.7489953,-84.3879823 (x1,y1)
		 * 2. Orlando, Florida = 28.5383354,-81.37923649999998 (x2,y2)
		 * 3. Savannah, Georgia = 32.0835406,-81.09983419999997 (x3,y3)
		 * 4. Charlotte, North Carolina = 35.2270868,-80.84312669999996 (x4,y4)
		 */

		double x1 = Math.toRadians(33.7489953);
		double y1 = Math.toRadians(-84.3879823);
		double x2 = Math.toRadians(28.5383354);
		double y2 = Math.toRadians(-81.37923649999998);
		double x3 = Math.toRadians(32.0835406);
		double y3 = Math.toRadians(-81.09983419999997);
		double x4 = Math.toRadians(35.2270868);
		double y4 = Math.toRadians(-80.84312669999996);

		// Radius of earth referred from the question
		double radius = 6371.01;

		// distance between atlanta(x1, y1) and orlando(x2,y2)
		double area1 = radius
				* Math.acos(Math.sin(x1) * Math.sin(x2) + Math.cos(x1) * Math.cos(x2) * Math.cos(y1 - y2));
		System.out.println("The distance between Atlanta and Orlando is " + area1 + " km");

		// distance between orlando(x2,y2) and savannah(x3,y3)
		double area2 = radius
				* Math.acos(Math.sin(x2) * Math.sin(x3) + Math.cos(x2) * Math.cos(x3) * Math.cos(y2 - y3));
		System.out.println("The distance between Orlando and Savannah is " + area2 + " km");

		// distance between savannah(x3,y3) and charlotte(x4,y4)
		double area3 = radius
				* Math.acos(Math.sin(x3) * Math.sin(x4) + Math.cos(x3) * Math.cos(x4) * Math.cos(y3 - y4));
		System.out.println("The distance between Savannah and Charlotte is " + area3 + " km");

		// distance between charlotte(x4,y4) and atlanta(x1,y1)
		double area4 = radius
				* Math.acos(Math.sin(x4) * Math.sin(x1) + Math.cos(x4) * Math.cos(x1) * Math.cos(y4 - y1));
		System.out.println("The distance between Charlotte and Atlanta is " + area4 + " km");

		// distance between atlanta(x1,y1) and savannah(x3,y3)
		double area5 = radius
				* Math.acos(Math.sin(x1) * Math.sin(x3) + Math.cos(x1) * Math.cos(x3) * Math.cos(y1 - y3));

		// calculate area of traingle1 using cities atlanta, orlando and savannah
		double s1 = (area1 + area2 + area5) / 2;
		double totalArea1 = Math.sqrt(s1 * (s1 - area1) * (s1 - area2) * (s1 - area5));
		System.out.println("\nThe area covered by Atlanta, Orlando, Savannah is " + area1 + " km2");

		// calculate area of traingle2 using cities atlanta, savannah and charlotte
		double s2 = (area3 + area4 + area5) / 2;
		double totalArea2 = Math.sqrt(s2 * (s2 - area3) * (s2 - area4) * (s2 - area5));
		System.out.println("The area covered by Atlanta, Savannah and Charlotte is " + area2 + " km2");

		// Total estimated area covered by four cities
		double totalArea = totalArea1 + totalArea2;
		System.out.println("\nTotal estimated area covered by four cities is " + totalArea + " km2");

		System.out.println("");
		System.out.println("End of program...");

		// Closing Scanner class to avoid memory leaks
		inputVar.close();

	}

}
