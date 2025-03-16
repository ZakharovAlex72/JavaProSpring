package ru.zaharov.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.zaharov.dto.ErrorResponse;
import ru.zaharov.dto.NoDataFoundException;

@RestControllerAdvice
public class NoDataFoundExceptionHandler {
    @ExceptionHandler(NoDataFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handle(NoDataFoundException noDataFoundException){
        return new ErrorResponse(noDataFoundException.getMessage(),noDataFoundException.getCode());
    }
}
