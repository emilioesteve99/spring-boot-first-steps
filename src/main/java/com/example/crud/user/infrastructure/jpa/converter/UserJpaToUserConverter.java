package com.example.crud.user.infrastructure.jpa.converter;

import com.example.crud.shared.domain.model.BaseEntity;
import com.example.crud.shared.infrastructure.jpa.converter.BaseEntityJpaToBaseEntityConverter;
import com.example.crud.user.domain.model.User;
import com.example.crud.user.infrastructure.jpa.model.UserJpa;
import org.springframework.stereotype.Component;

@Component
public class UserJpaToUserConverter extends BaseEntityJpaToBaseEntityConverter<UserJpa, User> {
  @Override
  protected User convertToSpecificEntity(UserJpa userJpa, BaseEntity baseEntity) {
    final User user = new User();
    user.id = userJpa.id;
    user.name = userJpa.name;
    return user;
  }
}
