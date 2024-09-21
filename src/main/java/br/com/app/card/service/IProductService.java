package br.com.app.card.service;

import br.com.app.card.model.ProductResponseModel;

public interface IProductService {

	ProductResponseModel getProductById(Long id);  
}
 