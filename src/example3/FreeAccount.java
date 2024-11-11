package example3;

import java.util.Map;

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
			System.out.printf("\t%s 통장에 보낼 금액은? ", account.name);
			String money = Tool.scanNext();
			if (Integer.parseInt(money) > super.balance) {
				Tool.printDanger("\t잔액이 부족합니다!(잔액: %s원)".formatted(Tool.decimalFormat(super.balance)));
				continue;
			}
			transferAction(account, Integer.parseInt(money));
			Tool.printGreen("\t%s 통장의 잔액은 %s원입니다.".formatted(super.name, Tool.decimalFormat(super.balance)));
			break;
		}

	}

	@Override
	public void withdrawMoney() {
		while (true) {
			System.out.print("\t출금 하실 금액은? ");
			String money = Tool.scanNext();
			if (Integer.parseInt(money) > super.balance) {
				Tool.printDanger("\t잔액이 부족합니다!(잔액: %s원)".formatted(Tool.decimalFormat(super.balance)));
				continue;
			}
			super.balance -= Integer.parseInt(money);
			Tool.printGreen(
				"\t%s 통장에서 %s원이 출금되었습니다".formatted(super.name, Tool.decimalFormat(Integer.parseInt(money))));
			Tool.printGreen(
				"\t%s 통장의 잔액은 %s원입니다.".formatted(super.name, Tool.decimalFormat(super.balance))
			);
			break;
		}
	}
}
