package bookstore.exceptions;

public class EmptyCartListException extends RuntimeException {
	public EmptyCartListException(String message) {
		super(message);
	}

	public EmptyCartListException() {
		super("장바구니가 비어있습니다.");
	}
}
