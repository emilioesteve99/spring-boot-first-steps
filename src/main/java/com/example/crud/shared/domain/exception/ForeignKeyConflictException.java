package com.example.crud.shared.domain.exception;

public class ForeignKeyConflictException extends RuntimeException {
  public ForeignKeyConflictException(Throwable cause) {
    super("Data integrity conflict", cause);
  }
}
