package br.com.app.card.testdata;

import br.com.app.card.enuns.StatusEnum;
import br.com.app.card.model.CardRequestModel;

public class CardRequestModelTestData {
	
	public static CardRequestModel getCardRequestModel() {
		CardRequestModel model = new CardRequestModel();
		model.setNumber("1231234");
		model.setPassword("password");
		model.setStatus(StatusEnum.ATIVO);
		model.setHolderName("holderName");
		model.setClientId(1234L);
		model.setProductId(12345L);
		return model;
	}
}
