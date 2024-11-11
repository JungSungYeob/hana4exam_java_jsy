package example3.exceptions;

public class TermCompleteException extends RuntimeException {
	public TermCompleteException(String message) {
		super(message);
	}

	public TermCompleteException() {
		super("");
	}
}
