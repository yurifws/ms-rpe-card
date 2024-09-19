package br.com.app.card.testdata;

import br.com.app.card.entity.CardEntity;
import br.com.app.card.entity.ClientEntity;
import br.com.app.card.entity.ProductEntity;
import br.com.app.card.enuns.StatusEnum;

public class CardEntityTestData {
	
	public static CardEntity getCardEntity() {
		CardEntity model = new CardEntity();
		model.setNumber("1231234");
		model.setPassword("password");
		model.setStatus(StatusEnum.ATIVO);
		model.setHolderName("holderName");
		model.setClient(getClientEntity());
		model.setProduct(getProductEntity());
		return model;
	}

	private static ClientEntity getClientEntity() {
		ClientEntity clientEntity = new ClientEntity();
		clientEntity.setId(1234L);
		return clientEntity;
	}
	
	private static ProductEntity getProductEntity() {
		ProductEntity productEntity = new ProductEntity();
		productEntity.setId(12345L);
		return productEntity;
	}

}
