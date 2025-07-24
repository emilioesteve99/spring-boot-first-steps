package com.example.crud.user.infrastructure.jpa.adapter;

import com.example.crud.shared.domain.converter.Converter;
import com.example.crud.shared.infrastructure.jpa.adapter.InsertOneJpaAdapter;
import com.example.crud.user.domain.command.UserInsertOneCommand;
import com.example.crud.user.domain.model.User;
import com.example.crud.user.infrastructure.jpa.model.UserJpa;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertOneUserJpaAdapter extends InsertOneJpaAdapter<UserInsertOneCommand, UserJpa, User> {
  @Autowired
  public InsertOneUserJpaAdapter(EntityManager entityManager, Converter<UserInsertOneCommand, Object, UserJpa> userInsertOneCommandToUserJpaConverter, Converter<UserJpa, Object, User> userJpaToUserConverter) {
    super(entityManager, userInsertOneCommandToUserJpaConverter, userJpaToUserConverter);
  }
}