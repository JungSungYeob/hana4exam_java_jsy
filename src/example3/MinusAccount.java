package example3;

public class MinusAccount extends Account {
	public MinusAccount(int balance, String owner, int accountNumber, String name) {
		super(balance, owner, accountNumber, name);
	}

	@Override
	public void withdrawMoney() {
		System.out.print("\t출금 하실 금액은? ");
		String money = Tool.scanNext();
		super.balance -= Integer.parseInt(money);
		Tool.printGreen("\t%s 통장에서 %s원이 출금되었습니다".formatted(super.name, Tool.decimalFormat(Integer.parseInt(money))));
		Tool.printGreen("\t%s 통장의 잔액은 %s원입니다.".formatted(super.name, Tool.decimalFormat(super.balance)));
	}

	@Override
	public void accountInfo() {
		Tool.printGreen("\t%s 통장 - 잔액: %s".formatted(super.name, Tool.decimalFormat(super.balance)));
	}
}
