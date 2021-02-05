package sorting;

import java.io.PrintWriter;
import java.io.StringWriter;

import basicIO.ArrayIO;
import basicIO.UserIO;

// Selection Sorting Algorithm - Implementation

// The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order) from
// unsorted part and putting it at the beginning. The algorithm maintains two subarrays in a given array.

// 		1) The subarray which is already sorted.
// 		2) Remaining subarray which is unsorted.

// In every iteration of selection sort, the minimum element (considering ascending order) from the unsorted subarray is 
// picked and moved to the sorted subarray.

public class SelectionSort {
	
	// Function to perform Selection Sorting Algorithm
	public static void selectionSort(int []arr, int n) {
		
		int i, j, min, temp;
		// One by one move the boundary of unsorted sub-array 
		for (i = 0; i < n - 1; i++) { // for number of passes
			
			// Assume that the min value is i - finding the minimum element in unsorted array
			min = i;
			
			for (j = i + 1; j < n; j++) { // for finding the minimum element by comparing all the elements from unsorted sub-array
				
				if (arr[j] < arr[min]) { // check for the minimum element from an unsorted array - if found then store the index of that element into min
					min = j;
				}
			}
			
			// if min value is updated i.e. min == j, then - swap arr[i] and arr[min]
			if (min != i) {
				
				temp = arr[i];
				arr[i] = arr[min];
				arr[min] = temp;
				
			}
		}
	}
	
	// Main method
	public static void main(String[] args) {
		
		int MAX;
		try {
			System.out.print("How many elements do you want to store? ");
			MAX = UserIO.readInt();
			
			int[] arr = ArrayIO.readArray(MAX);
			
			System.out.println("Original Array : ");
			ArrayIO.printArray(arr);
			
			selectionSort(arr, MAX);
			System.out.println("\nSorted Array : ");
			ArrayIO.printArray(arr);
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
 * -> Time Complexity : O(n^2) as there are two nested loops.
 * 
 * 		-> Best Case Time Complexity : Ω(n)
 * 		-> Average Case Time Complexity : θ(n^2)
 * 		-> Worst Case Time Complexity : O(n^2)
 * 
 * -> Space Complexity : O(1) - Auxiliary Space
 * 
 * -> Stability : Not Stable - The default implementation is not stable.
 * -> In Place : Yes, it does not require extra space.
 * 
 * -> The good thing about selection sort is it never makes more than O(n) swaps and can be useful when memory write is a 
 *    costly operation.
 *    
 * -> (n - 1) + (n - 2) + ... + 1 = (n * (n - 1)) / 2 comparisons and n swaps therefore, Time Complexity : O(n^2)
 */


