package com.example.crud.user.domain.command;

import com.example.crud.shared.domain.command.BaseEntityInsertOneCommand;

public class UserInsertOneCommand extends BaseEntityInsertOneCommand {
  public final String name;

  public UserInsertOneCommand(String name) {
    this.name = name;
  }
}
