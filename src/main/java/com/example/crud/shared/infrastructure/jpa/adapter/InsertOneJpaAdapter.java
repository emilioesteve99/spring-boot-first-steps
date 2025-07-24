package com.example.crud.shared.infrastructure.jpa.adapter;

import com.example.crud.shared.domain.adapter.InsertOneAdapter;
import com.example.crud.shared.domain.command.Command;
import com.example.crud.shared.domain.converter.Converter;
import com.example.crud.shared.domain.exception.ForeignKeyConflictException;
import com.example.crud.shared.domain.exception.UnknownException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

public class InsertOneJpaAdapter<TCommand extends Command, TModelDB, TModel> implements InsertOneAdapter<TCommand, TModel> {
  @PersistenceContext
  protected final EntityManager entityManager;
  protected final Converter<TCommand, Object, TModelDB> insertOneCommandToEntityJpaConverter;
  protected final Converter<TModelDB, Object, TModel> entityJpaToEntityConverter;

  public InsertOneJpaAdapter(EntityManager entityManager, Converter<TCommand, Object, TModelDB> insertOneCommandToEntityJpaConverter, Converter<TModelDB, Object, TModel> entityJpaToEntityConverter) {
    this.entityManager = entityManager;
    this.insertOneCommandToEntityJpaConverter = insertOneCommandToEntityJpaConverter;
    this.entityJpaToEntityConverter = entityJpaToEntityConverter;
  }

  @Override
  @Transactional
  public TModel insertOne(TCommand command) {
    final TModelDB entityJpa = this.insertOneCommandToEntityJpaConverter.convert(command);
    try {
      this.entityManager.persist(entityJpa);
      this.entityManager.flush();
    } catch (DataIntegrityViolationException | ConstraintViolationException e) {
      throw new ForeignKeyConflictException(e);
    } catch (Exception e) {
      throw new UnknownException(e);
    }
    return this.entityJpaToEntityConverter.convert(entityJpa);
  }
}
