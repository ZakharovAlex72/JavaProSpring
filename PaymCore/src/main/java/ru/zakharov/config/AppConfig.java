package ru.zakharov.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
@EnableConfigurationProperties(IntegrationProperties.class)
public class AppConfig {

    private final IntegrationProperties integrationProperties;

    public AppConfig(IntegrationProperties integrationProperties) {
        this.integrationProperties = integrationProperties;
    }

    @Bean
    public RestTemplate paymentClient(RestTemplateResponseErrorHandler errorHandler){
        RestTemplateProperties properties = integrationProperties.getPaymentsClientProperties();
        return new RestTemplateBuilder()
                .rootUri(properties.getUri())
                .setConnectTimeout(properties.getConnectTimeout())
                .setReadTimeout(properties.getReadTimeout())
                .errorHandler(errorHandler)
                .build();

    }
}
