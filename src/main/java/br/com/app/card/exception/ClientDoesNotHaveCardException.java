package br.com.app.card.exception;

public class ClientDoesNotHaveCardException extends BusinessException {
	
	private static final long serialVersionUID = -5028651843589379753L;
	
	private static final String MSG_CLIENT_DOES_NOT_HAVE_CARD = "Não existe um cadastro de cartão para o cliente com código %d";

	public ClientDoesNotHaveCardException(String mensagem) {
		super(mensagem);
	}

	public ClientDoesNotHaveCardException(Long clientId) {
		this(String.format(MSG_CLIENT_DOES_NOT_HAVE_CARD, clientId));
	}
}
