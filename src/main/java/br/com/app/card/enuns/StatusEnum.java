package br.com.app.card.enuns;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum StatusEnum {

	ATIVO("ATIVO"),
	BLOQUEADO("BLOQUEADO"),
	CANCELADO("CANCELADO");
	
	private final String value;
}
