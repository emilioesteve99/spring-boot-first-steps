package com.example.crud.shared.infrastructure.jpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.util.UUID;

public abstract class BaseEntityJpa {
  @Id
  @Column(name = "id")
  public UUID id;
}
