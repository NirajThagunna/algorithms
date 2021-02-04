package searching;

import java.io.PrintWriter;
import java.io.StringWriter;

import basicIO.ArrayIO;
import basicIO.UserIO;

// Binary Search Algorithm - Implementation - Recursively
public class BinarySearchRecursive {
	
	// Performing Binary Search algorithm by Recursively
	public static int binarySearch(int []arr, int l, int r, int key) {
		
		// Small sub-problem
		if (l == r) {
			if (arr[l] == key) {
				return l;
			}
			else {
				return -1;
			}
		}
		
		// Large sub-problem
		else if (l < r) {
			int mid = (l + r) / 2;
			
			// Element present at middle index - center element
			if (key == arr[mid]) {
				return mid;
			}
			
			// Element present at left side - element is less than middle index element
			else if (key < arr[mid]) {
				return binarySearch(arr, l, mid - 1, key);
			}
			
			// Element present at right side - element is greater than middle index element
			else {
				return binarySearch(arr, mid + 1, r, key);
			}
		}
		
		// If the element is not present
		else {
			return -1;
		}
	}
	
	// Driver Function | Main Method
	public static void main(String[] args) {
		
		int MAX, key;
		
		try {
			System.out.print("How many elements do you want to store? ");
			MAX = UserIO.readInt();

			int[] arr = ArrayIO.readArray(MAX);

			System.out.println("Original Array : ");
			ArrayIO.printArray(arr);

			System.out.print("\nEnter the element you want to search? ");
			key = UserIO.readInt();

			int result = binarySearch(arr, 0, MAX - 1, key);

			if (result == -1) {
				System.out.println("\n" + key + " is not present in a given array.");
			}
			else {
				System.out.printf("\n%d is present at position %d.", key, result + 1);
			}
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
 * Defination:
 * 		Binary Search: Θ(log n)
 * 			-> Search a sorted array by repeatedly dividing the search interval in half. Begin with an interval covering the
 * 			   whole array. If the value of the search key is less than the item in the middle of the interval, narrow the 
 *             interval to the lower half. Otherwise, narrow it to the upper half. Repeatedly check until the value is found
 *             or the interval is empty.
 *             
 *		-> Time Complexity of Binary Search Algorithm : O(log2 (n)) || Order of log n base 2 || O(log n) - Worst Case
 *		-> Time Complexity : Θ(log n) - By solving recurrence relation - T(n) = 1 + T(n/2) by using master theorem
 *
 *			-> The time complexity of the binary search algorithm is O(log n). 
 *          -> The best-case time complexity would be O(1) when the central index would directly match the desired value.
 *          
 *       -> In the recursive method, the space complexity would be O(log n).
 *       -> Space Complexity : O(log n)
 *       
 * -> In the iterative method, the space complexity would be O(1). 
 * -> While in the recursive method, the space complexity would be O(log n).
 * 
 * Conclusion:
 * 		-> The major difference between the iterative and recursive version of Binary Search is that the recursive version
 * 		   has a space complexity of O(log n) while the iterative version has a space complexity of O(1). Hence, even 
 *         though recursive version may be easy to implement, the iterative version is efficient.
 */

