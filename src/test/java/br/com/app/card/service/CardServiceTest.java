package br.com.app.card.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.app.card.entity.CardEntity;
import br.com.app.card.model.ProductResponseModel;
import br.com.app.card.repository.CardRepository;
import br.com.app.card.testdata.CardEntityTestData;
import br.com.app.card.testdata.CardRequestModelTestData;
import br.com.app.card.testdata.ProductResponseModelTestData;

@SpringBootTest
class CardServiceTest {
	
	@Mock
	ProductService productService;
	
	@Mock
	CardRepository cardRepository;
	
	@InjectMocks
	CardService cardService;

	@Test
	void insert() {
		Long productId =12345L;
		ProductResponseModel productResponseModel = ProductResponseModelTestData.getProductResponseModel();
		CardEntity cardEntity = CardEntityTestData.getCardEntity();
		
		when(productService.getProductById(productId)).thenReturn(productResponseModel);
		when(cardRepository.save(cardEntity)).thenReturn(cardEntity);
		
		cardService.insert(CardRequestModelTestData.getCardRequestModel());
		
		verify(productService).getProductById(productId);
		verify(cardRepository).save(cardEntity);
		
	}

}
