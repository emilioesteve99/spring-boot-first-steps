package com.example.crud.shared.application.commandHandler;

import com.example.crud.shared.domain.adapter.InsertOneAdapter;
import com.example.crud.shared.domain.command.Command;

public class InsertOneCommandHandler<TCommand extends Command, TOutput> implements ICommandHandler<TCommand, TOutput> {
  protected final InsertOneAdapter<TCommand, TOutput> insertOneAdapter;

  public InsertOneCommandHandler(InsertOneAdapter<TCommand, TOutput> insertOneAdapter) {
    this.insertOneAdapter = insertOneAdapter;
  }

  @Override
  public TOutput execute(TCommand command) {
    return this.insertOneAdapter.insertOne(command);
  }
}