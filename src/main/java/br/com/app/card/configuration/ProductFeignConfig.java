package br.com.app.card.configuration;

import org.springframework.beans.factory.annotation.Value;

import br.com.app.card.client.ProductClient;
import feign.Feign;

//@Configuration
public class ProductFeignConfig {

    @Value("${feign.client.config.product-service.url}")
    private String productServiceUrl;

  //  @Bean
    ProductClient productClient() {
        return Feign.builder()
                .target(ProductClient.class, productServiceUrl);
    }
}