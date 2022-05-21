/*
 * CS501 - Introduction to Java Programming
 * GeometricObject.java
 * Submitted by Chaitanya Pawar
 * */

public abstract class GeometricObject {
  private String color = "white";
  private boolean filled = false;

  // Setting Constructors
  protected GeometricObject() {
  }

  protected GeometricObject(String color, boolean filled) {
    this.color = color;
    this.filled = filled;
  }

  // Setting getter
  public String getColor() {
    return color;
  }

  // Setting setter
  public void setColor(String color) {
    this.color = color;
  }

  public boolean isFilled() {
    return filled;
  }

  public void setFilled(boolean filled) {
    this.filled = filled;
  }

  public abstract double getArea();

  public abstract double getPerimeter();
}