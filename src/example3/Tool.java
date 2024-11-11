package example3;

import java.text.DecimalFormat;
import java.util.Scanner;

import example3.exceptions.ExitException;

public class Tool {
	public static final String RESET = "\u001B[0m";
	public static final String GREEN = "\u001B[32m";
	public static final String RED = "\u001B[31m";

	public static String scanNext() {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		moveBack(input);
		scanner.close();
		return input;
	}

	public static void moveBack(String option) {
		if (option.equals("0") || option.isEmpty()) {
			throw new ExitException();
		}
	}

	public static String decimalFormat(int balance) {
		DecimalFormat df = new DecimalFormat("#,###");
		return df.format(balance);
	}

	public static void printDanger(String string) {
		System.out.println(Tool.RED + string + Tool.RESET);
	}

	public static void printGreen(String string) {
		System.out.println(Tool.GREEN + string + Tool.RESET);
	}
}
