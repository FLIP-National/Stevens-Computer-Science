/*
 * CS501 - Introduction to Java Programming
 * MyRectangle2D.java
 * Submitted by Chaitanya Pawar
 * */

public class MyRectangle2D extends Rectangle {

    // Declaring Parameters
    private MyPoint center = new MyPoint();

    // Setting Constructors
    public MyRectangle2D() {
    }

    public MyRectangle2D(double w, double height, double x, double y) throws Exception {
        setWidth(w);
        setHeight(height);
        center = new MyPoint(x, y);
    }

    // Setting getters
    public MyPoint getTopLeft() {
        return new MyPoint(center.getX() - getWidth() / 2, center.getY() + getHeight() / 2);
    }

    public MyPoint getBottomRight() {
        return new MyPoint(center.getX() + getWidth() / 2, center.getY() - getHeight() / 2);
    }

    public MyPoint getCenter() {
        return center;
    }

    // Setting setters
    public void setCenter(double x, double y) {
        center = new MyPoint(x, y);
    }

    public boolean contains(double x, double y) {
        // Testing if point is in rectangle
        if (x <= center.getX() + getWidth() / 2 &&
                x >= center.getX() - getWidth() / 2 &&
                y <= center.getY() + getHeight() / 2 &&
                y >= center.getY() - getHeight() / 2) {
            return true;
        }
        return false;
    }

    public boolean contains(MyRectangle2D other) {
        if (other.getCenter().getX() + other.getWidth() / 2 < center.getX() + getWidth() / 2 &&
                other.getCenter().getX() - other.getWidth() / 2 > center.getX() - getWidth() / 2 &&
                other.getCenter().getY() + other.getHeight() / 2 < center.getY() + getHeight() / 2 &&
                other.getCenter().getY() - other.getHeight() / 2 > center.getY() - getHeight() / 2) {
            return true;
        }
        return false;
    }

    public boolean overlaps(MyRectangle2D other) {
        // Hold coordinates for the Top Left and Bottom Right corners of each Rectangle
        MyPoint thisTLeft = getTopLeft();
        MyPoint thisBRight = getBottomRight();
        MyPoint otherTLeft = other.getTopLeft();
        MyPoint otherBRight = other.getBottomRight();

        if (thisTLeft.getX() >= otherBRight.getX() || otherTLeft.getX() >= thisBRight.getX()) {
            return false;
        }
        if (thisTLeft.getY() <= otherBRight.getY() || otherTLeft.getY() <= thisBRight.getY()) {
            return false;
        }
        return true;
    }

    // Check if Both rectangles share only a border
    public boolean abut(MyRectangle2D other) {
        MyPoint thisTLeft = getTopLeft();
        MyPoint thisBRight = getBottomRight();
        MyPoint otherTLeft = other.getTopLeft();
        MyPoint otherBRight = other.getBottomRight();

        // Left side of THIS against right side of OTHER
        if (thisTLeft.getX() == otherBRight.getX() &&
                ((thisTLeft.getY() <= otherTLeft.getY() && thisTLeft.getY() >= otherBRight.getY()) ||
                        (thisBRight.getY() <= otherTLeft.getY() && thisBRight.getY() >= otherBRight.getY()) ||
                        (thisTLeft.getY() >= otherTLeft.getY() && thisBRight.getY() <= otherBRight.getY()))) {
            return true;
        }

        // Right side of THIS against left side of OTHER
        if (thisBRight.getX() == otherTLeft.getX() &&
                ((thisTLeft.getY() <= otherTLeft.getY() && thisTLeft.getY() >= otherBRight.getY()) ||
                        (thisBRight.getY() <= otherTLeft.getY() && thisBRight.getY() >= otherBRight.getY()) ||
                        (thisTLeft.getY() >= otherTLeft.getY() && thisBRight.getY() <= otherBRight.getY()))) {
            return true;
        }

        // Top of THIS against bottom of OTHER
        if (thisTLeft.getY() == otherBRight.getY() &&
                ((thisTLeft.getX() >= otherTLeft.getX() && thisTLeft.getX() <= otherBRight.getX()) ||
                        (thisBRight.getX() >= otherTLeft.getX() && thisBRight.getX() <= otherBRight.getX()) ||
                        (thisTLeft.getX() <= otherTLeft.getX() && thisBRight.getX() >= otherBRight.getX()))) {
            return true;
        }

        // Bottom of THIS against top of OTHER
        if (thisBRight.getY() == otherTLeft.getY() &&
                ((thisTLeft.getX() >= otherTLeft.getX() && thisTLeft.getX() <= otherBRight.getX()) ||
                        (thisBRight.getX() >= otherTLeft.getX() && thisBRight.getX() <= otherBRight.getX()) ||
                        (thisTLeft.getX() <= otherTLeft.getX() && thisBRight.getX() >= otherBRight.getX()))) {
            return true;
        }

        return false;
    }

    // Returns true if two rectangles do not overlap or are abut
    public boolean distinct(MyRectangle2D other) {
        return (!overlaps(other) && !abut(other));
    }

    public void print() {
        System.out.println("Width     = " + getWidth());
        System.out.println("Height    = " + getHeight());
        System.out.println("Center	  = " + center.toString());
        System.out.println("Area      = " + getArea());
        System.out.println("Perimeter = " + getPerimeter());
    }

    public String toString() {
        return "[Width = " + getWidth() + " : Height = " + getHeight()
                + " : Center = " + center.toString() + " : Area = " + getArea()
                + " : Perimeter = " + getPerimeter() + "]";
    }

}