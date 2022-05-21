/*
 * CS501 - Introduction to Java Programming
 * Triangle.java
 * Submitted by Chaitanya Pawar
 * */

public class Triangle extends GeometricObject {
	// Declaring Parameters
	private double s1, s2, s3;
	private String errorMessage = "";

	// Setting Constructors
	Triangle() {
		s1 = s2 = s3 = 1.0;
	}

	// Checking if sides of triangle is valid
	Triangle(double s1, double s2, double s3) throws IllegalTriangleException {
		if (!isValidTriangle(s1, s2, s3))
			throw new IllegalTriangleException(s1, s2, s3);
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
	}

	Triangle(double s1, double s2, double s3, String color, boolean filled) throws IllegalTriangleException {
		if (!isValidTriangle(s1, s2, s3))
			throw new IllegalTriangleException(s1, s2, s3);
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
		setColor(color);
		setFilled(filled);
	}

	// Setting getters
	public double getSide1() {
		return s1;
	}

	public double getSide2() {
		return s2;
	}

	public double getSide3() {
		return s3;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	// Setting setters
	public void setSide1(double s1) throws IllegalTriangleException {
		if (!isValidTriangle(s1, s2, s3))
			throw new IllegalTriangleException(s1, s2, s3);
		this.s1 = s1;
	}

	public void setSide2(double s2) throws IllegalTriangleException {
		if (!isValidTriangle(s1, s2, s3))
			throw new IllegalTriangleException(s1, s2, s3);
		this.s2 = s2;
	}

	public void setSide3(double s3) throws IllegalTriangleException {
		if (!isValidTriangle(s1, s2, s3))
			throw new IllegalTriangleException(s1, s2, s3);
		this.s3 = s3;
	}

	// Checking validity of triangle
	public boolean isValidTriangle(double s1, double s2, double s3) {
		if (s1 + s2 > s3 && s2 + s3 > s1 && s1 + s3 > s2)
			return true;
		else {
			errorMessage = "Invalid Input: Side lengths must be greater than zero and "
					+ "\nthe sum of any two sides must be greater than the third";
			return false;
		}
	}

	// Getting Area of triangle
	public double getArea() {
		double sSum = (s1 + s2 + s3) / 2;
		double area = sSum;
		area *= (sSum - s1) * (sSum - s2) * (sSum - s3);
		area = Math.pow(area, 0.5);
		return area;
	}

	// Getting perimeter of triangle
	public double getPerimeter() {
		return s1 + s2 + s3;
	}

	public void print() {
		System.out.println("Triangle:");
		System.out.println("---------");
		System.out.println("Side 1     = " + s1);
		System.out.println("Side 2     = " + s2);
		System.out.println("Side 3     = " + s3);
		System.out.println("Color      = " + getColor());
		System.out.println("Filled     = " + isFilled());
		System.out.println("Area       = " + getArea());
		System.out.println("Perimeter  = " + getPerimeter());
	}

	public String toString() {
		return "[Side1 = " + s1 + " : Side2 = " + s2 + " : Side3 = " + s3 + "]";
	}

	public boolean equals(Object obj) {
		// Checking for null parameters
		if (obj == null) {
			return false;
		}

		// Checking for object types
		String s = obj.getClass().getName();
		if (!s.equals("Triangle")) {
			return false;
		}

		// Checking for equivalent parameter values
		Triangle b = (Triangle) obj;
		if (s1 != b.getSide1()) {
			return false;
		}
		if (s2 != b.getSide2()) {
			return false;
		}
		if (s3 != b.getSide3()) {
			return false;
		}
		return true;
	}
}
