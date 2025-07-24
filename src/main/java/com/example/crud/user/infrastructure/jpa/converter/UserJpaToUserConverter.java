package com.example.crud.user.infrastructure.jpa.converter;

import com.example.crud.shared.domain.converter.Converter;
import com.example.crud.user.domain.model.User;
import com.example.crud.user.infrastructure.jpa.model.UserJpa;
import org.springframework.stereotype.Component;

@Component
public class UserJpaToUserConverter implements Converter<UserJpa, Object, User> {
  @Override
  public User convert(UserJpa userJpa, Object ctx) {
    final User user = new User();

    user.id = userJpa.id;
    user.name = userJpa.name;

    return user;
  }
}
