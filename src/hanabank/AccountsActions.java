package hanabank;

import java.util.Map;

public interface AccountsActions {
	public void withdrawalMoney();

	public void plusAction();

	public void transferMoney(Map<Integer, Account> accountList);

	public boolean transferMoney(Map<Integer, Account> accountList, int money);

	public void getAccountInfo();

	public String simpleInfo();
}
