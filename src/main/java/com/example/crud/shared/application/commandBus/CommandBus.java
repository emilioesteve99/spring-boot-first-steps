package com.example.crud.shared.application.commandBus;

import com.example.crud.shared.application.commandHandler.ICommandHandler;
import com.example.crud.shared.application.decorator.CommandHandler;
import com.example.crud.shared.domain.command.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CommandBus implements ICommandBus {
  private final Map<String, ? extends ICommandHandler<?, ?>> handlers;

  @Autowired
  public CommandBus(ApplicationContext context) {
    handlers = context.getBeansWithAnnotation(CommandHandler.class)
            .values()
            .stream()
            .map(h -> (ICommandHandler<?, ?>) h)
            .collect(Collectors.toMap(
                    h -> {
                      CommandHandler annotation = h.getClass().getAnnotation(CommandHandler.class);
                      return annotation.value().getName();
                    },
                    h -> h
            ));
  }

  @Override
  public <TCommand extends Command, TOutput> TOutput execute(TCommand command) {
    ICommandHandler<TCommand, TOutput> handler = (ICommandHandler<TCommand, TOutput>) handlers.get(command.getClass().getName());
    if (handler == null) {
      throw new IllegalArgumentException("Command handler not found for " + command.getClass().getName());
    }
    return handler.execute(command);
  }
}
