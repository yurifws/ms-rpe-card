package br.com.app.card.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

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
		assertEquals(expected.getDateCreated(), actual.getDateCreated());
		assertEquals(expected.getDateUpdated(), actual.getDateUpdated());
		assertEquals(expected.getProduct().getId(), actual.getProduct().getId());
		assertEquals(expected.getProduct().getDescription(), actual.getProduct().getDescription());
		assertEquals(expected.getProduct().getStatus(), actual.getProduct().getStatus());
		assertEquals(expected.getProduct().getDateCreated(), actual.getProduct().getDateCreated());
		assertEquals(expected.getProduct().getDateUpdated(), actual.getProduct().getDateUpdated());
		
	}
	
	@Test
	void toResponseModel_List() {
		
		CardEntity expected = CardEntityTestData.getCardEntity();
		List<CardResponseModel> response = CardMapper.INSTANCE.toResponseModel(List.of(expected));
		
		CardResponseModel actual = response.get(0);
		assertNotNull(actual);
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getNumber(), actual.getNumber());
		assertEquals(expected.getPassword(), actual.getPassword());
		assertEquals(expected.getStatus(), actual.getStatus());
		assertEquals(expected.getHolderName(), actual.getHolderName());
		assertEquals(expected.getDateCreated(), actual.getDateCreated());
		assertEquals(expected.getDateUpdated(), actual.getDateUpdated());
		assertEquals(expected.getProduct().getId(), actual.getProduct().getId());
		assertEquals(expected.getProduct().getDescription(), actual.getProduct().getDescription());
		assertEquals(expected.getProduct().getStatus(), actual.getProduct().getStatus());
		assertEquals(expected.getProduct().getDateCreated(), actual.getProduct().getDateCreated());
		assertEquals(expected.getProduct().getDateUpdated(), actual.getProduct().getDateUpdated());
		
	}

}
