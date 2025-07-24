package com.example.crud.shared.infrastructure.jpa.converter;

import com.example.crud.shared.domain.converter.Converter;
import com.example.crud.shared.domain.model.BaseEntity;
import com.example.crud.shared.infrastructure.jpa.model.BaseEntityJpa;

public abstract class BaseEntityJpaToBaseEntityConverter<TInput extends BaseEntityJpa, TOutput extends BaseEntity> implements Converter<TInput, Object, TOutput> {
  @Override
  public TOutput convert(TInput input, Object ctx) {
    final BaseEntity baseEntity = new BaseEntity();
    baseEntity.id = input.id;
    final TOutput entity = this.convertToSpecificEntity(input, baseEntity);
    return entity;
  }

  protected abstract TOutput convertToSpecificEntity(TInput input, BaseEntity baseEntity);
}
