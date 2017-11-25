package app;

import java.nio.charset.Charset;
import java.util.Scanner;

public class Console {

	static Scanner reader = new Scanner(System.in, Charset.defaultCharset().name());
	
	public static int getInput() {
		System.out.println("Enter a number: ");
		int n = 0;
		try {
			n = Integer.parseInt(reader.nextLine());
		} catch (NumberFormatException e) {
			// Ignore
		}
		return n;
	}
	
	public static void out(String out) {
		System.out.println(out);
	}
	
}
