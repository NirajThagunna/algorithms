package searching;

import java.io.PrintWriter;
import java.io.StringWriter;

import basicIO.ArrayIO;
import basicIO.UserIO;

public class LastOccurrence {
	
	// Method to find the last occurrence of an element
	public static int findOccurrence(int []arr, int num) {
		int n = arr.length;
		int count = 0;
		
		for (int i = 0; i < n; i++) {
			if (arr[i] == num) {
				count = i;
			}
		}
		
		return count;
	}
	
	// Driver function
	public static void main(String[] args) {
		int MAX, num;
		try {
			System.out.print("How many elements do you want to store? ");
			MAX = UserIO.readInt();
			
			int[] arr = ArrayIO.readArray(MAX);
			
			System.out.println("Original Array : ");
			ArrayIO.printArray(arr);
			
			System.out.print("\nEnter any number whose last occurrence is to be found: ");
			num = UserIO.readInt();
			
			int result = findOccurrence(arr, num);
			
			if (result == 0) {
				System.out.println("-1");
			}
			else {
				System.out.println(result + 1);
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
