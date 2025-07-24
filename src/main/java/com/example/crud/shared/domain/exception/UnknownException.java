package com.example.crud.shared.domain.exception;

public class UnknownException extends RuntimeException {
  public UnknownException(Throwable cause) {
    super("Error", cause);
  }
}
