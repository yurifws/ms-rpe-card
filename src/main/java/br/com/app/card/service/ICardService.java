package br.com.app.card.service;

import java.util.List;

import br.com.app.card.model.CardRequestModel;
import br.com.app.card.model.CardResponseModel;

public interface ICardService {

	void insert(CardRequestModel cardRequestModel);
	List<CardResponseModel> findByClientId(Long clientId);
}
 