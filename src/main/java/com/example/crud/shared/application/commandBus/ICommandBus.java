package com.example.crud.shared.application.commandBus;

import com.example.crud.shared.domain.command.Command;

public interface ICommandBus {
    <TCommand extends Command, TOutput> TOutput execute(TCommand command);
}
