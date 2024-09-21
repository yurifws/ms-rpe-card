package br.com.app.card.model;

import br.com.app.card.enuns.StatusEnum;
import lombok.Data;

@Data
public class CardRequestModel {
	
    private String number;
    
    private String password;
    
    private StatusEnum status;
    
    private String holderName;
    
    private Long clientId;
    
    private Long productId;
	
}
