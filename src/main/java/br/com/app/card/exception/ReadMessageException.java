package br.com.app.card.exception;

public class ReadMessageException extends RuntimeException {

	private static final long serialVersionUID = 4624233082213416250L;
	
	private static final String MSG_READ_MESSAGE_ERROR = "Erro ao tentar ler a mensagem da fila! %s";

	public ReadMessageException(Throwable ex) {
		super(String.format(MSG_READ_MESSAGE_ERROR, ex.getMessage()));
	}

}
