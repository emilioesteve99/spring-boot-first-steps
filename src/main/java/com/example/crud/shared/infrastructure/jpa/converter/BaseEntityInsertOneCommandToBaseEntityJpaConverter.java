package com.example.crud.shared.infrastructure.jpa.converter;

import com.example.crud.shared.domain.command.BaseEntityInsertOneCommand;
import com.example.crud.shared.domain.converter.Converter;
import com.example.crud.shared.infrastructure.jpa.model.BaseEntityJpa;

import java.util.UUID;

public abstract class BaseEntityInsertOneCommandToBaseEntityJpaConverter<TInput extends BaseEntityInsertOneCommand, TOutput extends BaseEntityJpa> implements Converter<TInput, Object, TOutput> {
  @Override
  public TOutput convert(TInput baseEntityInsertOneCommand, Object ctx) {
    final BaseEntityJpa baseEntityJpa = new BaseEntityJpa();
    baseEntityJpa.id = UUID.randomUUID();
    final TOutput entityJpa = this.convertToSpecificBaseEntityJpa(baseEntityInsertOneCommand, baseEntityJpa);
    return entityJpa;
  }

  protected abstract TOutput convertToSpecificBaseEntityJpa(TInput baseEntityInsertOneCommand, BaseEntityJpa baseEntityJpa);
}
