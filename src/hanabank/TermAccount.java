package hanabank;

import java.util.Map;
import java.util.TreeMap;

import hanabank.exceptions.InvalidInputException;
import hanabank.exceptions.TransferException;
import hanabank.exceptions.WithdrawException;

public class TermAccount extends Account {

	private final TreeMap<Integer, Double> rates;

	public TermAccount(int balance, String owner, int accountNumber, String name) {
		super(balance, owner, accountNumber, name);
		rates = new TreeMap<>();
		rates.put(1, 3.0);
		rates.put(3, 3.35);
		rates.put(6, 3.4);
		rates.put(9, 3.35);
		rates.put(12, 3.35);
		rates.put(24, 2.9);
		rates.put(36, 2.9);
		rates.put(48, 2.9);
	}

	public boolean plusAction(Map<Integer, Account> accountList) {
		while (true) {
			System.out.print("\t예치 개월 수를 입력하세요(1 ~ 60개월) ");
			String month = Tool.scanNext();
			Map.Entry<Integer, Double> entry = rates.floorEntry(Integer.parseInt(month));
			System.out.printf("\t%s개월(적용금리 %.2f%%)로 만기 처리하시겠어요? (y/n) ", month, entry.getValue());
			String check = Tool.scanNext();
			if (check.equalsIgnoreCase("Y")) {
				int total = (int)(super.balance * (100 + entry.getValue()) / 100);
				return super.transferMoney(accountList, total);
			} else if (check.equalsIgnoreCase("N")) {
				continue;
			} else {
				throw new InvalidInputException();
			}
		}
	}

	@Override
	public void transferMoney(Map<Integer, Account> accountList) {
		throw new TransferException("\t이체할 수 없는 통장입니다.");
	}

	@Override
	public void withdrawMoney() {
		throw new WithdrawException("\t출금할 수 없는 통장입니다.");
	}

	public void rateInfo() {
		Tool.printGreen("\t* 예치 개월에 따른 적용 금리");
		for (Map.Entry<Integer, Double> entry : this.rates.entrySet()) {
			Tool.printGreen("\t\t%d개월 이상\t%.2f%%".formatted(entry.getKey(), entry.getValue()));
		}
	}
}
