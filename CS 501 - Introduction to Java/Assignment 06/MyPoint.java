/*
 * CS501 - Introduction to Java Programming
 * MyPoint.java
 * Submitted by Chaitanya Pawar
 * */

public class MyPoint {
	// Declaring Parameters
	private double x = 0.0;
	private double y = 0.0;
	private String errorMessage = "";

	// Setting Constructors
	public MyPoint() {
	}

	public MyPoint(double _x, double _y) {
		x = _x;
		y = _y;
	}

	// Setting getters and setters
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setX(double _x) {
		x = _x;
	}

	public void setY(double _y) {
		y = _y;
	}

	public void print() {
		System.out.print("(" + x + ", " + y + ")");
	}

	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	public boolean equals(Object obj) {

		// Checking for null parameters
		if (obj == null) {
			return false;
		}

		// Checking for object types
		String s = obj.getClass().getName();
		if (!s.equals("MyPoint")) {
			return false;
		}

		// check for equivalent parameter values
		MyPoint b = (MyPoint) obj;
		if (x != b.getX()) {
			return false;
		}
		if (y != b.getY()) {
			return false;
		}

		return true;
	}

	public double distance(MyPoint point) {
		// Sum of the squared differences
		double distance = Math.pow((point.getX() - x), 2) + Math.pow((point.getY() - y), 2);
		// Square root of the sum of squared differences
		return Math.pow(distance, 0.5);
	}

	public double distance(double _x, double _y) {
		// Sum of the squared differences
		double distance = Math.pow((_x - x), 2) + Math.pow((_y - y), 2);
		// Square root of the sum of squared differences
		return Math.pow(distance, 0.5);
	}

}
