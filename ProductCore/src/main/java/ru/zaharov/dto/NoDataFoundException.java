package ru.zaharov.dto;

import jakarta.persistence.EntityNotFoundException;

public class NoDataFoundException extends EntityNotFoundException {
    private final String code;

    public NoDataFoundException(String message,String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
