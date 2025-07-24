package com.example.crud.shared.application.queryBus;

import com.example.crud.shared.application.decorator.QueryHandler;
import com.example.crud.shared.application.queryHandler.IQueryHandler;
import com.example.crud.shared.domain.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;

@Component
public class QueryBus implements IQueryBus {
  private final Map<String, ? extends IQueryHandler<?, ?>> handlers;

  @Autowired
  public QueryBus(ApplicationContext context) {
    handlers = context.getBeansWithAnnotation(QueryHandler.class)
            .values()
            .stream()
            .map(h -> (IQueryHandler<?, ?>) h)
            .collect(Collectors.toMap(
                    h -> {
                      QueryHandler annotation = h.getClass().getAnnotation(QueryHandler.class);
                      return annotation.value().getName();
                    },
                    h -> h
            ));
  }

  @Override
  public <TQuery extends Query, TOutput> TOutput execute(TQuery query) {
    IQueryHandler<TQuery, TOutput> handler = (IQueryHandler<TQuery, TOutput>) handlers.get(query.getClass().getName());
    if (handler == null) {
      throw new IllegalArgumentException("Query handler not found for " + query.getClass().getName());
    }
    return handler.execute(query);
  }
}
