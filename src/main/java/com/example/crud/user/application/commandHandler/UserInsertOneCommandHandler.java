package com.example.crud.user.application.commandHandler;

import com.example.crud.shared.application.commandHandler.InsertOneCommandHandler;
import com.example.crud.shared.application.decorator.CommandHandler;
import com.example.crud.shared.domain.adapter.InsertOneAdapter;
import com.example.crud.user.domain.command.UserInsertOneCommand;
import com.example.crud.user.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;

@CommandHandler(UserInsertOneCommand.class)
public class UserInsertOneCommandHandler extends InsertOneCommandHandler<UserInsertOneCommand, User> {
  @Autowired
  public UserInsertOneCommandHandler(InsertOneAdapter<UserInsertOneCommand, User> insertOneUserJpaAdapter) {
    super(insertOneUserJpaAdapter);
  }
}
