package br.com.app.card.entrypoint.controller;

import static br.com.app.card.constants.RestConstants.PATH_CARDS;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.app.card.model.CardResponseModel;
import br.com.app.card.service.ICardService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = PATH_CARDS, produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class CardController {
	
	private final ICardService cardService;

	@GetMapping
	public ResponseEntity<CardResponseModel> findByClientId(@RequestParam Long clientId) {
		return ResponseEntity.ok(cardService.findByClientId(clientId));
	}
}
