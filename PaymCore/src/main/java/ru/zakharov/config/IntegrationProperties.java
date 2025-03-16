package ru.zakharov.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;


@ConfigurationProperties(prefix = "integration.clients")
public class IntegrationProperties {
    private final RestTemplateProperties paymentsClient;

    @ConstructorBinding
    public IntegrationProperties(RestTemplateProperties paymentsClient) {
        this.paymentsClient = paymentsClient;
    }

    public RestTemplateProperties getPaymentsClientProperties() {
        return paymentsClient;
    }
}
