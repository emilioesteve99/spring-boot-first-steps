package com.example.crud.shared.infrastructure.http.exceptionHandler;

import com.example.crud.shared.domain.exception.ForeignKeyConflictException;
import com.example.crud.shared.domain.exception.UnknownException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ForeignKeyConflictException.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  public String handleForeignKeyConflict(ForeignKeyConflictException ex) {
    return ex.getMessage();
  }

  @ExceptionHandler(UnknownException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public String handleUnknown(ForeignKeyConflictException ex) {
    return ex.getMessage();
  }
}