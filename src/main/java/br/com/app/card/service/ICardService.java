package br.com.app.card.service;

import br.com.app.card.model.CardRequestModel;
import br.com.app.card.model.CardResponseModel;

public interface ICardService {

	void insert(CardRequestModel cardRequestModel);
	CardResponseModel findByClientId(Long clientId);
}
 