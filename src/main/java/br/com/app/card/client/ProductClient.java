package br.com.app.card.client;

import static br.com.app.card.constants.RestConstants.PATH_VARIABLE_ID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.app.card.configuration.ProductFeignConfig;
import br.com.app.card.model.ProductResponseModel;

//@FeignClient(name = "productClient", configuration = ProductFeignConfig.class)
@FeignClient(name = "productClient", url = "${feign.client.config.product-service.url}")
public interface ProductClient {

    @GetMapping(path = PATH_VARIABLE_ID)
    ProductResponseModel getProductById(@RequestParam("id") Long id);
}
