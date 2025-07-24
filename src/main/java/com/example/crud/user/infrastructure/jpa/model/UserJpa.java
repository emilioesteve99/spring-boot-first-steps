package com.example.crud.user.infrastructure.jpa.model;

import com.example.crud.shared.infrastructure.jpa.model.BaseEntityJpa;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UserJpa extends BaseEntityJpa {
  @Column(name = "name", nullable = false)
  public String name;
}
