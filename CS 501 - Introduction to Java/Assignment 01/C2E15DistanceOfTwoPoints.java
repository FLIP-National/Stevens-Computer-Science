import java.util.Scanner;

public class C2E15DistanceOfTwoPoints {

	public static void main(String[] args) {
		
		Scanner inp = new Scanner(System.in);
		
		
		System.out.println("Enter two points (x1, y1) and (x2, y2) for calculating distance");
		
		System.out.print("Enter x1 and y1 = ");
		double x1 = inp.nextDouble();
		double y1 = inp.nextDouble();
		
		System.out.print("Enter x2 and y2 = ");
		double x2 = inp.nextDouble();
		double y2 = inp.nextDouble();
		
		System.out.println("Distance between 2 points = "+ Math.pow((Math.pow((x2 - x1),2) + Math.pow((y2 - y1),2)),0.5));
		inp.close();

	}

}
