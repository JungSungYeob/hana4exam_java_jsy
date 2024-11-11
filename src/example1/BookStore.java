package example1;

import java.util.Scanner;

import example1.exceptions.EmptyCartListException;
import example1.exceptions.InvalidInput;

public class BookStore {
	// private BookList bookList;
	private User user;

	public BookStore() {
		Scanner scanner = new Scanner(System.in);
		login(scanner);
	}

	private void login(Scanner scanner) {
		System.out.print("당신의 이름을 입력하세요: ");
		String name = scanner.nextLine();
		System.out.print("연락처를 입력하세요: ");
		String phoneNum = scanner.nextLine();
		user = new User(name, phoneNum);
		// System.out.println(user.getUserInfo());
		bookStoreSystem(scanner);
	}

	private int menu(Scanner scanner) {
		System.out.println("\t***********************************");
		System.out.print("\t오늘의 선택, 코난문고\n\t영원한 스테디셀러, 명탐정 코난시리즈를 만나보세요!\n");
		System.out.println("\t***********************************");
		System.out.print(
			"\t1. 고객 정보 확인하기 2. 장바구니 상품 목록 보기\n\t3. 바구니에 항목 추가하기 4. 장바구니의 항목 삭제하기\n\t5. 장바구니 비우기 6. 영수증 표시하기 7. 종료\n");
		System.out.println("\t***********************************");
		System.out.print("메뉴 번호를 선택해주세요 ");
		return scanner.nextInt();
	}

	private void bookStoreSystem(Scanner scanner) {
		int selected = 0;
		while (true) {
			selected = menu(scanner);
			scanner.nextLine();
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
						user.addCart(scanner);
						break;
					}
					case 4: {
						user.deleteCart(scanner);
						break;
					}
					case 5: {
						user.deleteAll();
						break;
					}
					case 6: {
						user.printRecipe(scanner);
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
