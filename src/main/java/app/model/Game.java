package app.model;

import java.nio.charset.Charset;
import java.util.Scanner;

public class Game {
	
	private static Scanner reader = new Scanner(System.in, Charset.defaultCharset().name());
	
	public static int getInput() {
		System.out.println("Enter a number: ");
		int n = 0;
		try {
			n = Integer.parseInt(reader.nextLine());
		} catch (NumberFormatException e) {
			
		}
		return n;
	}
	
	public int number;
	public int maxCount;
	public int count;
	
	public Game() {
		this.number = Double.valueOf(Math.random() * 10).intValue();
		this.maxCount = 5;
		this.count = 0;
	}
	
	public boolean canGuess() {
		return count < maxCount;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int guessCount) {
		this.count = guessCount;
	}
	
	public Guess guess(int num) {
		count++;
		return new Guess(num);
	}
	
	
	
}
