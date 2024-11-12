package hanabank.exceptions;

public class InvalidInputException extends RuntimeException {
	public InvalidInputException(String message) {
		super(message);
	}

	public InvalidInputException() {
		super("\t유효하지 않은 입력입니다.");
	}
}
