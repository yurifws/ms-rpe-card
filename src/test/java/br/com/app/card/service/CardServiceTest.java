package br.com.app.card.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.app.card.entity.CardEntity;
import br.com.app.card.exception.CardNumberAlreadyExistsException;
import br.com.app.card.model.CardRequestModel;
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
		cardEntity.setDateCreated(null);
		cardEntity.setDateUpdated(null);
		CardRequestModel cardRequestModel = CardRequestModelTestData.getCardRequestModel();

		when(productService.getProductById(productId)).thenReturn(productResponseModel);
		when(cardRepository.existsByNumber(cardRequestModel.getNumber())).thenReturn(false);
		when(cardRepository.save(cardEntity)).thenReturn(cardEntity);

		cardService.insert(cardRequestModel);

		verify(productService).getProductById(productId);
		verify(cardRepository).existsByNumber(cardRequestModel.getNumber());
		verify(cardRepository).save(cardEntity);

	}

	@Test
	void insert_throwCardNumberAlreadyExistsException() {
		Long productId =12345L;
		ProductResponseModel productResponseModel = ProductResponseModelTestData.getProductResponseModel();
		CardEntity cardEntity = CardEntityTestData.getCardEntity();
		cardEntity.setDateCreated(null);
		cardEntity.setDateUpdated(null);
		CardRequestModel cardRequestModel = CardRequestModelTestData.getCardRequestModel();

		when(productService.getProductById(productId)).thenReturn(productResponseModel);
		when(cardRepository.existsByNumber(cardRequestModel.getNumber())).thenReturn(true);
		when(cardRepository.save(cardEntity)).thenReturn(cardEntity);

		assertThrows(CardNumberAlreadyExistsException.class,() -> cardService.insert(cardRequestModel));

		verify(productService).getProductById(productId);
		verify(cardRepository).existsByNumber(cardRequestModel.getNumber());
		verify(cardRepository, times(0)).save(cardEntity);

	}

	@Test
	void findByClientId() {
		Long clientId = 1234L;

		when(cardRepository.findByClientId(clientId)).thenReturn(List.of(CardEntityTestData.getCardEntity()));


		cardService.findByClientId(clientId);
		verify(cardRepository).findByClientId(clientId);
	}

	@Test
	void findByClientId_isEmpty() {
		Long clientId = 1234L;

		when(cardRepository.findByClientId(clientId)).thenReturn(new  ArrayList<>());

		cardService.findByClientId(clientId);

		verify(cardRepository).findByClientId(clientId);
	}

}
