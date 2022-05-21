import java.text.DecimalFormat;
import java.util.Scanner;

public class C2E19AreaOfTriangle {

	public static void main(String[] args) {
		// User input variable
		Scanner userinput = new Scanner(System.in);
		
		//Setting Decimal Limit to 2
		DecimalFormat decf = new DecimalFormat();
		decf.setMinimumFractionDigits(2);
		
		//Getting input from user
		System.out.println("Enter sides for (a1, b1), (a2, b2), (a3, b3) to calculate area");
		System.out.print("a1 = ");
		double a1 = userinput.nextDouble();
		System.out.print("b1 = ");
		double b1 = userinput.nextDouble();
		System.out.print("a2 = ");
		double a2 = userinput.nextDouble();
		System.out.print("b2 = ");
		double b2 = userinput.nextDouble();
		System.out.print("a3 = ");
		double a3 = userinput.nextDouble();
		System.out.print("b3 = ");
		double b3 = userinput.nextDouble();
		
		double side1 = Math.sqrt(Math.pow((a2 - a1),2) + Math.pow((b2 - b1),2));
		double side2 = Math.sqrt(Math.pow((a2 - a3),2) + Math.pow((b2 - b3),2));
		double side3 = Math.sqrt(Math.pow((a3 - a1),2) + Math.pow((b3 - b1),2));
		
		double s = (side1 + side2 + side3)/2;
		
		System.out.print("The area of the triangle is "+decf.format(Math.sqrt(s*(s-side1)*(s-side2)*(s-side3))));
		
		userinput.close();		

	}

}
