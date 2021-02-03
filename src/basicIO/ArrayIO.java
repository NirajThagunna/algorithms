package basicIO;

public class ArrayIO {
	// Reading an array from a user
	public static int[] readArray(int n) {
		int[] temp = new int[n];

		for (int i = 0; i < n; i++) {
			System.out.print("Enter any number : ");
			temp[i] = UserIO.readInt();
		}
		System.out.println();

		return temp;
	}

	// Printing an array
	public static void printArray(int []arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
