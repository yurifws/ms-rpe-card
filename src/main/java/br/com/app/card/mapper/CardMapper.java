package br.com.app.card.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

import br.com.app.card.entity.CardEntity;
import br.com.app.card.model.CardRequestModel;
import br.com.app.card.model.CardResponseModel;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface CardMapper {

	CardMapper INSTANCE = Mappers.getMapper(CardMapper.class);

	@Mapping(target = "client.id", source = "clientId")
	@Mapping(target = "product.id", source = "productId")
	CardEntity toEntity(CardRequestModel cardRequestModel);
	
	CardResponseModel toResponseModel(CardEntity cardEntity);
	
}

