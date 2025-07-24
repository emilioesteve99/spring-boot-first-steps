package com.example.crud.user.infrastructure.jpa.converter;

import com.example.crud.shared.infrastructure.jpa.converter.BaseEntityInsertOneCommandToBaseEntityJpaConverter;
import com.example.crud.shared.infrastructure.jpa.model.BaseEntityJpa;
import com.example.crud.user.domain.command.UserInsertOneCommand;
import com.example.crud.user.infrastructure.jpa.model.UserJpa;
import org.springframework.stereotype.Component;

@Component
public class UserInsertOneCommandToUserJpaConverter extends BaseEntityInsertOneCommandToBaseEntityJpaConverter<UserInsertOneCommand, UserJpa> {
  @Override
  protected UserJpa convertToSpecificBaseEntityJpa(UserInsertOneCommand command, BaseEntityJpa baseEntityJpa) {
    final UserJpa userJpa = new UserJpa();
    userJpa.id = baseEntityJpa.id;
    userJpa.name = command.name;
    return userJpa;
  }
}
