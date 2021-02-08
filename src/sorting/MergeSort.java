package sorting;

import java.io.PrintWriter;
import java.io.StringWriter;

import basicIO.ArrayIO;
import basicIO.UserIO;

// Merge Sort Algorithm - Implementation
public class MergeSort {
	
	// merge() function to perform merge operations
	public static void merge(int []arr, int low, int mid, int high) {
		
		int i, j, k;
		i = low; // Left Array
		j = mid + 1; // Right Array
		k = low; // temp[]
		
		int[] temp = new int[arr.length];
		
		while ((i <= mid) && (j <= high)) {
			// for left most array
			if (arr[i] <= arr[j]) {
				temp[k] = arr[i];
				i++;
				// k++;
			}
			else { // if (arr[j] <= arr[i]) - for right most array
				temp[k] = arr[j];
				j++;
				// k++;
			}
			k++;
		}
		
		// for the remaining elements in any sub-array
		// Copy remaining elements of R[] if any
		if (i > mid) { // i reached to it's boundary/limit
			
			while (j <= high) { // remaining elements in a right most array
				temp[k] = arr[j];
				j++;
				k++;
			}
			
		}
		// Copy remaining elements of L[] if any
		else { // if (j > high) - j reached to it's boundary/limit
			
			while (i <= mid) { // remaining elements in a left most array
				temp[k] = arr[i];
				i++;
				k++;
			}
			
		}
		
		// Copying the elements from temp[] into arr[]
		for (k = low; k <= high; k++) {
			arr[k] = temp[k];
		}
	}
	
	// Merge Sort Algorithm
	public static void mergeSort(int []arr, int low, int high) {
		
		if (low < high) {
			
			int mid = (low + high) / 2;
			mergeSort(arr, low, mid);
			mergeSort(arr, mid + 1, high);
			merge(arr, low, mid, high);
			
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
			
			mergeSort(arr, 0, MAX - 1);
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
 * Merge Sort is a recursive algorithm and time complexity can be expressed as following recurrence relation. 
 * 		- T(n) = 2T(n/2) + θ(n) -> 2T(n/2) - for two mergeSort() and θ(n) - for merge() - Time Functions
 * 
 * Time complexity of Merge Sort is θ(nLogn) in all 3 cases (worst, average and best) as merge sort always divides the 
 * array into two halves and takes linear time θ(n) to merge two halves.
 * 
 * -> Total Space Complexity : θ(n + log n) - Auxiliary Space : O(n)
 * -> Algorithmic Paradigm: Divide and Conquer Technique
 * -> Sorting In Place: No in a typical implementation
 * 
 * -> Stable: Yes
 * -> Extra Space : No in-place sort
 * 
 * Applications of Merge Sort :
 * 		-> Merge Sort is useful for sorting linked lists in O(nLogn) time.
 * 		-> Inversion Count Problem - Implemented
 * 		-> Used in External Sorting
 */



