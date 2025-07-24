package com.example.crud.shared.infrastructure.jpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.util.UUID;

@MappedSuperclass
public class BaseEntityJpa {
  @Id
  @Column(name = "id")
  public UUID id;
}
