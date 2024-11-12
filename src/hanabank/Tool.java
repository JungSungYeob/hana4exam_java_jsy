package hanabank;

import java.text.DecimalFormat;
import java.util.Scanner;

import hanabank.exceptions.ExitException;
import hanabank.exceptions.NotEnoughMoneyException;

public class Tool {
	private static final Scanner scanner = new Scanner(System.in);
	public static final String RESET = "\u001B[0m";
	public static final String GREEN = "\u001B[32m";
	public static final String RED = "\u001B[31m";

	public static String scanNext() {
		String input = scanner.nextLine();
		moveBack(input);
		return input;
	}

	public static void moveBack(String option) {
		if (option.equals("0") || option.isEmpty()) {
			throw new ExitException();
		}
	}

	public static void isEnough(String money, int balance) {
		if (Integer.parseInt(money) > balance) {
			throw new NotEnoughMoneyException(
				"\t잔액이 부족합니다!(잔액: %s원)".formatted(Tool.decimalFormat(balance)));
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
