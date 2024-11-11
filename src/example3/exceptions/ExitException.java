package example3.exceptions;

public class ExitException extends RuntimeException {
	public ExitException(String message) {
		super(message);
	}

	public ExitException() {
		super("\t뒤로가기");
	}
}
