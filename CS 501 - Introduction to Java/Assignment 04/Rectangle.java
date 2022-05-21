/*
 * CS501 - Introduction to Java Programming
 * Rectangle.java
 * Submitted by Chaitanya Pawar
 * */

/*
 * (The Rectangle class) Following the example of the Circle class in Section 9.2,
 * design a class named Rectangle to represent a rectangle. The class contains:
	* Two double data fields named width and height that specify the width and
		height of the rectangle. The default values are 1 for both width and height.
	* A no-arg constructor that creates a default rectangle.
	* A constructor that creates a rectangle with the specified width and height.
	* A method named getArea() that returns the area of this rectangle.
	* A method named getPerimeter() that returns the perimeter.
 * Draw the UML diagram for the class and then implement the class. Write a test
 * program that creates two Rectangle objects—one with width 4 and height 40
 * and the other with width 3.5 and height 35.9. Display the width, height, area,
 * and perimeter of each rectangle in this order.
*/

public class Rectangle {
	// Declaring Parameters
	private double width = 1.0;
	private double height = 1.0;
	private String errorMessage = "";

	// Default constructor
	public Rectangle() {
	}

	public Rectangle(double _width, double _height) throws Exception // Fully parameterized constructor (fpzc)
	{
		setWidth(_width);
		setHeight(_height);
	}

	//Get functions
	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	// Set functions
	public void setWidth(double _width) throws Exception {
		if (!isValidWidth(_width))
			throw new Exception(errorMessage);
		width = _width;
	}

	public void setHeight(double _height) throws Exception {
		if (!isValidHeight(_height))
			throw new Exception(errorMessage);
		height = _height;
	}

	// Applying Standard Methods from Object class
	public void print() {
		System.out.println("Rectangle:");
		System.out.println("----------");
		System.out.println("Width     = " + width);
		System.out.println("Height    = " + height);
		System.out.println("Area      = " + getArea());
		System.out.println("Perimeter = " + getPerimeter());
	}

	public String toString() {
		return "[Width = " + width + "; Height = " + height + "]";
	}

	public boolean equals(Object o) {
		// check for null parameter
		if (o == null)
			return false;

		// check for object type
		String s = o.getClass().getName(); // method to get class name
		if (!s.equals("Rectangle"))
			return false;

		// check for equivalent parameter values
		Rectangle b = (Rectangle) o; // cast unspecified object to
		// Rectangle object in order to be able
		// to use Rectangle get() functions
		if (width != b.getWidth())
			return false;
		if (height != b.getHeight())
			return false;

		return true;
	}

	// Checking whether method is valid or not
	public boolean isValidWidth(double _width) {
		if (_width > 0)
			return true;
		else {
			errorMessage = "Invalid Width Length: must be greater than 0";
			return false;
		}

	}

	public boolean isValidHeight(double _height) {
		if (_height > 0)
			return true;
		else {
			errorMessage = "Invalid Height Length: must be greater than 0";
			return false;
		}
	}

	// Implementing methods for calculations
	public double getArea() {
		return width * height;
	}

	public double getPerimeter() {
		return (2 * width) + (2 * height);
	}

}