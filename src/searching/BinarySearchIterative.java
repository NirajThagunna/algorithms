package searching;

import java.io.PrintWriter;
import java.io.StringWriter;

import basicIO.ArrayIO;
import basicIO.UserIO;

// Binary Search Algorithm - Implementation
// Binary Search - Works only for Sorted Array
public class BinarySearchIterative {
	
	// Function to search an element by using Binary Search Algorithm
	public static int binarySearch(int[] arr, int n, int key) {
		int l = 0, r = n - 1; // l = left index and r = right index
		
		// Check if the element present in a given array then return that index
		while (l <= r) {
			int mid = (l + r) / 2; // Only taking a floor value of mid
			
			if (key == arr[mid]) {
				return mid;
			}
			else if (key < arr[mid]) {
				r = mid - 1;
			}
			else {
				l = mid + 1;
			}
		}
		
		// If the element is not present in a given array
		return -1;
	}
	
	// Driver Function | Main
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
			
			int result = binarySearch(arr, MAX, key);
			
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
 *		Binary search is a fast search algorithm with run-time complexity of Ο(log n). This search algorithm works on the 
 *		principle of divide and conquer. For this algorithm to work properly, the data collection should be in the sorted form.
 * 		
 * 		The time complexity of the binary search algorithm is O(log n). 
 * 		The best-case time complexity would be O(1) when the central index would directly match the desired value. 
 * 		The worst-case scenario could be the values at either extremity of the list or values not in the list.
 * 
 * 		The space complexity of the binary search algorithm depends on the implementation of the algorithm.
 * 			1) Iterative Method
 * 			2) Recursive Method
 * 		Both methods are quite the same, with two differences in implementation. First, there is no loop in the recursive 
 * 		method. Second, rather than passing the new values to the next iteration of the loop, it passes them to the next 
 * 		recursion. In the iterative method, the iterations can be controlled through the looping conditions, while in the 
 * 		recursive method, the maximum and minimum are used as the boundary condition.
 * 
 * Analysis Of Binary Searching Algorithm :
 * 		-> Time Complexity : O(log n)
 * 			- Best Case Time Complexity : O(1) | Big-Omega
 * 			- Worst Case Time Complexity : O(log n)
 * 			- Average Case Time Complexity : O(log n)
 * 
 * 		-> Space Complexity : O(1)
 * 		-> In the iterative method, the space complexity would be O(1).
 */
