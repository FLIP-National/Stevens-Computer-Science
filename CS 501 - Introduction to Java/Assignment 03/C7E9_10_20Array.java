/*
 * CS501 - Introduction to Java Programming
 * C7E9_10_20Array.java
 * Submitted by Chaitanya Pawar
 * */

/*
7.9:
	(Find the smallest element) Write a method that finds the smallest element in an array of
	double values using the following header:
	
	public static double min(double[] array)
	
	Write a test program that prompts the user to enter 10 numbers, invokes this method to
	return the minimum value, and displays the minimum value. 

7.10:
	(Find the index of the smallest element) Write a method that returns the index of
	the smallest element in an array of integers. If the number of such elements is greater than 1,
	return the smallest index. Use the following header:
	
	public static int indexOfSmallestElement(double[] array)
	
	Write a test program that prompts the user to enter 10 numbers, invokes this
	method to return the index of the smallest element, and displays the index.

7.20:
	(Revise selection sort) In Listing 7.8, you used selection sort to sort an array.
	The selection-sort method repeatedly finds the smallest number in the current array and swaps
	it with the first. Rewrite this program by finding the largest number and swapping it with
	the last. Write a test program that reads in 10 double numbers, invokes the method, and 
	displays the sorted numbers.
 */

import java.util.Scanner;

public class C7E9_10_20Array {
	
	static Scanner inputVar = new Scanner(System.in);
	
	//get array elements
		public static void getArrayElements(){
			
			double[] list = new double[10];
			
			System.out.print("Enter ten numbers: ");
			for(int i = 0; i < list.length; i++){
				list[i] = inputVar.nextDouble();
			}
			
			double minNumber = min(list);
			System.out.println("The minimum number is: "+minNumber);
			printSortedArray(list);
				
		}
		
		//print sorted array
		public static void printSortedArray(double[] list){
			
			reviseSelectionSort(list);
			
			System.out.print("Sorted Array: ");
			for(int i = 0; i < list.length; i++ ){
				System.out.print(list[i]+" ");
			}
			
		}
		
		//Revise selection sort
		public static void reviseSelectionSort(double[] list){
			
			for (int i = list.length-1 ; i >= 0; i--) {
			
				// Find the maximum in the list[i..list.length-1]
				double currentMax = list[i]; //3
				int currentMaxIndex = i; //9
			
				for (int j = 0; j < i; j++) {
					if (list[j] > currentMax) {
						currentMax = list[j];
						currentMaxIndex = j;
					}
				}
			
				// Swap list[i] with list[currentMaxIndex] if necessary
				if (currentMaxIndex != i) {
					list[currentMaxIndex] = list[i];
					list[i] = currentMax;
				}
			}
			
		}
		
		public static double min(double[] array){
			// get the smallest element in the array
			
			int index = indexOfSmallestElement(array);
			System.out.println("");
			System.out.println("The index of minimum number is: "+index);
			
			return array[index];
			
		}
		
		public static int indexOfSmallestElement(double[] list)
		{
				// Find the index of minimum element in the the list
				double currentMin = list[0];
				int currentMinIndex = 0;
				
				for (int i = 1; i < list.length; i++) {
					
					if (currentMin > list[i]) {
						currentMin = list[i];
						currentMinIndex = i;
					}
				}
				
				return currentMinIndex;
		}
	public static void main(String[] args) {
		
		int repeat = -1;
		while(repeat < 0){
		
			getArrayElements();
			
			System.out.println("\nEnter 1 for try again and 0 for exit: ");
			int response = inputVar.nextInt();
			
			if(response == 0)
			{
				repeat++;
				System.out.println("\nThank you.");
				System.out.println("End of Program...");
			}
			
		}
		inputVar.close();
		
	}

}
