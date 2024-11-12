package hanabank;

import java.util.Map;

import hanabank.exceptions.InvalidInputException;
import hanabank.exceptions.NotEnoughMoneyException;

public class FreeAccount extends Account {

	public FreeAccount(int balance, String owner, int accountNumber, String name) {
		super(balance, owner, accountNumber, name);
	}

	// @Override
	// public void plusAction(Scanner scanner) {
	//
	// }

	@Override
	public void transferMoney(Map<Integer, Account> accountList) {
		Account account = super.selectAccount(accountList);
		while (true) {
			try {
				System.out.printf("\t%s 통장에 보낼 금액은? ", account.name);
				String money = Tool.scanNext();
				Tool.isEnough(money, super.balance);
				transferAction(account, Integer.parseInt(money));
				Tool.printGreen("\t%s 통장의 잔액은 %s원입니다.".formatted(super.name, Tool.decimalFormat(super.balance)));
				break;
			} catch (NotEnoughMoneyException | InvalidInputException | NumberFormatException e) {
				if (e instanceof NumberFormatException) {
					Tool.printDanger("\t계좌 번호는 숫자로만 이루어져있습니다. 정확한 입력을 해주십시오.");
				} else {
					Tool.printDanger(e.getMessage());
				}
			}
		}
	}

	@Override
	public void withdrawalMoney() {
		while (true) {
			try {
				System.out.print("\t출금 하실 금액은? ");
				String money = Tool.scanNext();
				Tool.isEnough(money, super.balance);
				super.balance -= Integer.parseInt(money);
				Tool.printGreen(
					"\t%s 통장에서 %s원이 출금되었습니다".formatted(super.name, Tool.decimalFormat(Integer.parseInt(money))));
				Tool.printGreen(
					"\t%s 통장의 잔액은 %s원입니다.".formatted(super.name, Tool.decimalFormat(super.balance))
				);
				break;
			} catch (NotEnoughMoneyException e) {
				Tool.printDanger(e.getMessage());
				continue;
			}

		}
	}
}
