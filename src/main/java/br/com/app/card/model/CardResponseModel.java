package br.com.app.card.model;

import java.time.LocalDateTime;

import br.com.app.card.enuns.StatusEnum;
import lombok.Data;

@Data
public class CardResponseModel {
	
    private Long id;
    
    private String number;

    private String password;

    private StatusEnum cardStatus;

    private String holderName;

    private LocalDateTime dateCreated;

    private LocalDateTime dateUpdated;

    private ClientResponseModel client;

    private ProductResponseModel product;

}
