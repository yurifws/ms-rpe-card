package br.com.app.card.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import br.com.app.card.entity.CardEntity;
import br.com.app.card.model.CardRequestModel;
import br.com.app.card.model.CardResponseModel;
import br.com.app.card.testdata.CardEntityTestData;
import br.com.app.card.testdata.CardRequestModelTestData;

class CardMapperTest {


	@Test
	void toEntity(){
		
		CardRequestModel expected = CardRequestModelTestData.getCardRequestModel();
		CardEntity actual = CardMapper.INSTANCE.toEntity(expected);
		
		
		assertNotNull(actual);
		assertEquals(expected.getNumber(), actual.getNumber());
		assertEquals(expected.getPassword(), actual.getPassword());
		assertEquals(expected.getStatus(), actual.getStatus());
		assertEquals(expected.getHolderName(), actual.getHolderName());
		assertEquals(expected.getClientId(), actual.getClient().getId());
		assertEquals(expected.getProductId(), actual.getProduct().getId());
		
	}
	
	@Test
	void toResponseModel() {
		
		CardEntity expected = CardEntityTestData.getCardEntity();
		CardResponseModel actual = CardMapper.INSTANCE.toResponseModel(expected);
		
		assertNotNull(actual);
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getNumber(), actual.getNumber());
		assertEquals(expected.getPassword(), actual.getPassword());
		assertEquals(expected.getStatus(), actual.getStatus());
		assertEquals(expected.getHolderName(), actual.getHolderName());
		assertEquals(expected.getProduct().getId(), actual.getProduct().getId());
		assertEquals(expected.getDateCreated(), actual.getDateCreated());
		assertEquals(expected.getDateUpdated(), actual.getDateUpdated());
		
	}

}
