package example1;

import java.util.Calendar;

public class Cart extends Book {
	private int cnt;

	public Cart(String title, int price, String author, String desc, String type, Calendar date) {
		super(title, price, author, desc, type, date);
		this.cnt = 1;
	}

	public void addCnt() {
		this.cnt += 1;
	}

	public int getCnt() {
		return cnt;
	}
}
