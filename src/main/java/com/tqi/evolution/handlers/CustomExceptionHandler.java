package com.tqi.evolution.handlers;

import com.tqi.evolution.dtos.ExceptionDTO;
import com.tqi.evolution.exceptions.BusinessException;
import com.tqi.evolution.exceptions.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {BusinessException.class})
    public ResponseEntity<ExceptionDTO> businessExceptionHandler(BusinessException exception, WebRequest request) {
        return new ResponseEntity<>(new ExceptionDTO(exception.getClass().getName(), exception.getMessage())
                , HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<ExceptionDTO> entityNotFoundExceptionHandler(EntityNotFoundException exception, WebRequest request) {
        return new ResponseEntity<>(new ExceptionDTO(exception.getClass().getName(), exception.getMessage())
                , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {AuthenticationException.class})
    public ResponseEntity<ExceptionDTO> entityNotFoundExceptionHandler(AuthenticationException exception, WebRequest request) {
        return new ResponseEntity<>(new ExceptionDTO(exception.getClass().getName(), exception.getMessage())
                , HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = {DataIntegrityViolationException.class})
    public ResponseEntity<ExceptionDTO> entityNotFoundExceptionHandler(RuntimeException exception, WebRequest request) {
        return new ResponseEntity<>(new ExceptionDTO(exception.getClass().getName(), exception.getLocalizedMessage())
                , HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
