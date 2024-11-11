package example1;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import example1.exceptions.EmptyCartListException;
import example1.exceptions.InvalidInput;

public class User {
	private final String name;
	private final String phoneNum;
	private final BookList bookList = new BookList();
	private final HashMap<String, Cart> cartList = new HashMap<String, Cart>();

	public User(String name, String phoneNum) {
		this.name = name;
		this.phoneNum = phoneNum;
	}

	public String getUserInfo() {
		return "현재 고객 정보\n이름: %s\n연락처: %s\n".formatted(this.name, this.phoneNum);
	}

	public void getCartList() {
		if (cartList.isEmpty()) {
			throw new EmptyCartListException();
		}
		System.out.printf("%-20s\t |\t %-16s\t |\t %-20s\n", "도서 ID", "수량", "합계");
		for (Map.Entry<String, Cart> cart : cartList.entrySet()) {
			// System.out.println(""cart.getKey() + " " + cart.getValue().getCnt());
			int total = cart.getValue().getCnt() * cart.getValue().getPrice();
			System.out.printf("%-20s\t |\t %-16d\t |\t %-20s\n", cart.getKey(), cart.getValue().getCnt(),
				cart.getValue().formattedPrice(total));
		}
	}

	public void addCart(Scanner scanner) {
		// BookList bookList = new BookList();
		bookList.getBookList();
		System.out.print("장바구니에 추가할 도서의 ID를 입력하세요 : ");
		String bookId = scanner.next();
		Book book = bookList.findBook(bookId);
		if (book == null) {
			throw new InvalidInput();
		}
		System.out.println("장바구니에 추가하겠습니까? Y | N");
		String check = scanner.next();
		if (check.equalsIgnoreCase("Y")) {
			//이미 있는지 찾고
			//있으면 addCnt 없으면 add new
			if (this.cartList.containsKey(bookId)) {
				this.cartList.get(bookId).addCnt();
				return;
			}
			this.cartList.put(bookId,
				new Cart(book.getTitle(), book.getPrice(), book.getAuthor(), book.getDesc(), book.getType(),
					book.getDate()));
			return;
		} else if (check.equalsIgnoreCase("N")) {
			return;
		} else {
			throw new InvalidInput();
		}
	}

	public void deleteCart(Scanner scanner) {
		if (cartList.isEmpty()) {
			throw new EmptyCartListException();
		}
		System.out.println("장바구니 상품 목록:");
		System.out.println("--------------------------------------------------------------");
		getCartList();
		System.out.println("--------------------------------------------------------------");
		System.out.print("장바구니에서 삭제할 도서의 ID를 입력하세요: ");
		String bookId = scanner.next();
		Book book = bookList.findBook(bookId);
		if (book == null) {
			throw new InvalidInput();
		}
		cartList.remove(bookId);
		System.out.printf("장바구니에서 %s가 삭제되었습니다.\n", bookId);
	}

	public void deleteAll() {
		if (cartList.isEmpty()) {
			throw new EmptyCartListException();
		}
		System.out.println("모든 장바구니 목록을 삭제합니다.");
		cartList.clear();
	}

	public void printRecipe(Scanner scanner) {
		if (cartList.isEmpty()) {
			throw new EmptyCartListException();
		}
		System.out.print("배송받을 분은 고객정보와 같습니까? Y | N ");
		String check = scanner.nextLine();
		String name;
		String phoneNum;
		String destination;

		if (check.equalsIgnoreCase("Y")) {
			name = this.name;
			phoneNum = this.phoneNum;
		} else if (check.equalsIgnoreCase("N")) {
			System.out.print("고객의 이름을 입력하세요: ");
			name = scanner.nextLine();
			System.out.print("연락처를 입력하세요: ");
			phoneNum = scanner.nextLine();
		} else {
			throw new InvalidInput();
		}

		System.out.print("배송지를 입력해주세요 ");
		destination = scanner.nextLine();

		Calendar calendar = Calendar.getInstance();
		String now = Book.formattedDateHyphen(calendar);
		System.out.println("-------------배송 받을 고객 정보-------------");
		System.out.printf("고객명: %-20s 연락처: %-20s\n", name, phoneNum);
		System.out.printf("배송지: %-20s 발송일: %-20s\n", destination, now);

		System.out.println("장바구니 상품 목록:");
		System.out.println("--------------------------------------------------------------");
		getCartList();
		System.out.println("--------------------------------------------------------------");
	}
}
