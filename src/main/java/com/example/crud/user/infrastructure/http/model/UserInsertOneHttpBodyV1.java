package com.example.crud.user.infrastructure.http.model;

import jakarta.validation.constraints.NotBlank;

public class UserInsertOneHttpBodyV1 {
  @NotBlank()
  public String name;
}