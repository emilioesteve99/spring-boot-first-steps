package com.example.crud.user.domain.command;

import com.example.crud.shared.domain.command.Command;

public class UserInsertOneCommand extends Command {
  public final String name;

  public UserInsertOneCommand(String name) {
    this.name = name;
  }
}
