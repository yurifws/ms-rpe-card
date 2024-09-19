package br.com.app.card.client;

import static br.com.app.card.constants.RestConstants.PATH_VARIABLE_ID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.app.card.configuration.ProductFeignConfig;
import br.com.app.card.model.ProductResponseModel;

@FeignClient(name = "ProductClient", configuration = ProductFeignConfig.class)
public interface ProductClient {

    @GetMapping(path = PATH_VARIABLE_ID)
    ProductResponseModel getProductById(Long id);
}
