/*
 * CS501 - Introduction to Java Programming
 * Rectangle.java
 * Submitted by Chaitanya Pawar
 * */

public class Rectangle {
	// Declaring Parameters
	private double w = 1.0;
	private double h = 1.0;
	private String errorMessage = "";

	// Setting Constructors
	public Rectangle() {
	}

	public Rectangle(double _w, double _h) throws Exception {
		setWidth(_w);
		setHeight(_h);
	}

	// Setting getters
	public double getWidth() {
		return w;
	}

	public double getHeight() {
		return h;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	// Setting setters
	public void setWidth(double _w) throws Exception {
		if (!isValidWidth(_w)) {
			throw new Exception(errorMessage);
		}
		w = _w;
	}

	public void setHeight(double _h) throws Exception {
		if (!isValidHeight(_h)) {
			throw new Exception(errorMessage);
		}
		h = _h;
	}

	public void print() {
		System.out.println("Width     = " + w);
		System.out.println("Height    = " + h);
		System.out.println("Area      = " + getArea());
		System.out.println("Perimeter = " + getPerimeter());
	}

	public String toString() {
		return "[Width = " + w + "; Height = " + h + "]";
	}

	public boolean equals(Object obj) {
		// Checking for null parameters
		if (obj == null) {
			return false;
		}

		// Checking for object types
		String s = obj.getClass().getName();
		if (!s.equals("Rectangle")) {
			return false;
		}

		// Checking for equivalent parameter values
		Rectangle b = (Rectangle) obj;
		if (w != b.getWidth()) {
			return false;
		}
		if (h != b.getHeight()) {
			return false;
		}
		return true;
	}

	// Checking validity of rectangle
	public boolean isValidWidth(double _w) {
		if (_w > 0) {
			return true;
		} else {
			errorMessage = "Invalid Width Length must be greater than 0";
			return false;
		}

	}

	public boolean isValidHeight(double _h) {
		if (_h > 0) {
			return true;
		} else {
			errorMessage = "Invalid Height Length must be greater than 0";
			return false;
		}
	}

	// Getting Area of rectangle
	public double getArea() {
		return w * h;
	}

	public double getPerimeter() {
		return (2 * w) + (2 * h);
	}

}