package br.com.app.card.enuns;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum StatusEnum {
	
	@JsonProperty("ATIVO")
	ATIVO("ATIVO"),
	@JsonProperty("BLOQUEADO")
	BLOQUEADO("BLOQUEADO"),
	@JsonProperty("CANCELADO")
	CANCELADO("CANCELADO");
	
	private final String value;
}
