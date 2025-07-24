package com.example.crud.user.infrastructure.jpa.model;

import com.example.crud.shared.infrastructure.jpa.model.BaseEntityJpa;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "users")
public class UserJpa extends BaseEntityJpa {
  @Id
  @Column(name = "id")
  public UUID id;

  @Column(name = "name", nullable = false)
  public String name;
}
