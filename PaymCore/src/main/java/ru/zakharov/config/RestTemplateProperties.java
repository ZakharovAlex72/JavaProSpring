package ru.zakharov.config;

import lombok.Getter;
import lombok.Setter;

import java.time.Duration;

@Setter
@Getter
public class RestTemplateProperties {
    private String uri;
    private Duration connectTimeout;
    private Duration readTimeout;

}
