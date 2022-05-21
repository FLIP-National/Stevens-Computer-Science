/*
 * CS501 - Introduction to Java Programming
 * IllegalTriangleException.java
 * Submitted by Chaitanya Pawar
 * */

public class IllegalTriangleException extends Exception {
	private double s1, s2, s3;

	/** Construct an exception */
	public IllegalTriangleException(double s1, double s2, double s3) {
		super("Invalid side lengths: " + s1 + ", " + s2 + ", " + s3
				+ "\n - The sum of any two sides must be greater than 0"
				+ "\n - All lengths must be greater than 0");
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
	}

	/** Return the side lengths */
	public double getSide1() {
		return s1;
	}

	public double getSide2() {
		return s2;
	}

	public double getSide3() {
		return s3;
	}
}