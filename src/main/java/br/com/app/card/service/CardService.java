package br.com.app.card.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.app.card.exception.CardNumberAlreadyExistsException;
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
		
		validateIfFindProductById(cardRequestModel.getProductId());
		validateIfNumberExists(cardRequestModel.getNumber());
		
		cardRepository.save(CardMapper.INSTANCE.toEntity(cardRequestModel));
		
		log.info("Cadastro de cartão realizado com sucesso!");
	}

	private ProductResponseModel validateIfFindProductById(Long productId) {
		return productService.getProductById(productId);
	}
	
	private void validateIfNumberExists(String number) {
		if(cardRepository.existsByNumber(number)) {
			throw new CardNumberAlreadyExistsException(number);
		}
	}

	@Override
	public List<CardResponseModel> findByClientId(Long clientId) {
		return CardMapper.INSTANCE.toResponseModel(
				cardRepository.findByClientId(clientId));
				//.orElseThrow(() -> new ClientDoesNotHaveCardException(clientId)));

	}

}
