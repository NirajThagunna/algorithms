package basicIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserIO {
	// Reading input from user
	public static String readInput() throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		return str;
	}
	
	// Reading integer value
	public static int readInt() {
		int num = 0;
		try {
			num = Integer.parseInt(readInput());
		}
		catch (NumberFormatException | IOException ex) {
			ex.printStackTrace();
		}
		return num;
	}
}
