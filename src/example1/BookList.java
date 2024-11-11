package example1;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class BookList {
	private final HashMap<String, Book> bookList;

	public BookList() {
		bookList = new HashMap<String, Book>();
		Calendar calendar = Calendar.getInstance();
		calendar.set(2018, Calendar.OCTOBER, 8);
		bookList.put("ISBN1234",
			new Book("셜록홈즈", 20000, "코난도일", "그 누구도 뛰어넘지 못했던 추리 소설의 고전", "추리소설",
				(Calendar)calendar.clone()));
		calendar.set(2022, Calendar.JANUARY, 22);
		bookList.put("ISBN2345",
			new Book("도리안 그레이의 초상", 16000, "오스카 와일드", "예술을 위한 예술!", "고전소설",
				(Calendar)calendar.clone()));
		calendar.set(2019, Calendar.JULY, 10);
		bookList.put("ISBN3456",
			new Book("쥐덫", 27000, "애거서 크리스티", "폭설 소게 갇힌 몽스웰 여관 - 네 명의 손님과 주인 부부, 그리고 한 명의 형사", "추리소설",
				(Calendar)calendar.clone()));
	}

	public void getBookList() {
		for (Map.Entry<String, Book> book : bookList.entrySet()) {
			System.out.println(book.getKey() + " | " + book.getValue().toString());
		}
	}

	public Book findBook(String bookId) {
		return bookList.get(bookId);
	}
}
