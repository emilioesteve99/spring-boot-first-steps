package com.example.crud.user.infrastructure.jpa.converter;

import com.example.crud.shared.domain.converter.Converter;
import com.example.crud.user.domain.command.UserInsertOneCommand;
import com.example.crud.user.infrastructure.jpa.model.UserJpa;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserInsertOneCommandToUserJpaConverter implements Converter<UserInsertOneCommand, Object, UserJpa> {
  @Override
  public UserJpa convert(UserInsertOneCommand command, Object ctx) {
    UserJpa userJpa = new UserJpa();

    userJpa.id = UUID.randomUUID();
    userJpa.name = command.name;

    return userJpa;
  }
}
