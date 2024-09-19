package br.com.app.card.entrypoint.listener;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.app.card.exception.ReadMessageException;
import br.com.app.card.model.CardRequestModel;
import br.com.app.card.service.CardService;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CardListener {
	
	private final CardService cardService;
	
	@SqsListener("${aws.sqs.queue.name}")
	public void onMessage(String message) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			cardService.insert(objectMapper.readValue(message, CardRequestModel.class));
		}catch (Exception e) {
			throw new ReadMessageException();
		}
	}

}
