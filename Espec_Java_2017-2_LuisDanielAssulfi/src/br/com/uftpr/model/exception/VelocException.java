package br.com.uftpr.model.exception;

public class VelocException extends Exception {
	private static final long serialVersionUID = 1L;

	public VelocException(String message) {
		super(message);
	}
	
	public VelocException(String message, Throwable cause) {
		super(message, cause);
	}
}
