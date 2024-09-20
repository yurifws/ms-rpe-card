package br.com.app.card.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.app.card.entity.CardEntity;

@Repository
public interface CardRepository extends JpaRepository<CardEntity, Long>{
	
	Optional<CardEntity> findByClientId(Long clientId);

}
