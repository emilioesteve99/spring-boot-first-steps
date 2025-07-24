package com.example.crud.shared.application.decorator;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface QueryHandler {
    Class<?> value();
}
