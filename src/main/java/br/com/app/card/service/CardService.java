package br.com.app.card.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.app.card.exception.ClientDoesNotHaveCardException;
import br.com.app.card.mapper.CardMapper;
import br.com.app.card.model.CardRequestModel;
import br.com.app.card.model.CardResponseModel;
import br.com.app.card.model.ProductResponseModel;
import br.com.app.card.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CardService implements ICardService {
	
	private final ProductService productService;
	private final CardRepository cardRepository;

	@Transactional
	@Override
	public void insert(CardRequestModel cardRequestModel) {
		
		validateIfFindProductById(cardRequestModel);
		
		cardRepository.save(CardMapper.INSTANCE.toEntity(cardRequestModel));
		
		log.info("Cadastro de cartão realizado com sucesso!");
	}

	private ProductResponseModel validateIfFindProductById(CardRequestModel cardRequestModel) {
		return productService.getProductById(cardRequestModel.getProductId());
	}

	@Override
	public CardResponseModel findByClientId(Long clientId) {
		return CardMapper.INSTANCE.toResponseModel(
				cardRepository.findByClientId(clientId)
				.orElseThrow(() -> new ClientDoesNotHaveCardException(clientId)));

	}

}
