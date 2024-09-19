package br.com.app.card.model;

import java.time.LocalDateTime;

import br.com.app.card.enuns.StatusEnum;
import lombok.Data;

@Data
public class ProductResponseModel {
	
	private Long id;
	
	private String description;
	
	private StatusEnum status;
	
	private LocalDateTime dateCreated;
	
	private LocalDateTime dateUpdated;

}
