/*
 * CS501 - Introduction to Java Programming
 * C10E13MyRectangle2D.java
 * Submitted by Chaitanya Pawar
 */

import java.util.Scanner;

public class C10E13MyRectangle2D {
    public static void main(String[] args) {
        Scanner inputVar = new Scanner(System.in);

        // Declaring variables
        double w, h;
        double x, y;
        int outL = 2, inL = 1;
        MyRectangle2D outRect = new MyRectangle2D(); // First Rectangle object for testing
        MyRectangle2D inRect = new MyRectangle2D(); // Second Rectangle object for testing

        // Program description
        System.out.println(
                "You may use this software to define two rectangles based on their width, height, and center coordinate.");
        System.out.println("Then you're told if they're distinct, abut, overlap, or contain one another.");

        while (outL != 0) {
            inL = 1; // Reset so that the loop for Rectangle 2 can run

            // Prompt user input
            System.out.println("\nRectangle 1");
            System.out.print("Enter center point (x,y): ");
            x = inputVar.nextDouble();
            y = inputVar.nextDouble();
            System.out.print("Enter width: ");
            w = inputVar.nextDouble();
            System.out.print("Enter height: ");
            h = inputVar.nextDouble();

            try {
                outRect = new MyRectangle2D(w, h, x, y);
            } catch (Exception e) {
                System.out.println("Test failed " +
                        "\nthrew Exception w/ message:\n" +
                        e.getMessage());
                System.out.println("Please try again");
                inL = 0;
            }
            while (inL == 1) {
                // Echo Rectangle 1
                System.out.println("\nRectangle 1: " + outRect.toString());

                // Prompt user input for Rectangle 2
                System.out.println("\nRectangle 2");
                System.out.print("Enter center point (x,y): ");
                x = inputVar.nextDouble();
                y = inputVar.nextDouble();
                System.out.print("Enter the width: ");
                w = inputVar.nextDouble();
                System.out.print("Enter the height: ");
                h = inputVar.nextDouble();

                try {
                    inRect = new MyRectangle2D(w, h, x, y);
                    // Printing user inputs
                    System.out.println("\nRectangle 1: " + outRect.toString());
                    System.out.println("Rectangle 2: " + inRect.toString());

                    System.out.println("\nTesting: ");

                    // Check if either rectangle CONTAINS or overlaps the other
                    if (outRect.contains(inRect))
                        System.out.println("\t- Rectangle 1 DOES contain Rectangle 2!");
                    else if (inRect.contains(outRect))
                        System.out.println("\t- Rectangle 2 DOES contain Rectangle 1!");
                    else
                        System.out.println("\t- Neither Rectangle contains the other ");

                    // OVERLAP
                    if (outRect.overlaps(inRect))
                        System.out.println("\t- Rectangle 1 & Rectangle 2 DO overlap!");
                    else
                        System.out.println("\t- Rectangle 1 & Rectangle 2 DO NOT overlap ");

                    // ABUT
                    if (outRect.abut(inRect))
                        System.out.println("\t- Rectangle 1 & Rectangle 2 ARE abut!");
                    else
                        System.out.println("\t- Rectangle 1 & Rectangle 2 ARE NOT abut ");

                    // DISTINCT
                    if (outRect.distinct(inRect))
                        System.out.println("\t- Rectangle 1 & Rectangle 2 ARE distinct!");
                    else
                        System.out.println("\t- Rectangle 1 & Rectangle 2 ARE NOT distinct ");

                    // Ask user if they would like to repeat of exit
                    System.out.println("\nEnter '0' to exit"
                            + "\nEnter '1' to test another Rectangle 2 with the SAME Rectangle 1"
                            + "\nEnter '2' to test two new Rectangles");
                    inL = inputVar.nextInt();
                    if (inL == 0) {
                        outL = 0;
                    }
                } catch (Exception e) {
                    System.out.println("Testing failed" +
                            "\nthrew Exception w/ message:\n" +
                            e.getMessage());
                    System.out.println("Please try again");
                }
            }
        }
        inputVar.close();
    }
}