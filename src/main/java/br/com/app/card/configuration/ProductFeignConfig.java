package br.com.app.card.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClientFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductFeignConfig {

    @Value("${feign.client.config.product-service.url}")
    private String productServiceUrl;

    @Bean
    public FeignClientFactoryBean feignClientFactoryBean() {
        FeignClientFactoryBean factoryBean = new FeignClientFactoryBean();
        factoryBean.setUrl(productServiceUrl);
        return factoryBean;
    }
}