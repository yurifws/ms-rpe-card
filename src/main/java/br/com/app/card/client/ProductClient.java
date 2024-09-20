package br.com.app.card.client;

import static br.com.app.card.constants.RestConstants.PATH_VARIABLE_ID;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.app.card.model.ProductResponseModel;

@FeignClient(name = "productClient", url = "${feign.client.config.product-service.url}")
public interface ProductClient {

    @Cacheable(value = "getProductById", key = "#id")
    @GetMapping(path = PATH_VARIABLE_ID)
    ProductResponseModel getProductById(@PathVariable Long id);
}
