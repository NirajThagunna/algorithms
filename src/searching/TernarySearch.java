package searching;

import java.io.PrintWriter;
import java.io.StringWriter;

import basicIO.ArrayIO;
import basicIO.UserIO;

// Ternary Search - Implementation - Based on Divide and Conquer Technique
// It divides an array into three half - in three parts
public class TernarySearch {
	
	// Ternary Search Function - Method
	public static int ternarySearch(int []arr, int l, int r, int key) {
		
		if (l <= r) {
			
			// find mid1 and mid2
			int mid1 = l + (r - l) / 3; // Operator Precedence - () -> / -> +
			int mid2 = r - (r - l) / 3; // () -> / -> -
			
			// Element is present at mid1
			if (key == arr[mid1]) {
				return mid1;
			}
			
			// Element present at mid2 index
			else if (key == arr[mid2]) {
				return mid2;
			}
			
			// Key element is less than mid1 - key present at first half
			else if (key < arr[mid1]) {
				return ternarySearch(arr, l, mid1 - 1, key);
			}
			
			// Key element is greater than mid1 and less than mid2 - key element is present at second half
			else if ((key > arr[mid1]) && (key < arr[mid2])) {
				return ternarySearch(arr, mid1 + 1, mid2 - 1, key);
			}
			
			// key element is greater than mid2 - key element is present at third half
			else {
				return ternarySearch(arr, mid2 + 1, r, key);
			}
		}
		
		// If the key element is not present
		return -1;
	}
	
	// Main Method || Driver
	public static void main(String[] args) {
		
		int MAX, key;
		try {
			System.out.print("How many elements do you want to store? ");
			MAX = UserIO.readInt();
			
			int[] arr = ArrayIO.readArray(MAX);
			
			System.out.println("Original Array : ");
			ArrayIO.printArray(arr);
			
			System.out.print("\nEnter the element you want to search : ");
			key = UserIO.readInt();
			
			int result = ternarySearch(arr, 0, MAX - 1, key);
			
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
 *	-> Time Complexity : O(log n base 3) || Order of log n base 3 || Θ(log n base 3)
 *		-> Time Complexity : Θ(log n base 3) || Big-Theta of log n base 3 - Average Case Time Complexity
 *	
 *	-> Space Complexity : Θ(log n base 3) || O(log n base 3)
 *
 * Which of the above two does less comparisons in worst case? - Binary and Ternary Search Algorithm
 * 		-> From the first look, it seems the ternary search does less number of comparisons as it makes Log3n recursive calls,
 * 	       but binary search makes Log2n (log n base 2) recursive calls. Let us take a closer look.
 * 
 * 		- The recursive formula for counting number comparisons in worst case of Binary Search.
 * 				-> T(n) = T(n/2) + 2,  T(1) = 1
 * 
 * 		- The recursive formula for counting comparisons in worst case of Ternary Search.
 * 				-> T(n) = T(n/3) + 4, T(1) = 1
 * 
 * - In binary search, there are 2Log2n + 1 comparisons in worst case. 
 * - In ternary search, there are 4Log3n + 1 comparisons in worst case.
 * 
 * 		- Time Complexity for Binary search = 2clog2n + O(1)
 *      - Time Complexity for Ternary search = 4clog3n + O(1)
 *      
 * - Thus, Ternary Search does more comparisons than Binary Search in worst case.
*/

