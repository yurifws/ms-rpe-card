package br.com.app.card.exception;

public abstract class EntityNotFoundException extends BusinessException {

	private static final long serialVersionUID = 484655831911059013L;

	public EntityNotFoundException(String message){
		super(message);
	}
}
