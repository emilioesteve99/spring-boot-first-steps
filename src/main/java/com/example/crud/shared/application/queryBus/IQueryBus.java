package com.example.crud.shared.application.queryBus;

import com.example.crud.shared.domain.query.Query;

public interface IQueryBus {
    <TQuery extends Query, TOutput> TOutput execute(TQuery query);
}
