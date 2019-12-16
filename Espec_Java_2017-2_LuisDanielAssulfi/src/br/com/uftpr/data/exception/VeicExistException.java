package br.com.uftpr.data.exception;

public class VeicExistException extends Exception {
	private static final long serialVersionUID = 1L;

	public VeicExistException(String message) {
		super(message);
	}
	
	public VeicExistException(String message, Throwable cause) {
		super(message, cause);
	}
}
