package br.com.app.card.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.app.card.client.ProductClient;
import br.com.app.card.exception.BusinessException;
import br.com.app.card.model.ProductResponseModel;
import br.com.app.card.testdata.ProductResponseModelTestData;
import feign.FeignException.FeignClientException;

@SpringBootTest
class ProductServiceTest {

	@Mock
	ProductClient productClient;
	
	@InjectMocks
	ProductService productService;

	@Test
	void getProductById() {
		Long productId =12345L;
		when(productClient.getProductById(productId)).thenReturn(ProductResponseModelTestData.getProductResponseModel());

		ProductResponseModel actual = productService.getProductById(productId);
		
		verify(productClient).getProductById(productId);
		
		assertNotNull(actual);
	}
	
	@Test
	void getProductById_BusinessException() {
		Long productId =12345L;
		when(productClient.getProductById(productId)).thenThrow(FeignClientException.class);

		assertThrows(BusinessException.class, () -> productService.getProductById(productId)); 
		
		verify(productClient).getProductById(productId);
	}

}
