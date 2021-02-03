package searching;

import java.io.StringWriter;

import basicIO.ArrayIO;
import basicIO.UserIO;

import java.io.PrintWriter;

// Linear Searching Algorithm - Implementation
class LinearSearchAlgo {
	// Function to implement Linear Search ALgorithm
	public static int linearSearch(int []arr, int key) {
		int n = arr.length;
		
		// if the element is present in a given array then, return index i.e. i
		for (int i = 0; i < n; i++) {
			// Comparing the key with all the elements of an array
			if (arr[i] == key) {
				return i;
			}
		}
		
		// return -1, if the element is not present in a given array
		return -1;
	}
}

// Main Class
public class LinearSearch extends LinearSearchAlgo {
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
			
			int result = linearSearch(arr, key);
			
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
 * Analysis of Linear Searching Algorithm :
 * 		-> Time Complexity : O(n)
 * 			- Worst Case Time Complexity : O(n)
 * 			- Best Case Time Complexity : Ω(1) or O(1) -> the best case performance of an algorithm is generally not useful
 * 			- Average Case Time Complexity : Θ((n + 1) / 2)
 * 
 * 		-> Space Complexity : O(1) -> It takes a constant time
 */
