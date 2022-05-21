import java.text.DecimalFormat;

public class C1E5ComputeExpressions {

	public static void main(String[] args) {
		
		DecimalFormat decf = new DecimalFormat();
		decf.setMinimumFractionDigits(4);
		
		double a = ((9.5 * 4.5) - (2.5 * 3)) / (45.5 - 3.5);
		
		System.out.println("((9.5 * 4.5) - (2.5 * 3)) / (45.5 - 3.5) = " +decf.format(a));

	}

}
