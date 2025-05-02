package com.ivanizv.postgresql.backend.controller;

import com.ivanizv.postgresql.backend.exception.RandomException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    private static final Logger log = LoggerFactory.getLogger(ErrorHandler.class);


    @ExceptionHandler(RandomException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handlerRandomException(RandomException exception) {

        var errorMessage = "BAD_REQUEST (ПЛОХОЙ ЗАПРОС), потому что: " + exception.getMessage();

        log.error(errorMessage, exception);

        return errorMessage;

    }


    @ExceptionHandler(DataAccessException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handlerPersistenceException(Exception exception) {

        var errorMessage = "INTERNAL_SERVER_ERROR (ВНУТРЕННЯЯ ОШИБКА СЕРВЕРА), потому что: " + exception.getMessage();

        log.error(errorMessage, exception);

        return errorMessage;

    }

}
