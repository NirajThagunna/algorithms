package sorting;

import java.io.PrintWriter;
import java.io.StringWriter;

import basicIO.ArrayIO;
import basicIO.UserIO;

// Quick Sort Algorithm - Implementation
public class QuickSort1 {

	// Partition() Method - returns the pivot index
	public static int partition(int []arr, int low, int high) {

		int pivot = arr[high];
		int i = (low - 1);

		for (int j = low; j < high; j++) {

			// If current element is smaller than or equals to the pivot
			if (arr[j] <= pivot) {

				i++;

				if (i < j) {
					// swap arr[i] and arr[j]
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}

			}

		}

		// swap arr[i+1] and arr[high] (or pivot)
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		return (i + 1);
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


