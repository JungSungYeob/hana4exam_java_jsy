package hanabank;

import java.util.HashMap;
import java.util.Map;

import hanabank.exceptions.ExitException;
import hanabank.exceptions.InvalidInputException;
import hanabank.exceptions.TermCompleteException;

public class Bank {
	private final Map<Integer, Account> accountList;

	public Bank() {
		this.accountList = new HashMap<Integer, Account>();
		this.accountList.put(1, new FreeAccount(0, "홍길동", 1, "자유입출금"));
		this.accountList.put(2, new TermAccount(50000000, "고길동", 2, "정기예금"));
		this.accountList.put(3, new MinusAccount(0, "코길동", 3, "마이너스"));
	}

	private void menu(Account account) {
		while (true) {
			try {
				if (account instanceof TermAccount) {
					System.out.printf("> %s이 만기되었습니다. (+: 만기처리, -: 출금, T: 이체, I: 정보) ", account.name);
				} else {
					System.out.print("> 원하시는 업무는? (+: 입금, -: 출금, T: 이체, I: 정보) ");
				}
				String action = Tool.scanNext();
				try {
					switch (action) {
						case "+": {
							if (account instanceof TermAccount) {
								if (((TermAccount)account).plusAction(accountList)) {
									this.accountList.remove(account.accountNumber);
									throw new TermCompleteException();
								}
							} else {
								account.plusAction();
							}
							break;
						}
						case "-": {
							account.withdrawalMoney();
							break;
						}
						case "T": {
							account.transferMoney(accountList);
							break;
						}
						case "I": {
							account.getAccountInfo();
							if (account instanceof TermAccount) {
								((TermAccount)account).rateInfo();
							}
							break;
						}
						default: {
							throw new InvalidInputException();
						}
					}
				} catch (ExitException e) {
					continue;
				}
			} catch (RuntimeException e) {
				if (e instanceof NumberFormatException) {
					Tool.printDanger("\t계좌 번호는 숫자로만 이루어져있습니다. 정확한 입력을 해주십시오.");
				} else if (e instanceof ExitException || e instanceof TermCompleteException) {
					Tool.printDanger(e.getMessage());
					break;
				} else {
					Tool.printDanger(e.getMessage());
				}
			}

		}
	}

	public void bankSystem() {
		while (true) {
			try {
				System.out.printf(">>통장을 선택하세요 %s ", Tool.showAllSimpleInfo(null, this.accountList));
				String action = Tool.scanNext();
				Account account = this.accountList.get(Integer.parseInt(action));
				if (account == null) {
					throw new InvalidInputException("\t유효하지 않은 계좌 번호입니다.");
				}
				account.getAccountInfo();
				menu(account);
			} catch (NumberFormatException | InvalidInputException | ExitException e) {
				if (e instanceof NumberFormatException) {
					Tool.printDanger("\t계좌 번호는 숫자로만 이루어져있습니다. 정확한 입력을 해주십시오.");
				} else if (e instanceof ExitException) {
					System.out.println("\t금일 OneHanaBank는 업무를 종료합니다. 감사합니다.");
					break;
				} else {
					Tool.printDanger(e.getMessage());
				}

			}
		}
	}
}
