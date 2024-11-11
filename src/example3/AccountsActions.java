package example3;

import java.util.Map;

public interface AccountsActions {
	public void withdrawMoney();

	public void plusAction();

	public void transferMoney(Map<Integer, Account> accountList);

	public boolean transferMoney(Map<Integer, Account> accountList, int money);

	public void accountInfo();

	public String simpleInfo();
}
