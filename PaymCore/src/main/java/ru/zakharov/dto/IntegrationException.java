package ru.zakharov.dto;

public class IntegrationException extends RuntimeException  {
    private IntegrationErrorDto errorDto;

    public IntegrationException(IntegrationErrorDto errorDto) {
        this.errorDto = errorDto;
    }

    public IntegrationErrorDto getErrorDto() {
        return errorDto;
    }
}
