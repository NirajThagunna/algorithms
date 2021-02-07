package sorting;

import java.io.PrintWriter;
import java.io.StringWriter;

import basicIO.ArrayIO;
import basicIO.UserIO;

// Quick Sort Algorithm - Implementation
public class QuickSort {
	
	// Partition() Method - returns the pivot index
	public static int partition(int []arr, int low, int high) {
		
		int pivot = arr[low];
		int start = low, end = high; // start = staring index and high = last index
		
		while (start < end) {
			
			while (arr[start] <= pivot) {
				start++;
			}
			
			while (arr[end] > pivot) {
				end--;
			}
			
			if (start < end) {
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
			}
		}
		
		int temp = arr[low];
		arr[low] = arr[end];
		arr[end] = temp;
		
		return end;
	}
	
	// quickSort() function
	public static void quickSort(int []arr, int low, int high) {
		
		if (low < high) {
			
			int pivotIndex = partition(arr, low, high);
			quickSort(arr, low, pivotIndex - 1); // elements < pivot || first half || Sorts the left side of pivot.
			quickSort(arr, pivotIndex + 1, high); // elements > pivot || second half || Sorts the right side of pivot.
			
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
			
			quickSort(arr, 0, MAX - 1);
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
 * Analysis of Quick Sort Algorithm :
 * 
 * Time Complexity Analysis :		
 * 		-> Best Case Time Complexity : O(n log n)
 * 		-> Average Case Time Complexity : O(n log n)
 * 		-> Worst Case Time Complexity : O(n^2)
 * 
 * Space Complexity Analysis :
 * 		-> In best case, Space Complexity is O(log n)
 * 		-> In worst case, Space Complexity is O(n)
 * 
 * Quick Sort Algorithm takes time space from log n to n.
 */


