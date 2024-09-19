package br.com.app.card.testdata;

import static br.com.app.card.testdata.ClientResponseModelTestData.getClientResponseModel;
import static br.com.app.card.testdata.ProductResponseModelTestData.getProductResponseModel;

import br.com.app.card.enuns.StatusEnum;
import br.com.app.card.model.CardResponseModel;

public class CardResponseModelTestData {
	
	public static CardResponseModel getCardRequestModel() {
		CardResponseModel model = new CardResponseModel();
		model.setNumber("1231234");
		model.setPassword("password");
		model.setStatus(StatusEnum.ATIVO);
		model.setHolderName("holderName");
		model.setClient(getClientResponseModel());
		model.setProduct(getProductResponseModel());
		return model;
	}
}
