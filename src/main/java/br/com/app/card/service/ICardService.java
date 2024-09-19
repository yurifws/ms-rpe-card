package br.com.app.card.service;

import br.com.app.card.model.CardRequestModel;
import br.com.app.card.model.CardResponseModel;

public interface ICardService {

	CardResponseModel insert(CardRequestModel cardRequestModel);
}
 