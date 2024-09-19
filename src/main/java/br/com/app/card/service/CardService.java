package br.com.app.card.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.app.card.mapper.CardMapper;
import br.com.app.card.model.CardRequestModel;
import br.com.app.card.model.CardResponseModel;
import br.com.app.card.model.ProductResponseModel;
import br.com.app.card.repository.CardRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CardService implements ICardService {
	
	private final ProductService productService;
	private final CardRepository cardRepository;

	@Transactional
	@Override
	public CardResponseModel insert(CardRequestModel cardRequestModel) {
		
		validateIfFindProductById(cardRequestModel);
		
		return CardMapper.INSTANCE.toResponseModel(
				cardRepository.save(CardMapper.INSTANCE.toEntity(cardRequestModel)));
	}

	private ProductResponseModel validateIfFindProductById(CardRequestModel cardRequestModel) {
		return productService.getProductById(cardRequestModel.getProductId());
	}

}
