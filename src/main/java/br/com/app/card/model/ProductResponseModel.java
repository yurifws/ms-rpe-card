package br.com.app.card.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import br.com.app.card.enuns.StatusEnum;
import lombok.Data;

@Data
public class ProductResponseModel implements Serializable {
	
	private static final long serialVersionUID = 8766784247396672766L;

	private Long id;
	
	private String description;
	
	private StatusEnum status;
	
	private LocalDateTime dateCreated;
	
	private LocalDateTime dateUpdated;

}
