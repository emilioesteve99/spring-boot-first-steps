package com.example.crud.shared.domain.adapter;

public interface InsertOneAdapter<TCommand, TOutput> {
  TOutput insertOne(TCommand command);
}
