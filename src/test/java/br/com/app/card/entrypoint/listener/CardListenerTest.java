package br.com.app.card.entrypoint.listener;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.app.card.exception.ReadMessageException;
import br.com.app.card.model.CardRequestModel;
import br.com.app.card.service.ICardService;
import br.com.app.card.testdata.CardRequestModelTestData;

@SpringBootTest
class CardListenerTest {

	@Mock
	ICardService cardService;
	
	@InjectMocks
	CardListener cardListener;
	
	@Test
	void onMessage() {
		String message = """
				{
					"number": "1231234",
					"password": "password",
					"status": "ATIVO",
					"holderName": "holderName",
					"clientId": 1234,
					"productId": 12345
				}
				""";
		CardRequestModel cardRequestModel = CardRequestModelTestData.getCardRequestModel();
		doNothing().when(cardService).insert(cardRequestModel);
		
		cardListener.onMessage(message);
		
		verify(cardService).insert(cardRequestModel);
		
	}
	
	@Test
	void onMessage_thenThrowReadMessageException() {
		String message = """
				{
				    ---------JSON INVALIDO--------
				    
					"number": "1231234", 
					"password": "password",
					"status": "ATIVO",
					"holderName": "holderName",
					"clientId": 1234,
					"productId": 12345
				}
				""";
		CardRequestModel cardRequestModel = CardRequestModelTestData.getCardRequestModel();
		
		assertThrows(ReadMessageException.class, () -> cardListener.onMessage(message)); 
		
		verify(cardService, times(0)).insert(cardRequestModel);
		
	}

}
