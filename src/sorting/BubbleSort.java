package sorting;

import java.io.PrintWriter;
import java.io.StringWriter;

import basicIO.ArrayIO;
import basicIO.UserIO;

// Bubble Sort Algorithm - Implementation
// Bubble Sort is based on the idea of repeatedly comparing pairs of adjacent elements and then swapping their positions
// if they exist in the wrong order.
public class BubbleSort {
	
	// Function to sort an array by using Bubble Sorting Algorithm
	public static void bubbleSort(int []arr, int n) {
		
		int i, j, temp;
		boolean flag;
		for (i = 0; i < n - 1; i++) { // for number of passes
			
			flag = false; // flag variable for swapping
			
			for (j = 0; j < n - 1 - i; j++) { // for number of comparisons
				
				if (arr[j] > arr[j + 1]) { // Check if the two adjacent elements are in right or wrong order
					// Swapping - if the adjacent elements are in wrong order
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					
					// Update the flag variable to true - if the swapping is happened
					flag = true;
				}
			}
			
			// terminate the loop if the flag == false
			// If no two elements were swapped by inner loop, then break
			if (flag == false) {
				break;
			}
		}
	}
	
	// Main || Driver Method
	public static void main(String[] args) {
		
		int MAX;
		try {
			System.out.print("How many elements do you want to store? ");
			MAX = UserIO.readInt();
			
			int[] arr = ArrayIO.readArray(MAX);
			
			System.out.println("Original Array : ");
			ArrayIO.printArray(arr);
			
			bubbleSort(arr, MAX);
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
 * -> Time Complexity : O(n^2)
 * 
 * 		- Worst Case Time Complexity : O(n^2)
 * 		- Average Case Time Complexity : O(n^2)
 * 		- Best Case Time Complexity : O(n) - if the array is already sorted.
 * 
 * -> Space Complexity : O(1) - It takes a constant time.
 * 
 * -> The complexity of bubble sort is O(n^2) in both worst and average cases, because the entire array needs to be iterated
 *    for every element.
 *    
 * -> Worst and Average Case Time Complexity: O(n*n). Worst case occurs when array is reverse sorted.
 * -> Best Case Time Complexity: O(n). Best case occurs when array is already sorted.
 * -> Auxiliary Space: O(1)
 * -> Boundary Cases: Bubble sort takes minimum time (Order of n) when elements are already sorted.
 * -> Sorting In Place: Yes
 * -> Stable : Yes
 */

