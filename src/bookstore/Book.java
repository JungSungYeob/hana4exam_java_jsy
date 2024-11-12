package bookstore;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Book {
	private final String title;
	private final int price;
	private final String author;
	private final String desc;
	private final String type;
	private final Calendar date;

	public Book(String title, int price, String author, String desc, String type, Calendar date) {
		this.title = title;
		this.price = price;
		this.author = author;
		this.desc = desc;
		this.type = type;
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getDesc() {
		return desc;
	}

	public String getType() {
		return type;
	}

	public int getPrice() {
		return price;
	}

	public Calendar getDate() {
		return date;
	}

	public static String formattedDateSlash(Calendar date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		return sdf.format(date.getTime());
	}

	public static String formattedDateHyphen(Calendar date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date.getTime());
	}

	public String formattedPrice(int price) {
		DecimalFormat df = new DecimalFormat("#,###");
		return df.format(price) + "원";
	}

	@Override
	public String toString() {
		return "%s | %s | %s | %s | %s | %s".formatted(
			title, formattedPrice(this.price), author, desc, type, formattedDateSlash(this.date));
	}
}
