package sorting;

import java.io.PrintWriter;
import java.io.StringWriter;

import basicIO.ArrayIO;
import basicIO.UserIO;

// Insertion Sort Algorithm - Implementation
// Insertion sort is a simple sorting algorithm that works similar to the way you sort playing cards in your hands. 
// The array is virtually split into a sorted and an unsorted part. Values from the unsorted part are picked and placed at 
// the correct position in the sorted part.

// Algorithm
// 		To sort an array of size n in ascending order:
// 		1: Iterate from arr[1] to arr[n] over the array.
// 		2: Compare the current element (key) to its predecessor.
// 		3: If the key element is smaller than its predecessor, compare it to the elements before. Move the greater elements
//         one position up to make space for the swapped element.

public class InsertionSort {
	
	// Function to sort an array by using Insertion Sorting Algorithm
	public static void insertionSort(int []arr, int n) {
		
		int i, j, temp;
		for (i = 1; i < n; i++) {
			
			// Store the current element in temp variable to compare with the predecessor or the element before the current element
			temp = arr[i];
			
			// Another loop for sorted array - in decreasing order
			j = i - 1;
			
			while ((j >= 0) && (arr[j] > temp)) {
				
				// moving the left side element to one position forward.
				arr[j + 1] = arr[j];
				
				// Decrementing the index j
				j--;
			}
			
			// moving current element to its correct position - Placing the current element in it's correct position
			arr[j + 1] = temp;
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
			
			insertionSort(arr, MAX);
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
 * In worst case, each element is compared with all the other elements in the sorted array. For n elements, there will be 
 * n^2 comparisons. Therefore, the time complexity is O(n^2) in worst case.
 * 
 * -> Time Complexity: O(n^2)
 * 
 * -> Space Complexity: O(1) - Auxiliary Space
 * 
 * -> Boundary Cases: 
 *  		- Insertion sort takes maximum time to sort if elements are sorted in reverse order - O(n^2) 
 *  		- And it takes minimum time (Order of n) when elements are already sorted - best case time complexity - O(n)
 *  
 *  -> Algorithmic Paradigm: Incremental Approach
 *  -> Sorting In Place: Yes
 *  -> Stable: Yes
 *  -> Online: Yes
 *  
 *  -> Uses: Insertion sort is used when number of elements is small. It can also be useful when input array is almost 
 *           sorted, only few elements are misplaced in complete big array.
 */

