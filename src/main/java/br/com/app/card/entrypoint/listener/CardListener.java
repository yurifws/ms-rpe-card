package br.com.app.card.entrypoint.listener;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.app.card.exception.ReadMessageException;
import br.com.app.card.model.CardRequestModel;
import br.com.app.card.service.ICardService;
import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CardListener {
	
	private final ICardService cardService;
	
	private volatile boolean keepProcessing = true;

	public void stopProcessing(String message) {
		log.info("Registro de fila parado! {}");
	    keepProcessing = false;
	}
	
	@SqsListener("${spring.cloud.aws.sqs.queue.name}")
	public void onMessage(String message) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			if (!keepProcessing) {
	            return; 
	        }
			log.info("Mesagem recebida com sucesso! {}", message);
			cardService.insert(objectMapper.readValue(message, CardRequestModel.class));
		}catch (Exception ex) {
			stopProcessing(message);
			throw new ReadMessageException(ex);
		}
	}

}
