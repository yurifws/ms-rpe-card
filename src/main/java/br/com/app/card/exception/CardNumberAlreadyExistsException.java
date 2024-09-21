package br.com.app.card.exception;

public class CardNumberAlreadyExistsException extends BusinessException {
	
	private static final long serialVersionUID = 4246307386773054821L;
	
	private static final String MSG_CARD_NUMBER_ALREADY_EXISTS = "Já existe um cadastro de cartão para o numero %s";

	public CardNumberAlreadyExistsException(String number) {
		super(String.format(MSG_CARD_NUMBER_ALREADY_EXISTS, number));
	}
}
