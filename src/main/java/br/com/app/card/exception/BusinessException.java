package br.com.app.card.exception;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 4079070137141015772L;

	public BusinessException(String message){
		super(message);
	}
	
	public BusinessException(String message, Throwable cause){
		super(message, cause);
	}

}
