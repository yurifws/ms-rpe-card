package br.com.app.card.entrypoint.controller;

import static br.com.app.card.constants.RestConstants.PATH_CARDS;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import br.com.app.card.model.CardResponseModel;
import br.com.app.card.service.ICardService;
import br.com.app.card.testdata.CardResponseModelTestData;

@WebMvcTest(CardController.class)
class CardControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	ICardService cardService;

	@Test
	void findByClientId() throws Exception {

		Long clientId = 1234L;
		CardResponseModel expected = CardResponseModelTestData.getCardResponseModel();
		
		when(cardService.findByClientId(clientId)).thenReturn(List.of(expected));
		
		mockMvc.perform(MockMvcRequestBuilders.get(PATH_CARDS)
				.param("clientId", String.valueOf(clientId))
				.contentType(MediaType.APPLICATION_JSON_VALUE))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$[0].id").value(expected.getId()))
		.andExpect(jsonPath("$[0].number").value(expected.getNumber()))
		.andExpect(jsonPath("$[0].password").value(expected.getPassword()))
		.andExpect(jsonPath("$[0].status").value(expected.getStatus().name()))
		.andExpect(jsonPath("$[0].holderName").value(expected.getHolderName()))
		.andExpect(jsonPath("$[0].dateCreated").value(expected.getDateCreated().toString()))
		.andExpect(jsonPath("$[0].dateUpdated").value(expected.getDateUpdated().toString()))
		.andExpect(jsonPath("$[0].product.id").value(expected.getProduct().getId()))
		.andExpect(jsonPath("$[0].product.description").value(expected.getProduct().getDescription()))
		.andExpect(jsonPath("$[0].product.status").value(expected.getProduct().getStatus().name()))
		.andExpect(jsonPath("$[0].product.dateCreated").value(expected.getProduct().getDateCreated().toString()))
		.andExpect(jsonPath("$[0].product.dateUpdated").value(expected.getProduct().getDateUpdated().toString()));
		
		verify(cardService).findByClientId(clientId);
	}

}
