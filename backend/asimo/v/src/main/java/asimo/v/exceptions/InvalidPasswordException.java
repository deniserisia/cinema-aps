package asimo.v.exceptions;

public class InvalidPasswordException extends RuntimeException {

	private static final long serialVersionUID = -4334828590954272274L;

	public InvalidPasswordException() {
	}

	public InvalidPasswordException(String message) {
		super(message);
	}

	public InvalidPasswordException(Throwable cause) {
		super(cause);
	}

	public InvalidPasswordException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidPasswordException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
