package bookstore;

import java.util.Scanner;

import bookstore.exceptions.EmptyCartListException;
import bookstore.exceptions.InvalidInput;

public class BookStore {
	private User user;
	private final Scanner scanner = new Scanner(System.in);
	private final BookList bookList;

	public BookStore() {
		bookList = new BookList();
	}

	private void login() {
		System.out.print("당신의 이름을 입력하세요: ");
		String name = scanner.nextLine();
		System.out.print("연락처를 입력하세요: ");
		String phoneNum = scanner.nextLine();
		user = new User(name, phoneNum);
		// System.out.println(user.getUserInfo());
		// bookStoreSystem(this.scanner);
	}

	private int menu() {
		System.out.println("\t***********************************");
		System.out.print("\t오늘의 선택, 코난문고\n\t영원한 스테디셀러, 명탐정 코난시리즈를 만나보세요!\n");
		System.out.println("\t***********************************");
		System.out.print(
			"\t1. 고객 정보 확인하기 2. 장바구니 상품 목록 보기\n\t3. 바구니에 항목 추가하기 4. 장바구니의 항목 삭제하기\n\t5. 장바구니 비우기 6. 영수증 표시하기 7. 종료\n");
		System.out.println("\t***********************************");
		System.out.print("메뉴 번호를 선택해주세요 ");
		return this.scanner.nextInt();
	}

	public void bookStoreSystem() {
		login();
		int selected = 0;
		while (true) {
			selected = menu();
			this.scanner.nextLine();
			try {
				switch (selected) {
					case 1: {
						System.out.println(user.getUserInfo());
						break;
					}
					case 2: {
						user.getCartList();
						break;
					}
					case 3: {
						// bookList.getBookList();
						user.addCart(bookList);
						break;
					}
					case 4: {
						user.deleteCart(bookList);
						break;
					}
					case 5: {
						user.deleteAll();
						break;
					}
					case 6: {
						user.printRecipe();
						break;
					}
					case 7: {
						System.out.println("시스템을 종료합니다.");
						return;
					}
					default:
						throw new InvalidInput();
				}
			} catch (EmptyCartListException | InvalidInput e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
