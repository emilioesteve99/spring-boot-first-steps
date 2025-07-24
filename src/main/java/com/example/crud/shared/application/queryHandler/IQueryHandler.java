package com.example.crud.shared.application.queryHandler;

import com.example.crud.shared.domain.query.Query;

public interface IQueryHandler<TQuery extends Query, TOutput> {
  TOutput execute(TQuery query);
}
