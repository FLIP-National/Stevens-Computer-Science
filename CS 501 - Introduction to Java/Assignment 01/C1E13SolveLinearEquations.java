import java.text.DecimalFormat;
import java.util.Scanner;

public class C1E13SolveLinearEquations {

	public static void main(String[] args) {
		//Creating variable to get input from user
		Scanner userinput = new Scanner(System.in);
		
		//Using Decimal Format to set floating points
		DecimalFormat decf = new DecimalFormat();
		decf.setMinimumFractionDigits(2);
		
		//Getting values from user to calculate two linear equations
		System.out.println("Enter values for equation: ax + by = e");
		System.out.print("Enter a: ");
		double a = userinput.nextDouble();
		
		System.out.print("Enter b: ");
		double b = userinput.nextDouble();
		
		System.out.print("Enter e: ");
		double e = userinput.nextDouble();
		
		System.out.println("Enter input variable for equation : cx + dy = f");
		System.out.print("Enter c: ");
		double c = userinput.nextDouble();
		
		System.out.print("Enter d: ");
		double d = userinput.nextDouble();
		
		System.out.print("Enter f: ");
		double f = userinput.nextDouble();
		System.out.println();
		
		if((a*d)-(b*c)==0) {
			System.out.println("The equation you entered may not have any solution");
		}else{
			//Now using Cramer's rule to solve given equations
			double x = (e*d - b*f) / (a*d - b*c);
			double y = (a*f - e*c) / (a*d - b*c);
			
			System.out.println("Value calculated for x and y is");
			System.out.println();
			System.out.println("x = "+decf.format(x)+" and y = "+decf.format(y));
		};
		userinput.close();
	}

}
