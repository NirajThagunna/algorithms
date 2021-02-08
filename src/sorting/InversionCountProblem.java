package sorting;

import java.io.PrintWriter;
import java.io.StringWriter;

import basicIO.ArrayIO;
import basicIO.UserIO;

// Inversion Count for an array indicates – how far (or close) the array is from being sorted. 
// If array is already sorted then inversion count is 0. 
// If array is sorted in reverse order that inversion count is the maximum. 
// Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.

public class InversionCountProblem {

	// inversionCount() method to count the inversions
	public static int inversionCount(int []arr, int n) {

		int i, j;
		int inversionCount = 0;

		for (i = 0; i < n - 1; i++) {
			for (j = i + 1; j < n; j++) {
				if (arr[i] > arr[j] && i < j) {
					inversionCount++;
				}
			}
		}

		return inversionCount;
	}

	public static void inversions(int []arr, int n) {
		int i, j;

		for (i = 0; i < n - 1; i++) {
			for (j = i + 1; j < n; j++) {
				if (arr[i] > arr[j] && i < j) {
					System.out.print("(" + arr[i] + ", " + arr[j] + ")" + "," + " ");
				}
			}
		}
	}

	public static void main(String[] args) {

		int MAX;
		try {
			System.out.print("How many elements do you want to store? ");
			MAX = UserIO.readInt();

			int[] arr = ArrayIO.readArray(MAX);

			System.out.println("Original Array : ");
			ArrayIO.printArray(arr);

			int result = inversionCount(arr, MAX);
			System.out.println("\nNumber of inversions are : " + result);
			
			System.out.println("\nGiven array has " + result + " inversions : ");
			inversions(arr, MAX);
		}
		catch (Exception ex) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			ex.printStackTrace(pw);
			String error = sw.toString();
			System.out.println("Error : \n" + error);
		}
	}
}

/*
 * Complexity Analysis: 
 * 		-> Time Complexity : O(n^2), Two nested loops are needed to traverse the array from start to end 
 *         So, the Time complexity is O(n^2)
 *      -> Space Complexity : O(1), No extra space is required.
 */


