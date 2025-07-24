package com.example.crud.shared.application.commandHandler;

import com.example.crud.shared.domain.command.Command;

public interface ICommandHandler<TCommand extends Command, TOutput> {
  TOutput execute(TCommand command);
}
