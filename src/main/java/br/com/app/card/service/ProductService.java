package br.com.app.card.service;

import org.springframework.stereotype.Service;

import br.com.app.card.client.ProductClient;
import br.com.app.card.exception.BusinessException;
import br.com.app.card.model.ProductResponseModel;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {
	
	private final ProductClient productClient;

	@Override
	public ProductResponseModel getProductById(Long id) {
		try {
			return productClient.getProductById(id);
		}catch (Exception ex) {
			throw new BusinessException(ex.getMessage(), ex);
		}
	}

}
