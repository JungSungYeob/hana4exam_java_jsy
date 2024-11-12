package hanabank;

import java.util.Map;

import hanabank.exceptions.InvalidInput;
import hanabank.exceptions.WithdrawException;

public abstract class Account implements AccountsActions {

	protected int balance;
	protected String owner;
	protected int accountNumber;
	protected String name;

	protected Account selectAccount(Map<Integer, Account> accountList) {
		System.out.printf("\t어디로 보낼까요? %s ", Bank.showAllSimpleInfo(this, accountList));
		String accountSelected = Tool.scanNext();
		Account account = accountList.get(Integer.parseInt(accountSelected));
		if (this.accountNumber == Integer.parseInt(accountSelected) || account == null) {
			throw new InvalidInput();
		}
		return account;
	}

	protected void transferAction(Account account, int money) {
		this.balance -= money;
		account.balance += money;
		Tool.printGreen("\t%s 통장에 %s원이 입금되었습니다.".formatted(account.name, Tool.decimalFormat(money)));
	}

	public Account(int balance, String owner, int accountNumber, String name) {
		this.balance = balance;
		this.owner = owner;
		this.accountNumber = accountNumber;
		this.name = name;
	}

	@Override
	public String simpleInfo() {
		return "%d: %s".formatted(this.accountNumber, this.name);
	}

	@Override
	public void accountInfo() {
		Tool.printGreen("\t%s 통장(계좌번호: %d, 잔액: %s, 예금주: %s)".formatted(this.name, this.accountNumber,
			Tool.decimalFormat(this.balance), this.owner));
	}

	@Override
	public void transferMoney(Map<Integer, Account> accountList) {
		Account account = selectAccount(accountList);
		System.out.printf("\t%s 통장에 보낼 금액은? ", account.name);
		String money = Tool.scanNext();
		transferAction(account, Integer.parseInt(money));
		Tool.printGreen("\t%s 통장의 잔액은 %s원입니다.".formatted(this.name, Tool.decimalFormat(this.balance)));
	}

	@Override
	public boolean transferMoney(Map<Integer, Account> accountList, int money) {
		Account account = selectAccount(accountList);
		transferAction(account, money);
		Tool.printGreen("\t%s 통장은 해지되었습니다. 감사합니다.".formatted(this.name));
		return true;
	}

	@Override
	public void withdrawMoney() {
		throw new WithdrawException("\t출금할 수 없는 통장입니다.");
	}

	@Override
	public void plusAction() {
		System.out.print("\t입금 하실 금액은? ");
		String money = Tool.scanNext();
		this.balance += Integer.parseInt(money);
		Tool.printGreen("\t%s 통장에 %s원이 입금되었습니다".formatted(this.name, Tool.decimalFormat(Integer.parseInt(money))));
	}
}
