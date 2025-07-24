package com.example.crud.shared.domain.converter;

public interface Converter<TInput, TContext, TOutput> {
    TOutput convert(TInput input, TContext ctx);

    default TOutput convert(TInput input) {
        return convert(input, null);
    }
}
