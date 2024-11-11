package example1.exceptions;

public class InvalidInput extends RuntimeException {
	public InvalidInput(String message) {
		super(message);
	}

	public InvalidInput() {
		super("유효하지 않은 입력입니다.");
	}
}
