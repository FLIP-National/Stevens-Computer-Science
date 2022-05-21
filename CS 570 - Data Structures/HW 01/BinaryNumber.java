/*
 * Submitted by Chaitanya Ramesh Pawar
 * CS570 B - data Structures
 * Stevens Institute of Technology | Hoboken, New
 * BinaryNumber.java
 * 
 * I have mentioned one query at the bottom of the code. Can you please help me out with it?
 * */
import java.util.Arrays;

public class BinaryNumber {

	// Creating a variable to store binary number
	private int data[];
	// Creating overflow variable for addition operation
	private boolean overflow;

	public BinaryNumber(int length) {
		// creating a binary number of length which will contain only zeros
		if (length > 0) {
			// Checking for zero or negative length input
			data = new int[length];
			for (int i = 0; i < length; i++) {
				data[i] = 0;
			}
		} else {
			// If improper input of some length is given then it should output an error
			System.out.println("Either 0 or negative length is entered, please check your inputs");
		}
	}

	public BinaryNumber(String str) {
		// Creating a binary number from string
		int size = str.length();
		data = new int[size];

		for (int i = 0; i < size; i++) {
			// Check whether any improper input is provided
			if (str.charAt(i) == '1' || str.charAt(i) == '0') {
				data[i] = Character.getNumericValue(str.charAt(i));
			} else {
				// If improper input is provided, then notify user
				System.out.println("Error! Entered value is not binary. Please input proper binary number");
				break;
			}
		}
	}

	public int getLength() {
		// Returning the length of a binary number
		return data.length;
	}

	public int getDigit(int index) {
		// Obtaining a digit of a binary number
		return data[index];
	}

	public void shiftR(int amount) {
		// Shifting all digits in a binary number any number of places to the right
		data = Arrays.copyOf(data, (data.length + amount));
		// .copyOf() copies specified array, if necessary truncates or adds padding with
		// zeros
		for (int i = 0; i < amount; i++) {
			int t = data[data.length - 1];
			for (int j = data.length - 1; j > 1; j--) {
				data[j] = data[j - 1];
			}
			data[i] = t;
		}
	}

	public void add(BinaryNumber aBinaryNumber) {
		// Add two binary numbers
		int userData[] = aBinaryNumber.data;
		// Checking input number for incorrect size
		if (data.length != userData.length) {
			System.out.println("The length of the binary numbers are not equal");
		} else {
			int temp = 0;
			int sum = 0;

			// Using switch case to check incorrect size
			for (int i = 0; i < data.length; i++) {
				sum = data[i] + userData[i] + temp;

				switch (sum) {
				case 0: {
					data[i] = 0;
					temp = 0;
					break;
				}
				case 1: {
					data[i] = 1;
					temp = 0;
					break;
				}
				case 2: {
					data[i] = 0;
					temp = 1;
					break;
				}
				case 3: {
					data[i] = 1;
					temp = 1;
					break;
				}
				}
			}
			if (temp == 1) {
				overflow = true;
			}
		}
	}

	public String toString() {
		// Return the binary number as a string
		if (overflow) {
			return "Overflow";
		} else {

			for (int i = 0; i < data.length; i++) {
				System.out.print(data[i]);
			}
			return "";
		}
	}

	public int toDecimal() {

		// Return decimal value of the binary number
		int decimalValue = 0;
		int j = 0;
		for (int i = 0; i < data.length; i++) {
			j = data[i];
			decimalValue += (j * Math.pow(2, i));
		}

		return decimalValue;

	}

	public void clearOverflow() {
		// Clears the overflow attribute of given binary number
		overflow = false;
	}

	public static void main(String args[]) {

		// Setting the length to 5 (length value not stated in question) to satisfy the
		// question.
		BinaryNumber binNum = new BinaryNumber(5);
		System.out.print("The output for length 5 with only zeros' is ");
		System.out.println(binNum.toString());
		System.out.println("");

		// Now initializing a binary number with input mentioned in question - 11001
		BinaryNumber binNum2 = new BinaryNumber("11001");
		// Printing the number in form of array using .toString() method.
		System.out.println("Initialized binary number from question: " + Arrays.toString(binNum2.data));
		System.out.println("");
		// Printing the length of binary number
		System.out.println("Length of binary number is " + binNum2.getLength());
		System.out.println("");
		// Printing first digit of binary number which should be 1
		System.out.println("First digit of binary number is " + binNum2.getDigit(0));
		System.out.println("");
		// Printing the Converted 11001 binary number to decimal using default
		// .toDecimal() method
		System.out.println("Converted Decimal of Binary number is " + binNum2.toDecimal());
		System.out.println("");
		// Performing Right shift operation to define an auxiliary private method.
		binNum2.shiftR(4);
		// Printing the right shifted number by converting
		System.out.print("Binary number after Right Shift operation: ");
		System.out.println(binNum2.toString());
		System.out.println("");
		// Getting the binary inputs as stated in question for addition operation
		BinaryNumber binNum3 = new BinaryNumber("001");
		BinaryNumber binNum4 = new BinaryNumber("010");
		// Printing the output of binary addition operation after adding the numbers
		// using default .add() method
		System.out.println("Performing Binary addition: 001 + 010");
		binNum3.add(binNum4);
		System.out.print("Output of Binary Addition: ");
		System.out.println(binNum3.toString());

	}

}

/*
 * Query - I didn't understand why System.out.println(); does not print output
 * as expected it just prints the converted string first and then the string
 * provided in double or single quotes
 * 
 * For example -
 * 
 * When System.out.println("Output of Binary Addition: " + binNum3.toString());
 * is used
 * 
 * Console prints - 011Output of Binary Addition:
 * 
 * Expected - Output of Binary Addition: 011
 * 
 * Can you please resolve my issue?
 */